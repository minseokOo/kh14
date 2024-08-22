/*
    별점 표시기
    - https://github.com/hiphop5782/score
    - version 0.0.5
*/
(function ($) {
    //External source - https://gist.github.com/ahtcx/0cd94e62691f539160b32ecda18af3d6
    const merge = (target, source) => {
        // Iterate through `source` properties and if an `Object` set property to merge of `target` and `source` properties
        for (let key of Object.keys(source)) {
            if (source[key] instanceof Object) Object.assign(source[key], merge(target[key], source[key]))
        }

        // Join `target` and modified `source`
        Object.assign(target || {}, source)
        return target
    }

    $.fn.score = function (options) {
        options = options || {};
        //기본 옵션
        const settings = merge({
            starColor: "gold", //별 색상
            backgroundColor: "transparent", //배경 색상
            editable: false, //점수 변경 가능 여부
            integerOnly: false, //정수만 설정 가능 여부
            zeroAvailable:false,//0 설정 가능 여부
            send: {
                sendable:false,
                name:"star",
            },
            display: {
                showNumber: false, //설정된 숫자 표시 가능 여부
                placeLimit: 1, //소수점 자리수 표시 길이
                textColor:"gold",//텍스트 색상
            },
            point: {
                max: 5,//최대 점수(data-max로 대체 가능)
                rate: 0,//실제 점수(data-rate로 대체 가능)
            }
        }, options);

        //유틸리티 : 점수 <---> 퍼센트
        const getPercentFromPoint = function (max, rate) {
            return rate / max * 100;
        };
        const getPercentFromPointInteger = function (max, rate) {
            const segment = 100 / max;
            return Math.floor((getPercentFromPoint(max, rate) + segment / 2) / segment) * segment;
        };
        const getPointFromPercent = function (max, percent, limit) {
            const value = max * percent / 100;
            return value.toFixed(limit || settings.display.placeLimit);
        };
        const getFillStarText = function(size){
            return "★".repeat(size);
        };
        const getEmptyStarText = function(size){
            return "☆".repeat(size);
        };

        //이벤트 핸들러
        function pointHandler (e) {
            //퍼센트 계산
            const data = this.parentNode._data;
            const width = parseInt(window.getComputedStyle(this, null).width);
            let percent = e.offsetX / width * 100;
            // percent = Math.round(percent/10)*10;
            if(!settings.zeroAvailable) {
                percent = percent == 0 ? 0.1 : percent;
            }
            
            //퍼센트 표시
            $(this).find(".foreground").css("width", percent + "%");

            //평점 표시
            if (settings.display.showNumber) {
                $(this).parent().find(".display-panel").text(getPointFromPercent(data.max, percent));
            }

            if (settings.send && settings.send.sendable) {
                $(this).parent().find(".point-input").val(getPointFromPercent(data.max, percent));
            }

            //이벤트 제거
            // if(e.type === "click"){
            //     $(this).off("click");
            //     $(this).off("mousemove");
            //     $(this).one("mouseenter", enterHandler);
            // }    
        };
        function pointIntegerHandler (e) {
            //퍼센트 계산
            const data = this.parentNode._data;
            const width = parseInt(window.getComputedStyle(this, null).width);
            const segment = 100 / data.max;
            let percent = e.offsetX / width * 100;
            percent = Math.round(percent/10)*10;
            percent = (Math.floor((percent-0.001) / segment) + 1) * segment
            if(!settings.zeroAvailable) {//0 설정 불가일 경우
                if(percent == 0){//0이면 segment로 설정
                    percent = segment;
                }
            }

            //퍼센트 표시
            $(this).find(".foreground").css("width", percent + "%");

            //평점 표시
            if (settings.display.showNumber) {
                $(this).parent().find(".display-panel").text(getPointFromPercent(data.max, percent));
            }

            if (settings.send && settings.send.sendable) {
                $(this).parent().find(".point-input").val(getPointFromPercent(data.max, percent));
            }

            //이벤트 제거
            // if(e.type === "click"){
            //     $(this).off("click");
            //     $(this).off("mousemove");
            //     $(this).one("mouseenter", enterHandler);
            // }
        };

        function enterHandler(e){
            //변경 가능할 경우 처리
            if (settings.editable) {
                if (settings.integerOnly) {
                    $(this).click(pointIntegerHandler);
                    $(this).mousemove(pointIntegerHandler);
                } else {
                    $(this).click(pointHandler);
                    $(this).mousemove(pointHandler);
                }
            }
        };

        return this.each(function () {
            //기본 디자인
            $(this).css({
                'display': "inline-flex",
                'cursor': "pointer",
                'color': settings.starColor,
                'background-color': settings.backgroundColor,
                'white-space':'nowrap',
            });

            //별점 설정
            this._data = {
                max:$(this).data("max") || settings.point.max,
                rate:$(this).data("rate") || settings.point.rate,
            };
            const percent = settings.integerOnly ? 
                        getPercentFromPointInteger(this._data.max, this._data.rate) 
                        : getPercentFromPoint(this._data.max, this._data.rate);
                                                
            //영역 생성
            const star = $("<div>").addClass("star")
                                                .css({
                                                    "color":"inherit",
                                                    "background-color":"inherit",
                                                    "position":"relative",
                                                    "display":"inline-flex"
                                                });
            const foreground = $("<div>").addClass("foreground")
                                                    .css({
                                                        "overflow":"hidden",
                                                        "width":percent+"%",
                                                        "color":"inherit",
                                                        "background-color":"inherit"
                                                    })
                                                    .text(getFillStarText(this._data.max));
            const background = $("<div>").addClass("background")
                                                        .css({
                                                            "position":"absolute",
                                                            "color":"inherit",
                                                            "background-color":"inherit"
                                                        })
                                                        .text(getEmptyStarText(this._data.max));

            //영역 배치
            //star.append(foreground).append(background).appendTo(this);
            star.append(foreground).append(background).appendTo(this);

            //점수판 생성 및 배치(옵션)
            if (settings.display.showNumber) {
                const displayPanel = $("<div>").addClass("display-panel").css("color", settings.display.textColor).text(this._data.rate.toFixed(settings.display.placeLimit));
                displayPanel.appendTo(this);
            }

            //전송 가능 처리(옵션)
            if (settings.send && settings.send.sendable) {
                const input = $("<input>").attr("type", "hidden").attr("name", settings.send.name).addClass("point-input");
                if(settings.integerOnly){
                    input.val(getPointFromPercent(settings.point.max, percent));
                }
                else {
                    input.val(getPointFromPercent(settings.point.max, percent));
                }
                input.appendTo(this);
            }

            //변경 가능할 경우 처리
            if (settings.editable) {
                if (settings.integerOnly) {
                    star.click(pointIntegerHandler);
                    //star.mousemove(pointIntegerHandler);
                } else {
                    star.click(pointHandler);
                    //star.mousemove(pointHandler);
                }
            }

        });
    };
})(jQuery);