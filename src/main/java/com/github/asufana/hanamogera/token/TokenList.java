package com.github.asufana.hanamogera.token;

import java.util.*;
import java.util.stream.*;

import lombok.*;
import lombok.experimental.*;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public class TokenList {
    
    private final List<Token> list;
    
    public boolean isNotEmpty() {
        return list.size() > 0;
    }
    
    public Token get() {
        if (isNotEmpty()) {
            return list.remove(0); //リストから削除する
        }
        throw new RuntimeException("no token.");
    }
    
    public Token peek() {
        if (isNotEmpty()) {
            return list.get(0); //リストから削除しない
        }
        throw new RuntimeException("no token.");
    }
    
    public boolean nextIs(final String text) {
        if (isNotEmpty()) {
            return list.get(0).text().equals(text);
        }
        throw new RuntimeException("no token.");
    }
    
    public Stream<Token> stream() {
        return list.stream();
    }
    
}
