package analise.semantica;

import java.util.List;

public abstract class Bloco 
{
    public Bloco(){}
    
//---------------------------------------------------------------------------------------------------------------------------
    public static BlocoDecVarListComandos decVarListComandos(List<DecVar> decVarList, List<Comando> comandos)
    {
        return new BlocoDecVarListComandos(decVarList, comandos);
    }    
    public static class BlocoDecVarListComandos extends Bloco{
        List<DecVar> decVarList;
        List<Comando> comandos;

        public BlocoDecVarListComandos(List<DecVar> decVarList, List<Comando> comandos) {
            this.decVarList = decVarList;
            this.comandos = comandos;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static BlocoDecVarList decVarList(List<DecVar> decVarList)
    {
        return new BlocoDecVarList(decVarList);
    }    
    public static class BlocoDecVarList extends Bloco{
        List<DecVar> decVarList;

        public BlocoDecVarList(List<DecVar> decVarList) {
            this.decVarList = decVarList;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    public static BlocoComandos comandos(List<Comando> comandos)
    {
        return new BlocoComandos(comandos);
    }    
    public static class BlocoComandos extends Bloco{
        List<Comando> comandos;

        public BlocoComandos(List<Comando> comandos) {
            this.comandos = comandos;
        }
    }
//---------------------------------------------------------------------------------------------------------------------------
    
}
