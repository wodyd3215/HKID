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
                    <!-- <div id="chat-admin">
                        <button name="chat-name" onclick="changeElement('${pageContext.request.contextPath}', this, '#chat-search', '#chat-content')">관리자</button>
                    </div> -->
                    <div id="chat-trade">
                        <button onclick="showAndHideElement('#chat-trade-user')">내 채팅방&nbsp;
                            <img src="${pageContext.request.contextPath}/resources/image/down.png">
                        </button>
                    </div>
                    <!-- 채팅유저 -->
                    <div id="chat-trade-user" class="hide">
                        
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
                                <!-- <div class="right-log">
                                    <div>
                                        <div>닉네임</div>
                                        <p>sadfasdfsa;djlkfjas;dklfj;aslkfj;ldakfj;sadlkfj;adkfjsda;lkfjsa;dlkfj;aldfkj</p>
                                    </div>
                                    <img src="${pageContext.request.contextPath}/resources/image/dogdduck.png">
                                </div>
                                <div class="left-log">
                                    <img src="${pageContext.request.contextPath}/resources/image/chat-bot.png">
                                    <div>
                                        <div>닉네임</div>
                                        <p>dsafkl;jasdfdksjf;lkdsajf;ldkasjf;ljaskdf;lkjadf;lakjf;asdlkfj;salkfj;aslkdfj;aksjdf;lasjkf;ajfk;sadljkf</p>
                                    </div>
                                </div> -->
                            </div>
                        </div>
                        <!-- 채팅 입력 -->
                        <!-- <div id="chat-input-area">
                            <div>
                                <textarea id="input-chat-text" name="input-chatting" placeholder="채팅 입력" 
                                          oninput="useChatBtn(this)" onkeydown="handleEnterKey(event, '${pageContext.request.contextPath}')"></textarea>
                                <div>
                                    <button id="send-chat-btn" onclick="inputChatting('${pageContext.request.contextPath}', '${loginMember.memberId}')" disabled>
                                        <img src="${pageContext.request.contextPath}/resources/image/Corner-down-right.png">
                                    </button>
                                </div>
                            </div>
                        </div> -->
                        
                    </div>
                    <!-- 유저 검색 컨텐츠 -->
                    <div id="chat-search" class="hide">
                        <div id="searchbar-div">
                            <input type="search" id="chat-search-bar" placeholder="닉네임을 입력해주세요.">
                            <button id="search-btn" onclick="searchNickName('${pageContext.request.contextPath}', '${loginMember.memberNo}')">
                                <img id="searchIcon" src="resources/image/searchIcon.png">
                            </button>
                        </div>

                        <!-- 검색한 유저 리스트 -->
                        <div class="search-users">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>