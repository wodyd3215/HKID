<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common/chatBox.css">
    <!--js-->
    <script src="${pageContext.request.contextPath}/resources/js/common/default.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/common/modal.js"></script>

    <script src="${pageContext.request.contextPath}/resources/js/common/chatBox.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/common/common.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <div id="chat-area">
        <!-- 클래스이름을 매개변수로 넘김 -->
        <button onclick="showAndHideElement('.chat-box')">
            <img src="${pageContext.request.contextPath}/resources/image/chatting_icon.png">
        </button>
        <div class="chat-box hide">
            <div class="chat-box-header">
                <button onclick="showAndHideElement2('#chat-search', '#chat-content')">
                    <img src="${pageContext.request.contextPath}/resources/image/searchIcon.png">
                </button>
            </div>
            <div class="chat-box-content">
                <div class="chat-box-left">
                    <div id="chat-bot">
                        <button name="chat-name" onclick="changeElement(this, '#chat-search', '#chat-content')">챗봇</button>
                    </div>
                    <div id="chat-admin">
                        <button name="chat-name" onclick="changeElement(this, '#chat-search', '#chat-content')">관리자</button>
                    </div>
                    <div id="chat-trade">
                        <button onclick="showAndHideElement('#chat-trade-user')">중고거래&nbsp;
                            <img src="${pageContext.request.contextPath}/resources/image/down.png">
                        </button>
                    </div>
                    <!-- 중고판매유저 -->
                    <div id="chat-trade-user" class="hide">
                        <div>
                            <img class="delete-btn" src="${pageContext.request.contextPath}/resources/image/dogdduck.png" onclick="nickToDelete(this)">
                            <button name="chat-name" class="trade-user-nick" onclick="changeElement(this, '#chat-search', '#chat-content')">개떡도지</button>
                            <button class="delete-chat hide" onclick="deleteChat(this)"><img src="${pageContext.request.contextPath}/resources/image/trash2.png"></button>
                        </div>
                        <div>
                            <img class="delete-btn" src="${pageContext.request.contextPath}/resources/image/dogdduck.png" onclick="nickToDelete(this)">
                            <button name="chat-name" class="trade-user-nick" onclick="changeElement(this, '#chat-search', '#chat-content')">개떡도지</button>
                            <button class="delete-chat hide" onclick="deleteChat(this)"><img src="${pageContext.request.contextPath}/resources/image/trash2.png"></button>
                        </div>
                        <div>
                            <img class="delete-btn" src="${pageContext.request.contextPath}/resources/image/dogdduck.png" onclick="nickToDelete(this)">
                            <button name="chat-name" class="trade-user-nick" onclick="changeElement(this, '#chat-search', '#chat-content')">무지개</button>
                            <button class="delete-chat hide" onclick="deleteChat(this)"><img src="${pageContext.request.contextPath}/resources/image/trash2.png"></button>
                        </div>
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
                                    <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                                </div>
                                <div class="left-log">
                                    <img src="${pageContext.request.contextPath}/resources/image/chat-bot.png">
                                    <p>dsafkl;jasdfdksjf;lkdsajf;ldkasjf;ljaskdf;lkjadf;lakjf;asdlkfj;salkfj;aslkdfj;aksjdf;lasjkf;ajfk;sadljkf</p>
                                </div>
                                <div class="right-log">
                                    <p>sadfasdfsa;djlkfjas;dklfj;aslkfj;ldakfj;sadlkfj;adkfjsda;lkfjsa;dlkfj;aldfkj</p>
                                    <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                                </div>
                                <div class="left-log">
                                    <img src="${pageContext.request.contextPath}/resources/image/chat-bot.png">
                                    <p>dsafkl;jasdfdksjf;lkdsajf;ldkasjf;ljaskdf;lkjadf;lakjf;asdlkfj;salkfj;aslkdfj;aksjdf;lasjkf;ajfk;sadljkf</p>
                                </div>
                                <div class="right-log">
                                    <p>sadfasdfsa;djlkfjas;dklfj;aslkfj;ldakfj;sadlkfj;adkfjsda;lkfjsa;dlkfj;aldfkj</p>
                                    <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                                </div>
                                <div class="left-log">
                                    <img src="${pageContext.request.contextPath}/resources/image/chat-bot.png">
                                    <p>dsafkl;jasdfdksjf;lkdsajf;ldkasjf;ljaskdf;lkjadf;lakjf;asdlkfj;salkfj;aslkdfj;aksjdf;lasjkf;ajfk;sadljkf</p>
                                </div>
                            </div>
                        </div>
                        <!-- 채팅 입력 -->
                        <div id="chat-input-area">
                            <div>
                                <textarea id="input-chat-text" name="input-chatting" placeholder="채팅 입력" 
                                          oninput="useChatBtn(this)" onkeydown="handleEnterKey(event, '${pageContext.request.contextPath}')"></textarea>
                                <div>
                                    <button id="send-chat-btn" onclick="inputChatting('${pageContext.request.contextPath}')" disabled>
                                        <img src="${pageContext.request.contextPath}/resources/image/Corner-down-right.png">
                                    </button>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- 유저 검색 컨텐츠 -->
                    <div id="chat-search" class="hide">
                        <div id="searchbar-div">
                            <input type="search" name="" id="board-search-bar" placeholder="닉네임을 입력해주세요.">
                            <button id="search-btn" type="submit">
                                <img id="searchIcon" src="resources/image/searchIcon.png">
                            </button>
                        </div>
                        <!-- 채팅 추가 JS미구현! -->
                        <div class="search-users">
                            <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                            <p>개떡도지</p>
                            <button onclick="addChattingRoom('${pageContext.request.contextPath}', this)">
                                <img src="${pageContext.request.contextPath}/resources/image/chat_bubble.png">
                            </button>
                        </div>
                        <div class="search-users">
                            <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                            <p>개벌레</p>
                            <button onclick="addChattingRoom('${pageContext.request.contextPath}', this)">
                                <img src="${pageContext.request.contextPath}/resources/image/chat_bubble.png">
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>