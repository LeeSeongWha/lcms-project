<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
<link rel="stylesheet" href="/dist/assets/css/bodyFormat.css">

<title>공지사항 목록</title>

<div style="display: flex; align-items: center; justify-content: space-between;">
	<h4 class="pageTitle">공지사항</h4>
	<button onclick="window.location.href='/staff/notice/noticeInsert.do'" class="submitButton">+ 등록</button>
</div>

<!-- 상단 카테고리 탭 -->
<div class="flex flex-wrap gap-2 border-b mb-6 CategoryContainer">
    <button onclick="filterNotices('전체', this)" class="px-4 py-2 rounded-t-md border-b-2 font-medium">전체</button>
    <button onclick="filterNotices('일반', this)" class="px-4 py-2 rounded-t-md border-b-2 font-medium">일반</button>
    <button onclick="filterNotices('학사', this)" class="px-4 py-2 rounded-t-md border-b-2 font-medium">학사</button>
    <button onclick="filterNotices('비교과', this)" class="px-4 py-2 rounded-t-md border-b-2 font-medium">비교과</button>
    <button onclick="filterNotices('건의사항', this)" class="px-4 py-2 rounded-t-md border-b-2 font-medium">건의사항</button>
    <button onclick="filterNotices('기타', this)" class="px-4 py-2 rounded-t-md border-b-2 font-medium">기타</button>
</div>

<form id="searchForm" style="margin-bottom: 1rem;">
	<select name="searchType">
		<option value="all" ${searchType == 'all' ? 'selected' : ''}>전체</option>
		<option value="boardNo" ${searchType == 'boardNo' ? 'selected' : ''}>게시글 번호</option>
		<option value="category" ${searchType == 'category' ? 'selected' : ''}>유형</option>
		<option value="boardTitle" ${searchType == 'boardTitle' ? 'selected' : ''}>제목</option>
		<option value="userName" ${searchType == 'userName' ? 'selected' : ''}>작성자</option>
		<option value="boardContent" ${searchType == 'boardContent' ? 'selected' : ''}>내용</option>
	</select>
	<input type="text" name="keyword" id="keyword" placeholder="검색어 입력" />
	<button type="submit" class="submitButton">검색</button>
</form>

<!-- 학사 소분류 -->
<div id="subCategoryContainer" class="mb-6 hidden">
    <div class="flex flex-wrap gap-2">
        <button onclick="filterSubCategory('ALL', this)" class="px-3 py-1 border rounded text-sm bg-blue-100 text-blue-700">학사전체</button>
        <button onclick="filterSubCategory('ACA_SCH', this)" class="px-3 py-1 border rounded text-sm bg-gray-100">수강일정</button>
        <button onclick="filterSubCategory('ACA_EXM', this)" class="px-3 py-1 border rounded text-sm bg-gray-100">시험 및 평가 일정</button>
        <button onclick="filterSubCategory('ACA_STA', this)" class="px-3 py-1 border rounded text-sm bg-gray-100">학적 변경</button>
        <button onclick="filterSubCategory('ACA_GRD', this)" class="px-3 py-1 border rounded text-sm bg-gray-100">졸업</button>
        <button onclick="filterSubCategory('ACA_TUI', this)" class="px-3 py-1 border rounded text-sm bg-gray-100">등록금 및 장학금</button>
        <button onclick="filterSubCategory('ACA_HOL', this)" class="px-3 py-1 border rounded text-sm bg-gray-100">방학 및 휴일</button>
    </div>
</div>

<!-- 공지 목록 테이블 -->
<div class="overflow-x-auto">
    <div class="tableContainer">
        <table class="w-full defaultTable">
            <thead class="tableHead">
                <tr>
                    <th class="p-3 border tableTh">번호</th>
                    <th class="p-3 border tableTh">유형</th>
                    <th class="p-3 border tableTh">제목</th>
                    <th class="p-3 border tableTh">작성자</th>
                    <th class="p-3 border tableTh">작성일시</th>
                </tr>
            </thead>
            <tbody id="noticeTableBody" class="text-sm">
                
            </tbody>
        </table>
    </div>
    <div class="pagination"></div>
</div>

<script>
let currentCategory = '전체';
let currentSubCategory = '';
let currentPage = 1;

// 공지 상세 이동
function moveToDetail(boardNo) {
    window.location.href = "/staff/notice/noticeDetail.do?what=" + boardNo;
}

// 데이터 로드
function loadNoticeList(page = 1, category = currentCategory, subCategory = currentSubCategory) {
    currentPage = page;
    currentCategory = category;
    currentSubCategory = subCategory;

    const keyword = document.querySelector('#keyword')?.value || '';
    const searchType = document.querySelector('select[name="searchType"]')?.value || 'all';

    fetch(`/staff/notice/noticeListData.do?page=\${page}&category=\${encodeURIComponent(category)}&subCategory=\${encodeURIComponent(subCategory)}&keyword=\${encodeURIComponent(keyword)}&searchType=\${encodeURIComponent(searchType)}`)
        .then(resp => resp.json())
        .then(data => {
            renderNoticeList(data.board);
            renderPagination(data.paging);
    });
}


// 테이블 렌더링
function renderNoticeList(list) {
    const tbody = document.getElementById('noticeTableBody');
    tbody.innerHTML = '';

    if (!list || list.length === 0) {
        tbody.innerHTML = '<tr><td colspan="5" class="p-3 text-center">조회된 공지가 없습니다.</td></tr>';
        return;
    }

    list.forEach(board => {
        const tr = document.createElement('tr');
        tr.className = "tableRowHover";
        tr.onclick = () => moveToDetail(board.boardNo);

        tr.innerHTML = `
            <td class="p-3 border tableTd">\${board.boardNo}</td>
            <td class="p-3 border tableTd">\${board.category}</td>
            <td class="p-3 border tableTd" style="text-align:left">\${board.boardTitle}</td>
            <td class="p-3 border tableTd">\${board.user ? board.user.userName : ''}</td>
            <td class="p-3 border tableTd">\${board.updateDate || ''}</td>
        `;
        tbody.appendChild(tr);
    });
}

// 페이지네이션 렌더링
function renderPagination(paging) {
    const container = document.querySelector('.pagination');
    container.innerHTML = '';

    if (paging.firstPageNoOnPageList > 1) {
        container.innerHTML += `<a href="#" class="pageButton" onclick="loadNoticeList(\${paging.firstPageNoOnPageList - paging.pageSize})">이전</a>`;
    }

    for (let i = paging.firstPageNoOnPageList; i <= paging.lastPageNoOnPageList; i++) {
        if (i === paging.currentPageNo) {
            container.innerHTML += `<strong class="pageButton active">\${i}</strong>`;
        } else {
            container.innerHTML += `<a href="#" class="pageButton" onclick="loadNoticeList(\${i})">\${i}</a>`;
        }
    }

    if (paging.lastPageNoOnPageList < paging.totalPageCount) {
        container.innerHTML += `<a href="#" class="pageButton" onclick="loadNoticeList(\${paging.firstPageNoOnPageList + paging.pageSize})">다음</a>`;
    }
}

// 카테고리 필터
function filterNotices(category, btn) {
    document.querySelectorAll('.CategoryContainer button')
        .forEach(b => b.classList.remove('text-blue-600', 'border-blue-600'));
    btn.classList.add('text-blue-600', 'border-blue-600');

    const subContainer = document.getElementById('subCategoryContainer');
    if (category === '학사') subContainer.classList.remove('hidden');
    else subContainer.classList.add('hidden');

    loadNoticeList(1, category, '');
}

// 학사 소분류 필터
function filterSubCategory(subtype, btn) {
    document.querySelectorAll('#subCategoryContainer button').forEach(b => {
        b.classList.remove('bg-blue-100', 'text-blue-700');
        b.classList.add('bg-gray-100', 'text-gray-700');
    });
    btn.classList.remove('bg-gray-100', 'text-gray-700');
    btn.classList.add('bg-blue-100', 'text-blue-700');

    loadNoticeList(1, '학사', subtype);
}

// 초기 로드
document.addEventListener('DOMContentLoaded', () => {
	const firstBtn = document.querySelector('.CategoryContainer button');
	
    if (firstBtn) {
        firstBtn.classList.add('text-blue-600', 'border-blue-600');
    }
    
    document.getElementById('searchForm').addEventListener('submit', e => {
        e.preventDefault();
        
        loadNoticeList(1, currentCategory, currentSubCategory);
    });
    
    loadNoticeList();
});
</script>
