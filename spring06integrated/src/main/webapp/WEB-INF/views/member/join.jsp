<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
.container {
	width: 300px;
}

[name=memberId] {
	background-image: url("images/user.png");
}

[name=memberPw] {
	background-image: url("images/password.png");
}
</style>
<script type="text/javascript">
	function account() {
		var account = document.querySelector(".account");
		//var account = document.querySelector("[name=memberId]")
		//var result = document.querySelector("#mamberid-result")
		var rexId = /^[a-z][a-z0-9]{7,19}$/;
		var isValid = rexId.test(account.value);

		//이제 주인공은 "입력창"이며 입력창에 success/fail을 추가한다
		account.classList.remove("success", "fail");
		account.classList.add(isValid ? "success" : "fail");
	}
	function password() {
		var password = document.querySelector(".password");
		var rexPw = /^(?=(.*?)[A-Z])(?=(.*?)[a-z])(?=(.*?)[0-9])(?=(.*?)[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
		var isValid = rexPw.test(password.value);

		password.classList.remove("success", "fail");
		password.classList.add(isValid ? "success" : "fail");

	}
	function checkPw() {
		var password = document.querySelector(".password");
		var checkPw = document.querySelector(".checkPw");
		var isValid = password.value.length > 0
				&& password.value === checkPw.value;
		console.log(isValid);
		checkPw.classList.remove("success", "fail");
		checkPw.classList.add(isValid ? "success" : "fail");

	}
</script>
<script type="text/javascript">
       $(function(){
        //이메일 인증 관련 처리
        var certEmail;

        $(".btn-cert-send").click(function(){
            //step 1 - 작성한 이메일을 불러온다
            var email = $("[name = memberEmail]").val();

            //step 2 - 작성한 이메일이 없으면 중단
            if(email.length == 0) return;

            //step 3 - 서버로 이메일 발송을 요청(ajax)
            // - 통신 시작과 종료 시점을 찾아 버튼을 비활성화 처리
            $.ajax({
                url:"http://localhost:8080/rest/cert/send",
                method:"post",
                data:{certEmail : email},
                beforeSend: function(){
                    console.log("전송 전");
                    $(".email-wrapper").nextAll(".cert-wrapper").remove();
                    $(".btn-cert-send").prop("disabled", true);
                    $(".btn-cert-send").find(".fa-solid").removeClass("fa-paper-plane").addClass("fa-spinner fa-spin");
                    $(".btn-cert-send").find("span").text("발송중");
                },
                complete:function(){
                    console.log("전송 후");
                    $(".btn-cert-send").prop("disabled", false);
                    $(".btn-cert-send").find(".fa-solid").removeClass("fa-spinner fa-spin").addClass("fa-paper-plane");
                    $(".btn-cert-send").find("span").text("보내기");
                },
                success:function(response){
                    //성공 시점의 이메일을 저장
                    certEmail = email;

                    //인증번호 템플릿을 이메일 입력창 뒤에 추가
                    var template = $("#cert-template").text();
                    var html = $.parseHTML(template);
                    $(".email-wrapper").after(html);
                },
            });
        });

        //인증 확인 버튼에 대한 이벤트
        $(document).on("click", ".btn-cert-check", function(){
            var currentEmail = $("[name=memberEmail]").val();
            if(certEmail != currentEmail){
                window.alert("이메일을 다시 입력해주세요.");
                $(".cert-wrapper").remove();
                return;
            }
            var certNumber = $(".cert-input").val();
            var regex = /^[0-9]{6}$/;
            if(regex.test(certNumber) == false){//인증번호가 형식에 맞지 않으면
                return; //진행 중지
            }

            //서버에 검사를 요청
            $.ajax({
                url:"http://localhost:8080/rest/cert/check",
                method:"post",
                data: {
                    certEmail : certEmail,
                    certNumber : certNumber,
                },
                success:function(response){
                    if(response == true){ //인증 성공 - 화면을 제거 + 인증 버튼 제거
                        $(".cert-wrapper").remove();
                        //(선택) 이메일 잠금처리 및 보내기 버튼 삭제
                        $("[name=memberEmail]").prop("readonly", true);
                        $(".btn-cert-send").remove();
                        //상태 객체 값을 갱신
                    }
                    else{
                        $(".cert-input").removeClass("success fail").addClass("fail");
                        //상태 객체 값을 갱신
                    }
                    //성공시점의 이메일을 저장
                    console.log("response", response);
                },
            });
        });
       });
    </script>
<!-- 인증번호 템플릿 -->
<script type="text/template" id="cert-template">
        <div class="flex-box mt-10 cert-wrapper">
            <input type="text" class="field cert-input" placeholder="인증번호 입력">
            <button type="button" class="btn btn-neutral btn-cert-check">
                <span>확인</span>
            </button>
        </div>
     </script>
     
     
<div class="container">
	<h1>회원 가입 정보 입력</h1>

	<form action="join" method="post" enctype="multipart/form-data"
		autocomplete="off">
		<div class="row">
			<label>아이디<i class="fa-beat fa-solid fa-asterisk"></i></label> <input
				class="field field-image w-100 account" type="text" name="memberId"
				onblur="account()" required>
			<div class="success-feedback">사용할 수 있는 아이디입니다.</div>
			<div class="fail-feedback">영문 소문자로 시작, 영문소문자와 0~9까지의 숫자 8~20글자를
				입력하세요.</div>
		</div>
		<div class="row answer"></div>

		<div class="row">
			<div class="row answer"></div>
			<label>비밀번호<i class="fa-beat fa-solid fa-asterisk"></i></label> <input
				class="field field-image w-100 password" type="password"
				name="memberPw" onblur="password()" required>
			<div class="success-feedback">사용 가능한 비밀번호 입니다.</div>
			<div class="fail-feedback">비밀번호는 영어대소문자, 숫자, 특수문자를 반드시 포함한
				8~16자로 작성하세요.</div>
		</div>
		<div class="row answerPw"></div>
		<div class="row">
			<label>비밀번호 확인<i class="fa-beat fa-solid fa-asterisk"></i></label> <input
				class="field field-image w-100 checkPw" type="password"
				onblur="checkPw();" required>
			<div class="success-feedback">비밀번호가 일치합니다.</div>
			<div class="fail-feedback">비밀번호가 일치하지 않습니다.</div>
		</div>
		<div class="row chePw"></div>
		<label>닉네임<i class="fa-beat fa-solid fa-asterisk"></i></label>
		<div class="row">
			<input class="field w-100" type="text" name="memberNickname" required>
		</div>
		<div class="row">
            <label>이메일</label>
            <!--입력창-->
            <div class="flex-box email-wrapper">
                <input type="email" name="memberEmail" class="field" style="flex-grow: 1;">
                <button type="button" class="btn btn-neutral btn-cert-send">
                    <i class="fa-solid fa-paper-plane"></i> 
                    <span>보내기</span>
                </button>
                <div class="fail-feedback">인증번호가 일치하지 않습니다</div>
            </div>
            
        </div>
		<label>생년월일</label>
		<div class="row">
			<input class="field w-100" type="date" name="memberBirth">
		</div>
		<label>연락처</label>
		<div class="row">
			<input class="field w-100" type="tel" name="memberContact">
		</div>
		<label>주소</label>
		<div class="row">

			<input class="field w-100" type="text" name=memberPost size="6"
				placeholder="우편번호">
		</div>
		<label>상세주소</label>
		<div class="row">
			<input class="field w-100" type="text" name=memberAddress1 size="60"
				placeholder="기본주소"> <input class="field w-100" type="text"
				name=memberAddress2 size="60" placeholder="상세주소">
		</div>
		<label>사진 등록</label>
		<div class="row">
			<input type="file" name="attach" class="field w-100">
		</div>
		<!-- 	프로필 이미지 <input type= "file" name= "attach" accept= ".png"> <br><br> -->
		<!-- 	프로필 이미지 <input type= "file" name= "attach" accept= ".png, .jpg"> <br><br> -->
		<div class="row right">
			<button class="btn btn-positive">가입하기</button>
		</div>
	</form>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>