//오픈API에 날짜 입력하면 해당 날짜에 확진자수를 받아 출력하기
//.coronaList > ul에 li(지역명, 확진자수)를 추가하는 방식
//CSS로 보기 편한 방식으로 만든 뒤 gsap으로 출력 방식 변경
//날짜를 입력하기 위해 light pick(달력 형태)라이브러리 사용
//기존에 입력한 날짜의 출력 화면을 지우고 새로 입력할 날짜의 출력 화면이 나타나도록 설정
//해당 날짜의 확진자수를 받는 시간동안 "로딩 중" 화면 구성 (lds-ellipsis)
//지역명 내림차순 정리를 위해 라이브러리 사용(lodash) ※문자열은 사칙연산 안 되므로 주의!
//화면에 나오는 정보들로 차트를 만들기 위해 라이브러리 사용(chart)
//기존에 입력된 차트는 지우고 새로 입력될 차트가 나타나도록 설정

const ldsEllipsis = document.querySelector(".lds-ellipsis");
//로딩 화면 만들기 위해 라이브러리 사용 (css loader(lds-ellipsis))
const coronaList = document.querySelector(".coronaList ul");
//1 li를 추가할 리스트 찾기
const removeItem = () => {
  const imgItem = document.querySelectorAll(".coronaList ul li");
  imgItem.forEach((item, idx) => {
    item.remove();
  });
};
const loadCoronaData = async (date) => {
  removeItem();
  //기존에 있던 화면 지워진 뒤 새 화면 나오도록 설정
  ldsEllipsis.classList.remove("off");
  //ldsEllipsis의 class로 off가 remove되면 나타나도록 설정
  const corona = await fetch(
    `http://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api?serviceKey=XZ6UxwzKR8MlUyDN6TwQ0Rz3wZ4CHCc%2FCKcOPMr5tScQ3Dp9DT3HJdrUsUz02ACvko57l97WEm1ckJhay3HFKQ%3D%3D&pageNo=1&numOfRows=500&apiType=JSON&std_day=${date}`
  ); //0 공공데이터포털에서 코로나 관련 오픈API 신청 후 인증키(encording) 입력, 날짜를 매개변수로 입력받아 사용할 예정
  const response = await corona.json();
  //json으로 응답받은 값을 변수에 대입
  const items = response.items;
  ldsEllipsis.classList.add("off");
  //ldsEllipsis의 class로 off가 add되면 사라지도록 설정
  const sortedItems = _.sortBy(items, ["gubun"]);
  //도시명 내림차순 정렬을 위해 라이브러리 사용 (lodash.js)
  //배열 또는 객체의 원본을 훼손하지 않고 복사할 경우
  const cities = [];
  const values = [];
  sortedItems.forEach((item, idx) => {
    cities.push(item.gubun);
    //배열에 gubun으로 분류되는 지역명 입력하기
    values.push(item.incDec);
    //배열에 incDec로 분류되는 확진자수 입력하기

    // console.log(item.gubun + "===" + item.incDec);
    // const li = document.createElement("li");
    // //2 반복문이 반복되는 숫자만큼 li를 추가할 것
    // const region = document.createElement("span");
    // region.classList.add("region");
    // //4 지역 설정
    // const incDec = document.createElement("span");
    // incDec.classList.add("incDec");
    // //5 확진자수 설정
    // region.textContent = item.gubun;
    // incDec.textContent = item.incDec;
    // li.append(region);
    // //6 li에 추가
    // li.append(incDec);
    // //7 li에 추가
    // coronaList.append(li);
    // //3 찾아놓은 ul까지의 목록에 li를 추가할 것
  });
  makeChart(cities, values);
  //gsap.from(".coronaList ul li", { scale: 0, duration: 0.5, stagger: 0.02 });
};

const datePicker = new Lightpick({
  //날짜 입력하기 위해 라이브러리 사용(매개변수 날짜) (light pick.js)
  field: document.querySelector(".date-picker"),
  format: "YYYY-MM-DD",
  onSelect: function (date) {
    //console.log(date.format("YYYY-MM-DD"));
    loadCoronaData(date.format("YYYY-MM-DD"));
    //오픈API소스와 맞도록 format속성을 이용해 날짜 정렬
  },
});
datePicker.setDate(new Date());

let myChart = null;
const makeChart = (cities, values) => {
  //차트 그리기 위해 라이브러리 사용(매개변수 도시, 확진자수) (chart.js)
  const ctx = document.querySelector(".chart");
  if (myChart !== null) myChart.destroy();
  //기존 차트가 지워진 뒤 새 차트가 입력되도록 설정
  myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: cities,
      //변수(배열)로 설정
      datasets: [
        {
          label: "확진자수",
          data: values,
          //변수(배열)로 설정
          borderWidth: 1,
          backgroundColor: "#9BD0F5",
        },
      ],
    },
    options: {
      scales: {
        y: {
          beginAtZero: true,
        },
      },
    },
  });
};
