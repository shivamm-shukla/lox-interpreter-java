package com.shivam.lox.runtime;

import com.shivam.lox.parser.ast.*;
import com.shivam.lox.lexer.TokenType;

public class Interpreter {

    public Object evaluate(Expr expr) {
        return visit(expr);
    }

    private Object visit(Expr expr) {

        if (expr instanceof Literal literal) {
            return literal.value;
        }

        if (expr instanceof Grouping grouping) {
            return evaluate(grouping.expression);
        }

        if (expr instanceof Unary unary) {
            Object right = evaluate(unary.right);

            if (unary.operator.type == TokenType.MINUS) {
                return - (double) right;
            }

            throw new RuntimeException("Unknown unary operator.");
        }

        if (expr instanceof Binary binary) {
            Object left = evaluate(binary.left);
            Object right = evaluate(binary.right);

            switch (binary.operator.type) {
                case PLUS:
                    return (double) left + (double) right;
                case MINUS:
                    return (double) left - (double) right;
                case STAR:
                    return (double) left * (double) right;
                case SLASH:
                    return (double) left / (double) right;
            }

            throw new RuntimeException("Unknown binary operator.");
        }

        throw new RuntimeException("Unknown expression.");
    }
}