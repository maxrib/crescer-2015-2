public class Item
{
    private String descricao;
    private int quantidade;
    
    public Item(int quantidade, String descricao) {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void aumentar1000Unidades(){
        this.quantidade += 1000;
    }
    
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
    }
}
