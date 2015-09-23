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
    
    public void debitarUmaUnidade(){
        if(this.quantidade > 0){
            this.quantidade--;
        }
    }

    public void aumentar1000Unidades() {
        this.quantidade += 1000;
    }

    public void aumentarQuantidadesComSomatorio() {
        int pa = this.quantidade * (this.quantidade+1) / 2;
        this.quantidade += 1000 * pa;
    }

    /*
     * Exercício de refatoração:
    public void shimbalaie() {
        int pa = this.quantidade * (this.quantidade+1) / 2;
        this.quantidade += 1000*pa;
    }
    */

    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
    }
}
