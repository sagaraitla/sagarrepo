
$(document).on("change", "#roleId", function() {
	var value = 'doctor';
	alert("value is---"+value);
	
	
	$.ajax({
		type: 'POST',
		//data: dataString,
		url: path+'/getDeptDetails',
		success: function(data) {
			
			alert("data:"+data);
			//var myDiv1 = document.getElementById("lableId");
			//var selectList1 = document.createElement("lable");
			 document.getElementById('lableId').innerHTML = 'Departments';
			//myDiv1.appendChild(selectList1);
			//var defaultOption = '<option  value="" label="--- Select Dept123---"/>';
			//document.getElementById("deptId").appendChild(defaultOption);
			var myDiv = document.getElementById("deptId");
			var selectList = document.createElement("select");
			//selectList.setAttribute("id", "mySelect");
			myDiv.appendChild(selectList);
			//alert("data:"+defaultOption);
			
			for (var i = 0; i < data.length; i++) {
			    var option = document.createElement("option");
			    option.setAttribute("value", data[i]);
			    option.text = data[i];
			    selectList.appendChild(option);
			}
			 	
		}
	});
	
	
	
});