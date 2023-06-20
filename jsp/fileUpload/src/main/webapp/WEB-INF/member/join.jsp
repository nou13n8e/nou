<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %>
<form action="../member/joinProcess" method="post" class="join" name="joinform" enctype="multipart/form-data">
  <div class="container-sm mt-5">
    <div class="row justify-content-center">
      <div class="col-6">
        <div class="form-floating mb-3">
          <div class="input-group mb-3">
            <input type="text" name="userId" class="form-control userId" id="floatingInput" placeholder="아이디를 입력해주세요." />
            <button class="btn btn-secondary" type="button" id="btnIdCheck">중복 찾기</button>
          </div>
        </div>
        <div class="mb-3">
          <label for="floatingPassword">Password</label>
          <input type="password" name="userPw" class="form-control" id="floatingPassword" placeholder="비밀번호를 입력해주세요." />
        </div>
        <div class="mb-3">
          <label for="floatingPassword">Password Check</label>
          <input type="password" name="userPw2" class="form-control" id="floatingPassword2" placeholder="비밀번호 확인" />
        </div>
        <div class="mb-3">
          <label for="floatingName">Name</label>
          <input type="text" name="userName" class="form-control" id="floatingName" placeholder="이름을 입력해주세요." />
        </div>
        <div class="mb-3">
          <label for="floatingEmail">Email</label>
          <input type="email" name="userEmail" class="form-control" id="floatingEmail" placeholder="이메일을 입력해주세요." />
        </div>
		<div class="mb-3">
		  <label for="formFile" class="form-label">Profile</label>
		  <input class="form-control" type="file" id="profile" name="profile">
		</div>
        <div class="input-group mb-3">
          <input type="text" class="form-control" id="zonecode" placeholder="우편번호를 입력해주세요." name="zonecode" readonly />
          <button class="btn btn-secondary" type="button" id="button-addon2" onclick="searchZonecode()">찾기</button>
        </div>
        <div class="mb-3">
          <label for="floatingAddress">Address</label>
          <input type="text" class="form-control address" id="floatingAddress" placeholder="주소를 입력해주세요." name="userAddress" />
        </div>
        <div class="row mb-3">
          <div class="col">
            <input type="text" class="form-control detailAddress" placeholder="상세주소" name="detailAddress" />
          </div>
          <div class="col">
            <input type="text" class="form-control extraAddress" placeholder="참고사항" name="extraAddress" />
          </div>
        </div>
        <div class="text-center">
          <button type="submit" class="btn btn-primary btn-lg" id="btnSubmit">Join</button>
        </div>
      </div>
    </div>
  </div>
</form>
<script>
  const regEmail = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
  const userId = document.querySelector(".userId");
  const btnIdCheck = document.querySelector("#btnIdCheck");
  const btnSubmit = document.querySelector("#btnSubmit");

  const joinform = document.forms.joinform;

  let isDoubleCheck = false;

  btnSubmit.addEventListener("click", (e) => {
    if (joinform.elements.userId.value.trim() === "") {
      e.preventDefault();
      alert("아이디를 입력하세요.");
      joinform.elements.userId.value = "";
      joinform.elements.userId.value.focus();
    } else if (isDoubleCheck === false) {
      e.preventDefault();
      alert("아이디 중복 찾기를 하세요.");
      userId.focus();
    } else if (joinform.elements.userPw.value.trim() === "") {
      e.preventDefault();
      alert("비밀번호를 입력하세요.");
      joinform.elements.userPw.value = "";
      joinform.elements.userPw.value.focus();
    } else if (joinform.elements.userPw.value !== joinform.elements.userPw2.value) {
      e.preventDefault();
      alert("비밀번호가 맞지 않습니다.");
      joinform.elements.userPw2.value = "";
      joinform.elements.userPw2.value.focus();
    } else if (joinform.elements.userName.value.trim() === "") {
      e.preventDefault();
      alert("이름을 입력하세요.");
      joinform.elements.userName.value = "";
      joinform.elements.userName.value.focus();
    } else if (joinform.elements.userEmail.value.trim() === "") {
      e.preventDefault();
      alert("이메일을 입력하세요.");
      joinform.elements.userEmail.value = "";
      joinform.elements.userEmail.value.focus();
    } else if (joinform.elements.userEmail.value.match(regEmail) === null) {
      e.preventDefault();
      alert("이메일 형식에 맞게 입력하세요.");
    } else if (joinform.elements.zonecode.value.trim() === "") {
      e.preventDefault();
      alert("우편번호를 입력하세요.");
      joinform.elements.zonecode.value = "";
      joinform.elements.zonecode.value.focus();
    } else if (joinform.elements.userAddress.value.trim() === "") {
      //trim: 글자의 공백 제거
      e.preventDefault();
      alert("주소를 입력하세요.");
      joinform.elements.userAddress.value = "";
      joinform.elements.userAddress.value.focus();
    }
  });
  btnIdCheck.addEventListener("click", () => {
    fetch("../member/idCheck?userId=" + userId.value)
      .then((response) => {
        return response.json();
      })
      .then((data) => {
        //console.log(data);
        if (data.isOk) {
          const result = confirm("사용할 수 있습니다. 사용하시겠습니까?");
          if (result) {
            userId.setAttribute("readonly", true);
            isDoubleCheck = true;
          } else {
            userId.value = "";
            userId.focus();
          }
        } else {
          alert("사용할 수 없습니다.");
          userId.value = "";
          userId.focus();
        }
      });
  });

  function searchZonecode() {
    new daum.Postcode({
      oncomplete: function (data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        let addr = ""; // 주소 변수
        let extraAddr = ""; // 참고항목 변수

        //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === "R") {
          // 사용자가 도로명 주소를 선택했을 경우
          addr = data.roadAddress;
        } else {
          // 사용자가 지번 주소를 선택했을 경우(J)
          addr = data.jibunAddress;
        }

        // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
        if (data.userSelectedType === "R") {
          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
            extraAddr += data.bname;
          }
          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== "" && data.apartment === "Y") {
            extraAddr += extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
          }
          // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraAddr !== "") {
            extraAddr = " (" + extraAddr + ")";
          }
          // 조합된 참고항목을 해당 필드에 넣는다.
          document.querySelector(".extraAddress").value = extraAddr;
        } else {
          document.querySelector(".extraAddress").value = "";
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.querySelector("#zonecode").value = data.zonecode;
        document.querySelector(".address").value = addr;
        // 커서를 상세주소 필드로 이동한다.
        document.querySelector(".detailAddress").focus();
      },
    }).open();
  }
</script>
<%@ include file = "../include/footer.jsp" %>
