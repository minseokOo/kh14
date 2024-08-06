$(function(){
    //1페이지로 이동
    move(1);

    //다음 버튼을 누르면 현재 페이지를 숨기고 다음 페이지를 표시
    //(+추가) 게이지 변경
    $(".multipage").find(".btn-next").click(function(){
        //this == 클릭당한 다음버튼
        var currentPage = $(this).parents(".page");
        var nextPage = currentPage.next(".page");
        var index = $(".multipage").children(".page").index(nextPage);
        move(index+1);
    });

    //이전 버튼을 누르면 현재 페이지를 수믹고 이전 페이지를 표시            
    $(".multipage").find(".btn-prev").click(function(){
        var currentPage = $(this).parents(".page");
        var prevPage = currentPage.prev(".page");
        var index = $(".multipage").children(".page").index(prevPage);
        move(index+1);
    });

    //이 코드에서만 사용할 함수를 구현
    //- 이전이건 다음이건 처음이건 그건 난 모르겠고
    //- 어느 페이지로 갈 건지만 얘기해라
    //- 그럼 나머지는 내가 알아서 할께
    function move(number) {//number는 1부터 시작
        $(".multipage").children(".page").hide()
                                    .eq(number-1).show();
        var percent = number * 100 / $(".multipage").children(".page").length;
        $(".progressbar").children(".guage").css("width", percent+"%");
    }
});