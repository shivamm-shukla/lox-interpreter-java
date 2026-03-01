package com.shivam.lox.parser;
import com.shivam.lox.parser.ast.*;

public class AstPrinter {
    public String print(Expr expr) {
        return parenthesize(expr);
    }

    private String parenthesize(Expr expr) {

        if (expr instanceof Literal literal) {
            if (literal.value == null) return "nil";
            return literal.value.toString();
        }
        else if (expr instanceof Grouping grouping) {
            return "(group " + parenthesize(grouping.expression) + ")";
        }
        else if (expr instanceof Unary unary) {
            return "(" + unary.operator.lexeme + " "
                    + parenthesize(unary.right) + ")";
        }
        else if (expr instanceof Binary binary) {
            return "(" + binary.operator.lexeme + " "
                    + parenthesize(binary.left) + " "
                    + parenthesize(binary.right) + ")";
        }

        throw new RuntimeException("Unknown expression type.");
    }

}