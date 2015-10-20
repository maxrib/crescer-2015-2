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

