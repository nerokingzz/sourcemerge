$(document).ready(function(){

	var stompClient = null;

	function welcome(content) { //웰컴메시지를 출력하는  function
	    stompClient.send("/app/chat.openMessage", {}, JSON.stringify(content));
	    var millisecondsToWait = 1000;
	    setTimeout(function() {
	    	sendMessage("웰컴메시지 이어서");
	    }, millisecondsToWait);
	    
	}

	
	
	function connect() { // 첫 연결 시
	    var socket = new SockJS('/ws');
	    stompClient = Stomp.over(socket);
			stompClient.connect({}, function(frame){
				console.log(frame);
				onConnected();
				welcome("sadadsdadsds");
			}, onError);
	}
	


	function onConnected() { // 연결 성공 시 구독
    	
	    stompClient.subscribe('/topic/chatbot', function (payload) {

	    	
	    	var content = JSON.parse(payload.body).content;
	    	var multiLinkList = JSON.parse(payload.body).multiLinkList;
	    	
	    	chatbotMessage(JSON.parse(payload.body).content);
	    	if(multiLinkList !== null){
	    		appendButton(multiLinkList);
	    	}
	    });
		
	    
	}

	function onError(error) { //에러 시
	    console.log(error)
	}

	
	function sendMessage(content, event) { //메시지를 stomp로 보내는 function
	    stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(content));
	}
	
	
	function appendButton(multiLinkList){
		for(i in multiLinkList){
			var title = multiLinkList[i].title;
			var url = multiLinkList[i].url;
			
			console.log(i + "번째 multiLink..." + title);
			$('<button class = "chatButton" onclick="location.href='+ url +' ">'+title +'</button>').appendTo($('.messages ul li').last().find('p'));
			$(".messages").animate({ scrollTop: $(document).height() }, "fast");
			
		}
		
	}

	function appendMessage(question) { //메시지를 보낼 때 html단 처리 function
		$('<li class="sent"><img src="https://i.imgur.com/yf255Pa.png" alt="작은 유저 이미지" /><p>' + question + '</p></li>').appendTo($('.messages ul'));
		$("#question").val("");
		$(".messages").animate({ scrollTop: $(document).height() }, "fast");
	};
	

	function chatbotMessage(msg) { //챗봇으로부터 응답 받았을 시 html append
		$('<li class="replies"><img src="https://i.imgur.com/ZCGZxZK.png" alt="작은 챗봇 이미지" /><p>' + msg + '</p></li>').appendTo($('.messages ul'));
		$(".messages").animate({ scrollTop: $(document).height() }, "fast");

	};

	
	$(".messages").animate({ scrollTop: $(document).height() }, "fast");

	
	$('#submitMessage1').on('click',function() { //전송 버튼을 클릭했을 때 메시지를 보내고, html에 append
		var question = $("#question").val();
		sendMessage(question);
		appendMessage(question);
		});
	
	
	$.ajax({
		
		
	})
	

	
	
	connect();

	
///////////////////////////////////////////////////

	
	
});

