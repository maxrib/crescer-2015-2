public class Elfo {
    private String nome;
    private int flechas,experiencia;
    public int atirarFlecha(){
        if(flechas==0){
            return flechas;
        }
        else{
            experiencia++;
            flechas--;
            return experiencia;
        }
    }
    public Elfo(String n) {
        nome = n;
        flechas = 42;
    }
    public Elfo(String n, int flech) {
        nome = n;
        flechas = flech;
    }
}