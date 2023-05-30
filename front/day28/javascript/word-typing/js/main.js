//1~24

const firstWords = ["강아지", "소나기", "기상청", "지우개", "청소부"];
//1 첫번째 단어로 나올 단어의 배열을 만든 뒤 무작위로 출력되도록 구성
const wordList = document.querySelector(".word-list ul");
//5 firstWord를 추가할 ul을 찾기 위해 사용
const word = document.querySelector(".word");
//7 input인 .word에 단어를 입력한 것을 받기 위해 사용
const wordArray = [];
//21 사용자가 입력하는 단어들을 저장할 배열을 만들고

const firstWord = firstWords[Math.floor(Math.random() * firstWords.length)];
console.log("🚀 ~ file: main.js:5 ~ firstWord:", firstWord);
//2 배열이 무작위가 되도록 random사용한 뒤 정수로 만들기 위해 floor사용

wordArray.push(firstWord);
//22 사용자가 입력하는 단어들을 저장하기 전에 컴퓨터가 고른 첫번째 단어를 push로 저장
//22 const여도 되는 이유는 배열은 데이터들을 참조하는 것이므로 할당을 하는 것이 아니기 때문

const appendWord = (inputWord) => {
  //11 반복이 되는 문장이므로 함수로 만들어서 사용
  const li = document.createElement("li");
  //3 변수 li에 li를 추가하기 위해서 사용
  li.textContent = inputWord;
  //4 li에 들어갈 단어를 넣기 위해 사용
  //9 word.value를 li에 추가하기 위해 사용
  //12 매개변수 inputWord를 설정해서 대신 사용
  wordList.append(li);
  //6 li를 추가하기 위해 append사용
  wordArray.push(inputWord);
  //25 해당 배열에서 중복 여부를 따져서 배열에 추가
};

const fault = () => {
  word.value = "";
  //15 세 글자가 아닌 경우 word가 비워지도록 설정
  gsap.from(".input-box", { x: 100, duration: 1, ease: "elastic.out(1, 0.2)" });
  //20 틀린 단어를 썼을 때 input이 흔들리도록 설정
};

appendWord(firstWord);
//13 첫번째 단어를 띄우기 위해 사용

word.addEventListener("keyup", (e) => {
  //7 word에 단어를 입력하고 enter를 누르면 실행하도록 구성
  //keyup: 키보드를 눌렀다가 뗐을 때 발생하는 이벤트 포착
  //8 enter를 눌렀다가 뗐을 때를 포착하기 위해 매개변수 e를 추가
  if (e.key === "Enter" || e.keyCode === 13) {
    if (word.value.length !== 3) {
      //14 세 글자만 입력될 수 있도록 if문 한 번 더 사용
      //  alert("세 글자만 입력하세요!");
      fault();
      return;
    }
    const lastWord = document.querySelector(".word-list ul li:last-child").textContent;
    //16 li에 추가된 마지막 단어를 알기 위해 lastWord를 선언한 뒤 사용
    const lastChar = lastWord.substring(2);
    //17 li에 추가된 마지막 단어의 마지막 글자를 알기 위해 lastChar를 선언한 뒤 사용
    if (word.value.substring(0, 1) !== lastChar) {
      //18 사용자가 입력한 단어의 첫번째 글자와 마지막 단어의 마지막 글자를 비교
      fault();
      return;
      //19 return을 만나면 아래의 실행문은 실행하지 않으니까 else 제거 가능
    }
    if (wordArray.includes(word.value)) {
      //24 해당 배열에서 중복 여부를 따져서 return사용
      fault();
      return;
    }
    fetch(`https://opendict.korean.go.kr/api/search?key=E2F648AE294E43B869CE9D57DA681C8D&q=${word.value}&req_type=json`)
      .then((response) => response.json())
      .then((data) => {
        if (data.channel.total <= 0) {
          fault();
          word.value = "";
        } else {
          appendWord(word.value);
          word.value = "";
          //10 한 번 입력한 뒤 word가 비워져서 다시 입력할 수 있도록 사용
        }
      });
  }
});

// const checkDic = (question) => {
//   fetch(`https://opendict.korean.go.kr/api/search?key=E2F648AE294E43B869CE9D57DA681C8D&q=${question}&req_type=json`)
//     .then((response) => {
//       return response.json();
//     })
//     .then((data) => {
//       return data.chanel.total;
//     });
// };
