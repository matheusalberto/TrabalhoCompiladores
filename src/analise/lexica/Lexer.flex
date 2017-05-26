package analise.lexica; 

import java_cup.runtime.Symbol;
import analise.sintatica.Sym;

%%

%cup
%public
%class Lexer
%line
%column

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

/* comments */
COMENTARIO = {TraditionalComment} | {EndOfLineComment}

TraditionalComment   = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment     = "//" {InputCharacter}*

LETRAS = [_|a-z|A-Z][a-z|A-Z|0-9|_]* 	 
DIGITO = [0-9][0-9]*
BRANCO=[\n| |\t|\r]
STRING = \"(.[^\"]*)\"

%%

<YYINITIAL> {

    /* Operadores Aritméticos */
    //( "+" | "-" | "*" | "/" | "%" )    {return new Symbol(Sym.OPERADOR_ARITMETICO); }
    ("+") {return new Symbol(Sym.MAIS, yyline, yycolumn, yytext());}
    ("-") {return new Symbol(Sym.MENOS, yyline, yycolumn, yytext());}
    ("/") {return new Symbol(Sym.DIVIDIR, yyline, yycolumn, yytext());}
    ("*") {return new Symbol(Sym.MULTIPLICAR, yyline, yycolumn, yytext());}
    ("%") {return new Symbol(Sym.MOD, yyline, yycolumn, yytext());}

    /* Operadores Lógicos */
    //("&&" | "||" | "&" | "|" )    {return new Symbol(Sym.OPERADOR_LOGICO);}

    ("&&") {return new Symbol(Sym.AND, yyline, yycolumn, yytext());}
    ("||") {return new Symbol(Sym.OR, yyline, yycolumn, yytext());}

    ("!") {return new Symbol(Sym.NEGACAO, yyline, yycolumn, yytext());}

    ( "?" ) {return new Symbol(Sym.INTERROGACAO, yyline, yycolumn, yytext());}


    /*Operadores Relacionais */
    //(">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>")   {return new Symbol(Sym.OPERADOR_RELACIONAL);}

    (">") {return new Symbol(Sym.MAIOR, yyline, yycolumn, yytext());}
    ("<") {return new Symbol(Sym.MENOR, yyline, yycolumn, yytext());}
    ("==") {return new Symbol(Sym.IGUAL, yyline, yycolumn, yytext());}
    ("!=") {return new Symbol(Sym.DIFERENTE, yyline, yycolumn, yytext());}
    (">=") {return new Symbol(Sym.MAIOR_IGUAL, yyline, yycolumn, yytext());}
    ("<=") {return new Symbol(Sym.MENOR_IGUAL, yyline, yycolumn, yytext());}

    /* Operadores Atribuição */
    ("+=" | "-="  | "*=" | "/=" | "%=" | "=")      {return new Symbol(Sym.OPERADOR_ATRIBUICAO);}

    /*Operadores Booleanos*/
    (true | false)      {return new Symbol(Sym.OPERADOR_BOOLEANO, yyline, yycolumn, yytext());}

    /*Separadores */
   ("(") {return new Symbol(Sym.ABREPARENTESES, yyline, yycolumn, yytext());}
   (")") {return new Symbol(Sym.FECHAPARENTESES, yyline, yycolumn, yytext());}
   ("[") {return new Symbol(Sym.ABRECOLCHETES, yyline, yycolumn, yytext());}
   ("]") {return new Symbol(Sym.FECHACOLCHETES, yyline, yycolumn, yytext());}
   ("{") {return new Symbol(Sym.ABRECHAVES, yyline, yycolumn, yytext());}
   ("}") {return new Symbol(Sym.FECHACHAVES, yyline, yycolumn, yytext());}
   (",") {return new Symbol(Sym.VIRGULA, yyline, yycolumn, yytext());}
   (";") {return new Symbol(Sym.PONTOEVIRGULA, yyline, yycolumn, yytext());}

    /*palavras reservadas */
  ("break") {return new Symbol(Sym.BREAK, yyline, yycolumn, yytext());}
  ("else") {return new Symbol(Sym.ELSE, yyline, yycolumn, yytext());}
  ("for") {return new Symbol(Sym.FOR, yyline, yycolumn, yytext());}
  ("if") {return new Symbol(Sym.IF, yyline, yycolumn, yytext());}
  ("return") {return new Symbol(Sym.RETURN, yyline, yycolumn, yytext());}
   ("while") {return new Symbol(Sym.WHILE, yyline, yycolumn, yytext());}
   ("bool") {return new Symbol(Sym.BOOL, yyline, yycolumn, yytext());}
   ("int") {return new Symbol(Sym.INT, yyline, yycolumn, yytext());}
   ("string") {return new Symbol(Sym.TIPO_STRING, yyline, yycolumn, yytext());}
   ("write") {return new Symbol(Sym.WRITE, yyline, yycolumn, yytext());}
   ("read") {return new Symbol(Sym.READ, yyline, yycolumn, yytext());}

    {BRANCO} {}
    {LETRAS} {return new Symbol(Sym.ID, yyline, yycolumn, yytext());}
    {DIGITO} {return new Symbol(Sym.NUMERO, yyline, yycolumn, yytext());}
    {STRING} {return new Symbol(Sym.STRING, yyline, yycolumn, yytext());}    
    {COMENTARIO} {}
    {DIGITO}{LETRAS} { throw new Error("Illegal character: ->"+yytext()+"<- at line "+(yyline+1)+", column "+(yycolumn+1));}
}
<<EOF>> { return new Symbol( Sym.EOF , yyline, yycolumn, yytext()); }

[^] { throw new Error("Illegal character: ->"+yytext()+"<- at line "+(yyline+1)+", column "+(yycolumn+1)); }