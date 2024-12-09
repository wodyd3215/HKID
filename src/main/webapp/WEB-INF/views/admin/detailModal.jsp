<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin/detailModal.css">

<script src="${pageContext.request.contextPath}/resources/js/admin/reportedBoard.js"></script>
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
                            <td class="content"><div></div></td>
                        </tr>
                        <tr>
                            <td class="title">신고 대상</td>
                            <td class="content"><div></div></td>
                        </tr>
                        <tr>
                            <td class="title">신고 유형</td>
                            <td class="content"><div></div></td>
                        </tr>
                    </table>
                </div>
                <div id="detail">
                    <div>상세내용</div>
                     <textarea readonly></textarea>
                </div>
            </div>
        </div>
    </div>

    <div class="modal" id="content-detail" onclick="closeModal()">
        <div class="custom-modal">
            <div class="custom-modal-header">
                <div class="custom-modal-title"></div>
                <button class="material-symbols-outlined close-btn " onclick="closeModal()">disabled_by_default</button>
            </div>
            <div class="custom-modal-content">
                <div id="top-wrapper">
                    <!-- 게시글 제목칸-->
                    <div id="board-title-wrapper">
                        <div id="board-title">
                            <p></p>
                        </div>
                        <div id="writer-date--update-delete">
                            <div id="writer-date">
                                <div></div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="second-div">
                    <div id="content" name="boardContent" required></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>