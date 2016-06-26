package com.github.asufana.hanamogera.token;

import lombok.*;
import lombok.experimental.*;

@Getter
@Accessors(fluent = true)
public class NumToken extends Token {
    
    private final int value;
    
    public NumToken(final String value) {
        this(Integer.parseInt(value));
    }
    
    public NumToken(final int value) {
        this.value = value;
    }
    
    @Override
    public String text() {
        return String.valueOf(value);
    }
    
    @Override
    public TokenType tokenType() {
        return TokenType.Num;
    }
    
    @Override
    public String toString() {
        return String.format("%s:%s", tokenType().name(), value);
    }
}
