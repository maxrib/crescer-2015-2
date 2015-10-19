import java.util.*;

public class EstrategiaAntiNoturnos implements EstrategiaDeAtaque {
    private ArrayList<Elfo> ordemDoUltimoAtaque = new ArrayList<>();

    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }

    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves) {
        this.ordemDoUltimoAtaque.clear();

        // 1 - Filtrar VIVOS
        // C#
        // elfos.Where(x => x.Status == Status.VIVO);
        ArrayList<Elfo> vivos = new ArrayList<>();
        for (Elfo elfo : elfos) {
            if (elfo.getStatus() == Status.VIVO) {
                vivos.add(elfo);
            }
        }

        // 2 - Variáveis de controle para quantidade de ataques.
        int intencoesAtaque = vivos.size() * dwarves.size();
        int limiteElfosNoturnos = (int)(intencoesAtaque * 0.3);
        int qtdElfosNoturnosQueJáAtacaram = 0;

        // 3 - Percorrendo lista de vivos para desferir os ataques seguindo as regras
        for (Elfo elfoQueVaiAtacar : vivos) {
            boolean éElfoNoturno = elfoQueVaiAtacar instanceof ElfoNoturno;

            if (éElfoNoturno) {
                if (qtdElfosNoturnosQueJáAtacaram >= limiteElfosNoturnos)
                    continue;
                qtdElfosNoturnosQueJáAtacaram++;
            }

            ordemDoUltimoAtaque.add(elfoQueVaiAtacar);
            for (Dwarf dwarf : dwarves) {
                elfoQueVaiAtacar.atirarFlecha(dwarf);
            }
        }
    }
}