package com.github.asufana.hanamogera;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.token.*;

public class ParserTest {
    
    @Test
    //足し算と引き算
    public void test01() {
        //字句解析
        final TokenList tokens = Lexer.toTokens("10 + 20 + 30 - 40");
        //構文解析
        final Ast nodes = new Parser(tokens).expression();
        //実行
        final Object result = nodes.eval();
        assertThat(result, is(20));
    }
    
    @Test
    //掛け算と割り算
    public void test02() {
        final TokenList tokens = Lexer.toTokens("10 * 20 / 40");
        final Ast nodes = new Parser(tokens).expression();
        final Object result = nodes.eval();
        assertThat(result, is(5));
    }
    
    @Test
    //四則計算
    public void test03() {
        final TokenList tokens = Lexer.toTokens("10 + 20 * 30 / 10");
        final Ast nodes = new Parser(tokens).expression();
        final Object result = nodes.eval();
        assertThat(result, is(70));
    }
    
}
