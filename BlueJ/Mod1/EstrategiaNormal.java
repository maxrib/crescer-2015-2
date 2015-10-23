import java.util.ArrayList;

public class EstrategiaNormal implements EstrategiaDeAtaque {

    public void atacar(ArrayList <Elfo> batalhao, ArrayList<Dwarf> dwarves){

        int nElfos = Elfo.getQtdElfos();
        int nAnoes = Dwarf.getQtdAnoes();

        int intencoesDeAtaque = nElfos*nAnoes;
        double elfosNoturnos = intencoesDeAtaque * 0.3;
        int elfosNoturnosQuePodemAtacar = (int)elfosNoturnos;
        int contagemNoturnos=0;

        for (Elfo elfo : batalhao){

            for (Dwarf dwarf : dwarves){

                if(elfo instanceof ElfoNoturno && contagemNoturnos<=elfosNoturnosQuePodemAtacar){

                    if(elfo.getStatus() == Status.VIVO)
                        elfo.atirarFlecha(dwarf);
                        
                }

            }

            System.out.println("Ataque maroto");
        }

    }
}
