package com.github.asufana.hanamogera.ast.expr;

import com.github.asufana.hanamogera.ast.*;

import lombok.*;
import lombok.experimental.*;

@Getter
@Accessors(fluent = true)
public class ASTExpr implements ASTNode {
    
    private final ASTNode left;
    private final ASTNode expr;
    private final ASTNode right;
    
    public ASTExpr(final ASTNode left, final ASTNode expr, final ASTNode right) {
        this.left = left;
        this.expr = expr;
        this.right = right;
    }
    
    /* @see com.github.asufana.hanamogera.ast.ASTNode#eval() */
    @Override
    public Object eval() {
        final Object left = left().eval();
        final Object right = right().eval();
        
        //処理振り分け
        if (left instanceof Integer && right instanceof Integer) {
            //数値処理
            return compute((Integer) left, expr(), (Integer) right);
        }
        throw new RuntimeException();
    }
    
    /** 数値処理 */
    private Integer compute(final Integer left, final ASTNode expr, final Integer right) {
        final String eval = (String) expr.eval();
        if (eval.equals("+")) {
            return left + right;
        }
        if (eval.equals("-")) {
            return left - right;
        }
        throw new RuntimeException();
    }
}
