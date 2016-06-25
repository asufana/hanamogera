package com.github.asufana.hanamogera;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.token.*;

public class FirstParserTest {
    
    @Test
    public void test() {
        //字句解析
        final List<Token> tokens = Lexer.toTokens("10 + 20 + 30");
        //構文解析
        final ASTNode nodes = new FirstParser(tokens).expression();
        //実行
        assertThat(nodes.eval(), is(60));
    }
    
}
