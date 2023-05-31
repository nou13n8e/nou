//select, manipulation, ajax(explorer)
//ios, android, react-natvie, flutter, angular, react, vee(sveltte)

const ldsEllipsis = document.querySelector(".lds-ellipsis");
const coronaList = document.querySelector(".coronaList ul");
const removeItem = () => {
  const imgItem = document.querySelectorAll(".coronaList ul li");
  imgItem.forEach((item, idx) => {
    item.remove();
  });
};
const loadCoronaData = async (date) => {
  removeItem();
  ldsEllipsis.classList.remove("off");
  const corona = await fetch(
    `http://apis.data.go.kr/1352000/ODMS_COVID_04/callCovid04Api?serviceKey=XZ6UxwzKR8MlUyDN6TwQ0Rz3wZ4CHCc%2FCKcOPMr5tScQ3Dp9DT3HJdrUsUz02ACvko57l97WEm1ckJhay3HFKQ%3D%3D&pageNo=1&numOfRows=500&apiType=JSON&std_day=${date}`
  );
  const response = await corona.json();
  const items = response.items;
  ldsEllipsis.classList.add("off");
  const sortedItems = _.sortBy(items, ["gubun"]);
  //배열 또는 객체의 원본을 훼손하지 않고 복사할 경우
  const cities = [];
  const values = [];
  sortedItems.forEach((item, idx) => {
    cities.push(item.gubun);
    values.push(item.incDec);
    // console.log(item.gubun + "===" + item.incDec);
    // const li = document.createElement("li");
    // //1 반복문이 반복되는 숫자만큼 li를 추가할 것
    // const region = document.createElement("span");
    // region.classList.add("region");
    // //3 지역 설정
    // const incDec = document.createElement("span");
    // incDec.classList.add("incDec");
    // //4 확진자수 설정
    // region.textContent = item.gubun;
    // incDec.textContent = item.incDec;
    // li.append(region);
    // //5 li에 추가
    // li.append(incDec);
    // //6 li에 추가
    // coronaList.append(li);
    // //2 찾아놓은 ul까지의 목록에 li를 추가할 것
  });
  makeChart(cities, values);
  //gsap.from(".coronaList ul li", { scale: 0, duration: 0.5, stagger: 0.02 });
};

const datePicker = new Lightpick({
  field: document.querySelector(".date-picker"),
  format: "YYYY-MM-DD",
  onSelect: function (date) {
    //console.log(date.format("YYYY-MM-DD"));
    loadCoronaData(date.format("YYYY-MM-DD"));
  },
});
datePicker.setDate(new Date());

let myChart = null;
const makeChart = (cities, values) => {
  const ctx = document.querySelector(".chart");
  if (myChart !== null) myChart.destroy();
  myChart = new Chart(ctx, {
    type: "bar",
    data: {
      labels: cities,
      datasets: [
        {
          label: "확진자수",
          data: values,
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
