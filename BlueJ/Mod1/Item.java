public class Item{
    public String desc;
    int qtd;
    
    public Item(String desc,int qtd){
        this.desc=desc;
        this.qtd=qtd;
    }
    
    public String getDesc(){
        return this.desc;
    }
    
    public int getQtd(){
        return this.qtd;
    }
}