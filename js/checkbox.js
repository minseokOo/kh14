$(function () {
    $(".check-all").change(function () {
        var checkAll = $(this).prop("checked");
        $(".check-item").prop("checked", checkAll)

        // change를 강제로 발생시켜서 연쇄적인 처리
        $(".check-item").trigger("change");
    });
    $(".check-required-all").change(function () {
        var checkRequired = $(this).prop("checked");
        $(".check-required-item").prop("checked", checkRequired)
        $(".check-item").trigger("change");
    });
    $(".check-item").change(function () {
        var requiredCount = $(".check-required-item:checked").length;
        var requiredCountAll = $(".check-required-item").length;
        var itemCount = $(".check-item:checked").length;
        var itemCountAll = $(".check-item").length;
        
        $(".check-required-all").prop("checked", requiredCount === requiredCountAll);
        $(".check-all").prop("checked", itemCount === itemCountAll);
    })
});