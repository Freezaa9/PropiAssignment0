/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prop.assignment0;

/**
 *
 * @author Geoffrey-Port
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class Tokenizer implements ITokenizer {

    private List<Lexeme> listLexeme;
    private Scanner scanner = null;
    private Lexeme current = null;
    private Lexeme next = null;



    public Tokenizer() {
        listLexeme = new ArrayList<>();
    }
    
        public List<Lexeme> getListLexeme() {
        return listLexeme;
    }
    
    /**
     * Opens a file for tokenizing.
     *
     * @param fileName
     * @throws java.io.IOException
     * @throws prop.assignment0.TokenizerException
     */
    @Override
    public void open(String fileName) throws IOException, TokenizerException {
        scanner = new Scanner();
        scanner.open(fileName);       
    }

    /**
     * Returns the current token in the stream.
     *
     * @return
     */
    @Override
    public Lexeme current() {
        return current;
    }

    /**
     * Moves current to the next token in the stream.
     *
     * @throws java.io.IOException
     * @throws prop.assignment0.TokenizerException
     */
    @Override
    public void moveNext() throws IOException, TokenizerException {
        if (scanner == null) {
            throw new IOException("No open file.");
        }
        while (next == null || next.token() != Token.EOF) {         
            scanner.moveNext();
            next = extractLexeme();
            listLexeme.add(next);
        }
        listLexeme.toString();
    }

    private void consumeWhiteSpaces() throws IOException {
        while (Character.isWhitespace(scanner.current())) {
            scanner.moveNext();
        }
    }

    private Lexeme extractLexeme() throws IOException, TokenizerException {
        consumeWhiteSpaces();
        Character ch = scanner.current();
        if (ch == Scanner.EOF) {
            return new Lexeme(ch, Token.EOF);
        } else {
            return analyse(ch);
        }
    }

    private Lexeme analyse(char ch) {
        Token token;
        switch (ch) {
            case '(':
                token = Token.LEFT_PAREN;
                break;
            case ')':
                token = Token.RIGHT_PAREN;
                break;
            case '+':
                token = Token.ADD_OP;
                break;
            case '-':
                token = Token.SUB_OP;
                break;
            case '*':
                token = Token.MULT_OP;
                break;
            case '/':
                token = Token.DIV_OP;
                break;
            case '=':
                token = Token.ASSIGN_OP;
                break;
            case ';':
                token = Token.SEMICOLON;
                break;
            case '{':
                token = Token.LEFT_CURLY;
                break;
            case '}':
                token = Token.RIGHT_CURLY;
                break;
            default:
                token = Token.EOF;
                if (Character.isLetter(ch)) {
                    token = Token.IDENT;
                }
                if (Character.isDigit(ch)) {
                    token = Token.INT_LIT;
                }

        }
        return new Lexeme(ch, token);
    }

    /**
     * Closes the file and releases any system resources associated with it.
     *
     * @throws java.io.IOException
     */
    @Override
    public void close() throws IOException {
        if (scanner != null) {
            scanner.close();
        }
    }

}
