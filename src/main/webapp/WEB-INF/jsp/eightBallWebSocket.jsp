<%@include file="/WEB-INF/jsp/includes/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Headers</title>
<link type="text/css" rel="stylesheet" href="css/main.css" />
<base href="${baseHref}" />
<script src="js/jquery-2.1.0.js" type="text/javascript"></script>
<script src="js/sockjs-0.3.4.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript" src="js/stomp.js"></script>
<script language="javascript" type="text/javascript" src="js/main.js"></script>
<script language="javascript" type="text/javascript">
	var stompClient = null;

	function setConnected(connected) {
		document.getElementById('connect').disabled = connected;
		document.getElementById('disconnect').disabled = !connected;
		document.getElementById('conversationDiv').style.visibility = connected ? 'visible'
				: 'hidden';
		document.getElementById('response').innerHTML = '';
	}

	function connect() {
		var socket = new SockJS('app');
		stompClient = Stomp.over(socket);
		stompClient.connect('', '', function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			stompClient.subscribe('/topic/eightBallAnswer', function(greeting) {
				showAnswer(JSON.parse(greeting.body).content);
			});
		});
	}

	function disconnect() {
		stompClient.disconnect();
		setConnected(false);
		console.log("Disconnected");
	}

	function sendQuestion() {
		var question = document.getElementById('question').value;
		stompClient.send("/eightBallQuestion", {}, JSON.stringify({
			'question' : question
		}));
	}

	function showAnswer(message) {
		var response = document.getElementById('response');
		var p = document.createElement('p');
		p.style.wordWrap = 'break-word';
		p.appendChild(document.createTextNode(message));
		response.appendChild(p);
	}
</script>
</head>
<body>
	<div id="bodyDiv" class="bodyContent">
		<div id="ctrls" class="controls">
			<h2 class="hBlu">HelloWorld</h2>
			<a href="index">Hello World Home</a>
			<hr class="hrClass" />
		</div>
		<div class="innerContent">
			<noscript>
				<img src="img/error_blu.gif">&nbsp;&nbsp;
				<h2 class="hBlu">Browser does not support JavaScript!</h2>
			</noscript>
			<div>
				<div>
					<button class="btnInput" id="connect" onclick="connect();">Connect</button>
					<button class="btnInput" id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
				</div>
				<div id="conversationDiv">
					<label>What is your question?</label><input type="text"
						class="txtInput" id="question" />
					<button id="sendQuestion" class="btnInput"
						onclick="sendQuestion();">Send</button>
					<p id="response"></p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>