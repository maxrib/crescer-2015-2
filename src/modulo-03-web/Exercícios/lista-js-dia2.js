//EXERCÍCIO 1A
function ordenarPorNacionais(array){
   array.sort((a,b)=>a.titulos[0].qtd<b.titulos[0].qtd);
   for(var i=0;i<array.length;i++){console.log(clubes[i].nome);};
};

//EXERCÍCIO 1B
function ordenarPorContinentais(array){
   array.sort((a,b)=>a.titulos[1].qtd<b.titulos[1].qtd);
   for(var i=0;i<array.length;i++){console.log(clubes[i].nome);};
};

//EXERCÍCIO 1C
function ordenarPorMundiais(array){
   array.sort((a,b)=>a.titulos[2].qtd<b.titulos[2].qtd);
   for(var i=0;i<array.length;i++){console.log(clubes[i].nome);};
};

//MELHORIA EXERCÍCIO 1
function ordenarPorTitulos(indice,array){
   array.sort((a,b)=>a.titulos[indice].qtd<b.titulos[indice].qtd);
   for(var i=0;i<array.length;i++){console.log(clubes[i].nome);};
}

//EXERCÍCIO 2A
function somarPorNacionais(array){
   var total=0;
   for(var i=0;i<array.length;i++){
      total=total+(clubes[i].titulos[0].qtd);
   }
   return total;
};

//EXERCÍCIO 2B
function somarPorContinentais(array){
   var total=0;
   for(var i=0;i<array.length;i++){
      total=total+(clubes[i].titulos[1].qtd);
   }
   return total;
};

//EXERCÍCIO 2C
function somarPorTodosTitulos(array){
   var total=0;
   for(var i=0;i<array.length;i++){
      for(var c=0;c<array[i].titulos.length;c++){
         total=total+(array[i].titulos[c].qtd);
      }
   }
   return total;
};

//EXERCÍCIO 3
function apenasOsMelhores(array){
   return array.filter(function(elem) {
     return elem.titulos[0].qtd > 18;
   });
};
