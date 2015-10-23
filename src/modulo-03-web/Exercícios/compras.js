var itens=[];

function Item(sku,desc,qtd,valorUnit){
   itens.push({   sku: this.sku=sku,
                  descricao: this.desc=desc,
                  quantidade: this.qtd=qtd,
                  ValorUnitario: this.valorUnit=valorUnit});
};

var CarrinhoDeCompras=[];

function addToCart(skuItem){
   itens.filter(function(elem) {
      if(elem.sku===skuItem){
         CarrinhoDeCompras.push(elem);
      }
   });
};
