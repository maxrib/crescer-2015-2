//Verificar se é palíndromo
String.prototype.palindromo = function () {
    return this.toLowerCase().toString() === this.split("").reverse().join("").toLowerCase();
};

//Verificar se começa com a letra 'B'
String.prototype.comecaComB = function () {
    return this[0].toUpperCase() === 'B';
};
