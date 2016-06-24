package com.github.asufana.hanamogera;

import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.regex.*;

import com.github.asufana.hanamogera.token.*;

public class Lexer {
    
    private static final Object[] tokenRegexs = {TokenType.Num.regex(), TokenType.Id.regex()};
    private static final String regex = String.format("\\s*((%s)|(%s))", tokenRegexs);
    private static final Pattern pattern = Pattern.compile(regex);
    
    /** 文字列をトークンリストに変換する */
    public static List<Token> toTokens(final List<String> lines) {
        final List<Token> tokens = lines.stream()
                                        .flatMap(line -> toTokens(line).stream())
                                        .collect(toList());
        return tokens;
    }
    
    /** 文字列をトークンリストに変換する */
    private static List<Token> toTokens(final String line) {
        final List<Token> tokens = new ArrayList<>();
        
        //正規表現マッチ
        final Matcher matcher = pattern.matcher(line);
        //マッチ結果をひとつずつ処理
        while (matcher.find()) {
            //トークンに変換
            final Token token = toToken(matcher);
            tokens.add(token);
        }
        return tokens;
    }
    
    /** マッチ結果をトークンに変換する */
    private static Token toToken(final Matcher matcher) {
        //マッチ位置でトークン種別を判別
        if (matcher.group(2) != null) {
            final TokenType tokenType = findTokenTypeBy(2);
            final String matchedString = matcher.group(2);
            return tokenType.createToken(matchedString);
        }
        //マッチ位置でトークン種別を判別
        if (matcher.group(3) != null) {
            final TokenType tokenType = findTokenTypeBy(3);
            final String matchedString = matcher.group(3);
            return tokenType.createToken(matchedString);
        }
        throw new RuntimeException();
    }
    
    /** トークン種別を取得 */
    private static TokenType findTokenTypeBy(final int groupMatchedIndex) {
        final Object regex = tokenRegexs[groupMatchedIndex - 2];
        return TokenType.findBy((String) regex);
    }
}
