package analise.semantica;

public abstract class Variavel 
{   
    public Variavel(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static VariavelId id(String id){return new VariavelId(id);}    
    public static class VariavelId extends Variavel{
        String id;

        public VariavelId(String id) {
            this.id = id;
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static VariavelIdArray idArray(String id, Expressao exp){return new VariavelIdArray(id, exp);}    
    public static class VariavelIdArray extends Variavel{
        String id; 
        Expressao exp;

        public VariavelIdArray(String id, Expressao exp) {
            this.id = id;            
            this.exp = exp;
        }        
    }
}
