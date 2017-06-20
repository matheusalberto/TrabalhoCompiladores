package analise.semantica;

import java.util.List;

public abstract class Chamada 
{
    public Chamada(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static ChamadaComParametro chamadaParametro(String id, List<Expressao> listaExpressoes){return new ChamadaComParametro(id, listaExpressoes);}    
    public static class ChamadaComParametro extends Chamada{
        String id;
        List<Expressao> listaExpressoes;

        public ChamadaComParametro(String id, List<Expressao> listaExpressoes) {
            this.id = id;
            this.listaExpressoes = listaExpressoes;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static ChamadaSemParametro chamadaSemParametro(String id){return new ChamadaSemParametro(id);}    
    public static class ChamadaSemParametro extends Chamada{
        String id;

        public ChamadaSemParametro(String id) {
            this.id = id;
        }
    }
    
}
