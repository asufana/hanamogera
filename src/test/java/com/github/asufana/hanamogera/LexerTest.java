package com.github.asufana.hanamogera;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.junit.*;

import com.github.asufana.hanamogera.token.*;

public class LexerTest {
    
    @Test
    public void testLexer() {
        final List<Token> tokens = Lexer.toTokens(Arrays.asList("10 + 20 + 30"));
        assertThat(tokens,
                   contains(new NumToken(10),
                            new IdToken("+"),
                            new NumToken(20),
                            new IdToken("+"),
                            new NumToken(30)));
        System.out.println("Tokens: " + tokens);
    }
    
}
