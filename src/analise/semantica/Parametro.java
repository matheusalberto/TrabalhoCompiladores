package analise.semantica;

public abstract class Parametro 
{
    public Parametro(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static ParametroComum parametro(Tipo tipo, String id){return new ParametroComum(tipo, id);}    
    public static class ParametroComum extends Parametro{
        Tipo tipo;
        String id;

        public ParametroComum(Tipo tipo, String id) {
            this.tipo = tipo;
            this.id = id;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ParametroArray parametroArray(Tipo tipo, String id){return new ParametroArray(tipo, id);}    
    public static class ParametroArray extends Parametro{
        Tipo tipo;
        String id;

        public ParametroArray(Tipo tipo, String id) {
            this.tipo = tipo;
            this.id = id;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------    
}
