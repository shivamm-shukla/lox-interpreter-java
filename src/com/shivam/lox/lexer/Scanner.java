package com.shivam.lox.lexer;

import java.util.ArrayList;
import java.util.List;

public class Scanner{
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;
    public Scanner(String source){
        this.source = source;
    }

    public List<Token> scanTokens(){
        while(!isAtEnd()){
            start = current;
            scanToken();
        }
        tokens.add(new Token(TokenType.EOF, "", null, line));
        return tokens;
    }

    private void scanToken(){
        char c = advance();
        switch(c){
            case '(':
                addToken(TokenType.LEFT_PAREN);
                break;
            case ')':
                addToken(TokenType.RIGHT_PAREN);
                break;
            case '+':
                addToken(TokenType.PLUS);
                break;
            case '-':
                addToken(TokenType.MINUS);
                break;
            case '*':
                addToken(TokenType.STAR);
                break;
            case '/':
                addToken(TokenType.SLASH);
                break;

            case ' ':
            case '\r':
            case '\t':
                break;

            case '\n':
                line++;
                break;
            default:
                if (isDigit(c)){
                    number();
                } else {
                    throw new RuntimeException( "Unexpected character '" + c + "' at line " + line);
                }
                break;
        }
    }
    private void number() {

        while (isDigit(peek())) {
            advance();
        }

        // Handle decimal part
        if (peek() == '.' && isDigit(peekNext())) {

            advance(); // consume '.'

            while (isDigit(peek())) {
                advance();
            }
        }

        String text = source.substring(start, current);
        double value = Double.parseDouble(text);

        addToken(TokenType.NUMBER, value);
    }
    private char advance() {
        return source.charAt(current++);
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }
    private char peekNext() {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private boolean isAtEnd() {
        return current >= source.length();
    }

    private void addToken(TokenType type) {
        addToken(type, null);
    }
    private void addToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }
}
