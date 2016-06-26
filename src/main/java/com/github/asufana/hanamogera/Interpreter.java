package com.github.asufana.hanamogera;

import static java.util.stream.Collectors.*;

import java.util.*;

import com.github.asufana.hanamogera.ast.*;
import com.github.asufana.hanamogera.token.*;

public class Interpreter {
    
    public static void main(final String[] args) {
        final String arg = Arrays.stream(args).collect(joining(" "));
        final TokenList tokens = Lexer.toTokens(arg);
        final Ast nodes = new Parser(tokens).expression();
        final Object result = nodes.eval();
        System.out.println(result);
    }
    
}
