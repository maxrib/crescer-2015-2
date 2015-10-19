// public sealed class Personagem {
// public final class Personagem {
public abstract class Personagem {
    protected String nome;
    protected Status status;
    protected int experiencia;
    protected double vida;
    protected final Inventario inventario;

    public Personagem() {
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public String getNome() {
        return this.nome;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public double getVida() {
        return this.vida;
    }

    public void adicionarItem(Item item) {
        inventario.adicionarItem(item);
    }

    public void perderItem(Item item) {
        inventario.perderItem(item);
    }

    public void receberAtaqueDoOrc(Orc orc){
        int dano = orc.getDanoDeAtaque();
        this.vida -= dano;
    }
    
    public abstract void tentarSorte();
}