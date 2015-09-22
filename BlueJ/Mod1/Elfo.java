public class Elfo {
    private String nome;
    private int flechas,experiencia;
    public Status status = Status.VIVO;
    
    public Elfo(String n) {
        nome = n;
        flechas = 42;
    }
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public void atirarFlechaDwarf(Dwarf dwarf){
        dwarf.receberFlechada();
        experiencia++;
        flechas--;
        }  
        
    public void atirarFlechaIrishDwarf(IrishDwarf irishDwarf){
        irishDwarf.receberFlechada();
        experiencia++;
        flechas--;
        }  
    
    public String toString() {  
        String textoNivel = "nível";
        String textoFlechas = "flecha";
        
        if(Math.abs(this.flechas)!=1){
            textoFlechas+="s";
        }
        if(Math.abs(this.experiencia)!=1){
            textoNivel="níveis";
        }
        
        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            this.flechas,
            textoFlechas,
            this.experiencia,
            textoNivel);
    }  
    
    public int getXp(){
        return experiencia;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    
    /*public void setNome(String novoNome) {
        this.nome = novoNome;
    }*/
    
    /* 
    public void setFlechas(int flechas) {
        if (flechas > this.flechas)
            this.flechas = flechas;
    }
    */
}