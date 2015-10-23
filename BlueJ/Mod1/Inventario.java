import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Item> itens = new ArrayList<>();
    
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }
    
    public void perderItem(Item item) {
        this.itens.remove(item);
    }
    
    public ArrayList<Item> getItens() {
        return this.itens;
    }
    
    public Item getItemPorDescricao(String descricao){
        for(Item item : this.itens){
            if(item.getDescricao().equals(descricao)) {
                return item;
            }
        }
        
        return null;
    }
    
    public String getDescricoesItens() {
        String descricoes = "";
        
        for (Item item : this.itens) {
            descricoes += item.getDescricao() + ",";
        }
        
        return descricoes.substring(0, descricoes.length() - 1);
    }
    
    public void aumentar1000UnidadesEmCadaItem() {
        for (Item item : this.itens) {
            item.aumentar1000Unidades();
        }
    }
    
    public Item getItemComMaiorQuantidade() {
        int indice = 0, maiorQtd = 0;
        
        for (Item item : this.itens) {
            int qtdAtual = item.getQuantidade();
            if (qtdAtual > maiorQtd) {
                indice = this.itens.indexOf(item);
                maiorQtd = qtdAtual;
            }
        }
        
        // C#6
        // return this.itens.Max(x => x.Quantidade);
        
        return this.itens.get(indice);
    }
    
    public void ordenarItens() {        
        // Versão mais simples porém mais instável do BubbleSort - sempre O(n^2)
        int numeroItens = this.itens.size();
        
        for (int i = 0; i < numeroItens; i++) {
            for (int j = 0; j < numeroItens - 1; j++) {
                Item itemAtual = this.itens.get(j);
                Item proximo = this.itens.get(j + 1);
                
                boolean precisaTrocar = 
                    itemAtual.getQuantidade() > proximo.getQuantidade();
                
                if (precisaTrocar) {
                    this.itens.set(j, proximo);
                    this.itens.set(j + 1, itemAtual);
                }
            }
        }        
        
        // Java - MergeSort - O(n logn)
        /*Collections.sort(this.itens, new Comparator<Item>() {
            public int compare(Item item, Item outroItem) {
                return Integer.compare(item.getQuantidade(), outroItem.getQuantidade());
            }
        });*/
        
        
        // C# - MergeSort - O(n logn)
        // return this.itens.OrderBy(x => x.Quantidade);
        
        // Ruby - QuickSort - O (n logn) em média, porém pior caso O(n^2)
        // itens.sort_by { |x| x.quantidade }
    }
    
    public void aumentarUnidadesComSomatorio() {
        for (Item item : this.itens) {
            item.aumentarQuantidadesComSomatorio();
        }
    }
    
    public boolean equals(Object obj) {
        Inventario outroInventario = (Inventario)obj;
        return this.itens.equals(outroInventario.getItens());
    }
}
