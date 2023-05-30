Splitting();
AOS.init();

const header = document.querySelector(".header");
window.addEventListener("scroll", () => {
  console.log(window.scrollY);
  const scrollY = window.scrollY;
  if (scrollY > 1000) {
    header.classList.add("on");
  } else {
    header.classList.remove("on");
  }
});

const mainSwiper = new Swiper(".main-mask", {
  loop: true,
});

const midSwiper = new Swiper(".mid-mask", {
  loop: true,
  slidesPerView: 3,
  spaceBetween: 100,
});

const lowerSwiper = new Swiper(".lower-mask", {
  loop: true,
});
