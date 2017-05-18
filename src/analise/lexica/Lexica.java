package analise.lexica;

import java.io.IOException;
import java.io.StringReader;
import javax.swing.JTextArea;

public class Lexica {
    
    public static void executarAnaliseLexica(JTextArea txtEntrada, JTextArea txtAreaResp) throws IOException{
        int linha = 1; int coluna = 1;
        JTextArea jText = txtEntrada;
        String expr;
        expr = (String) jText.getText();
        Lexer lexer = new Lexer(new StringReader(expr));

        String resultado = "";

        while (true) {
            Token token = lexer.yylex();
            if (token == null) {

                txtAreaResp.setText(resultado);
                return;
            }            
            switch (token) {
                case PALAVRA:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[PALAVRA_RESERVADA] => " + lexer.lexeme + "\n";
                    break;
                case OPERADOR_ARITMETICO:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[OPERADOR_ARITMÉTICO] => " + lexer.lexeme + "\n";
                    break;
                case OPERADOR_LOGICO:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[OPERADOR_LÓGICO] => " + lexer.lexeme + "\n";
                    break;
                case OP_ATRIBUICAO:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[OPERADOR_ATRIBUIÇÃO] => " + lexer.lexeme + "\n";
                    break;
                case OP_RELACIONAL:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[OPERADOR_RELACIONAL] => " + lexer.lexeme + "\n";
                    break;
                case OP_BOOLEANO:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[OPERADOR_BOOLEANO] => " + lexer.lexeme + "\n";
                    break;
                case SEPARADOR:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[SEPARADOR] => " + lexer.lexeme + "\n";
                    break;
                case ESPECIAL:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[CARACTER_ESPECIAL] => " + lexer.lexeme + "\n";
                    break;
                case COMENTARIO:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[COMENTÁRIO] => " + lexer.lexeme + "\n";
                    break;
                case ERROR:                    
                    resultado = resultado + "[Linha: " + linha +
                            ", Coluna: " + coluna +
                            ". ERRO LÉXICO, símbolo não reconhecido]" + "\n";
                    coluna = coluna + lexer.lexeme.length();
                    break;
                case ID:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[ID] => " + lexer.lexeme + "\n";
                    break;
                case BRANCO:
                    if(lexer.lexeme.equals("\n")){
                        coluna = 1; linha++;
                    } else coluna = coluna + lexer.lexeme.length();
                    //resultado = resultado + "<BRANCO> " + lexer.lexeme + "\n";
                    break;
                case NUMERO:      
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[NÚMERO] => " + lexer.lexeme + "\n";
                    break;
                case STRING:
                    coluna = coluna + lexer.lexeme.length();
                    resultado = resultado + "[STRING] => " + lexer.lexeme + "\n";
                    break;
                default:
                    resultado = resultado + "[" + lexer.lexeme + "]";                    
            }
        }
    }
    
}
