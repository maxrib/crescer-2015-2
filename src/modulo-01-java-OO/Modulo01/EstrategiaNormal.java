import java.util.ArrayList;

// C#
// public class EstrategiaNormal : IEstrategiaDeAtaque, IOutroContrato
public class EstrategiaNormal implements EstrategiaDeAtaque {
    
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> pelotao, ArrayList<Dwarf> dwarves) {        
        
        ordemDoUltimoAtaque.clear();
        
        for (Elfo elfo : pelotao) {
            ordemDoUltimoAtaque.add(elfo);
            for (Dwarf dwarf : dwarves) {
                elfo.atirarFlecha(dwarf);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }
}