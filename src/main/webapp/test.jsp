<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Sample Page</title>
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

	<link rel='stylesheet' href='//releases.flowplayer.org/6.0.5/skin/functional.css'>
	<script src='//releases.flowplayer.org/6.0.5/flowplayer.min.js'></script>
	
	<!-- <script src='http://releases.flowplayer.org/js/flowplayer-3.2.13.min.js'></script> -->
	
	<script>
		function testfunc(num){
			return "testfunc " + num;			
		}
	</script>
</head>
<body>
	TEST
	<script>
		$(function(){
			if(true){
				
				document.write("<div class='flowplayer' id='divPlayer' style='width:720px; height:405px;'></div>"); 
				//$("body").append("<div class='flowplayer' id='divPlayer' style='width:720px; height:405px;'></div>");
					
				// select the above element as player container
				var container = document.getElementById("divPlayer");
					 
				// install flowplayer into selected container
				flowplayer(container, {
					    clip: {
					        sources: [
					              { type: "application/x-mpegurl",
					                src:  "http://kdavideo-vh.akamaihd.net/i/transcoding/delivery/0c/21/0c21a180-f1b5-43f5-8453-eaf57f262beb/Video%20Lookbook%20-%20total_,600k,4000k,800k,200k,2500k,400k,1000k,1500k,.mp4.csmil/master.m3u8" }
					        ]
					    }
					});
			}else{
				var v_token = testfunc('2');
				$("body").append(v_token)
					
					document.write("<div id='player' style='width:720px; height:405px;'>aaa</div>");
					
					player=flowplayer(
							    "player",
							    {
							     src: "http://releases.flowplayer.org/swf/flowplayer-3.2.18.swf",
							     wmode: "direct"
							    },     
							    {
							     debug: true,
							     clip:
							     {
							      live:false,            
							      provider: 'akamai',
							      autoPlay: true,
							      autoBuffering: true,
							      stopLiveOnPause:false,
							      accelerated: true,
							      scaling: 'fit',
							      url: 'http://kdavideo-vh.akamaihd.net/z/transcoding/delivery/0c/21/0c21a180-f1b5-43f5-8453-eaf57f262beb/Video%20Lookbook%20-%20total_,600k,4000k,800k,200k,2500k,400k,1000k,1500k,.mp4.csmil/manifest.f4m',
							      onStart: function(){ },
							      onPause: function(){ },
							      onResume: function(){ },
							      onFinish: function(){ }
							     },
							     plugins:
							     {          
							      akamai:
							      {
							       url:'/js/flowplayer/AkamaiAdvancedFlowplayerProvider.swf'
							      }
							     }
							    }
							   );
			}
		});
	</script>
	
</body>
</html>