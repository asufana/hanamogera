package com.github.asufana.hanamogera.ast.leaf;

import com.github.asufana.hanamogera.token.*;

public class ASTNum extends ASTLeaf {
    
    public ASTNum(final NumToken token) {
        super(token);
    }
    
    /* @see com.github.asufana.hanamogera.ast.ASTNode#eval() */
    @Override
    public Object eval() {
        //数値を返却
        return ((NumToken) token).value();
    }
    
}
