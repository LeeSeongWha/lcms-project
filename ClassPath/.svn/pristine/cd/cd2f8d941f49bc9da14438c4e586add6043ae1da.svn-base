/**
 * 
 */
document.addEventListener("DOMContentLoaded", () => {
	const bankCd = document.querySelector("#bankCd");
	const initBank = bankCd.dataset.initBank;
	
    const CPATH = document.body.dataset.contextPath;
    
   
	
	axios.get(`${CPATH}/staff/staffmanage/bankCodeList.do`)
		 .then(resp => {
			const bankCodeList = resp.data;
			
			console.log("체킁 :", bankCodeList);
			
			if (bankCodeList) {
				const cOptions = bankCodeList.map(item => 
					`<option value="${item.typeCode}">${item.typeName}</option>`
				).join("\n");
				
				bankCd.innerHTML += cOptions;
				
				bankCd.value = initBank ?? "";
			}
	})
});
