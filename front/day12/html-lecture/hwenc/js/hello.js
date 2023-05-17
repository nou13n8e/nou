let name = "장선영";
const pi = 3.14;
//변수 앞에 let, const를 붙일 수 있다(js에는 타입이 없다)
name = 10;
//const는 변수를 바꿀 수 없고(불변성), let은 변수를 바꿀 수 있다
console.log(10 + 10);
//사칙연산이 모두 가능하다
for (let i = 0; i < 3; i++) {
  console.log("hello js");
}
console.log(name);
//let을 사용해 변수가 변하는 것을 볼 수 있다

function add(a, b) {
  return a + b;
}
const result = add(10, 20);
console.log(result);
