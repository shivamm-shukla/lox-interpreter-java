# Lox Interpreter (Java Implementation)

This repository contains a step-by-step implementation of the **Lox programming language** from the book:

> Crafting Interpreters — Robert Nystrom

This project is built as a deep learning exercise to understand:

- Language Design
- Interpreter Architecture
- Parsing Techniques
- Abstract Syntax Trees (AST)
- Runtime Evaluation
- Compiler Fundamentals

This is not a new language invention. It is a structured and carefully implemented version of Lox based on the book.

---

# Current Status

## Expression Interpreter Phase — Completed

The following components are fully implemented:

### 1️. Scanner (Tokenization)
- Converts source code into tokens
- Supports:
    - Numbers
    - Operators: `+ - * /`
    - Parentheses
    - Unary minus
    - EOF handling

---

### 2️. Abstract Syntax Tree (AST)
- Recursive tree-based expression modeling
- Node types implemented:
    - Literal
    - Unary
    - Binary
    - Grouping
- Clean hierarchical structure

---

### 3️. Recursive Descent Parser
- Grammar-based parsing
- Handles:
    - Operator precedence
    - Left associativity
    - Parentheses grouping
    - Unary expressions
- Detects syntax errors

---

### 4. Interpreter
- Recursively evaluates the AST
- Uses postorder traversal
- Supports:
    - Arithmetic operations
    - Unary negation
    - Grouping expressions

---

### 5️. REPL (Interactive Mode)

You can run expressions directly:

```
> 3 + 4 * 5
23.0

> (3 + 4) * 5
35.0

> -3 * (2 + 1)
-9.0
```

---

### 6️. Script Execution

You can also run `.lox` files:

```
java -cp out com.shivam.lox.Lox program.lox
```

---

# Project Architecture

```
Source Code
   ↓
Scanner (Tokens)
   ↓
Parser (AST)
   ↓
Interpreter (Evaluation)
   ↓
Output
```

Project structure:

```
src/
 └── com.shivam.lox
     ├── Lox.java
     ├── lexer/
     ├── parser/
     │    └── ast/
     └── runtime/
```

---

# ▶ How To Run

## Option 1 — Using IntelliJ
Run `Lox.java` directly.

## Option 2 — Using Terminal

### Compile
```
javac -d out $(find src -name "*.java")
```

### Run REPL
```
java -cp out com.shivam.lox.Lox
```

### Run Script
```
java -cp out com.shivam.lox.Lox file.lox
```

---

# Roadmap — Full Lox Implementation

The goal is to implement the complete Lox language, including:

- Logical operators (`&&`, `||`)
- Expression statements
- Print statements
- Variables
- Environments & Scope
- Control flow (`if`, `while`, `for`)
- Functions
- Closures
- Classes
- Inheritance
- Error recovery
- Bytecode VM (advanced phase)

---

# Purpose of This Repository

This repository exists to:

- Build deep understanding of interpreter internals
- Practice clean architecture and modular design
- Learn how programming languages work internally
- Prepare for designing custom languages from scratch

---

# Reference

Crafting Interpreters — Robert Nystrom  
https://craftinginterpreters.com/

---

# Current Phase

🟢 Arithmetic Expression Interpreter — Complete  
🟡 Next Phase — Statements and Variables

---

# Development Philosophy

- Clean separation of concerns
- Progressive feature addition
- Deep conceptual clarity
- Professional Git discipline