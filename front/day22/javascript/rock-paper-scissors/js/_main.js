const computerList = document.querySelectorAll(".computer ul li");
const humanList = document.querySelectorAll(".human ul li");
let computerChoice = 0;
const resultList = document.querySelector(".result ul");

const appendItems = (className) => {
  const appendItem = document.createElement("li");
  appendItem.classList.add(className);
  appendItem.textContent = className.substring(0, 1);
  resultList.appendChild(appendItem);
};

const makeRandom = () => {
  computerList[0].style.display = "none";
  computerList[1].style.display = "none";
  computerList[2].style.display = "none";
  computerChoice = Math.floor(Math.random() * 3);
  computerList[computerChoice].style.display = "block";
};

let i = 0;
let gameIdx = 0;
humanList.forEach((item, idx) => {
  item.addEventListener("click", () => {
    i++;
    clearInterval(computerIdx);

    if (i >= 5) {
      clearTimeout(gameIdx);
    } else {
      gameIdx = setTimeout(() => {
        console.log("재실행");
        computerIdx = setInterval(makeRandom, 50);
      }, 2000);
    }

    if (idx === computerChoice) {
      appendItems("draw");
    } else if (idx === 0 && computerChoice === 1) {
      appendItems("lose");
    } else if (idx === 1 && computerChoice === 2) {
      appendItems("lose");
    } else if (idx === 2 && computerChoice === 0) {
      appendItems("lose");
    } else {
      appendItems("win");
    }
  });
});

let computerIdx = setInterval(makeRandom, 50);
makeRandom();
