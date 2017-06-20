package analise.semantica;

import java.util.List;

public abstract class DecVar extends Declaracao
{
    public DecVar(){}
    
    //---------------------------------------------------------------------------------------------------------------------------
    public static DeclaracaoVariavel _decVar(Tipo tipo, List<SpecVar> specVarSeq){return new DeclaracaoVariavel(tipo, specVarSeq);}    
    public static class DeclaracaoVariavel extends DecVar{
        Tipo tipo;
        List<SpecVar> specVarSeq;

        public DeclaracaoVariavel(Tipo tipo, List<SpecVar> specVarSeq) {
            this.tipo = tipo;
            this.specVarSeq = specVarSeq;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    
}
