// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('#dataTable').DataTable({
	  "lengthChange": false,
	  "info": false
  });
  
  var date = new Date(); 
  $('#nowTime').text((date.getHours() >= 0 && date.getHours() < 10 ? "0" + date.getHours() : date.getHours()) + ":" + (date.getMinutes() >= 0 && date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes()) + " " + (date.getHours >= 0 && date.getHours < 12 ? "AM" : "PM"));
  
});
