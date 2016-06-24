package com.github.asufana.hanamogera.token;

import java.util.*;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
/** トークン種別 */
public enum TokenType {
                       Id("[\\+\\-]") {
                           @Override
                           public Token createToken(final String value) {
                               return new IdToken(value);
                           }
                       },
                       Num("[0-9]+") {
                           @Override
                           public Token createToken(final String value) {
                               return new NumToken(value);
                           }
                       };
                       
    /* Token識別する正規表現 */
    private String regex;
    
    /* Tokenインスタンス生成 */
    public abstract Token createToken(String value);
    
    /* regex文字列からTokenTypeを取得する */
    public static TokenType findBy(final String regex) {
        return Arrays.stream(values())
                     .filter(v -> v.regex().equals(regex))
                     .findAny()
                     .orElseThrow(() -> new RuntimeException("Unknown token matcher: " + regex));
    }
}
