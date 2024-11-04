<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/community/boardDetail.css">
</head>
<body>
    <div class="wrapper">
        <hr>
        <!-- 게시글 정보 출력 -->
        <div id="top-wrapper">

            <!-- 1번 게시글 제목칸-->
            <div>
                <div id="board-title">
                    <p>[전체] 피티 연장할까 고민입니다</p>
                </div>
                <div id="writer-date--update-delect">
                    <div id="writer-date">
                        <div>풍근풍근</div> &nbsp;&nbsp;&nbsp;
                        <div>2024.10.24</div>
                    </div>
                    <div>
                        <button>수정</button>
                        <button>삭제</button>
                    </div>
                </div>
                <hr>
            </div>

            <!-- 2번 내용 + 댓글작성-->
            <div id="second-div">
                <textarea id="content"  style="resize:none;" name="boardContent" required>피티는 지금 50번 정도 받았고  몸이 좋아지긴 했는데 
                    또 받자니 부담이 되네요.. 연장을 하는게 좋을까요?
                </textarea>
                    
                </textarea>
                <div id="testsss">
                    <div id="etc-menu">
                        <div> 
                            <div class="heart-div">
                                <img src="resources/image/heart.png" alt="">
                                <p class="ptext">5</p>
                            </div>

                            <div class="heart-div">
                                <img src="resources/image/talk.png" alt="">
                                <p class="ptext">2</p>
                            </div>
                            
                        </div>
                        <div>
                            <div class="img-div">
                                <img id="link-img" src="resources/image/Link.png" alt="">
                                <p class="ptext">url복사</p>
                            </div>
                            <div class="img-div">
                                <img id="siren-img" src="resources/image/siren.png" alt="">
                                <p class="ptext">신고</p>
                            </div>
                            
                        </div>
                    </div>
                    <!-- 댓글 작성 -->
                    <form id="comment">
                        <p class="user-name">개떡도지</p>
                        <textarea name="" id="write-comment" style="resize: none;" placeholder="댓글을 작성하세요">

                        </textarea>
                        <input type="submit" name="" id="submit-btn" value="등록">
                    </form>
                </div>
            </div>

            <hr>

            <!-- 3번 댓글리스트 -->
            <div id="comments-body-wrapper">
                <div id="comments-body">
                    <div id="main-comment">
                        <div id="comment-left">
                            <p class="user-name">개떡도지</p>
                            <p>2024.10.24 &nbsp; 13:34</p>
                            <button id="add-sub-comment">답글쓰기</button>
                        </div>
                        <div id="comment-middle">
                            dasdsa
                        </div>
                        <div id="comment-right">
                            <button>수정</button>
                            <button>삭제</button>
                        </div>
                    </div>
                </div>
            </div>
            <hr>

            <!-- ----------------------------- -->

            <div id="comments-body-wrapper">
                <div id="sub-comments-body">
                    <div>
                        <img id="drift-arrow" src="resources/image/driftArrow.png" alt="">
                    </div>
                    <div id="main-comment">
                        <div id="comment-left">
                            <p class="user-name">개떡도지</p>
                            <p>2024.10.24 &nbsp; 13:34</p>
                            <button id="add-sub-comment">답글쓰기</button>
                        </div>
                        <div id="comment-middle">
                            dasdsa
                        </div>
                        <div id="comment-right">
                            <button>수정</button>
                            <button>삭제</button>
                        </div>
                    </div>
                </div>
            </div>
            <hr>
        </div>
        

        <!-- 아래 게시글 목록 -->
        <div id="bottom-wrapper">
            <table id="main-table">
                <tr>
                    <th>공지</th>
                    <th id="th-title">게시글 작성 시 지켜야할 규칙</th>
                    <th>꾸준히 운동</th>
                    <th>2024-10-10</th>
                    <th>2</th>
                </tr>
                <tr>
                    <td id="board-category">질문</td>
                    <!-- 게시글 임시 링크 -->
                    <td><a href="boardDetail.bo">세트별 개수 설정에 대해 질문드립니다 [0]</a></td>
                    <td>꾸준히 운동</td>
                    <td>2024-10-10</td>
                    <td>4</td>
                </tr>
            </table>
            
            <!-- 게시글 수 + 글쓰기 버튼 -->
            <div id="boCount-wirte-div">
                <select name="board-bottom-div" class="category-choice">
                    <option value="">5개씩</option>
                    <option value="">10개씩</option>
                    <option value="">15개씩</option>
                </select>
                <form action="boardWrite.bo" method="POST">
                    <button id="write-btn">글쓰기</button>
                </form>
            </div>
    
            <!-- 글쓰기 버튼 누를 때 나오는 로그인 모달 -->
            <div id="modalContainer" class="hidden">
                <div id="modal-content">
                    <p></p>
    
                </div>
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
    

</body>
</html>