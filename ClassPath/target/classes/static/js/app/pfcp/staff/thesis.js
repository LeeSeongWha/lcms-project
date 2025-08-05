/**
 * 
 */
function initializeThesisDetail(thesisNo, contextPath, flashMessage) {
    document.addEventListener("DOMContentLoaded", function() {
        const CPATH = contextPath; 

        const cancelButton = document.querySelector(".cancelButton");
        if (cancelButton) {
            cancelButton.addEventListener("click", function() {
                location.href = `${CPATH}/staff/thesis/thesisList.do`;
            });
        }


        const approveButton = document.getElementById("approveButton");
        if (approveButton) {
            approveButton.addEventListener("click", function() {
                if (confirm("정말로 이 논문을 승인하시겠습니까?")) {
                    const form = document.createElement('form');
                    form.method = 'POST';
                    form.action = `${CPATH}/staff/thesis/approveThesis.do`;
                    
                    let inputThesisNo = document.createElement('input');
                    inputThesisNo.type = 'hidden';
                    inputThesisNo.name = 'thesisNo';
                    inputThesisNo.value = thesisNo; 
                    form.appendChild(inputThesisNo);
                    
                    document.body.appendChild(form);
                    form.submit();
                }
            });
        }

        const rejectButton = document.getElementById("rejectButton");
        const rejectModal = document.getElementById("rejectModal");
        const modalBackdrop = document.getElementById("modalBackdrop");
        const rejReasonInput = document.getElementById("rejReasonInput");
        const confirmReject = document.getElementById("confirmReject");
        const cancelReject = document.getElementById("cancelReject");

        if (rejectButton) {
            rejectButton.addEventListener("click", function() {
                rejReasonInput.value = ''; 
                rejectModal.style.display = 'block';
                modalBackdrop.style.display = 'block';
            });

            cancelReject.addEventListener("click", function() {
                rejectModal.style.display = 'none';
                modalBackdrop.style.display = 'none';
            });

            confirmReject.addEventListener("click", function() {
                const rejReason = rejReasonInput.value.trim();
                if (rejReason === "") {
                    alert("반려 사유를 입력해주세요.");
                    return;
                }

                if (confirm("정말로 이 논문을 반려하고, 사유를 제출하시겠습니까?")) {
                    const form = document.createElement('form');
                    form.method = 'POST';
                    form.action = `${CPATH}/staff/thesis/rejectThesis.do`;
                    
                    let inputThesisNo = document.createElement('input');
                    inputThesisNo.type = 'hidden';
                    inputThesisNo.name = 'thesisNo';
                    inputThesisNo.value = thesisNo; 
                    form.appendChild(inputThesisNo);
                    
                    let inputRejReason = document.createElement('input');
                    inputRejReason.type = 'hidden';
                    inputRejReason.name = 'rejReason';
                    inputRejReason.value = rejReason;
                    form.appendChild(inputRejReason);
                    
                    document.body.appendChild(form);
                    form.submit();
                }
            });
        }
       
        if (flashMessage && flashMessage !== "") {
            alert(flashMessage);
        }
    });
}