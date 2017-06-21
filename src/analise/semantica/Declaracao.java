package analise.semantica;

import java.util.List;

public abstract class Declaracao
{
    public Declaracao(){}    

    public static DeclaracaoFuncaoComParametro declaracaoFuncaoComParametro(Tipo tipo, String id, List<Parametro> listaParametro, Bloco bloco)
    {
        return new DeclaracaoFuncaoComParametro(tipo, id, listaParametro, bloco);
    }    
    public static class DeclaracaoFuncaoComParametro extends Declaracao{
        Tipo tipo;
        String id;
        List<Parametro> listaParametro;
        Bloco bloco;

        public DeclaracaoFuncaoComParametro(Tipo tipo, String id, List<Parametro> listaParametro, Bloco bloco) {
            this.tipo = tipo;
            this.id = id;
            this.listaParametro = listaParametro;
            this.bloco = bloco;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static DeclaracaoFuncaoSemParametro declaracaoFuncaoSemParametro(Tipo tipo, String id, Bloco bloco)
    {
        return new DeclaracaoFuncaoSemParametro(tipo, id, bloco);
    }    
    public static class DeclaracaoFuncaoSemParametro extends Declaracao{
        Tipo tipo;
        String id;
        Bloco bloco;

        public DeclaracaoFuncaoSemParametro(Tipo tipo, String id, Bloco bloco) {
            this.tipo = tipo;
            this.id = id;
            this.bloco = bloco;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static DeclaracaoProcedimentoComParametro declaracaoProcedimentoComParametro(String id, List<Parametro> listaParametro, Bloco bloco)
    {
        return new DeclaracaoProcedimentoComParametro(id, listaParametro, bloco);
    }    
    public static class DeclaracaoProcedimentoComParametro extends Declaracao{
        String id;
        List<Parametro> listaParametro;
        Bloco bloco;

        public DeclaracaoProcedimentoComParametro(String id, List<Parametro> listaParametro, Bloco bloco) {
            this.id = id;
            this.listaParametro = listaParametro;
            this.bloco = bloco;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static DeclaracaoProcedimentoSemParametro declaracaoProcedimentoSemParametro(String id, Bloco bloco)
    {
        return new DeclaracaoProcedimentoSemParametro(id, bloco);
    }    
    public static class DeclaracaoProcedimentoSemParametro extends Declaracao{
        String id;
        Bloco bloco;

        public DeclaracaoProcedimentoSemParametro(String id, Bloco bloco) {
            this.id = id;
            this.bloco = bloco;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------    
    public static InicializacaoDeclaracao InicDec(Declaracao dec)
    {
        return new InicializacaoDeclaracao(dec);
    }    
    public static class InicializacaoDeclaracao extends Declaracao{

        Declaracao dec;
        
        public InicializacaoDeclaracao(Declaracao dec) 
        {
            this.dec = dec;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------    
}
