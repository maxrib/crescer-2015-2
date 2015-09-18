public class Dwarf {
    private String nome;
    private int vida=110,experiencia=0;
    public Status status = Status.VIVO;
    
    public Dwarf(String n) {
        nome = n;
    }
    
    public void receberFlechada() {
        this.vida-=10;
        if(this.vida<=0){
        status = Status.MORTO;
        this.vida=0;
    }
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
}