import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;

public class ExercitoElfos {
    private HashMap<String,Elfo> exercitoElfos = new HashMap<>();
    private HashMap<Status,ArrayList<Elfo>> statusElfo = new HashMap<>();

    public void alistarElfo(Elfo elfo){
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        
        if(podeAlistar)
        this.exercitoElfos.put(elfo.getNome(),elfo);
    }
    
    public ExercitoElfos(){
        exercitoElfos = new HashMap<>();
    }

    public int getTotalDeElfos(){
        return exercitoElfos.size();
    }

    public Elfo pesquisarElfo(String nome)
    {
        if(exercitoElfos.containsKey(nome)){
            return exercitoElfos.get(nome);
        }
        else{
            return null;
        }
    }

    public HashMap getExercito(){
        return exercitoElfos;
    }

    public void agruparPorStatus() {
        statusElfo.clear();
        
        for (Elfo elfo : exercitoElfos.values()) {
            if(statusElfo.get(elfo.getStatus()) == null) 
                statusElfo.put(elfo.getStatus(),new ArrayList<Elfo>());
            statusElfo.get(elfo.getStatus()).add(elfo); 
        }
        //ArrayList<Elfo> exibir = statusElfo.get(statusElfo);            
        //return exibir;
    }

}
