function Item(sku,descricao,qtd,valorUnit){
   this.sku=sku;
   this.descricao=descricao;
   this.qtd=qtd;
   this.valorUnit=valorUnit;
}

function CarrinhoDeCompras(sku,descricao,qtd,valorUnit){
   this.sku=sku;
   this.descricao=descricao;
   this.qtd=qtd;
   this.valorUnit=valorUnit;
}

   CarrinhoDeCompras.prototype.adicionarItem = function(item.sku) {
      CarrinhoDeCompras.push(item.sku,item.descricao,item.qtd,item.valorUnit);
   }
