const container = document.querySelector(".map"); //지도를 담을 영역의 DOM 레퍼런스
const options = {
  //지도를 생성할 때 필요한 기본 옵션
  center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
  level: 3, //지도의 레벨(확대, 축소 정도)
};

const map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
//1 카카오맵API에서 코드를 받아 const, querySelector로 바꿔서 사용

const geocoder = new kakao.maps.services.Geocoder(); //주소-좌표 변환 객체를 생성
//2 카카오맵API에서 주소를 입력하면 위도, 경도를 알려주는 라이브러리 사용
//3 마커 생성 후 이미지 다운로드 받아서 경로 변경한 뒤 마커 위치 설정
//4 마커 위에 표시될 커스텀 오버레이 사용(CSS에 내용 추가)

geocoder.addressSearch("서울시 관악구 남부순환로 1820 에그옐로우빌딩 14층", function (result, status) {
  if (status === kakao.maps.services.Status.OK) {
    const coords = new kakao.maps.LatLng(result[0].y, result[0].x); //정상적으로 검색이 완료됐으면

    /* 기본적으로 사용하는 마커는 주석 처리 
    // 결과값으로 받은 위치를 마커로 표시합니다
    const marker = new kakao.maps.Marker({
      map: map,
      position: coords,
    });
 
    const infowindow = new kakao.maps.InfoWindow({
      content: '<div style="width:150px;text-align:center;padding:6px 0;">학원</div>',
    });
    infowindow.open(map, marker); //인포윈도우로 장소에 대한 설명을 표시
    */

    const imageSrc = "../images/location-pin.png"; //마커이미지의 주소
    const imageSize = new kakao.maps.Size(64, 64); //마커이미지의 크기
    const imageOption = { offset: new kakao.maps.Point(32, 64) }; //마커이미지의 옵션(이미지 안에서의 좌표)

    //마커의 이미지정보를 가지고 있는 마커이미지를 생성
    const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
    const markerPosition = coords; //마커가 표시될 위치

    //마커를 생성
    const marker = new kakao.maps.Marker({
      position: markerPosition,
      image: markerImage, //마커이미지 설정
    });

    // 커스텀 오버레이에 표출될 내용
    const content =
      '<div class="customoverlay">' +
      '  <a href="http://www.githrd.com/" target="_blank">' +
      '    <span class="title">글로벌IT인재개발원</span>' +
      "  </a>" +
      "</div>";

    // 커스텀 오버레이가 표시될 위치
    const position = coords;

    // 커스텀 오버레이를 생성
    const customOverlay = new kakao.maps.CustomOverlay({
      map: map,
      position: position,
      content: content,
      yAnchor: 1,
    });

    //마커가 지도 위에 표시되도록 설정
    marker.setMap(map);

    map.setCenter(coords); //지도의 중심을 결과값으로 받은 위치로 이동
  }
});
