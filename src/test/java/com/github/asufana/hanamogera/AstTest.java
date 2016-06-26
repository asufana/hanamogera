package com.github.asufana.hanamogera;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.ast.expr.*;
import com.github.asufana.hanamogera.ast.leaf.*;
import com.github.asufana.hanamogera.token.*;

public class AstTest {
    
    @Test
    //10+20
    public void testAddition01() throws Exception {
        final Ast leafLeft = new AstNum(new NumToken(10));
        final Ast expr = new AstId(new IdToken("+"));
        final Ast leafRight = new AstNum(new NumToken(20));
        final Ast nodes = new AstExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(30));
    }
    
    @Test
    //10+20+30 -> (10+20)+30
    public void testAddtion02() throws Exception {
        //10+20
        final Ast leafLeftLeft = new AstNum(new NumToken(10));
        final Ast expr = new AstId(new IdToken("+"));
        final Ast leafLeftRight = new AstNum(new NumToken(20));
        final Ast leafLeft = new AstExpr(leafLeftLeft, expr, leafLeftRight);
        
        //(10+20)+30
        final Ast leafRight = new AstNum(new NumToken(30));
        final Ast nodes = new AstExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(60));
    }
    
    @Test
    //20-10
    public void testSubtraction() throws Exception {
        final Ast leafLeft = new AstNum(new NumToken(20));
        final Ast expr = new AstId(new IdToken("-"));
        final Ast leafRight = new AstNum(new NumToken(10));
        final Ast nodes = new AstExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(10));
    }
    
    @Test
    //2*3
    public void testMultiplication() throws Exception {
        final Ast leafLeft = new AstNum(new NumToken(2));
        final Ast expr = new AstId(new IdToken("*"));
        final Ast leafRight = new AstNum(new NumToken(3));
        final Ast nodes = new AstExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(6));
    }
    
    @Test
    //4/2
    public void testDivision() throws Exception {
        final Ast leafLeft = new AstNum(new NumToken(4));
        final Ast expr = new AstId(new IdToken("/"));
        final Ast leafRight = new AstNum(new NumToken(2));
        final Ast nodes = new AstExpr(leafLeft, expr, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(2));
    }
    
    @Test
    //10+20*30->10+(20*30)
    public void testAdditionAndMultiplication() throws Exception {
        //10+
        final Ast leafLeft = new AstNum(new NumToken(10));
        final Ast exprAdd = new AstId(new IdToken("+"));
        
        //20*30
        final Ast leafRightLeft = new AstNum(new NumToken(20));
        final Ast exprMulti = new AstId(new IdToken("*"));
        final Ast leafRightRight = new AstNum(new NumToken(30));
        final Ast leafRight = new AstExpr(leafRightLeft, exprMulti, leafRightRight);
        
        final Ast nodes = new AstExpr(leafLeft, exprAdd, leafRight);
        
        //eval
        final Object result = nodes.eval();
        assertThat(result, is(610));
    }
    
}
