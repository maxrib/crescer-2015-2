import java.util.ArrayList;

public class ExercitoElfos {
    private ArrayList<Elfo> elfos = new ArrayList<>();
    
    public void alistarElfoVerde(ElfoVerde elfo) {
        this.elfos.add(elfo);
    }
    
    public void alistarElfoNoturno(ElfoNoturno elfo) {
        this.elfos.add(elfo);
    }
    
}
