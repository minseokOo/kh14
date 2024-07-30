<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
   <style>
        .btn.btn-positive{
            border: none;
            border-radius: 3px;
            background-color: rgb(113, 113, 255);
        }
        .btn.btn-neutral{
            border-radius: 3px;
            color: black;
        }
    </style>
    
     <script type="text/javascript">
        var eNameValid = false;
        var eDeptValid = false;
        var eSalValid = false;
        var eDateValid = false;

         function eName() {
            var eName = document.querySelector(".eName");
            var rexId = /^[가-힣]{2,7}$/;
            eNameValid = eName.value.length > 0 && rexId.test(eName.value);
            console.log(eNameValid);
            eName.classList.remove("success", "fail");
            eName.classList.add(eNameValid ? "success" : "fail");
        }
        function eDept(){
            var eDept = document.querySelector(".eDept");

            eDeptValid = eDept.value.length > 0;
            eDept.classList.remove("success", "fail");
            eDept.classList.add(eDeptValid ? "success" : "fail");
        }
        function eSal() {
            var eSal = document.querySelector(".eSal");
            eSalValid = eSal.value >= 0;
            eSal.classList.remove("success", "fail");
            eSal.classList.add(eSalValid ? "success" : "fail");
        }
        function eDate(){
            var eDate = document.querySelector(".eDate");
            var rexDate = /^(19[0-9]{2}|20([01][0-9]|2[0-3]))-(02-(0[1-9]|1[0-9]|2[0-9])|(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)|(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))$/;
            eDateValid = rexDate.test(eDate.value);
            eDate.classList.remove("success", "fail");
            eDate.classList.add(eDateValid ? "success" : "fail");
        }
        function checkForm(){
            return eNameValid && eDeptValid &&eSalValid && eDateValid;
        }

    </script>
    <div class="container w-400 my-50">
        <div class="row">
            <h2>사원 정보 등록</h2>
        </div>
        <form action= "./add" method="post" enctype= "multipart/form-data" autocomplete="off" onsubmit="return checkForm();">
            <div class="row">
                <label>사원명</label>
                <input type="text" name="empName" class="eName field w-100" onblur="eName();">
            </div>
            <div class="row">
            <label>사진 등록</label>
            <input class="field w-100" name= "attach" type= "file">
            </div>
                <div class="row">
                    <label>부서명</label>
                    <select name="empDept" class="eDept field w-100" oninput="eDept();">
                        <option value="">선택하세요</option>
                        <option value="기획팀">기획팀</option>
                        <option value="영업팀">영업팀</option>
                        <option value="총무팀">총무팀</option>
                        <option value="개발팀">개발팀</option>
                        <option value="운영팀">운영팀</option>
                    </select>
                </div>
                <div class="row">
                    <label>입사일</label>
                    <input type="date" name="empDate" class="eDate field w-100" oninput="eDate();" >
                </div>
                <div class="row">
                    <label>사원등급</label>
                    <select name="empRank" class="field w-100" required>
                        <option value="인턴">인턴</option>
                        <option value="사원">사원</option>
                        <option value="주임">주임</option>
                        <option value="대리">대리</option>
                        <option value="과장">과장</option>
                        <option value="부장">부장</option>
                        <option value="이사">이사</option>
                        <option value="부사장">부사장</option>
                        <option value="사장">사장</option>
                    </select>
                </div>
                <div class="row">
                    <label>급여</label>
                    <input type="number" name="empSal" class="eSal field w-100" onblur="eSal();">
                </div>
                <div class="row">
                    <button class="btn btn-positive" type="submit">등록</button>
                </div>
        </form>
        </div>
</body>
</html>
  
  <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
  