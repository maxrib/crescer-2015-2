
/**
 * Escreva a descrição da classe UrukHai aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class UrukHai extends Orc
{
    public UrukHai(){
        Item escudoUrukHai = new Item(1, "Escudo Uruk-Hai");
        Item espada = new Item(1, "Espada");
        super.adicionarItem(escudoUrukHai);
        super.adicionarItem(espada);
        super.vida = 150;
    }
}
