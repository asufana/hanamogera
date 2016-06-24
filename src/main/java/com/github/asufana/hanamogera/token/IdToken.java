package com.github.asufana.hanamogera.token;

import lombok.*;
import lombok.experimental.*;

@Getter
@Accessors(fluent = true)
public class IdToken extends Token {
    
    private final String value;
    
    public IdToken(final String value) {
        this.value = value;
    }
    
    @Override
    public TokenType tokenType() {
        return TokenType.Id;
    }
    
    @Override
    public String toString() {
        return String.format("%s:%s", tokenType().name(), value);
    }
    
}
