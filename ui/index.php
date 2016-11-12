<?php
	$method=array(' ','마타하리암호','카이사르암호','전치형암호','스키테일암호','모스부호');
	$type=array(
		'de'=>"복호화",
		'en'=>'암호화'
	);
	$hz = array(
		'3C'=>'261',
		'4D'=>'293',
		'3E'=>'329',
		'3F'=>'349',
		'3G'=>'391',
		'3A'=>'440',
		'3B'=>'493',
		'4C'=>'523',
		'4E'=>'659',
		'4E'=>'659',
		'4F'=>'698',
		'4G'=>'783',
		'4A'=>'880'
	)
?>
<!Doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>JavaProjectCipher</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/hipster_cards.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
    <link href='https://fonts.googleapis.com/css?family=Playfair+Display|Raleway:700,100,400|Roboto:400,700|Playfair+Display+SC:400,700' rel='stylesheet' type='text/css'>
		<script src="./riffwave.js"></script>
		<script>
		var agent = navigator.userAgent.toLowerCase();

				function simHertz(hz, length) {
		    var audio = new Audio();
		    var wave = new RIFFWAVE();
		    var data = [];

		    wave.header.sampleRate = 44100/length;

		    var seconds = 1;

		    for (var i = 0; i < wave.header.sampleRate * seconds; i ++) {
		        data[i] = Math.round(128 + 127 * Math.sin(i * 2 * Math.PI * hz / wave.header.sampleRate));
		    }

		    wave.Make(data);
		    audio.src = wave.dataURI;
		    return audio;
			}
			var audio = simHertz(440);
			function play(){

			<?php if($_GET['method'] == 1 && $_GET['type']=='en'){
				?>
				if (agent.search("trident") > -1) {
						alert("인터넷익스플로러는 지원되지 않습니다. 크롬또는 파이어폭스를 이용해주세요.");
						}
				else if(agent.search("edge/") > -1){
					alert("Edge는 지원되지 않습니다. 크롬또는 파이어폭스를 이용해주세요.");
				}

				<?php
					for($i = 1; $i<=strlen($_GET['text'])/6; $i++){
						$key = substr($_GET['text'],($i-1)*6,6);
						if(substr($key,3,3) == "000"){
							$length = 1;
							$hzs = $hz[substr($key,1,2)];
							echo "setTimeout(function() { var audio = simHertz(".$hzs.",1); audio.play() }, ".($i-1)."000);\n";
						}else{
							$length = 2;
							$hz1 = $hz[substr($key,1,2)];
							$hz2 = $hz[substr($key,4,2)];
							echo "setTimeout(function() { var audio = simHertz(".$hz1.",2); audio.play() }, ".($i-1)."000);\n";
							echo "setTimeout(function() { var audio = simHertz(".$hz2.",2); audio.play() }, ".($i-1)."500);\n";
						}
					}
			}
			?>
			}
			play();
			// var audio = simHertz(440);
			// audio.play();
		</script>
    <style>
        .card{
            margin-bottom: 70px;
        }
        body{
          padding-top:70px;
        }
				.titlee{
					height:430px !important;
				}
				.title123{
					height:200px;
				}
    </style>
</head>
<body>

<div class="wrapper">
    <div class="container">

        <div class="masonry-container">
					<div class="card-box col-md-4 col-sm-6">
							<div class="card card-with-border titlee" data-background="color" data-color="azure">
									<div class="header">
											<div class="icon">
													<i class="fa fa-github-alt"></i>
											</div>
									</div>
									<div class="content text-center">
											<h4 class="title title-modern">Team Github</h4>
											<p class="description">Github를 통해 효율적인 협업을 하였습니다.</p>
									</div>
									<div class="footer text-center">
											<button class="btn btn-neutral btn-round btn-fill btn-modern" onclick="location.href='https://github.com/JavaProjectCipher/JavaProjectCipher'">바로가기</button>
									</div>
							</div> <!-- end card -->
					</div>
					<div class="card-box col-md-4 col-sm-6">
							<div class="card card-with-border titlee" data-background="color" data-color="azure">
									<div class="header">
											<div class="icon">
													<i class="fa fa-unlock"></i>
											</div>
									</div>
									<div class="content text-center">
											<h4 class="title title-modern">현재 선택한 암호</h4>
											<p class="description"><?php echo $method[$_GET['method']]; ?></p>
									</div>
									<div class="footer text-center">
											<button class="btn btn-neutral btn-round btn-fill btn-modern" onclick="location.href='#ki'">자세히 보기</button>
									</div>
							</div> <!-- end card -->
					</div>
					<div class="card-box col-md-4 col-sm-6">
							<div class="card card-with-border titlee" data-background="color" data-color="azure">
									<div class="header">
											<div class="icon">
													<i class="fa fa-key"></i>
											</div>
									</div>
									<div class="content text-center">
											<h4 class="title title-modern"><?php echo $type[$_GET['type']]; ?>된 문장</h4>
											<p class="description"><?php echo 'TEXT : '.$_GET['text']; ?></p>
											<p class="description"><?php
												if($_GET['key']){
													echo "KEY : ".$_GET['key'];
												}
											?></p>
											<?php if($_GET['method'] == '1' && $_GET['type'] == 'en'){ ?>
												<button class="btn btn-neutral btn-round btn-fill btn-modern" onclick="play()">재생</button>
											<?php } ?>
									</div>
									<div class="footer text-center">
									</div>
							</div> <!-- end card -->
					</div>
					<div class="card-box col-md-4 col-sm-6">
							<div class="card">
									<div class="header">
											<img src="https://avatars0.githubusercontent.com/u/18441444?v=3&s=460" />

											<div class="social-line social-line-visible" data-buttons="4">
													<button class="btn btn-social btn-facebook" onclick="location.href='https://github.com/sunghyeonwoo'">
															<i class="fa fa-github"></i>
													</button>
											</div>
									</div>

									<div class="content">
											<h6 class="category">Member</h6>
											<h4 class="title">성현우</h4>
											<p class="description">카이사르 암호, 스키테일 암호</p>
									</div>
							</div> <!-- end card -->
					</div>

					<div class="card-box col-md-4 col-sm-6">
							<div class="card">
									<div class="header">
											<img src="https://avatars3.githubusercontent.com/u/22029423?v=3&s=460" />

											<div class="social-line social-line-visible" data-buttons="4">
													<button class="btn btn-social btn-facebook" onclick="location.href='https://github.com/MaengSeongHo'">
															<i class="fa fa-github"></i>
													</button>
											</div>
									</div>

									<div class="content">
											<h6 class="category">Member</h6>
											<h4 class="title">맹성호</h4>
											<p class="description">모스부호, 전치형암호</p>
									</div>
							</div> <!-- end card -->
					</div>

					<div class="card-box col-md-4 col-sm-6">
							<div class="card">
									<div class="header">
											<img src="https://avatars0.githubusercontent.com/u/16171447?v=3&s=460" />

											<div class="social-line social-line-visible" data-buttons="4">
													<button class="btn btn-social btn-facebook" onclick="location.href='https://github.com/SuhwanCha'">
															<i class="fa fa-github"></i>
													</button>
											</div>
									</div>

									<div class="content">
											<h6 class="category">Member</h6>
											<h4 class="title">차수환</h4>
											<p class="description">마타하리암호, 웹사이트제작</p>
									</div>
							</div> <!-- end card -->
					</div>


            <div class="card-box col-md-4 col-sm-6" id="ki">
                <div class="card card-with-border title123 card-just-text" data-background="color" data-color="black" >
                    <div class="content">
                        <h4 class="title">카이사르 암호</h4>
												<p class="description">순서에 따른 치환</p>
                    </div>
                </div>
            </div>

						<div class="card-box col-md-4 col-sm-6">
                <div class="card card-with-border title123 card-just-text" data-background="color" data-color="black" >
                    <div class="content">
                        <h4 class="title">모스부호</h4>
												<p class="description">1838년의 전신 부호</p>

                    </div>
                </div>
            </div>
						<div class="card-box col-md-4 col-sm-6">
                <div class="card card-with-border title123 card-just-text" data-background="color" data-color="black" >
                    <div class="content">
                        <h4 class="title">마타하리 암호</h4>
												<p class="description">20만명을 죽인 암호</p>
                    </div>
                </div>
            </div>


            <div class="card-box col-md-4 col-sm-6">
                <div class="card">
                    <div class="header">
                        <img src="./img/3192825.png"/>
                        <div class="filter"></div>

                        <div class="actions">
                            <button class="btn btn-round btn-fill btn-neutral btn-modern" onclick="location.href='http://www.ddanzi.com/ddanziNews/3192779'" >
                                자세히보기
                            </button>
                        </div>
                    </div>

                    <div class="content">
                        <h6 class="category">자세히보기</h6>
                        <h4 class="title"><a href="#">카이사르 암호</a></h4>
                        <p class="description"></p>
                    </div>
                </div> <!-- end card -->
             </div>

						 <div class="card-box col-md-4 col-sm-6">
								 <div class="card">
										 <div class="header">
												 <img src="./img/186A964F5004F124162E15"/>
												 <div class="filter"></div>

												 <div class="actions">
														 <button class="btn btn-round btn-fill btn-neutral btn-modern" onclick="location.href='https://namu.wiki/w/%EB%AA%A8%EC%8A%A4%20%EB%B6%80%ED%98%B8'" >
																 자세히보기
														 </button>
												 </div>
										 </div>

										 <div class="content">
												 <h6 class="category">자세히보기</h6>
												 <h4 class="title"><a href="#">모스부호</a></h4>
												 <p class="description"></p>
										 </div>
								 </div> <!-- end card -->
							</div>

							<div class="card-box col-md-4 col-sm-6">
									<div class="card">
											<div class="header">
													<img src="./img/49b35f613046e"/>
													<div class="filter"></div>

													<div class="actions">
															<button class="btn btn-round btn-fill btn-neutral btn-modern" onclick="location.href='http://blog.naver.com/PostView.nhn?blogId=bartok74&logNo=220357378991'" >
																	자세히보기
															</button>
													</div>
											</div>

											<div class="content">
													<h6 class="category">자세히보기</h6>
													<h4 class="title"><a href="#">마타하리 암호</a></h4>
													<p class="description"></p>
											</div>
									</div> <!-- end card -->
							 </div>

							 <div class="card-box col-md-4 col-sm-6">
									 <div class="card card-with-border title123 card-just-text" data-background="color" data-color="black" >
											 <div class="content">
													 <h4 class="title">스키테일 암호</h4>
													<p class="description">무작위 문자 삽입</p>
											 </div>
									 </div>
							 </div>

							 <div class="card-box col-md-4 col-sm-6">
									 <div class="card card-with-border title123 card-just-text" data-background="color" data-color="black" >
											 <div class="content">
													 <h4 class="title">전치형 암호</h4>
													<p class="description">배열과 행열에 따른 순서 변경	</p>
											 </div>
									 </div>
							 </div>

							 <div class="card-box col-md-4 col-sm-6">
									 <div class="card card-with-border title123 card-just-text" data-background="color" data-color="black" >
											 <div class="content">
													 <h4 class="title">Web</h4>
													<p class="description">Made With Creative-Tim</p>
											 </div>
									 </div>
							 </div>

							 <div class="card-box col-md-4 col-sm-6">
 									<div class="card">
 											<div class="header">
 													<img src="./img/b0142763_4d009644c7514.jpg"/>
 													<div class="filter"></div>

 													<div class="actions">
 															<button class="btn btn-round btn-fill btn-neutral btn-modern" onclick="location.href='https://ko.wikipedia.org/wiki/%EC%8A%A4%ED%82%A4%ED%85%8C%EC%9D%BC'" >
 																	자세히보기
 															</button>
 													</div>
 											</div>

 											<div class="content">
 													<h6 class="category">자세히보기</h6>
 													<h4 class="title"><a href="#">스키테일 암호</a></h4>
 													<p class="description"></p>
 											</div>
 									</div> <!-- end card -->
 							 </div>

							 <div class="card-box col-md-4 col-sm-6">
									<div class="card">
											<div class="header">
													<img src="./img/211C703D554D9DA129CAA1"/>
													<div class="filter"></div>

													<div class="actions">
															<button class="btn btn-round btn-fill btn-neutral btn-modern" onclick="location.href='http://bongsnet.tistory.com/76'" >
																	자세히보기
															</button>
													</div>
											</div>

											<div class="content">
													<h6 class="category">자세히보기</h6>
													<h4 class="title"><a href="#">전치형 암호</a></h4>
													<p class="description"></p>
											</div>
									</div> <!-- end card -->
							 </div>

							 <div class="card-box col-md-4 col-sm-6">
									<div class="card">
											<div class="header">
													<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/HTML5_logo_and_wordmark.svg/220px-HTML5_logo_and_wordmark.svg.png"/>
													<div class="filter"></div>

													<div class="actions">
															<button class="btn btn-round btn-fill btn-neutral btn-modern" onclick="location.href='https://github.com/JavaProjectCipher/JavaProjectCipher/blob/master/ui/index.php'" >
																소스보기
															</button>
													</div>
											</div>

											<div class="content">
													<h6 class="category">HTML5 + CSS3 + PHP7.0 + Jquery1.x</h6>
													<h4 class="title"><a href="#">Web</a></h4>
													<p class="description"></p>
											</div>

									</div> <!-- end card -->
							 </div>



            </div>


        </div>

    </div>
</div> <!-- end wrapper -->

</body>

    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/js/hipster-cards.js"></script>

	<!--  Just for demo	 -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/masonry/3.3.1/masonry.pkgd.min.js"></script>

	<script>

    	$().ready(function(){

        	var $container = $('.masonry-container');

            doc_width = $(document).width();

            if (doc_width >= 768){
                $container.masonry({
                    itemSelector        : '.card-box',
                    columnWidth         : '.card-box',
                    transitionDuration  : 0
                });
            } else {
                $('.mas-container').removeClass('mas-container').addClass('row');
            }
    	});
	</script>

</html>
