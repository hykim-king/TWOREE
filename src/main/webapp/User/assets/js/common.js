/**
 * 입력 값이 비어있는지 확인하는 함수
   @param{any} value: 입력값
   @returns {boolean} 비어있으면 t, x f
 */
let isEmpty = function(value){
	
	if(null === value || value == undefined){
		return true;
	}
	if( typeof value === 'string' && value.trim() === ''){
		return true;
	}
	
	if(Array.isArray(value)&&value.lengh === 0){
		return true;
	}
	
	return false;
}