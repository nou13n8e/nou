const container = document.querySelector(".map");
const options = {
  center: new kakao.maps.LatLng(35.8242238, 127.1479532),
  level: 13,
};
const map = new kakao.maps.Map(container, options);

const searchCamping = async () => {
  const camping = await fetch(
    "https://apis.data.go.kr/B551011/GoCamping/basedList?serviceKey=XZ6UxwzKR8MlUyDN6TwQ0Rz3wZ4CHCc%2FCKcOPMr5tScQ3Dp9DT3HJdrUsUz02ACvko57l97WEm1ckJhay3HFKQ%3D%3D&numOfRows=30&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json"
  );
  const response = await camping.json();
  //console.log(response);
  const campingList = response.response.body.items.item;
  //console.log(campingList);
  campingList.forEach((item, idx) => {
    const marker = new kakao.maps.Marker({
      map: map,
      position: new kakao.maps.LatLng(item.mapY, item.mapX),
    });
  });
};

searchCamping();
