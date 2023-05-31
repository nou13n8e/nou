/*
const myPromise = new Promise(function (resolve, reject) {
  setTimeout(function () {
    resolve("success");
    //주어진 값으로 이행하는 Promise 객체를 반환
    reject("fail");
    //주어진 사유로 거부하는 Promise 객체를 반환
  }, 1000);
});
console.log(myPromise);
//대기(pending): 초기
//이행(fulfilled): 성공
//거부(rejected): 실패

myPromise
  .then(function (msg) {
    //then: 프로미스에 이행과 거부 처리기 콜백을 추가
    console.log(msg);
  })
  .catch(function (msg) {
    //catch: 프로미스에 거부 처리기 콜백을 추가
    console.log(msg);
  })
  .finally(function () {
    //finally: 프로미스의 이행과 거부 여부에 상관없이 항상 호출
    console.log("finally는 무조건 출력");
    console.log(myPromise);
  });
  */

const user = {
  id: "nou13n8e",
  name: "nou13n8e",
};

function fetchUser() {
  const url = "https://jsonplaceholder.typicode.com/users/1";
  return fetch(url).then((response) => response.json());
}

async function checkName() {
  const user = await fetchUser();
  /*동기적(Synchronous): 어떤 작업을 요청했을 때 그 작업이 종료될때 까지 기다린 후 다음 작업을 수행하는 방식*/
  /*비동기적(Asynchronous): 어떤 작업을 요청했을 때 다른 작업을 하고 있다가, 요청했던 작업이 종료되면 추가 작업을 수행하는 방식*/
  //async: 비동기적 실행을 동기적으로 바꾸어주는 함수 <> await는 단독으로 쓸 수 없다
  console.log(user);
  if (user.id === 1) {
    console.log(user.name);
  }
}
//checkName();

fetch("https://jsonplaceholder.typicode.com/posts/1")
  //fetch() 메서드는 네트워크에서 리소스를 취득하는 절차를 시작하고, 응답이 사용 가능해지면 이행하는 프로미스를 반환
  .then((response) => response.json())
  //응답은 Response 객체로 표현되며, JSON 응답 본문을 바로 반환하지는 않음
  .then((data) => data.userId)
  .then(function (userId) {
    fetch(`https://jsonplaceholder.typicode.com/users/${userId}`)
      .then((response) => response.json())
      .then(function (user) {
        //console.log(user.name);
      });
  });

async function fetchUserName(postId) {
  //fetchUserName 함수 선언
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`);
  //postId(번호)에 작성된 post를 찾아 response에 대입 (대기)
  const post = await response.json();
  //response에 대입된 값을 json으로 반환하여 post에 대입 (대기)
  const userId = post.userId;
  //post에 대입된 값에서 userId를 취득해 userId에 대입
  const userResponse = await fetch(`https://jsonplaceholder.typicode.com/users/${userId}`);
  //취득한 userId(번호)로 user를 찾아 userResponse에 대입 (대기)
  const user = await userResponse.json();
  //userResponse에 대딥된 값을 json으로 반환하여 user에 대입 (대기)
  return user.name;
  //user의 속성 중 name을 반환하도록 함수 정의
}
fetchUserName(1).then(function (name) {
  //1번 post를 작성한 user를 찾아 name을 반환하는 함수 = fetchUserName을 실행
  console.log(name);
});
