Splitting();

const header = document.querySelector(".header");
// header.classList.add("on");
// 사용자가 scroll을 해서 높이가 0보다 커지면 header의 class에 on을 붙인다

window.addEventListener("scroll", () => {
  console.log(window.scrollY);
  const scrollY = window.scrollY;
  if (scrollY > 0) {
    header.classList.add("on");
  } else {
    header.classList.remove("on");
  }
});

gsap.from(".main-visual .slogan .char", { y: 100, opacity: 0, ease: "power3", duration: 1, delay: 1, stagger: 0.02 });

new Swiper(".banner .mask", {
  slidesPerView: "auto",
  //auto를 사용할 거라면 반드시 넓이 지정 (-main.css)
  spaceBetween: 30,
  //슬라이드 사이의 간격 조정
  loop: true,
  navigation: {
    prevEl: ".banner .mask .btn-prev",
    nextEl: ".banner .mask .btn-next",
  },
  pagination: {
    el: ".banner .mask .pagination",
    clickable: true,
    //pagination을 눌러도 슬라이드 이동
  },
});

new Swiper(".partner .brand", {
  slidesPerView: "auto",
  speed: 1000,
  loop: true,
  loopedSlides: 5,
  autoplay: {
    delay: 10,
    disableOnInteraction: false,
  },
});
