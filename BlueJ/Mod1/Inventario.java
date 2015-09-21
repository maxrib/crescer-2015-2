import java.util.ArrayList;

public class Inventario{
    private ArrayList<Item> itens;
    
    public Inventario(){
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(Item item){
        this.itens.add(item);
    }
    
    public void perderItem(Item item){
        this.itens.remove(item);
    }
    
    public String getDescricoesItens(){
        int i;
        String lista = "";
        for(i=0;i<itens.size();i++){
            if(i==itens.size()-1){
                lista = lista + itens.get(i).getDesc() + ".";
            }
            else{
                lista = lista + itens.get(i).getDesc() + "";
            }
        }
        return lista;
    }
}