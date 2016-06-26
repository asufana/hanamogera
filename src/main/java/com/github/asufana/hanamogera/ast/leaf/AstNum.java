package com.github.asufana.hanamogera.ast.leaf;

import com.github.asufana.hanamogera.token.*;

public class AstNum extends AstLeaf {
    
    public AstNum(final NumToken token) {
        super(token);
    }
    
    /* @see com.github.asufana.hanamogera.ast.ASTNode#eval() */
    @Override
    public Object eval() {
        //数値を返却
        return ((NumToken) token).value();
    }
    
}
