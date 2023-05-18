const menu = document.querySelectorAll(".master-piece .menu li");
//console.log(menu);
// console을 봤을 때 배열처럼 생겼지만 배열이 아니므로 배열의 메서드 사용 불가

const contentsList = document.querySelectorAll(".master-piece .contents li");

menu.forEach((item01, idx01) => {
  item01.addEventListener("mouseenter", () => {
    // console.log(idx01 + "번째 입니다.");
    contentsList.forEach((item02, idx02) => {
      item02.classList.remove("on");
    });
    const target = document.querySelector(`.master-piece .contents li:nth-child(${idx01 + 1})`);
    target.classList.add("on");
  });
  item01.addEventListener("mouseleave", () => {
    contentsList.forEach((item02, idx02) => {
      item02.classList.remove("on");
    });
  });
});
// => : function()대신에 화살표 함수(fat arrow) 사용 가능
// 함수를 변수에 할당 가능(함수가 데이터처럼 기능)
// 다른 함수를 인자(argument)로 전달 가능, 결과로 리턴 가능

// const sum = (a,b) => a + b;
// console.log(sum(100,100));
// 함수 선언(호출 가능), 함수 표현(호출 불가) 주의
// 식이 한 줄인 경우 {}, return 생략 가능

const header = document.querySelector(".header");
const gnbList = document.querySelectorAll(".gnb .list > li");
gnbList.forEach(function (item, idx) {
  item.addEventListener("mouseenter", function () {
    header.classList.add("on");
    //mouseenter = 마우스가 올라갔을 때 function으로 제어(header에 on클래스 추가)
  });
  item.addEventListener("mouseleave", function () {
    header.classList.remove("on");
    //mouseleave = 마우스가 내려갔을 때 function으로 제어(header에 on클래스 제거)
  });
});

const swiper = new Swiper(".social .mask", {
  speed: 600,
  slidesPerView: 4,
  spaceBetween: 25,
  loop: true,
  navigation: {
    nextEl: ".social .btns .btn-next",
    prevEl: ".social .btns .btn-prev",
  },
  pagination: {
    el: ".social .pagination .inner",
    type: "progressbar",
  },
});
