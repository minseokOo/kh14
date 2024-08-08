   //차트 생성 함수
   function creatChart(url, selector, legend='', type='bar'){
    $.ajax({
      url : url,
      method : "post",
      success : function(response){
        console.log(response);

        //response를 두 개의 배열로 분리
        var names = []; //title
        var values = []; //cnt

        for(var i=0; i < response.length; i++){
          names.push(response[i].title); //title을 names에 추가
          values.push(response[i].cnt); //cnt를 values에 추가
        }
        console.log(names, values);

        //step 2
        // 차트를 그릴 대상 선택
    const ctx = document.querySelector(selector);
    
    // 차트 생성 코드
    // new Chart(캔버스태그, {옵션객체});
    new Chart(ctx, {
      type: type, // 차트 유형(bar/pie/doughnut/line)
      data: {// 차트에 표시될 데이터

        //label은 차트에 표시되는 항목(x축)
        labels: names,

        //실제로 차트에 표시될 값
        datasets: [{
          label: legend, //범례
          data: values, //데이터
          borderWidth: 1
        }
      ]
      },
    options: {
      scales: {
        y: {
          beginAtZero: true //차트를 0부터 표기
        }
      }
    }
  });
  

      }
    });
  }
