var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }, 
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

function ordenaPorIndice(indice, times) {

  /* Arrow functions
  return clubes.sort(
    (x,y) => x.titulos[indice].qtd < y.titulos[indice].qtd
  );
  */

  var clubes = [];

  times.sort(function(elemEsq, elemDir, clubes) {
    return elemEsq.titulos[indice].qtd < elemDir.titulos[indice].qtd;
  });

  return clubes;
};

// 1A
// Crie uma função chamada ordenaPorNacionais(Array) 
// que recebe o array de clubes e retorna o array ordenado 
// pela quantidade de títulos Nacionais descendente (Z->A).

function ordenaPorNacionais(times) {
  return ordenaPorIndice(0, times);
};

console.log('1A: ', ordenaPorNacionais(clubes.concat()));

// 1B
// Crie uma função chamada ordenaPorContinentais(Array) que recebe o array de clubes e retorna o array ordenado pela quantidade de títulos Continentais descendente (Z->A).
function ordenaPorContinentais(times) {
  return ordenaPorIndice(1, times);
};

console.log('1B: ', ordenaPorContinentais(clubes.concat()));

// 1C
// Crie uma função chamada ordenaPorMundiais(Array) que recebe o array de clubes e retorna o array ordenado pela quantidade de títulos Mundiais descendente (Z->A).

function ordenaPorMundiais(times) {
  return ordenaPorIndice(2, times);
}
console.log('1C: ', ordenaPorMundiais(clubes.concat()));

function somaPorIndice(indice, clubes) {
  // clubes.reduce( (acc, elem) => acc + elem.titulos[0].qtd, 0)
  return clubes.reduce(function(acumulador, elemAtual) {
    return acumulador + elemAtual.titulos[indice].qtd;
  }, 0);
};

// 2A
function somarPorNacionais(clubes) {
  return somaPorIndice(0, clubes);
};

console.log('2A: ', somarPorNacionais(clubes.concat()));

// 2B
function somarPorContinentais(clubes) {
  return somaPorIndice(1, clubes);
};

console.log('2B: ', somarPorContinentais(clubes.concat()));

// 2C
function somarPorTodosTitulos(clubes) {
  /*
  var soma = 0;
  [0,1,2].forEach(function(i) {
    soma += somaPorIndice(i, clubes);
  });
  return soma;
  */
  return somarPorNacionais(clubes)
    + somarPorContinentais(clubes)
    + somaPorIndice(2, clubes);
};

console.log('2C: ', somarPorTodosTitulos(clubes.concat()));

function apenasOsMelhores(clubes) {
  return clubes.filter(function(elem) {
    return elem.titulos[0].qtd > 18;
  });
};

console.log('3: ', apenasOsMelhores(clubes.concat()));




