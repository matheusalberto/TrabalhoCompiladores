package analise.semantica;

import java.util.List;

public abstract class SpecVar 
{
    public SpecVar(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static SpecVarId id(String id){return new SpecVarId(id);}    
    public static class SpecVarId extends SpecVar{
        String id;

        public SpecVarId(String id) {
            this.id = id;
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------

    public static SpecVarIdAtribuicao idAtribuicao(String id, Literal literal){return new SpecVarIdAtribuicao(id, literal);}    
    public static class SpecVarIdAtribuicao extends SpecVar{
        String id; Literal literal;

        public SpecVarIdAtribuicao(String id, Literal literal) {
            this.id = id;
            this.literal = literal;
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------
    
    public static SpecVarIdArray idArray(String id, String num){return new SpecVarIdArray(id, num);}    
    public static class SpecVarIdArray extends SpecVar{
        String id; int num;

        public SpecVarIdArray(String id, String num) {
            this.id = id;
            this.num = Integer.parseInt(num);
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------
    
    public static SpecVarIdArrayAtribuicao idArrayAtribuicao(String id, String num, List<Literal> lista){return new SpecVarIdArrayAtribuicao(id, num, lista);}    
    public static class SpecVarIdArrayAtribuicao extends SpecVar{
        String id; int num; List<Literal> lista;

        public SpecVarIdArrayAtribuicao(String id, String num, List<Literal> lista) {
            this.id = id;
            this.num = Integer.parseInt(num);
            this.lista = lista;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    
}
