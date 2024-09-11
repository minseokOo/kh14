const text = "hello";
const text2 = "hi";
const text3 = "hola";

//text를 외부에서 쓸 수 있도록 내보내겠습니다. (모듈 시스템)
//export default text;

export {text, text2, text3}; //text, text2, text3을 내보내겠습니다.