const container = document.querySelector(".map");
const options = {
  center: new kakao.maps.LatLng(35.8242238, 127.1479532),
  level: 13,
};
const map = new kakao.maps.Map(container, options);

// 마커 클러스터러를 생성
const clusterer = new kakao.maps.MarkerClusterer({
  map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
  averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
  minLevel: 10, // 클러스터 할 최소 지도 레벨
});

//마커 위에 커스텀 오버레이를 표시
const overlay = new kakao.maps.CustomOverlay({
  //content: content,
  //map: map,
  //position: marker.getPosition(),
});

const searchChargePlace = async (place) => {
  clusterer.clear();
  const charge = await fetch(
    `https://api.odcloud.kr/api/EvInfoServiceV2/v1/getEvSearchList?page=1&perPage=1000&cond%5Baddr%3A%3ALIKE%5D=${place}&serviceKey=XZ6UxwzKR8MlUyDN6TwQ0Rz3wZ4CHCc%2FCKcOPMr5tScQ3Dp9DT3HJdrUsUz02ACvko57l97WEm1ckJhay3HFKQ%3D%3D`
  );
  const response = await charge.json();
  // .then(function (response) {
  //   return response.json();
  // })
  // .then(function (data) {
  //   console.log(data);
  const evchargeList = response.data;
  const markers = [];
  evchargeList.forEach((item, idx) => {
    const marker = new kakao.maps.Marker({
      map: map,
      position: new kakao.maps.LatLng(item.lat, item.longi),
    });

    //마커를 클릭했을 때 커스텀 오버레이를 표시
    kakao.maps.event.addListener(marker, "click", function () {
      overlay.setMap(map);
      overlay.setPosition(marker.getPosition());
      overlay.setContent(
        `<div class="wrap">
            <div class="info">
                <div class="title">
                    ${item.csNm}
                    <div class="close" onclick="closeOverlay()" title="닫기"></div>
                        </div>
                            <div class="body">
                            <div class="desc">
                        <div class="ellipsis">${item.addr}</div>
                        <div class="type ellipsis">${item.cpNm}</div>
                    </div>
                </div>
            </div>
         </div>`
      );
      map.setCenter(marker.getPosition());
    });
    markers.push(marker);
  });
  clusterer.addMarkers(markers);
};

const search = document.querySelector(".search");
search.addEventListener("keyup", (e) => {
  if (e.ket === "Enter" || e.keyCode === 13) {
    searchChargePlace(search.value);
  }
});
function closeOverlay() {
  overlay.setMap(null);
}
