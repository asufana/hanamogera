package com.github.asufana.hanamogera.ast.leaf;

import com.github.asufana.hanamogera.token.*;

public class AstId extends AstLeaf {
    
    public AstId(final IdToken token) {
        super(token);
    }
    
    /* @see com.github.asufana.hanamogera.ast.ASTNode#eval() */
    @Override
    public Object eval() {
        //文字列を返却
        return ((IdToken) token).value();
    }
    
}
