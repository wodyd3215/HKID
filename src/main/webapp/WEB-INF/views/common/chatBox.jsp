<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/chatBox.css">
    <title>Insert title here</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="wrapper">
        <div id="chat-area">
            <button>
                <img src="${pageContext.request.contextPath}/resources/image/chatting_icon.png">
            </button>
            <div class="chat-box">
                <div class="chat-box-header">
                    <button>
                        <img src="${pageContext.request.contextPath}/resources/image/searchIcon.png">
                    </button>
                </div>
                <div class="chat-box-content">
                    <div class="chat-box-left">
                        <div id="chat-bot">
                            <button>챗봇</button>
                        </div>
                        <div id="chat-admin">
                            <button>관리자</button>
                        </div>
                        <div id="chat-trade">
                            <button>중고거래&nbsp;
                                <img src="${pageContext.request.contextPath}/resources/image/down.png">
                            </button>
                        </div>
                        <!-- 중고판매유저 -->
                        <div id="chat-trade-user">
                            <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                            <button>개떡도지</button>
                        </div>
                        <div id="chat-trade-user">
                            <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                            <button>무지개</button>
                        </div>
                    </div>
                    <!-- 채팅 우측 컨텐츠 -->
                    <div class="chat-box-right">
                        <!-- 채팅 컨텐츠 -->
                        <div id="chat-content">
                            <!-- 채팅 로그 -->
                            <div id="chat-log-area">
                                <div>
                                    <!-- ajax로 list 요청 후 for,if -->
                                    <div class="right-log">
                                        <p>sadfasdfsa;djlkfjas;dklfj;aslkfj;ldakfj;sadlkfj;adkfjsda;lkfjsa;dlkfj;aldfkj</p>
                                        <img src="${pageContext.request.contextPath}/resources/image/chat-bot.png">
                                    </div>
                                    <div class="left-log">
                                        <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                                        <p>dsafkl;jasdfdksjf;lkdsajf;ldkasjf;ljaskdf;lkjadf;lakjf;asdlkfj;salkfj;aslkdfj;aksjdf;lasjkf;ajfk;sadljkf</p>
                                    </div>
                                    <div class="right-log">
                                        <p>sadfasdfsa;djlkfjas;dklfj;aslkfj;ldakfj;sadlkfj;adkfjsda;lkfjsa;dlkfj;aldfkj</p>
                                        <img src="${pageContext.request.contextPath}/resources/image/chat-bot.png">
                                    </div>
                                    <div class="left-log">
                                        <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                                        <p>dsafkl;jasdfdksjf;lkdsajf;ldkasjf;ljaskdf;lkjadf;lakjf;asdlkfj;salkfj;aslkdfj;aksjdf;lasjkf;ajfk;sadljkf</p>
                                    </div>
                                </div>
                            </div>
                            <!-- 채팅 입력 -->
                            <div id="chat-input-area">
                                <div>
                                    <textarea name="input-chatting" placeholder="채팅 입력"></textarea>
                                    <div>
                                        <button>
                                            <img src="${pageContext.request.contextPath}/resources/image/Corner-down-right.png">
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 유저 검색 컨텐츠 -->
                        <div id="chat-search">
                            <div id="searchbar-div">
                                <input type="search" name="" id="board-search-bar" placeholder="닉네임을 입력해주세요.">
                                <button id="search-btn" type="submit">
                                    <img id="searchIcon" src="resources/image/searchIcon.png">
                                </button>
                            </div>
                            <div id="search-users">
                                <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                                <p>개떡도지</p>
                                <button>
                                    <img src="${pageContext.request.contextPath}/resources/image/chat_bubble.png">
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
	<jsp:include page="footer.jsp" />
</body>
</html>