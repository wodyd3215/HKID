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
    <script src="${pageContext.request.contextPath}/resources/js/common/common.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/apis/boardApi.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/community/boardDetail.js"></script>

</head>
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<body>
    <%@ include file="/WEB-INF/views/common/header.jsp" %>

    b = ${b}
    <br><br>
    m = ${m}



    <c:choose>
        <c:when test="${m != null and not empty m}">
            
        </c:when>
        <c:otherwise>
            
        </c:otherwise>
    </c:choose>

    <br><br><br><br>
    <div class="wrapper">
        <hr>
        <div id="top-wrapper">
            <!-- 게시글 제목칸-->
            <div id="board-title-wrapper">
                <div id="board-title">
                    <p>${b.boardTitle}</p>
                </div>
                <div id="writer-date--update-delete">
                    <div id="writer-date">
                        <div>${b.nickName}</div> &nbsp;&nbsp;&nbsp;
                        <div>${b.boardDate}</div>
                    </div>
                    <div class="btn-div">
                        <!--게시글의 작성자일 경우-->
                        <c:choose>
                            <c:when test="${b.memberNo == m.memberNo}">
                                <a class="btn" href="updateForm.bo?bno=${b.boardNo}">수정</a>
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
                <div id="content" name="boardContent" required>${b.content}</div>
                <div id="etc-reply-wrapper">
                    <div id="etc-menu"> 
                        <div> 
                            <div class="heart-div" id="heart-div">
                                <!-- 로그인 O / X -->
                                <c:choose>
                                    <c:when test="${m != null and not empty m}">
                                        <img id="heart-img" src="" alt="하트" onclick="HeartChangeBtn(this, '${b.boardNo}', '${loginMember.memberNo}')">
                                    </c:when>
                                    <c:otherwise>
                                        <img id="heart-img" src="resources/image/board/emptyHeart.png" alt="하트">
                                    </c:otherwise>
                                </c:choose>
                                <p class="ptext" id="count-good">하트 개수</p>
                            </div>
                            <div class="heart-div">
                                <img src="resources/image/talk.png" alt="">
                                <p id="reply-count" class="ptext">${replyCount}</p>
                            </div>
                        </div>

                        <div id="copy-siren">
                            <button id="URLcopy-btn" class=".img-button">
                                <img id="link-img" onclick="copyLink(window.location.href, '클립보드에 현재 url이 복사되었습니다.', '복사에 실패했습니다. 다시 시도해주세요.')" 
                                    src="resources/image/Link.png" alt="URL 복사 버튼">
                            </button>
                            <button id=siren-btn class=".img-button">
                                <img id="siren-img" src="resources/image/siren.png" alt="신고 버튼" data-target="report-modal" onclick="openModal(event)">
                            </button>
                        </div>
                    </div>

                    <!-- 댓글 작성 -->
                    <!--로그인 조건 -->
                    <c:choose>
                        <c:when test="${m != null and not empty m}">
                            <div id="comment">
                                <p class="user-name">${m.nickName}</p>
                                <textarea name="replyContent" id="write-comment" placeholder="댓글을 작성하세요"></textarea>
                                <div>
                                    <button name="" id="submit-btn" onclick="addReply('${b.boardNo}', '${m.memberNo}')">등록</button>
                                </div>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div id="comment">
                                <p class="user-name">사용자</p>
                                <textarea disabled name="replyContent" id="write-comment" placeholder="로그인이 필요합니다"></textarea>
                                <div>
                                    <button name="" id="submit-btn" onclick="">등록</button>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>


            <!-- 댓글리스트 -->
            <div id="all-reply-wrapper">    <!--이 div으로 js에서 댓글 목록 작성-->
                

            </div>
            <hr>
                <!-- 대댓글 -->
                <!-- <div id="sub-comments-body">
                    <div class="sub-main-comment">
                        <div id="comment-front">
                            <img id="drift-arrow" src="resources/image/driftArrow.png" alt="">
                        </div>
                        <div class="comment-left">
                            <p class="user-name">개떡도지</p>
                            <p>2024.10.24 &nbsp; 13:34</p>
                            <button class="add-sub-comment">답글쓰기</button>
                        </div>
                        <div class="comment-middle">
                            dasdsa
                        </div>
                        <div class="comment-right">
                            <button class="reply-update-btn">수정</button>
                            <button class="reply-delete-btn">삭제</button>
                        </div>
                    </div>
                </div>
            <hr> -->

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
    

    <!-------- 삭제 버튼 모달 --------->
    <div class="modal" id="delete-modal">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">게시글을 삭제하시겠습니까?</div>
            </div>
            <div class="custom-modal-content">
                <form id="postForm" method="post" action="">
                    <input type="hidden" name="bno" value="${b.boardNo}">
                    <!-- 게시글 삭제 버튼 -->
                    <button class="modal-btn" id="yes-btn" onclick="postFormSubmit('boardDelete.bo')">예</button>
                </form>
                <!-- 모달 닫기 -->
                <button class="modal-btn" id="no-btn" onclick="closeModal()">아니오</button>
            </div>
        </div>
    </div>

    <!-------- 신고 모달 --------->
    <div class="modal" id="report-modal">
        <div class="custom-modal">
            <form class="postForm" method="post" action="">
                <input type="hidden" name="bno" value="${b.boardNo}">
                <div class="custom-modal-header">
                    <div class="custom-modal-title"><h3>신고</h3></div>
                    <button class="material-symbols-outlined close-btn" onclick="closeModal()">x</button>
                </div>
                <hr class="report-h3">
                <div id="model-middle">
                    <div id="target-div">
                        <label for="target1">대상</label>
                        <div id="target1">${b.boardTitle}</div>
                    </div>
                    <div>
                        <label for="target2">신고 사유</label>
                        <select name="reportTypeNo" id="target2">
                            <option value="" hidden>신고 유형을 선택해주세요</option>
                            <option value="1">욕설</option>
                            <option value="2">스팸 / 홍보</option>
                            <option value="3">음란물</option>
                            <option value="4">개인정보 노출</option>
                            <option value="5">불쾌한 표현</option>
                        </select>
                    </div>
                    <hr>
                    <div>
                        <h5>상세내용</h5>
                        <textarea name="reportDetailContent" id="report-textarea"></textarea>
                    </div>
                </div>
                

                <div class="custom-modal-content">
                    <button class="modal-btn" id="report-submit-btn" onclick="postFormSubmit('report.bo')">제출</button>
                </div>
            </form>
        </div>
    </div>


</body>
</html>