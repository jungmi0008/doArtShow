// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

var date = new Date(); 
var year = date.getFullYear(); 
var ages = new Array();

for (var i = 0; i < 5; i++) {
	var startYear = year - (18 + (10 * i));
	var lastYear = year - (9 + (10 * i));
	
	(function(i) {
	  $.ajax({
	  	url: "/doArtShow/getAgeCnt.do",
			type: "GET",
			data: "startYear=" + startYear + "&lastYear=" + lastYear,
			async: false,
			success:function(data){
				ages[i] = parseInt(data);
				console.log(data);
			}
	  });
	})(i);
}

// Pie Chart Example
var ctx = document.getElementById("myPieChart");
var myPieChart = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ["10대", "20대", "30대", "40대", "50대"],
    datasets: [{
      data: ages,
      backgroundColor: ['#28a745', '#007bff', '#ffc107', '#ff7f00', '#dc3545'],
    }],
  },
});
