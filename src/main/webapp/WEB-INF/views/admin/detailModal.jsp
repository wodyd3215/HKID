<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/detailModal.css">
</head>
<body>
    <div class="modal" id="report-detail" onclick="closeModal()">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title">신고</div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <div id="report-info">
                    <table>
                        <tr>
                            <td class="title">신고자</td>
                            <td class="content"><div>개떡도지</div></td>
                        </tr>
                        <tr>
                            <td class="title">신고 대상</td>
                            <td class="content"><div>세트별 개수 설정에 대해 질문드립니다.dsadsaddads</div></td>
                        </tr>
                        <tr>
                            <td class="title">신고 유형</td>
                            <td class="content"><div>도배 글입니다.</div></td>
                        </tr>
                    </table>
                </div>
                <div id="report-detail">
                    <div>상세내용</div>
                     <textarea value="" readonly></textarea>
                </div>
            </div>
        </div>
    </div> 
</body>
</html>