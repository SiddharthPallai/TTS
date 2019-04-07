////function renderTimetable() {
////
////    var search = {}
////    search["username"] = $("#username").val();
////
////    $("#btn-search").prop("disabled", true);
////
////    $.ajax({
////        type: "POST",
////        contentType: "application/json",
////        url: "/api/search",
////        data: JSON.stringify(search),
////        dataType: 'json',
////        cache: false,
////        timeout: 600000,
////        success: function (data) {
////
////            var json = "<h4>Ajax Response</h4><pre>"
////                + JSON.stringify(data, null, 4) + "</pre>";
////            $('#feedback').html(json);
////
////            console.log("SUCCESS : ", data);
////            $("#btn-search").prop("disabled", false);
////
////        },
////        error: function (e) {
////
////            var json = "<h4>Ajax Response</h4><pre>"
////                + e.responseText + "</pre>";
////            $('#feedback').html(json);
////
////            console.log("ERROR : ", e);
////            $("#btn-search").prop("disabled", false);
////
////        }
////    });
////
////}
//
//$( document ).ready(function() {
//	
//	// GET REQUEST
//	$("#course1").change(function(event){
//		event.preventDefault();
//		alert('Hello');
//	});
//	
//	// DO GET
//	function renderTable(){
//		$.ajax({
//			type : "GET",
//			url : window.location + "api/customer/all",
//			success: function(result){
//				if(result.status == "Done"){
//					$('#getResultDiv ul').empty();
//					var custList = "";
//					$.each(result.data, function(i, customer){
//						var customer = "- Customer with Id = " + i + ", firstname = " + customer.firstname + ", lastName = " + customer.lastname + "<br>";
//						$('#getResultDiv .list-group').append(customer)
//			        });
//					console.log("Success: ", result);
//				}else{
//					$("#getResultDiv").html("<strong>Error</strong>");
//					console.log("Fail: ", result);
//				}
//			},
//			error : function(e) {
//				$("#getResultDiv").html("<strong>Error</strong>");
//				console.log("ERROR: ", e);
//			}
//		});	
//	}
//})directories=0,titlebar=0,toolbar=0,location=0,status=0,menubar=0,scrollbars=no,resizable=no
	function basicPopup(url,height,width) {
popupWindow = window.open(url,'popUpWindow','height='+height+',width='+width+',left=50,top=50,location=0,titlebar=no,resizable=yes,status=no,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no')
	}
