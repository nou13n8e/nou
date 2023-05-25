//1~30
//5회 실행 후 cover의 display: none이 사라지고 cover가 브라우저에 드러나며 다시 한 번! 버튼을 누르면 게임을 다시 시작할 수 있도록 할 것(cover가 브라우저에서 사라지고, 기존의 게임 결과가 없어져야 한다)

const computerList = document.querySelectorAll(".computer ul li");
// console.log("🚀 ~ file: main.js:9 ~ computerList:", computerList);
//1 컴퓨터가 무작위로 오브젝트를 선택하게 하기 위해 computerList를 찾아 출력 > 배열의 형식으로 되어있다고 확인
const humanList = document.querySelectorAll(".human ul li");
//8 사용자가 선택한 오브젝트를 알기 위해 humanList를 찾아 출력하기 위해 사용
let computerChoice = 0;
// 11 승패를 알기 위해 반복문을 사용할 예정: 변수의 값이 바뀔 것이기 때문에 const가 아니라 let으로 변경
const resultList = document.querySelector(".result ul");
//17 console을 열지 않고도 브라우저에서 승패를 확인할 수 있도록 하기 위해 변수 resultList를 선언

const appendItems = (className) => {
  //21 해당 내용을 함수로 만들기 위해서 함수 appendItems를 선언, 매개변수 className선언
  const li = document.createElement("li");
  //18 li태그를 추가하기 위해 document.createElement 사용
  li.classList.add(className);
  //19 li 뒤에 class를 추가하기 위해 classList.add 사용
  //22 "WIN" > className변수로 변경
  li.textContent = className.substring(0, 1);
  //20 win, lose, draw의 첫글자를 따와 브라우저에 표시하기 위해 textContent 사용
  //23 "W" > className의 첫글자를 따오기 위해 substring 사용
  resultList.append(li);
};

const makeRandom = () => {
  //5 makeRandom이라는 함수를 만들어 호출하기 위해 사용
  computerList[0].style.display = "none";
  computerList[1].style.display = "none";
  computerList[2].style.display = "none";
  //2 ".computer ul li"의 style을 통제해 안 보이게 하기 위해 사용

  computerChoice = Math.floor(Math.random() * 3);
  //4 Math.random을 사용해 나온 값을 정수만 남기기 위해 Math.floor를 사용, 정수만 남은 값을 computerChoice라는 변수에 받아 무작위(정수)로 나온 값을 나타나게 하기 위해 사용

  computerList[computerChoice].style.display = "block";
  //3 오브젝트 3개를 사라지게 하고, 1개만 block처리를 해서 브라우저에 나타나게 하기 위해 사용
};

let i = 0;
let gameIdx = 0;
//27 재실행을 그만하기 위해 조건문을 만들어 5회 이상 할 수 없도록 하기 위해 반복문 사용 예정, 사용할 변수를 선언
humanList.forEach((item, idx) => {
  //14 배열 반복문을 이용해 사용자의 선택지와 컴퓨터의 선택지를 비교(승패)하기 위해 사용
  item.addEventListener("click", () => {
    i++;
    //28 실행할 때마다 i의 값이 1씩 증가하도록 설정
    //13 click이벤트가 발생할 humanList[0]를 item으로 변경
    clearInterval(computerIdx);
    //+컴퓨터의 선택지가 담긴 변수를 가져와 정지시키는 기능 추가

    if (i >= 5) {
      //29 5회 이상 할 수 없도록 하기 위해 반복문의 조건 설정
      clearTimeout(gameIdx);
      //30 i>=5의 값이 true라면 더 이상 재실행되지 않도록 clearTimeout을 사용
    } else {
      gameIdx = setTimeout(() => {
        computerIdx = setInterval(makeRandom, 50);
      }, 1000);
      //24 재실행을 시키기 위해 setTimeout 사용, 실행시키는 함수를 가져와서 사용자가 지정한 시간 후에 실행되도록 설정
    }

    if (computerChoice === idx) {
      //   console.log("draw");
      appendItems("DRAW");
      //24 사용자가 만든 appendItems를 활용하기 위해 console.log 부분은 주석처리한 뒤 사용
    } else if (computerChoice === 0 && idx === 1) {
      //   console.log("win");
      appendItems("WIN");
    } else if (computerChoice === 1 && idx === 2) {
      //   console.log("win");
      appendItems("WIN");
    } else if (computerChoice === 2 && idx === 0) {
      //   console.log("win");
      appendItems("WIN");
    } else {
      //   console.log("lose");
      appendItems("LOSE");
      //15 사용자가 이기는 조건을 설정해 if문에 적용, 승패를 알 수 있게 사용
      //16 console을 열지 않고도 브라우저에서 승패를 확인할 수 있도록 할 예정
    }
  });
  //9 사용자가 선택한 오브젝트에 "click"이벤트가 발생하면 addEventListener가 포착하고, 사용자가 지정한 함수를 실행하기 위해 선언(멈추게 하는 기능 추가하기 위해 변수 선언)
  //12 승패에 관련된 배열 반복문을 사용하기 위해 3가지 조건을 설정, 배열의 형식을 띄고 있기 때문에 forEach를 사용할 예정
});

let computerIdx = setInterval(makeRandom, 50);
//7 컴퓨터가 사용자가 지정한 시간(50)에 한번씩 makeRandom 함수를 호출해 시간 간격을 만들어 주기 위해 사용
//10 이벤트에 사용할 함수에 멈추게 하는 기능을 추가하기 위해 값을 받기 위해 변수 computerIdx를 선언
//26 재할당을 하기 위해 const > let으로 변경
makeRandom();
//6 사용자가 아니라 컴퓨터에게 함수 호출을 맡기기 위해 setInterval을 사용할 예정
