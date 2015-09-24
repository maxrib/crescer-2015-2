import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;

public class ExercitoElfos {
    HashMap<Status,ArrayList<Elfo>> statusElfo;
    HashMap<String,Elfo> exercitoElfos;
    
    public ExercitoElfos(){
        exercitoElfos = new HashMap<>();
    }
    
    public void alistarElfoVerde(ElfoVerde elfo) {
        exercitoElfos.put(elfo.getNome(),elfo);
    }
    
    public void alistarElfoNoturno(ElfoNoturno elfo) {
        exercitoElfos.put(elfo.getNome(),elfo);
    }
    
    public int getTotalDeElfos()
   {
       return exercitoElfos.size();
   }
   
   public Elfo pesquisarElfo(String nome)
   {
       if(exercitoElfos.containsKey(nome))
       {
           return exercitoElfos.get(nome);
       }
       else
       {
           return null;
       }
   }
   
}
