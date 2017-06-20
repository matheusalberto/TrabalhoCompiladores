package analise.semantica;

public abstract class Literal 
{
    public Literal(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static LiteralNumero numero(String numeroString){return new LiteralNumero(numeroString);}    
    public static class LiteralNumero extends Literal{
        int numero;

        public LiteralNumero(String numeroString) {
            this.numero = Integer.parseInt(numeroString);
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static LiteralString string(String string){return new LiteralString(string);}    
    public static class LiteralString extends Literal{
        String string;

        public LiteralString(String string) {
            this.string = string;
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------   
    public static LiteralBoolean bool(String boolString){return new LiteralBoolean(boolString);}    
    public static class LiteralBoolean extends Literal{
        Boolean bool;

        public LiteralBoolean(String boolString) {
            this.bool = Boolean.parseBoolean(boolString);
        }        
    }
//---------------------------------------------------------------------------------------------------------------------------  
}