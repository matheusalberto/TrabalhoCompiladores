package analise.lexica; 

import java_cup.runtime.Symbol;

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
    ("+") {return new Symbol(Sym.MAIS);}
    ("-") {return new Symbol(Sym.MENOS);}
    ("/") {return new Symbol(Sym.DIVIDIR);}
    ("*") {return new Symbol(Sym.MULTIPLICAR);}
    ("%") {return new Symbol(Sym.MOD);}

    /* Operadores Lógicos */
    //("&&" | "||" | "&" | "|" )    {return new Symbol(Sym.OPERADOR_LOGICO);}

    ("&&") {return new Symbol(Sym.AND);}
    ("||") {return new Symbol(Sym.OR);}

    ("!") {return new Symbol(Sym.NEGACAO);}

    ( "?" ) {return new Symbol(Sym.INTERROGACAO);}


    /*Operadores Relacionais */
    //(">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>")   {return new Symbol(Sym.OPERADOR_RELACIONAL);}

    (">") {return new Symbol(Sym.MAIOR);}
    ("<") {return new Symbol(Sym.MENOR);}
    ("==") {return new Symbol(Sym.IGUAL);}
    ("!=") {return new Symbol(Sym.DIFERENTE);}
    (">=") {return new Symbol(Sym.MAIOR_IGUAL);}
    ("<=") {return new Symbol(Sym.MENOR_IGUAL);}

    /* Operadores Atribuição */
    ("+=" | "-="  | "*=" | "/=" | "%=" | "=")      {return new Symbol(Sym.OPERADOR_ATRIBUICAO);}

    /*Operadores Booleanos*/
    (true | false)      {return new Symbol(Sym.OPERADOR_BOOLEANO);}

    /*Separadores */
   ("(") {return new Symbol(Sym.ABREPARENTESES);}
   (")") {return new Symbol(Sym.FECHAPARENTESES);}
   ("[") {return new Symbol(Sym.ABRECOLCHETES);}
   ("]") {return new Symbol(Sym.FECHACOLCHETES);}
   ("{") {return new Symbol(Sym.ABRECHAVES);}
   ("}") {return new Symbol(Sym.FECHACHAVES);}
   (",") {return new Symbol(Sym.VIRGULA);}
   (";") {return new Symbol(Sym.PONTOEVIRGULA);}

    /*palavras reservadas */
  (“break”) {return new Symbol(Sym.BREAK);}
  (“else”) {return new Symbol(Sym.ELSE);}
  (“for”) {return new Symbol(Sym.FOR);}
  (“if”) {return new Symbol(Sym.IF);}
  (“return”) {return new Symbol(Sym.RETURN);}
   (“while”) {return new Symbol(Sym.WHILE);}
   (“bool”) {return new Symbol(Sym.BOOL);}
   (“int”) {return new Symbol(Sym.INT);}
   (“string”) {return new Symbol(Sym.TIPO_STRING);}
   (“write”) {return new Symbol(Sym.WRITE);}
   (“read”) {return new Symbol(Sym.READ);}

    {BRANCO} {}
    {LETRAS} {return new Symbol(Sym.ID);}
    {DIGITO} {return new Symbol(Sym.NUMERO);}
    {STRING} {return new Symbol(Sym.STRING);}    
    {COMENTARIO} {}
    {DIGITO}{LETRAS} { throw new Error("Illegal character: "+yytext()+" at line "+(yyline+1)+", column "+(yycolumn+1) ); }
}
<<EOF>> { return new Symbol( Sym.EOF ); }

[^] { throw new Error("Illegal character: "+yytext()+" at line "+(yyline+1)+", column "+(yycolumn+1) ); }