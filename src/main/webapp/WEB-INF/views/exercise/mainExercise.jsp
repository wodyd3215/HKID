<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/exercise/mainExercise.css?after">
<link rel="stylesheet" href="./resources/css/default.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
		<div class="wrapper">
			<div class="exerTitle">
				<p>운동 라이브러리</p>
			</div>
			<div id="exerSearch-form">
				<form id="searchForm" action="exercise.se" method="post">
					<table>
						<tr>
							<th><p>부위별 선택</p></th>
								<td>
									<div class="part">
										<input type="checkbox" name="part" id="chest" value="가슴">
										<label for="chest">#가슴</label>

										<input type="checkbox" name="part" id="back" value="등">
										<label for="back">#등</label>

										<input type="checkbox" name="part" id="abs" value="복근">
										<label for="abs">#복근</label>

										<input type="checkbox" name="part" id="shoulder" value="어깨">
										<label for="shoulder">#어깨</label>

										<input type="checkbox" name="part" id="arm" value="팔">
										<label for="arm">#팔</label>

										<input type="checkbox" name="part" id="leg" value="하체">
										<label for="leg">#하체</label>
									</div>
								</td>
						</tr>

						<tr>
							<th><p>난이도 선택</p></th>
								<td>
									<div class="difficulty">
										<input type="checkbox" name="difficulty" id="hard" value="어려움">
										<label for="hard">어려움</label>

										<input type="checkbox" name="difficulty" id="middle" value="보통">
										<label for="middle">보통</label>

										<input type="checkbox" name="difficulty" id="easy" value="쉬움">
										<label for="easy">쉬움</label>
									</div>
								</td>
						</tr>
					</table>
				
			</div>
			<div class="exerContent">
				<p class="exerTitle2">운동 리스트</p>
					<div>
						<input type="text" name="keyword" value="${ keyword}" placeholder="검색어를 입력해주세요.">
						<input type="submit" value="검색">
					</div>
				</form>
			</div>
			
			
			<div class="content-box">
				<div class="list-box" id="tour-content">
				<c:forEach var="e" items="${list}">
						<div id="list-con">
							<div id="list-img">
								<a href="">
									<img src="./resources/image/exerciseImages/${ e.exerciseImg}" style="height: 250px; width: 250px;">
								</a>
							</div>
							<br>
							<p class="list-text">${e.exerciseName}</p>
							<br>
							<div id="under-area">
								<p class="list-text2">${e.exerciseDifficulty}</p>
								<button type="button">
									<img src="./resources/img/buy.png" class="like(this)" onclick="like(this)">
								</button>
							</div>
						</div>
					</c:forEach>
					</div>
					
					<div id="paging-area">
            <c:if test="${pi.currentPage ne 1}">
                <a href="list.ex?cpage=${pi.currentPage - 1}">[이전]</a>
            </c:if>

            <c:forEach var="i" begin="${pi.startPage}" end="${pi.endPage}">
            	
            	<c:choose>
            		<c:when test="${empty part}">
            			<a href="list.ex?cpage=${i}">${i}</a>
            		</c:when>
            		<c:otherwise>
            			<a href="exercise.se?cpage=${i}">${i}</a>
            		</c:otherwise>
            	</c:choose>
                
            </c:forEach>

            <c:if test="${pi.currentPage ne pi.maxPage}">
                <a href="list.ex?cpage=${pi.currentPage + 1}">[다음]</a>
            </c:if>
        </div>
        <br><br>
    </div>
			</div>
		</div>
		<br><br><br>
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
</body>
</html>