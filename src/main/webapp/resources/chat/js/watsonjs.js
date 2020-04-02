
	const options = {
			integrationID : "17492039-629e-4de1-bd22-7e87d039b29a",
			region : "kr-seo"
				
	};
	
	
	//메시지 윈도우를 열 때 설정해야하는 부분
	function windowOpen(event){
		console.log('window:open');
	
	}

	
	
	//챗봇 메시지를 받기 전 설정해야하는 부분
	function preRecieve(event){
		console.log('pre:receive');
		checkId(event);
	}
	
	//위젯 열 때 실행될 메소드 1. 회원 아이디가 있는지 체크. 있다면 $isLogin을 true로 바꾸기.
	//단 한 번만 실행됨.(instance.once)
	function checkId(event){
		console.log('checkId');
		
		var userId = event.data.context.global.system.user_id;
		console.log("현재 접속한 유저의 아이디 : " + userId);
		
		if(!userId.includes('IBM')){
			console.log(event.data.context.skills['main skill'].user_defined);
			event.data.context.skills['main skill'].user_defined.isLogin = true;
		}	
	}

	
	
	//챗봇 메시지를 받을 때 설정부
	function receive(event){
		console.log('receive');
	}
	
	
	
	//챗봇 메시지를 보낼 때 설정부
	function send(event) {
		console.log("send....."); 
	}
	

	//에러 발생 시 설정부
	function error(event){
		console.log('개발자님.. 뭔가 문제가 생긴 것 같아요');
		console.log('error type : ' + event.type);
		console.log('error data : ' + event.data);
	}
	
	

	window.loadWatsonAssistantChat(options).then(function(instance) {
		$('#login').on('click',function(){
			$('#status').html('현재 상태 : 회원');
			instance.updateUserID('suny21');
		});
		
		instance.on({ type: 'window:open', handler: windowOpen });
		
		instance.on({ type: 'pre:receive', handler: preRecieve });
		instance.on({ type: 'receive', handler: receive });
		
		instance.on({ type: 'send', handler: send });
		instance.on({ type: 'error', handler: error });
		
		
		console.log("instance.... " + JSON.stringify(instance));
		instance.render();
	});
	
	

	
	
	