const menu = document.querySelectorAll(".master-piece .menu li");
//console.log(menu);
// console을 봤을 때 배열처럼 생겼지만 배열이 아니므로 배열의 메서드 사용 불가

for (let i = 0; i < menu.length; i++) {
  menu[i].addEventListener("click", function () {
    alert(i + "번째 입니다.");
    //alert : ()안에 담긴 내용으로 경고창을 띄운다
  });
}

const menu01 = document.querySelector(".master-piece .menu li:nth-child(1)");
//상위 요소인 document에서 querySelector를 이용해 제어하고자 하는 요소를 찾아 변수에 대입
//제어하고자 하는 요소를 찾을 땐 css문법을 사용하여 위치 등을 지시한다
menu01.addEventListener("click", function () {
  //변수 menu01에 담긴 요소에서 "click" 이벤트를 수집해 (function()으로) 제어하도록 선언
  //function() : 익명함수로, 사용자가 이벤트를 발생시켰을 때에 호출 = callback
  //예를 들어 기명함수로 되어있다면 이벤트를 발생시키기도 전에 호출되므로 주의
  alert("menu01을 눌렀습니다.");
});
const menu02 = document.querySelector(".master-piece .menu li:nth-child(2)");
menu02.addEventListener("click", function () {
  alert("menu02를 눌렀습니다.");
});
