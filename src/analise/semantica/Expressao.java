package analise.semantica;

public abstract class Expressao {
    public Expressao(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static ExpressaoBinaria binop(Expressao exp1, int op, Expressao exp2){return new ExpressaoBinaria(exp1, op, exp2);}    
    public static class ExpressaoBinaria extends Expressao{
        Expressao exp1, exp2;
        int op;

        public ExpressaoBinaria(Expressao exp1, int op, Expressao exp2) {
            this.exp1 = exp1;
            this.exp2 = exp2;
            this.op = op;
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ExpressaoUnaria unop(int op, Expressao exp1){return new ExpressaoUnaria(op, exp1);}
    public static class ExpressaoUnaria extends Expressao{
        Expressao exp1;
        int op;

        public ExpressaoUnaria(int op, Expressao exp1) {
            this.exp1 = exp1;
            this.op = op;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ExpressaoTernaria ternop(Expressao exp1, Expressao exp2, Expressao exp3){return new ExpressaoTernaria(exp1, exp2, exp3);}
    public static class ExpressaoTernaria extends Expressao{
        Expressao exp1, exp2, exp3;

        public ExpressaoTernaria(Expressao exp1, Expressao exp2, Expressao exp3) {
            this.exp1 = exp1;
            this.exp2 = exp2;
            this.exp3 = exp3;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ExpressaoLiteral literal(Literal literal){return new ExpressaoLiteral(literal);}
    public static class ExpressaoLiteral extends Expressao{
        Literal literal;

        public ExpressaoLiteral(Literal literal) {
            this.literal = literal;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ExpressaoVariavel variavel(Variavel variavel){return new ExpressaoVariavel(variavel);}
    public static class ExpressaoVariavel extends Expressao{
        Variavel variavel;

        public ExpressaoVariavel(Variavel variavel) {
            this.variavel = variavel;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
public static ExpressaoChamada chamada(Chamada chamada){return new ExpressaoChamada(chamada);}
    public static class ExpressaoChamada extends Expressao{
        Chamada chamada;

        public ExpressaoChamada(Chamada chamada) {
            this.chamada = chamada;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
}
