package com.shivam.lox;

import com.shivam.lox.lexer.Scanner;
import com.shivam.lox.lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//     String source = "12 + 5 * (3 - 2.5)";
        String source = "3.14.15";
     Scanner scan = new Scanner(source);
     List<Token> tokens = scan.scanTokens();
     for (Token token : tokens) {
         System.out.println(token);

     }

    }
}
