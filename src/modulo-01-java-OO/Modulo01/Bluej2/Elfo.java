public class Elfo {
    private String nome;
    private int flechas,experiencia;
    
    public void atirarFlechaDwarf(Dwarf dwarf){
        dwarf.receberFlechada();
        experiencia++;
        flechas--;
        }    
    
    public String toString() {  
        return getNome() + " possui " + getFlechas() + " flechas e " + getXp() + " níveis de experiência.";
        //System.out.println(getNome() + " possui " + getFlechas() + " flechas e " + getXp() + " níveis de experiência."); 
        //return null;
    }  
        
    public Elfo(String n) {
        nome = n;
        flechas = 42;
    }
    
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
    
    public int getXp(){
        return experiencia;
    }
    
    public String getNome() {
        return nome;
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