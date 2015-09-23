public class Personagem{
    protected Inventario inventario = new Inventario();
    protected String nome;
    protected int experiencia,vida;
    protected Status status;
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void receberAtaqueDoOrc(Orc orc){
        int danoCausado = orc.getDanoDeAtaque();
        this.vida -= danoCausado;
    }
}