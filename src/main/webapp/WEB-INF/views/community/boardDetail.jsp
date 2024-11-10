<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>​
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/tableForm.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardDetail.css">

    <script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>

</head>
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>
    <script src="${pageContext.request.contextPath}/resources/js/community/boardDetail.js"></script>
    <br><br><br><br>
    <div class="wrapper">
        <hr>
        <div id="top-wrapper">

            <!-- 게시글 제목칸-->
            <div id="board-title-wrapper">
                <div id="board-title">
                    <p>[전체] 피티 연장할까 고민입니다</p>
                </div>
                <div id="writer-date--update-delete">
                    <div id="writer-date">
                        <div>풍근풍근</div> &nbsp;&nbsp;&nbsp;
                        <div>2024.10.24</div>
                    </div>
                    <div class="btn-div">
                        <form class="postForm" method="post">
                            <button class="btn" onclick = "postFormSubmit('edit')">수정</button>
                        </form>
                        <button class="btn" data-target="delete-modal" onclick="openModal(event)">삭제</button>
                    </div>
                    
                </div>
                <hr>
            </div>

            
            <!--댓글작성-->
            <div id="second-div">
                <div id="content" name="boardContent" required>피티는 지금 50번 정도 받았고  몸이 좋아지긴 했는데 또 받자니 부담이 되네요.. 연장을 하는게 좋을까요?</ㅇ>
                    
                </div>
                <div id="etc-reply-wrapper">
                    <div id="etc-menu">
                        <div> 
                            <div class="heart-div">
                                <img src="resources/image/heart.png" alt="">
                                <p class="ptext">하트 개수</p>
                            </div>
                            
                            <div class="heart-div">
                                <img src="resources/image/talk.png" alt="">
                                <p id="reply-count" class="ptext">${replyCount}</p>
                            </div>
                            
                        </div>
                        <div id="copy-siren">
                            <button id="URLcopy-btn" class=".img-button">
                                <img id="link-img" onclick="copyLink()" src="resources/image/Link.png" alt="URL 복사 버튼">
                            </button>
                            <button id=siren-btn class=".img-button">
                                <img id="siren-img" src="resources/image/siren.png" alt="신고 버튼" data-target="report-modal" onclick="openModal(event)">
                            </button>
                            
                        </div>
                    </div>
                        
                    <!-- 댓글 작성 -->
                    <div id="comment">
                        <p class="user-name">개떡도지</p>
                        <textarea name="replyContent" id="write-comment" style="resize: none;" placeholder="댓글을 작성하세요"></textarea>
                    </div>
                    <button name="" id="submit-btn" onclick="addReply()">등록</button>
                </div>
            </div>

            <!-- 댓글리스트 -->
            <div id="all-reply-wrapper">
                <c:forEach var="c" items="${replyList}" > <!-- 댓글 반복 -->
                    <hr>     
                        <div class="comments-body">
                            <div class="main-comment">
                                <div id="comment-left">
                                    <p class="user-name">${c.userName}</p>
                                    <p>${c.date} &nbsp;</p>
                                    <button class="add-sub-comment">답글쓰기</button>
                                </div>
                                <div class="comment-middle">${c.content}</div>
                                <div class="comment-right">
                                    <button>수정</button>
                                    <button>삭제</button>
                                </div>
                            </div>
                        </div>
                </c:forEach>
            </div>
            <hr>
                <!-- 대댓글 -->
                <div class="comments-body-wrapper">
                    <div id="sub-comments-body">
                        <div>
                            <img id="drift-arrow" src="resources/image/driftArrow.png" alt="">
                        </div>
                        <div class="main-comment">
                            <div id="comment-left">
                                <p class="user-name">개떡도지</p>
                                <p>2024.10.24 &nbsp; 13:34</p>
                                <button class="add-sub-comment">답글쓰기</button>
                            </div>
                            <div class="comment-middle">
                                dasdsa
                            </div>
                            <div class="comment-right">
                                <button>수정</button>
                                <button>삭제</button>
                            </div>
                        </div>
                    </div>
                </div>
   
            <hr>
        </div>

        <!------------------ 아래쪽 게시글 목록 -------------------->
        <div id="bottom-wrapper">
            <table id="top-table">
                <tr>
                    <th>
                        <select name="category" class="category-choice">전체
                            <option value="all">전체</option>
                            <option value="question">질문</option>
                            <option value="tip">팁</option>
                            <option value="show-off">자랑</option>
                            <option value="ad">홍보</option>
                        </select>
                    </th>
                    <th id="th-title">제목</th>
                    <th id="writer">작성자</th>
                    <th id="write-date">작성일</th>
                    <th id="view-count">조회수</th>
                </tr>
            </table>
            
            <!-------------- 게시글 목록  ---------------->
            <table id="main-table">
                <tr>
                    <td id="board-category">질문</td>
                    <td><a href="boardDetail.bo">세트별 개수 설정에 대해 질문드립니다 [0]</a></td>
                    <td id="writer2">꾸준히 운동</td>
                    <td id="write-date2">2024-10-10</td>
                    <td class id="view-counts">4</td>
                </tr>
            </table>
            
            
            <!-- 게시글 수 + 글쓰기 버튼 -->
            <div id="boCount-wirte-div">
                <select name="board-bottom-div" class="category-choice">
                    <option value="">5개씩</option>
                    <option value="">10개씩</option>
                    <option value="">15개씩</option>
                </select>

            </div>
    
            <!-- 검색 바 -->
            <div id="searchbar-div">
                <select name="search-category" id="search-category">전체
                    <option value="all">전체</option>
                    <option value="question">질문</option>
                    <option value="tip">팁</option>
                    <option value="show-off">자랑</option>
                    <option value="ad">홍보</option>
                </select>
                
                <input type="search" name="" id="board-search-bar" placeholder="검색어를 입력해주세요">
                <button id="search-btn" type="submit">
                    <img id="searchIcon" src="resources/image/searchIcon.png">
                </button>
            </div>  
    
            <!-- 페이지 버튼 -->
            <div id="paging-div">
                <button class="page-btn">&lt;</button>
                <button class="page-btn">1</button>
                <button class="page-btn">2</button>
                <button class="page-btn">3</button>
                <button class="page-btn">4</button>
                <button class="page-btn">5</button>
                <button class="page-btn">&gt;</button>
            </div>
        </div>
    </div>
    
    <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    

    <!-------- 로그인 버튼 모달 --------->
    <div class="modal" id="delete-modal">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">게시글을 삭제하시겠습니까?</div>
            </div>
            <div class="custom-modal-content">
                <form class="postForm" method="post">
                    <!-- 게시글 삭제 버튼 -->
                    <button class="modal-btn" id="yes-btn" onclick="postFormSubmit('delete')">예</button>
                </form>
                <!-- 모달 닫기 -->
                <button class="modal-btn" id="no-btn" onclick="closeModal()">아니오</button>
                
            </div>
        </div>
    </div>

    <!-------- 신고 버튼 모달 --------->
    <div class="modal" id="report-modal">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">게시글을 신고하겠습니까?</div>
            </div>
            <div class="custom-modal-content">
                <form class="postForm" method="post">
                    <!-- 게시글 신고 버튼 -->
                    <button class="modal-btn" id="yes-btn" onclick="postFormSubmit('report')">예</button>
                </form>
                <!-- 모달 닫기 -->
                <button class="modal-btn" id="no-btn" onclick="closeModal()">아니오</button>
                
            </div>
        </div>
    </div>
    <!--------------------------------->


</body>
</html>