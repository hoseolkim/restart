<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dokdo&family=Gugi&family=Hahmlet:wght@300;600&family=IBM+Plex+Sans+KR:wght@500&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dokdo&family=Gugi&family=Hahmlet:wght@300;600&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<style>
#all{
 text-align: center;
 margin-top: 150px;
 border : 5px solid #38ef7d;
 border-radius : 20px;
 width : 450px;
 margin-left : 700px;
 background-color: RGB(500,500,500,0.4);
}
p{
color : black;
font-family: 'IBM Plex Sans KR', sans-serif;
font-size: 50px;
margin-top: 60px;
}
#innum{
width : 300px;
height: 50px;
border : 2px green solid;
border-radius : 20px;
text-align: center;
}
body{
	background-image: url(${pageContext.request.contextPath}/resources/background.png);
    background-size: cover; /* 이미지를 화면에 맞게 조절 */
    background-repeat: no-repeat; /* 이미지 반복 여부 설정 */
}
.btn {
  border: none;
  display: block;
  text-align: center;
  cursor: pointer;
  text-transform: uppercase;
  outline: none;
  overflow: hidden;
  position: relative;
  color: #fff;
  font-size: 25px;
  font-family: 'IBM Plex Sans KR', sans-serif;
  background: #11998e;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #38ef7d, #11998e);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #38ef7d, #11998e); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
  padding: 6px 60px;
  margin: 0 auto;
  box-shadow: 0 5px 15px rgba(0,0,0,0.20);
  margin-top: 20px;
  width : 300px;
  height: 50px;
  border-radius : 20px;
  margin-bottom: 30px;
}
.btn:after {
  content: "";
  position: absolute;
  left: 0;
  top: 0;
  height: 490%;
  width: 140%;
  background: #78c7d2;
  -webkit-transition: all .5s ease-in-out;
  transition: all .5s ease-in-out;
  -webkit-transform: translateX(-98%) translateY(-25%) rotate(45deg);
  transform: translateX(-98%) translateY(-25%) rotate(45deg);
}

.btn:hover:after {
  -webkit-transform: translateX(-9%) translateY(-25%) rotate(45deg);
  transform: translateX(-9%) translateY(-25%) rotate(45deg);
}
img{
width : 300px;
height: 300px;
}
#imgdi{
	margin-bottom: -80px;
	margin-top: -30px;
}
</style>
<body>
<c:if test="${not empty sessionScope.message }">
	<script>
		alert("${message}");
	</script>
	<c:remove var="message" scope="session" />
</c:if>
<div id="all">
<form action="${pageContext.request.contextPath }/login" method="post">
	
	<div id="imgdi">
	<img src="${pageContext.request.contextPath}/resources/hak.png">
	</div>
	<p>학번입력</p>

	<div id="num">
	<input type="text" name="id" id="innum"/>
	</div>
	
	<div class="button_container" id="btn">
	<input type="submit" value="로그인" class="btn" required/>
	</div>
	
	
	<br/>
	<span>${sessionScope.errors.stdNo }${sessionScope.errors.proCd }</span>
	<c:remove var="errors" scope="session" />
</form>
</div>
</body>