package com.github.asufana.hanamogera;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.ast.expr.*;
import com.github.asufana.hanamogera.ast.leaf.*;
import com.github.asufana.hanamogera.token.*;

public class InterpreterTest {
    
    @Test
    //10+20
    public void test01() throws Exception {
        final ASTNode leafLeft = new ASTNum(new NumToken(10));
        final ASTNode expr = new ASTId(new IdToken("+"));
        final ASTNode leafRight = new ASTNum(new NumToken(20));
        final ASTExpr nodes = new ASTExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(30));
    }
    
    @Test
    //10+20+30 -> (10+20)+30
    public void test02() throws Exception {
        //10+20
        final ASTNode leafLeft = new ASTNum(new NumToken(10));
        final ASTNode expr = new ASTId(new IdToken("+"));
        final ASTNode leafRight = new ASTNum(new NumToken(20));
        final ASTExpr nodesLeft = new ASTExpr(leafLeft, expr, leafRight);
        //(10+20)+30
        final ASTNode nodesRight = new ASTNum(new NumToken(30));
        final ASTExpr nodes = new ASTExpr(nodesLeft, expr, nodesRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(60));
    }
    
}
