<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.payment.model.vo.Payment" %>
<%
	Payment selectPay = (Payment) request.getAttribute("selectPay");
	String method = "";
	if(selectPay.getPaymentType().equals("카드")){
		method = "card";
	}else{
		method = "vbank";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<title>Insert title here</title>
</head>
<body>

	


<script>

	
	IMP.init("imp89701275"); // "imp00000000" 대신 발급받은 "가맹점 식별코드"를 사용합니다.
	
	  // IMP.request_pay(param, callback) 호출
	  IMP.request_pay({ // param
	    pg: "inicis",
	    pay_method: "<%=method%>",
	    merchant_uid: "<%=selectPay.getTicketNo()%>",
	    name: "<%=selectPay.getContentTitle()%>",
	    amount: <%=selectPay.getPaymentTotal()%>,
	    buyer_email: "<%=selectPay.getEmail()%>",
	    buyer_name: "<%=selectPay.getUserName()%>",
	    buyer_tel: "<%=selectPay.getPhone()%>"
	  }, function (rsp) { // callback
		    if (rsp.success) { // 결제 성공 시: 결제 승인 또는 가상계좌 발급에 성공한 경우
		    	
		    	//결제여부, 날짜 업데이트용 ajax 호출
		    	<%if(method.equals("card")){%>
		    		updatePaymentDate();
		    	<%}%>
		    	
		    	var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        alert(msg);
		        location.href = "<%=request.getContextPath()%>/reservation.my?currentPage=1&userNo=<%=selectPay.getUserNo()%>";
		        
		      } else {
		    	  var msg = '결제에 실패하였습니다.';
		          msg += '에러내용 : ' + rsp.error_msg;
		          alert(msg);
		          location.href = "<%=request.getContextPath()%>/reservation.my?currentPage=1&userNo=<%=selectPay.getUserNo()%>";
		      }
		    });
	
	//결제상태, 결제일 업데이트용 함수 
	function updatePaymentDate(){
		$.ajax({
			url : "<%=request.getContextPath()%>/updateStatus.pay",
			type:"get",
			data:{"ticketNo":<%=selectPay.getTicketNo()%>},
			success : function(result){
				console.log(result);
			}, error : function(){
				console.log('통신실패!');
			}
			
		});
	}

</script>

</body>
</html>