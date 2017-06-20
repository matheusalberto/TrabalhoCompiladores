package analise.semantica;

import java.util.List;

public abstract class Comando
{
    public Comando(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static ComandoIf _if(Expressao exp, Bloco bloco){return new ComandoIf(exp, bloco);}    
    public static class ComandoIf extends Comando{
        Expressao exp;
        Bloco bloco;

        public ComandoIf(Expressao exp, Bloco bloco) {
            this.exp = exp;
            this.bloco = bloco;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ComandoIfElse _ifElse(Expressao exp, Bloco bloco1, Bloco bloco2){return new ComandoIfElse(exp, bloco1, bloco2);}    
    public static class ComandoIfElse extends Comando{
        Expressao exp;
        Bloco bloco1, bloco2;

        public ComandoIfElse(Expressao exp, Bloco bloco1, Bloco bloco2) {
            this.exp = exp;
            this.bloco1 = bloco1;
            this.bloco2 = bloco2;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ComandoWhile _while(Expressao exp, Bloco bloco){return new ComandoWhile(exp, bloco);}    
    public static class ComandoWhile extends Comando{
        Expressao exp;
        Bloco bloco;

        public ComandoWhile(Expressao exp, Bloco bloco) {
            this.exp = exp;
            this.bloco = bloco;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ComandoFor _for(Comando comandoAtribuicao1, Expressao exp, Comando comandoAtribuicao2, Bloco bloco){return new ComandoFor(comandoAtribuicao1, exp,comandoAtribuicao2, bloco);}    
    public static class ComandoFor extends Comando{
        Comando comandoAtribuicao1;
        Expressao exp;
        Comando comandoAtribuicao2;
        Bloco bloco;

        public ComandoFor(Comando comandoAtribuicao1, Expressao exp, Comando comandoAtribuicao2, Bloco bloco) {
            this.comandoAtribuicao1 = comandoAtribuicao1;
            this.exp = exp;
            this.comandoAtribuicao2 = comandoAtribuicao2;
            this.bloco = bloco;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ComandoAtribuicao atribuicao(Variavel variavel, int op, Expressao exp){return new ComandoAtribuicao(variavel, op, exp);}    
    public static class ComandoAtribuicao extends Comando{
        Variavel variavel;
        int op;
        Expressao exp;

        public ComandoAtribuicao(Variavel variavel, int op, Expressao exp) {
            this.variavel = variavel;
            this.op = op;
            this.exp = exp;
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------

    public static InterrupcaoDeLaco interrupcao(int _break){return new InterrupcaoDeLaco(_break);}    
    public static class InterrupcaoDeLaco extends Comando{
        int op;

        public InterrupcaoDeLaco(int op) {
            this.op = op;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------

    public static Read read(Variavel var){return new Read(var);}    
    public static class Read extends Comando{
        Variavel var;

        public Read(Variavel var) {
            this.var = var;
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static Write write(List<Expressao> listaExpressoes){return new Write(listaExpressoes);}    
    public static class Write extends Comando{
        List<Expressao> listaExpressoes;

        public Write(List<Expressao> listaExpressoes) {
            this.listaExpressoes = listaExpressoes;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static RetornoSubprograma _retorno(int ret){return new RetornoSubprograma(ret);}    
    public static class RetornoSubprograma extends Comando{
        int value;

        public RetornoSubprograma(int value) {
            this.value = value;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------

    public static RetornoExpressapSubprograma _retornoExp(int value, Expressao exp){return new RetornoExpressapSubprograma(value, exp);}    
    public static class RetornoExpressapSubprograma extends Comando{
        int value; Expressao exp;

        public RetornoExpressapSubprograma(int value, Expressao exp) {
            this.value = value;
            this.exp = exp;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    
    
}
