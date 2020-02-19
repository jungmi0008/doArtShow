// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var date = new Date(); 
var year = date.getFullYear(); 
var month = new String(date.getMonth() + 1); 
var day = new String(date.getDate()); 

// 한자리수일 경우 0을 채워준다. 
if(month.length == 1){ 
  month = "0" + month; 
} 
if(day.length == 1){ 
  day = "0" + day; 
} 

//var week = new Array('일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일');

var chkNum = 0;

for (var i = 1; i <= 7; i++) {
	var chkFirstMon = year + "-" + month + "-0" + i;

	var chkFirstMonday = new Date(chkFirstMon).getDay();

	if (chkFirstMonday == 1) {
		chkNum = i;
		break;
	}
}

var chkFirstDate = year + "-" + month + "-01";
var chkFirstDay = new Date(chkFirstDate).getDay();

if (chkFirstDay == 0) {
	chkFirstDay = 7;
}

var chkWeek = 0;
var chkMonth = date.getMonth() + 1;

if (chkFirstDay <= 3) {
	if (date.getDate() == chkNum) {
		chkWeek = parseInt((date.getDate() - chkNum) / 7) + 1;
	}else if (date.getDate() - chkNum < 0) {
		chkWeek = 1;
	} else {
		chkWeek = parseInt(((date.getDate() - chkNum) / 7) + 1) + 1;		
	}
} else {
	if (date.getDate() - chkNum < 0) {
		chkMonth -= 1;
		chkWeek = 5;
	} else {
		chkWeek = parseInt((date.getDate() - chkNum) / 7) + 1;		
	}
}

$("#title_week").text(chkMonth + "월 " + chkWeek + "주차 방문자 통계");

var chkDay = date.getDay();

if (chkDay == 0) {
	chkDay = 7;
}

var week = new Array();
var weekVisitCnt = new Array();
var chkOne = 0;

for (var i = 0; i < chkDay; i++) {
	week[i] = (date.getDate() - chkDay + 1) + i + "일";
	
	if (week[i] == "1일") {
		chkOne = i;
	}
}

for (var i = 0; i < chkOne; i++) {
	week[i] = new Date(date.getMonth() == 0 ? year - 1 : year, date.getMonth() == 0 ? 12 : date.getMonth(), 0).getDate() - (chkOne - 1 - i) + "일";
}

for (var i = 0; i < chkDay; i++) {
	if (i >= chkOne) {
		weekValue = year + "-" + month + "-" + week[i];
	} else {
		weekValue = (date.getMonth() == 0 ? year - 1 : year) + "-" + (date.getMonth() == 0 ? 12 : date.getMonth()) + "-" + week[i];
	}
	
	(function(i) {
	  $.ajax({
	  	url: "/doArtShow/getWeekVisitCnt.do",
			type: "GET",
			data: "weekValue=" + weekValue + "&value=week",
			async: false,
			success:function(data){
				weekVisitCnt[i] = parseInt(data);
			}
	  });
	})(i);
}


// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
  type: 'line',
  data: {
    labels: week,
    datasets: [{
      label: "방문자",
      lineTension: 0.3,
      backgroundColor: "rgba(2,117,216,0.2)",
      borderColor: "rgba(2,117,216,1)",
      pointRadius: 5,
      pointBackgroundColor: "rgba(2,117,216,1)",
      pointBorderColor: "rgba(255,255,255,0.8)",
      pointHoverRadius: 5,
      pointHoverBackgroundColor: "rgba(2,117,216,1)",
      pointHitRadius: 50,
      pointBorderWidth: 2,
      data: weekVisitCnt,
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'date'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 7
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 150,
          maxTicksLimit: 4
        },
        gridLines: {
          color: "rgba(0, 0, 0, .125)",
        }
      }],
    },
    legend: {
      display: false
    }
  }
});

$('.nowTime').text((date.getHours() >= 0 && date.getHours() < 10 ? "0" + date.getHours() : date.getHours()) + ":" + (date.getMinutes() >= 0 && date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes()) + " " + (date.getHours >= 0 && date.getHours < 12 ? "AM" : "PM"));