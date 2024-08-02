/*
    class="confirm-link" 처리된 a태그는
    클릭시 확인창을 띄우고 확인을 누르면 이동
*/ 
$(function(){
    $(".confirm-link").click(function(){
        var text = $(this).attr("data-text") || "정말 이동하시겠습니까?";
    return window.confirm(text);
    });
});