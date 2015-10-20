//EXERCÍCIO 1
function isNumber(n){
	return !isNaN(n)
}

function daisygame(p1) {
	if(isNumber(p1) && p1%2==0) {
		return 'Love me not';
	}
else {
		return 'Love me';
}
};

//EXERCÍCIO 2
function maiorTexto(mt) {
	if(mt.length===1){longest=mt[0]}
	else{
		for(var i=1; i < mt.length; i++) {
			if(mt[i].length > mt[i-1].length) {
				longest = mt[i];
			}
		}
	}
	return longest;
}

//EXERCÍCIO 3
function imprime(arr,func) {
	if(typeof func==="function") {
		for(var i=0;i < arr.length;i++) {
			func(arr[i]);
		}
	}
	else {
		return 'shimbalacreks';
	}
};

//EXERCÍCIO 4
var fibonacci = function(n){
	if(n===1) return 1;
	if(n===2) return 1;
	return fibonacci(n-1)+fibonacci(n-2);
};

function fibonaSum(n){
	if (n===1) return 1;
	return fibonacci(n)+fibonaSum(n-1);
}

