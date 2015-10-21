var clubes = [
  {
    nome: 'Arsenal',
    fundacao: new Date(1886, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Manchester United',
    fundacao: new Date(1878, 0, 1),
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    fundacao: new Date(1892, 2, 15),
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    fundacao: new Date(1905, 2, 10),
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];


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
