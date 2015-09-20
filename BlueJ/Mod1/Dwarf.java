public class Dwarf {
    private String nome;
    private DataTerceiraEra dataNascimento=new DataTerceiraEra(1,1,1);
    private int vida=110,experiencia=0;
    public Status status = Status.VIVO;
    
    public Dwarf(){
    }
    
    public Dwarf(String n) {
        nome = n;
    }
    
    public void receberFlechada(){
        double x= this.getNumeroSorte();
        if(x<0){
            this.experiencia+=2;
        }
        else if(x>=0 && x<=100){
            return;
        }
        else{
            this.vida-=10;
            if(this.vida<=0){
                status = Status.MORTO;
                this.vida = 0;
            }
        }
    }
    
    public double getNumeroSorte(){
        double x=101.0;
        
        if(dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <=90){
            x *= -33;
        }
        
        if(!dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            x = x * 33 % 100;
        }
        
        return x;
    }
    
    public String getNascimento(){
        return String.format("%s/%s/%s",
            this.dataNascimento.dia,
            this.dataNascimento.mes,
            this.dataNascimento.ano);
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    public int getXp(){
        return this.experiencia;
    }
}