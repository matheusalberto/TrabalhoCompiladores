package analise.semantica;

import analise.semantica.Declaracao.DeclaracaoProcedimentoSemParametro;
import analise.semantica.Declaracao.InicializacaoDeclaracao;

public class AnaliseSemantica {
    public Boolean AnalisarPrograma(Programa programa)
    {
        Boolean retornouOk = true;
        for(Declaracao dec : programa.declaracoes)
        {
            Class<? extends Declaracao> c = dec.getClass();
            String Name = c.getSimpleName();            
            if(Name.equals("InicializacaoDeclaracao")) {
                InicializacaoDeclaracao decResult = (InicializacaoDeclaracao) dec;
                retornouOk = AnalisarInicializacaoDeclaracao(decResult); 
            } else if(Name.equals("InicializacaoDecVar")){
                
            }
            //retornouOk = AnalisarDeclaracao(decResult); 
            
            if(!retornouOk){
                System.out.println("Erro...");
                return retornouOk;
            }
            
        }
        return retornouOk;
    }
    
    public Boolean AnalisarInicializacaoDeclaracao(InicializacaoDeclaracao declaracao)
    {
        Declaracao dec = declaracao.dec;
        Class<? extends Declaracao> c = dec.getClass();
        String Name = c.getSimpleName();
        
        if(Name.equals("DeclaracaoProcedimentoSemParametro")){
            DeclaracaoProcedimentoSemParametro newDec = (DeclaracaoProcedimentoSemParametro) dec;
        }
        
        Boolean retornouOk = true; 
        return retornouOk;
    }
}
