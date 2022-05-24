function createMatrixInputs(width, height) {
	var oldNode = document.querySelector('.inputbox__matrix');
    var node = document.createElement('tbody');
	node.classList.add("inputbox__matrix");
    oldNode.parentNode.replaceChild(node, oldNode);
	node = document.querySelector('.inputbox__matrix');


	var matrixInputs = []
	for (var i = 0; i < height; i += 1) {
		var row = node.insertRow()
		var inputsRow = []
    	matrixInputs.push(inputsRow)
    	for (var j = 0; j < width; j += 1) {
      		var cell = row.insertCell()	
      		var input = document.createElement('input')
			input.classList.add("inputbox__matrix__cell");
			input.classList.add("roboto-regular");
      		inputsRow.push(input)
      		input.type = 'text'
      	cell.appendChild(input)
    	}
	}
	return matrixInputs
}

function getMatrixValues(matrixInputs) {
	var res = []
	for (var i = 0; i < matrixInputs.length; i += 1) {
		var inputsRow = matrixInputs[i]
    	var valuesRow = []
   	 	for (var j = 0; j < inputsRow.length; j += 1) {
      		var input = inputsRow[j]
      		var valueNum = parseFloat(input.value)
      		if (isNaN(valueNum)) { 
        		valueNum = 0
      		}
      		valuesRow.push(valueNum)
    	}
    	res.push(valuesRow)
  	}
  	return res
}

var dimension = 3;
var dimension = 3;
var matrixInputs = createMatrixInputs(dimension, dimension);


var submitButton = document.querySelector('.inputbox__btnSubmit');
submitButton.addEventListener('click', function() {
	var matrix = getMatrixValues(matrixInputs);
	console.log('matrix', matrix);
	request = $.ajax({
		headers: {
			"Access-Control-Allow-Origin": "*"
		},
        url: "localhost:8080/matirxOperations/eigenvectors/solve",
        type: "post",
        data: matrix,
		success:function(response){
          var r=JSON.parse(response);
          console.log(r);
        },
		error : function(jqXHR, textStatus, errorThrown) {
            alert(errorThrown);
        }
    });
}, false);

var increaseButton = document.querySelector('.inputbox__btnIncrease');
increaseButton.addEventListener('click', function() {
	if(dimension >= 10) return;
	++dimension;
	matrixInputs = createMatrixInputs(dimension, dimension);
}, false);


var decreaseButton = document.querySelector('.inputbox__btnDecrease');
decreaseButton.addEventListener('click', function() {
	if(dimension <= 1) return;
	--dimension;
	matrixInputs = createMatrixInputs(dimension, dimension);
}, false);

var clearButton = document.querySelector('.inputbox__btnClear');
clearButton.addEventListener('click', function() {
	matrixInputs = createMatrixInputs(dimension, dimension);
}, false);