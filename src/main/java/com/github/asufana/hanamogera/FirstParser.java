package com.github.asufana.hanamogera;

import java.util.*;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.ast.expr.*;
import com.github.asufana.hanamogera.ast.leaf.*;
import com.github.asufana.hanamogera.token.*;

import lombok.*;

/** LL構文解析（再帰下降構文解析器） */
// factor     ::= NUMBER
// term       ::= factor ( ( '*' | '/' ) factor )*
// expression ::= term ( ( '+' | '-' ) term )*

@AllArgsConstructor
public class FirstParser {
    
    private final List<Token> tokens;
    
    /** 構文解析 */
    public ASTNode expression() {
        ASTNode left = term();
        //再帰的に解析する
        //BNFに従い + と - を解析
        while (tokens.size() > 0
                && (tokens.get(0).text().equals("+") || tokens.get(0).text().equals("-"))) {
            final ASTNode expr = expr();
            final ASTNode right = term();
            left = new ASTExpr(left, expr, right);
        }
        return left;
    }
    
    /** term解析 */
    private ASTNode term() {
        ASTNode left = factor();
        //再帰的に解析する
        //BNFに従い * と / を解析
        
        while (tokens.size() > 0
                && (tokens.get(0).text().equals("*") || tokens.get(0).text().equals("/"))) {
            final ASTNode expr = expr();
            final ASTNode right = factor();
            left = new ASTExpr(left, expr, right);
        }
        return left;
    }
    
    /** 識別子解析 */
    private ASTNode expr() {
        final Token token = tokens.remove(0);
        return new ASTId((IdToken) token);
    }
    
    /** factor解析 */
    private ASTNode factor() {
        //factorはNUMBERのみ
        final Token token = tokens.remove(0);
        return new ASTNum((NumToken) token);
    }
}
