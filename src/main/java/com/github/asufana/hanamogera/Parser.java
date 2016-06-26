package com.github.asufana.hanamogera;

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
public class Parser {
    
    private final TokenList tokens;
    
    /** 構文解析 */
    public Ast expression() {
        Ast left = term();
        //再帰的に解析する
        //BNFに従い + と - を解析
        while (tokens.isNotEmpty() && (tokens.nextIs("+") || tokens.nextIs("-"))) {
            final Ast expr = expr();
            final Ast right = term();
            left = new AstExpr(left, expr, right);
        }
        return left;
    }
    
    /** term解析 */
    private Ast term() {
        Ast left = factor();
        //再帰的に解析する
        //BNFに従い * と / を解析
        
        while (tokens.isNotEmpty() && (tokens.nextIs("*") || tokens.nextIs("/"))) {
            final Ast expr = expr();
            final Ast right = factor();
            left = new AstExpr(left, expr, right);
        }
        return left;
    }
    
    /** 識別子解析 */
    private Ast expr() {
        final Token token = tokens.get();
        return new AstId((IdToken) token);
    }
    
    /** factor解析 */
    private Ast factor() {
        //factorはNUMBERのみ
        final Token token = tokens.get();
        return new AstNum((NumToken) token);
    }
}
