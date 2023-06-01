const thumbsList = document.querySelector(".thumbs-box ul");
const search = document.querySelector(".search");
search.addEventListener("keyup", (e) => {
  if (e.key === "Enter" || e.keyCode === 13) {
    const searchWord = search.value;
    searchImg(searchWord);
  }
});

//기존에 검색했던 이미지 없어지게 하기 1
const removeItem = () => {
  const imgItem = document.querySelectorAll(".thumbsList ul li");
  imgItem.forEach((item, idx) => {
    item.remove();
  });
};

const searchImg = async (searchWord) => {
  //기존에 검색했던 이미지 없어지게 하기 2
  removeItem();
  const imgResponse = await fetch(`https://dapi.kakao.com/v2/search/vclip?query=${searchWord}&size=30`, {
    headers: {
      Authorization: "KakaoAK 846226e98cc351f6022662efd632e220",
    },
  });
  const imgJson = await imgResponse.json();
  const imgList = imgJson.documents;
  imgList.forEach((item, idx) => {
    const li = document.createElement("li");
    const img = document.createElement("img");
    const a = document.createElement("a");
    img.src = item.thumbnail;
    a.href = item.url;
    //2 큰 이미지 경로 입력
    a.setAttribute("data-fancybox", "gallery");
    //3 fancybox 설정
    a.append(img);
    //1 a태그 추가
    li.append(a);
    thumbsList.append(li);
  });
  gsap.from(".thumbsList li", { scale: 0, duration: 1, stagger: 0.02 });
  //3 fancybox 적용
  Fancybox.bind("[data-fancybox", {});
};
