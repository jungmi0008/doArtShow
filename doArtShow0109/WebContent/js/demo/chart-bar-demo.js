// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var date = new Date(); 
var year = date.getFullYear(); 

var years = new Array();
var months = new Array();

if (date.getMonth() + 1 >= 1 && date.getMonth() + 1 <= 5) {
	lastYear = year - 1;
	
	for (var i = 0; i < 6 - (date.getMonth() + 1); i++) {
		years[i] = lastYear;
		months[i] = 8 + i + date.getMonth();
	}
	
	for (var i = 6 - (date.getMonth() + 1); i < 6; i++) {
		years[i] = year;
		months[i] = i - (5 - (date.getMonth() + 1));
	}
} else {
	for (var i = 0; i < 6; i++) {
		years[i] = year;
		months[i] = (date.getMonth() + 1) - 5 + i; 
	}
}

var monthVisitCnt = new Array();

for (var i = 0; i < 6; i++) {
	(function(i) {
	  $.ajax({
	  	url: "/doArtShow/getMonthVisitCnt.do",
			type: "GET",
			data: "year=" + years[i] + "&monthValue=" + months[i] + "&value=month",
			async: false,
			success:function(data){
				monthVisitCnt[i] = parseInt(data);
			}
	  });
	})(i);
	
	months[i] = months[i] + "월";
}

// Bar Chart Example
var ctx = document.getElementById("myBarChart");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: months,
    datasets: [{
      label: "방문자",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: monthVisitCnt,
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 400,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});

var avg = 0;

for (var i = 0; i < 6; i++) {
	avg += monthVisitCnt[i];
}

$('#average').text(parseInt(avg/6));
$('#min').text(Math.min.apply(null, monthVisitCnt));
$('#max').text(Math.max.apply(null, monthVisitCnt));