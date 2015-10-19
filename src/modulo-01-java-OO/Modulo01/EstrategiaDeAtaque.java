import java.util.ArrayList;

public interface EstrategiaDeAtaque {
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
    void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves);
}
