package com.github.asufana.hanamogera;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import org.junit.*;

import com.github.asufana.hanamogera.token.*;

public class LexerTest {
    
    @Test
    //足し算
    public void testAddition() {
        final List<Token> tokens = Lexer.toTokens("10 + 20 + 30");
        assertThat(tokens,
                   contains(new NumToken(10),
                            new IdToken("+"),
                            new NumToken(20),
                            new IdToken("+"),
                            new NumToken(30)));
        System.out.println("Tokens: " + tokens);
    }
    
    @Test
    //引き算
    public void testSubtraction() {
        final List<Token> tokens = Lexer.toTokens("30 - 20 - 10");
        assertThat(tokens,
                   contains(new NumToken(30),
                            new IdToken("-"),
                            new NumToken(20),
                            new IdToken("-"),
                            new NumToken(10)));
        System.out.println("Tokens: " + tokens);
    }
    
    @Test
    //掛け算
    public void testMultiplication() {
        final List<Token> tokens = Lexer.toTokens("1 * 2 * 3");
        assertThat(tokens,
                   contains(new NumToken(1),
                            new IdToken("*"),
                            new NumToken(2),
                            new IdToken("*"),
                            new NumToken(3)));
        System.out.println("Tokens: " + tokens);
    }
    
    @Test
    //割り算
    public void testDivision() {
        final List<Token> tokens = Lexer.toTokens("4 / 2 / 1");
        assertThat(tokens,
                   contains(new NumToken(4),
                            new IdToken("/"),
                            new NumToken(2),
                            new IdToken("/"),
                            new NumToken(1)));
        System.out.println("Tokens: " + tokens);
    }
    
}
