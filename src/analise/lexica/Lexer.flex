package analise.lexica;

import static analise.lexica.Token.*;


%%
%class Lexer
%type Token
LETRAS = [_|a-z|A-Z][a-z|A-Z|0-9|_]* 	 
DIGITO = [0-9][0-9]*
BRANCO=[\n| |\t|\r]
STRING = \"(.[^\"]*)\"

%{
public String lexeme;
%}
%%

/* Operadores Aritméticos */
( "+" | "-" | "*" | "/" | "%" )    {lexeme = yytext(); return OPERADOR_ARITMETICO;}

/* Operadores Lógicos */
("&&" | "||" | "!" | "&" | "|" )    {lexeme = yytext(); return OPERADOR_LOGICO;}

/*Operadores Relacionais */
(">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>")   {lexeme = yytext(); return OP_RELACIONAL;}

/* Operadores Atribuição */
("+=" | "-="  | "*=" | "/=" | "%=" | "=")      {lexeme = yytext(); return OP_ATRIBUICAO;}

/*Operadores Booleanos*/
(true | false)      {lexeme=yytext(); return OP_BOOLEANO;}

/*Separadores */
("(" | ")" | "{" | "}" | "[" | "]" | ";" | "," |  "." |  "\"")      {lexeme = yytext(); return SEPARADOR;}

/* Caracteres Especiais */
/*(\b | "\t" | "\n" | "\f")   {lexeme = yytext(); return ESPECIAL;} */

/* Comentarios */
( "//" | "/*" | "*/")     {lexeme = yytext(); return COMENTARIO;}

/*palavras reservadas */
(break | else | for | if | return | while | bool | int | string | write | read) {lexeme = yytext(); return PALAVRA;}

{BRANCO} {lexeme=yytext(); return BRANCO;}
{LETRAS} {lexeme=yytext(); return ID;}
{DIGITO} {lexeme=yytext(); return NUMERO;}
{STRING} {lexeme=yytext(); return STRING;}
{DIGITO}{LETRAS} {lexeme=yytext(); return ERROR;}

. {return ERROR;}