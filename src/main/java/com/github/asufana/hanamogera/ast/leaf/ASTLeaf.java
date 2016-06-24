package com.github.asufana.hanamogera.ast.leaf;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.token.*;

/** AST末端オブジェクト */
public abstract class ASTLeaf implements ASTNode {
    
    protected final Token token;
    
    public ASTLeaf(final Token token) {
        this.token = token;
    }
}
