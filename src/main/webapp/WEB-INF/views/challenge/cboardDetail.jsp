<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <% String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/css/challenge/cboardDetail.css?after">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/tableForm.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardDetail.css">
<link rel="stylesheet" href="./resources/css/default.css">

</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <div class="wrapper">
        <hr>
        <div id="top-wrapper">
            <!-- 게시글 제목칸-->
            <div id="board-title-wrapper">
                <div id="board-title">
                     <p>${c.chaTitle}</p>
                </div>
                <div id="writer-date--update-delete">
                    <div id="writer-date">
                        <div>${c.nickName}</div> &nbsp;&nbsp;&nbsp;
                        <div>${c.chaDate}</div>
                    </div>
                    <div class="btn-div">
                        <!--게시글의 작성자일 경우-->
                        <c:choose>
                            <c:when test="${c.memberNo == m.memberNo}">
                                <a class="btn" href="updateForm.cbo?cbno=${c.challengeBoardNo}">수정</a>
                                <button class="btn" data-target="delete-modal" onclick="openModal(event)">삭제</button>
                            </c:when>
                            <c:otherwise>
                                <a class="btn" href="">&nbsp;&nbsp;</a>
                                <button class="btn">&nbsp;&nbsp;</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>

        <hr>

        <div id="second-div">
            <div id="content" name="boardContent" required>${c.chaContent}</div>
        </div>

    <!-------- 삭제 버튼 모달 --------->
    <div class="modal" id="delete-modal">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">게시글을 삭제하시겠습니까?</div>
            </div>
            <div class="custom-modal-content">
                <form id="postForm" method="post" action="">
                    <input type="hidden" name="cbno" value="${cbno}">
                    <!-- 게시글 삭제 버튼 -->
                    <button class="modal-btn" id="yes-btn" onclick="postFormSubmit('boardDelete.cbo')">예</button>
                </form>
                <!-- 모달 닫기 -->
                <button class="modal-btn" id="no-btn" onclick="closeModal()">아니오</button>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    <script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>
</body>
</html>