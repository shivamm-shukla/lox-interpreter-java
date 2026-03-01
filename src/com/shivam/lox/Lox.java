package com.shivam.lox;

import com.shivam.lox.lexer.Scanner;
import com.shivam.lox.lexer.Token;
import com.shivam.lox.parser.Parser;
import com.shivam.lox.parser.ast.Expr;
import com.shivam.lox.runtime.Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {

    private static final Interpreter interpreter = new Interpreter();

    public static void main(String[] args) throws IOException {

        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        }
        else if (args.length == 1) {
            runFile(args[0]);
        }
        else {
            runPrompt();
        }
    }

    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes));
    }

    private static void runPrompt() throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        while (true) {
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
        }
    }

    private static void run(String source) {

        Scanner lexer = new Scanner(source);
        List<Token> tokens = lexer.scanTokens();

        Parser parser = new Parser(tokens);
        Expr expression = parser.parse();

        Object result = interpreter.evaluate(expression);
        System.out.println(result);
    }
}