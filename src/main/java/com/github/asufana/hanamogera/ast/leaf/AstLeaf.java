package com.github.asufana.hanamogera.ast.leaf;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.token.*;

/** AST末端オブジェクト */
public abstract class AstLeaf implements Ast {
    
    protected final Token token;
    
    public AstLeaf(final Token token) {
        this.token = token;
    }
}
