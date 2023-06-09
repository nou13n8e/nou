//1~10
const container = document.querySelector(".map");
const options = {
  center: new kakao.maps.LatLng(35.8242238, 127.1479532),
  level: 13,
};
const map = new kakao.maps.Map(container, options);

const clusterer = new kakao.maps.MarkerClusterer({
  map: map,
  averageCenter: true,
  minLevel: 10,
});
//7 clusterer 활용을 위해 clusterer 선언 및 속성 입력

// 마커 위에 커스텀 오버레이를 표시합니다.
const overlay = new kakao.maps.CustomOverlay({
  // content: content,
  // map: map,
  // position: marker.getPosition(),
});

const searchCamping = async () => {
  //3 searchCamping이라는 함수 정의
  const camping = await fetch(
    //2 fetch를 통해 서버와 통신한 값을 camping에 대입
    "https://apis.data.go.kr/B551011/GoCamping/basedList?serviceKey=XZ6UxwzKR8MlUyDN6TwQ0Rz3wZ4CHCc%2FCKcOPMr5tScQ3Dp9DT3HJdrUsUz02ACvko57l97WEm1ckJhay3HFKQ%3D%3D&numOfRows=30&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json" //1 오픈API를 통해 활용 신청
  );
  const response = await camping.json();
  //4 response에 camping에 대입된 값을 json 형태로 대입
  //console.log(response);
  const campingList = response.response.body.items.item;
  //5 response에 대입된 값의 경로를 campingList에 대입
  //console.log(campingList);
  const markers = [];
  //8 markers라는 배열 선언
  campingList.forEach((item, idx) => {
    //6 campingList의 값을 forEach로 반복하면서 marker 생성
    const marker = new kakao.maps.Marker({
      map: map,
      position: new kakao.maps.LatLng(item.mapY, item.mapX),
    });

    // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다.
    kakao.maps.event.addListener(marker, "click", function () {
      overlay.setMap(map);
      overlay.setPosition(marker.getPosition());
      overlay.setContent(
        // 커스텀 오버레이에 표시할 컨텐츠 입니다
        // 커스텀 오버레이는 아래와 같이 사용자가 자유롭게 컨텐츠를 구성하고 이벤트를 제어할 수 있기 때문에
        // 별도의 이벤트 메소드를 제공하지 않습니다
        `<div class="wrap">
              <div class="info">
                  <div class="title">
                      ${item.facltNm}
                      <div class="close" onclick="closeOverlay()" title="닫기"></div>
                  </div>
                  <div class="body">
                      <div class="desc">
                          <div class="ellipsis">${item.addr1}</div>
                      </div>
                  </div>
              </div>
          </div>`
      );
    });
    map.setCenter(marker.getPosition());
    markers.push(marker);
    //9 markers(배열)에 반복되고 있는 marker를 push하게 설정
  });
  clusterer.addMarkers(markers);
  //10 clusterer에 markers에 대입된 값을 addMarkers하게 설정
};

searchCamping();
//함수는 정의하고 난 뒤 꼭 호출할 것!

// 커스텀 오버레이를 닫기 위해 호출되는 함수입니다.
function closeOverlay() {
  overlay.setMap(null);
}
