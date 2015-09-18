public class DataTerceiraEra {
    private String mes;
    private int dia,ano;
    
    public DataTerceiraEra(int dia, String mes, int ano){
        this.dia=dia;
        this.mes=mes;
        this.ano=ano;
    }
    
    public int getDia(){
        return this.dia;
    }
    
    public String getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    public boolean ehBissexto(){
        boolean x = (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
        return x;
    }
}