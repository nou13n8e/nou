const gnbList = document.querySelectorAll(".gnb .list > li");
const header = document.querySelector(".header");
gnbList.forEach((item, idx) => {
  item.addEventListener("mouseenter", () => {
    header.classList.add("on");
  });
});
header.addEventListener("mouseleave", () => {
  header.classList.remove("on");
});

new Swiper(".media .mask", {
  slidesPerView: "auto",
  centeredSlides: true,
  //가운데를 중심으로 펼쳐지게 설정
  spaceBetween: 20,
  //슬라이드 사이의 여백
  loop: true,
});
