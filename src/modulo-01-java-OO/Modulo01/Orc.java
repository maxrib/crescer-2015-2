public class Orc extends Personagem
{

    public Orc(){
    }
    
    public void levarAtaque() {
        
        int dano = getItem("Escudo Uruk-Hai") == null ? 10 : 6;
        perderVida(dano);
    }
    
    public void atacar(Personagem personagem){
        
        boolean podeAtacarComEspada = podeAtacarComEspada();
        boolean podeAtacarComArco = podeAtacarComArco();
        
        if(podeAtacarComEspada || podeAtacarComArco){
            personagem.receberAtaqueDoOrc(this);
            
            if(!podeAtacarComEspada) {
                debitarFlecha();
            }
        }
        else {
            status = Status.FUGINDO;
        }
    }
    
    public void receberAtaqueDoOrc(Orc orc) {
        this.levarAtaque();
    }
    
    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }
        
        if(podeAtacarComArco()){
            return 8;
        }
        
        return 0;
    }
    
    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            perderItem(flecha);
        }
        else {
            flecha.debitarUmaUnidade();
        }
    }
    
    private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }
    
    private boolean podeAtacarComArco(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;
        
        return temArco && temFlechaProArco;
    }
    
    private void perderVida(int qtdVidaPerdida) {
        vida -= qtdVidaPerdida;
        definirStatusComBaseNaVida();
    }
    
    private void definirStatusComBaseNaVida(){
        
        super.status = vida <= 0 ? Status.MORTO : Status.FERIDO;
    }
    
    private Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
    
    public void tentarSorte() {
    }
    
}
