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

