/**
 * 
 */

document.addEventListener("DOMContentLoaded", function() {
	document.querySelectorAll('[data-tab]').forEach(tab => {
		tab.addEventListener('click', function() {
			const selected = this.dataset.tab;

			document.querySelectorAll('.tab').forEach(btn => btn.classList.remove('active'));
			this.classList.add('active');

			document.querySelectorAll('[data-tab-content]').forEach(div => {
				div.style.display = div.dataset.tabContent === selected ? 'block' : 'none';
			});

			if (selected === 'statistics') {
				setTimeout(() => {
					loadProgramStatsChart();
					loadDonutChart();
				}, 100);
			}
		});
	});

	const defaultTab = document.querySelector('.tab.active')?.dataset.tab;
	if (defaultTab === 'statistics') {
		loadProgramStatsChart();
		loadDonutChart();
	}
});

// ✅ 상세보기 이동
function goToDetail(programNo) {
	location.href = `/staff/program/edit/${programNo}`;
}

// ✅ 신청자 관리 이동
function goToApplyPage(programNo) {
	location.href = `/staff/program/apply/${programNo}`;
}

// ✅ 삭제
function deleteProgram(programNo) {
	if (!confirm("정말 이 프로그램을 삭제하시겠습니까?")) return;
	fetch(`/staff/program/delete/${programNo}`, {
		method: 'DELETE'
	}).then(res => {
		if (res.ok) {
			alert("삭제되었습니다.");
			location.reload();
		} else {
			alert("삭제 실패");
		}
	}).catch(() => alert("서버 오류"));
}

// ✅ 통계 차트
function loadProgramStatsChart() {
	const barCtx = document.getElementById('programStatChart')?.getContext('2d');
	if (!barCtx) return;
	new Chart(barCtx, {
		type: 'bar',
		data: {
			labels: ['전체 프로그램 수', '전체 신청자 수', '당월 신청자 수'],
			datasets: [{
				label: window.statDate + ' 기준 통계',
				data: [window.totalPrograms, window.totalApplicants, window.monthlyApply],
				backgroundColor: ['#4e79a7', '#f28e2b', '#e15759'],
				borderColor: ['#4e79a7', '#f28e2b', '#e15759'],
				borderWidth: 1,
				borderRadius: 5
			}]
		},
		options: {
			responsive: true,
			plugins: {
				legend: { display: true, position: 'bottom' }
			},
			scales: {
				y: { beginAtZero: true },
				x: { ticks: { font: { size: 12 } } }
			}
		}
	});
}

// ✅ 도넛 차트
function loadDonutChart() {
	fetch("/staff/program/donut/data")
		.then(res => res.json())
		.then(data => {
			const ctx = document.getElementById('donutChart')?.getContext('2d');
			if (!ctx) return;
			new Chart(ctx, {
				type: 'doughnut',
				data: {
					labels: data.map(d => d.typeCode),
					datasets: [{
						label: '신청자 수',
						data: data.map(d => d.applyCount),
						backgroundColor: ['#4e79a7', '#f28e2b', '#e15759', '#76b7b2', '#59a14f', '#edc948']
					}]
				},
				options: {
					responsive: true,
					plugins: {
						legend: { position: 'bottom' }
					}
				}
			});
		});
}
