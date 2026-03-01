package com.shivam.lox;

import com.shivam.lox.lexer.Scanner;
import com.shivam.lox.lexer.Token;
import com.shivam.lox.parser.AstPrinter;
import com.shivam.lox.parser.Parser;
import com.shivam.lox.parser.ast.Expr;
import com.shivam.lox.runtime.Interpreter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Checking Lexer
////     String source = "12 + 5 * (3 - 2.5)";
//        String source = "3.14.15";
//     Scanner scan = new Scanner(source);
//     List<Token> tokens = scan.scanTokens();
//     for (Token token : tokens) {
//         System.out.println(token);
//
//     }

//        Checking AST Tree

//        String source = "3 + 4 * 5";
//        String source = "(3 + 4) * 5";
//        String source = "-3 * (2 + 1)";
        String source = "3 + 4 * 5";
        Scanner lexer = new Scanner(source);
        List<Token> tokens = lexer.scanTokens();

        Parser parser = new Parser(tokens);
        Expr expression = parser.parse();

//        AstPrinter printer = new AstPrinter();
//        System.out.println(printer.print(expression));


//        Interpreter checking

        Interpreter interpreter = new Interpreter();
        Object result = interpreter.evaluate(expression);
        System.out.println(result);

    }
}
