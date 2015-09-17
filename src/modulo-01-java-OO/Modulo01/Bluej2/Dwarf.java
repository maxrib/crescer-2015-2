public class Dwarf {
    private int vida=110;
    public Status status = Status.VIVO;
    
    public void receberFlechada() {
        this.vida-=10;
        if(this.vida<=0)
        status = Status.MORTO;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
}