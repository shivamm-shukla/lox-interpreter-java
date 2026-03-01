package com.shivam.lox.parser.ast;

import com.shivam.lox.lexer.Token;

public class Binary extends Expr {

    public final Expr left;
    public final Token operator;
    public final Expr right;

    public Binary(Expr left, Token operator, Expr right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }
}