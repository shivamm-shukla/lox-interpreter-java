package com.shivam.lox.parser.ast;

import com.shivam.lox.lexer.Token;

public class Unary extends Expr {
    public final Token operator;
    public final Expr right;

    public Unary(Token token, Expr right) {
        this.operator = token;
        this.right = right;
    }
}
