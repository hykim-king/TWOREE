/**
	입력 값이 비어있는지 확인하는 함수
	@param {any} value : 입력값
	@return {boolean} 비어 있으면 true
 */
let isEmpty = function(value){
	
	if(null === value || value == undefined){
		return true;
	}
	
	if(typeof value === 'String' && value.trim() === ''){
		return true;
	}
	
	if(Array.isArray(value) &&value.length === 0){
		return true;
	}
	
	return false;
}