public class DataTerceiraEra {
    public int dia,mes,ano;
    
    public  DataTerceiraEra(int dia, int mes, int ano){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }
    
    public String toStringData(){
        return String.format("%d/%d/%d",
            this.dia,
            this.mes,
            this.ano);
    }
    
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public boolean ehBissexto(){
        return (this.ano % 400 == 0) || (this.ano % 4 == 0 && this.ano % 100 != 0);
    }
}