<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css">
<title>Insert title here</title>
</head>
<body>
    <!-- content -->
    <div class="wrapper">
        <div>
            <a href=""><img src="${pageContext.request.contextPath}/resources/image/HKID_Logo.png" alt="로고"></a>
            <form action="">
                <div> 
                    <h3>로그인</h3>
                </div>
                <div>
                    <input type="text" placeholder="아이디 입력">
                    <input type="text" placeholder="비밀번호 입력">
                </div>
                <div>
                    <label id="autoLogin">
                        <input type="checkbox">자동로그인
                    </label>
                    <label id="autoLogin">
                        <input type="checkbox">아이디저장
                    </label>
                </div>

                <br><br>

                <div>
                    <input type="submit" value="로그인">
                </div>
            </form>
            <div>
                <p>회원가입</p>&nbsp;
                &nbsp;<p>|</p>&nbsp;
                &nbsp;<p>아이디 찾기</p>&nbsp;
                &nbsp;<p>|</p>&nbsp;
                &nbsp;<p>비밀번호 찾기</p>
            </div>
            <fieldset style="text-align: center; border: none; border-top: 1px solid rgb(223, 223, 223);">
                <legend>&nbsp;&nbsp;간편로그인&nbsp;&nbsp;</legend>
                <button><img src="">카카오 로그인</button>
                <button><img src="">네이버 로그인</button>
                <button><img src="">Google 로그인</button>
            </fieldset>
            

        </div>
    </div>
</body>
</html>