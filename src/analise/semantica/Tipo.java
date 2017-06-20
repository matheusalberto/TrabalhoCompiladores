package analise.semantica;

public abstract class Tipo
{
    public Tipo(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static TipoString tipoString(String tipo){return new TipoString(tipo);}    
    public static class TipoString extends Tipo{
        String tipo;

        public TipoString(String tipo) {
            this.tipo = tipo;
        }       
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static TipoInt tipoInt(String tipo){return new TipoInt(tipo);}    
    public static class TipoInt extends Tipo{
        String tipo;

        public TipoInt(String tipo) {
            this.tipo = tipo;
        }       
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static TipoBoolean tipoBoolean(String tipo){return new TipoBoolean(tipo);}    
    public static class TipoBoolean extends Tipo{
        String tipo;

        public TipoBoolean(String tipo) {
            this.tipo = tipo;
        }       
    }
//---------------------------------------------------------------------------------------------------------------------------
    
}
