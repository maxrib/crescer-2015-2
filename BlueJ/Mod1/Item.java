public class Item{
    public String desc;
    int qtd;
    
    public Item(String desc,int qtd){
        this.desc=desc;
        this.qtd=qtd;
    }
    
    public Item(String desc){
        this.desc=desc;
        this.qtd=1;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
    public int getQtd(){
        return this.qtd;
    }
    
    public void setQtdLeprechaun(){
        this.qtd += 1000;
    }
}