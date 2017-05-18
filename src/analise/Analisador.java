package analise;

import java.io.File;

public class Analisador {
    
    public static void gerarLexer(String path){
        File file = new File(path);
        jflex.Main.generate(file);
    }
    
    public static void main(String[] args) {
        String path = "C:\\Users\\Matheus\\Google Drive\\CIÊNCIA DA COMPUTAÇÃO - 2017\\Comp\\TrabalhoCompiladores\\src\\analise\\lexica\\Lexer.flex";
        gerarLexer(path);
    }
    
}
