/*
const myPromise = new Promise(function (resolve, reject) {
  setTimeout(function () {
    resolve("success");
    //reject("fail");
  }, 1000);
});
console.log(myPromise);
//Promise{<pending>} 대기 중인 상태 (초기 상태)

myPromise
  .then(function (msg) {
    console.log(msg);
  })
  .catch(function (msg) {
    console.log(msg);
  })
  .finally(function () {
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
  //비동기적 실행을 동기적으로 바꾸어주는 함수 (async, await)
  //async는 함수 앞에서만 쓸 수 있고, await는 단독으로 쓸 수 없다
  console.log(user);
  if (user.id === 1) {
    console.log(user.name);
  }
}
//checkName();

fetch("https://jsonplaceholder.typicode.com/posts/1")
  .then((response) => response.json())
  .then((data) => data.userId)
  .then(function (userId) {
    fetch(`https://jsonplaceholder.typicode.com/users/${userId}`)
      .then((response) => response.json())
      .then(function (user) {
        //console.log(user.name);
      });
  });

async function fetchUserName(postId) {
  const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${postId}`);
  const post = await response.json();
  const userId = post.userId;
  const userResponse = await fetch(`https://jsonplaceholder.typicode.com/users/${userId}`);
  const user = await userResponse.json();
  return user.name;
}
fetchUserName(1).then(function (name) {
  console.log(name);
});
