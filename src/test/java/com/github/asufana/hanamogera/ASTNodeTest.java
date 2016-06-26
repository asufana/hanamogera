package com.github.asufana.hanamogera;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.ast.expr.*;
import com.github.asufana.hanamogera.ast.leaf.*;
import com.github.asufana.hanamogera.token.*;

public class ASTNodeTest {
    
    @Test
    //10+20
    public void testAddition01() throws Exception {
        final ASTNode leafLeft = new ASTNum(new NumToken(10));
        final ASTNode expr = new ASTId(new IdToken("+"));
        final ASTNode leafRight = new ASTNum(new NumToken(20));
        final ASTNode nodes = new ASTExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(30));
    }
    
    @Test
    //10+20+30 -> (10+20)+30
    public void testAddtion02() throws Exception {
        //10+20
        final ASTNode leafLeftLeft = new ASTNum(new NumToken(10));
        final ASTNode expr = new ASTId(new IdToken("+"));
        final ASTNode leafLeftRight = new ASTNum(new NumToken(20));
        final ASTNode leafLeft = new ASTExpr(leafLeftLeft, expr, leafLeftRight);
        
        //(10+20)+30
        final ASTNode leafRight = new ASTNum(new NumToken(30));
        final ASTNode nodes = new ASTExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(60));
    }
    
    @Test
    //20-10
    public void testSubtraction() throws Exception {
        final ASTNode leafLeft = new ASTNum(new NumToken(20));
        final ASTNode expr = new ASTId(new IdToken("-"));
        final ASTNode leafRight = new ASTNum(new NumToken(10));
        final ASTNode nodes = new ASTExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(10));
    }
    
    @Test
    //2*3
    public void testMultiplication() throws Exception {
        final ASTNode leafLeft = new ASTNum(new NumToken(2));
        final ASTNode expr = new ASTId(new IdToken("*"));
        final ASTNode leafRight = new ASTNum(new NumToken(3));
        final ASTNode nodes = new ASTExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(6));
    }
    
    @Test
    //4/2
    public void testDivision() throws Exception {
        final ASTNode leafLeft = new ASTNum(new NumToken(4));
        final ASTNode expr = new ASTId(new IdToken("/"));
        final ASTNode leafRight = new ASTNum(new NumToken(2));
        final ASTNode nodes = new ASTExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(2));
    }
    
    @Test
    //10+20*30->10+(20*30)
    public void testAdditionAndMultiplication() throws Exception {
        //10+
        final ASTNode leafLeft = new ASTNum(new NumToken(10));
        final ASTNode exprAdd = new ASTId(new IdToken("+"));
        
        //20*30
        final ASTNode leafRightLeft = new ASTNum(new NumToken(20));
        final ASTNode exprMulti = new ASTId(new IdToken("*"));
        final ASTNode leafRightRight = new ASTNum(new NumToken(30));
        final ASTNode leafRight = new ASTExpr(leafRightLeft, exprMulti, leafRightRight);
        
        final ASTNode nodes = new ASTExpr(leafLeft, exprAdd, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(610));
    }
    
}
