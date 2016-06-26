package com.github.asufana.hanamogera.token;

import org.apache.commons.lang3.builder.*;

public abstract class Token {
    
    public abstract String text();
    
    public abstract TokenType tokenType();
    
    @Override
    public boolean equals(final Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        return EqualsBuilder.reflectionEquals(this, other);
    }
    
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
    
}
