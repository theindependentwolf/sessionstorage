var sessionStorageType = "";


function setInitialSessionStorageType() {
	if (sessionStorage.getItem("sessionSorageType") === null) {		
		sessionStorageType = document.getElementById("systemSessionType").innerHTML;
		sessionStorage.setItem("sessionSorageType", sessionStorageType);	
	}
}


function setSessionStorageAndRedirect(pageName){
	setInitialSessionStorageType();
	var currentURL = window.location.toString();
	var newURL = currentURL.substring(0, currentURL.lastIndexOf("/") + 1) + pageName;	
	window.location=newURL;
}


//Set Current session type for maintenance view
function setCurrentMaintenanceSessionType(){
	sessionStorageType = sessionStorage.getItem("sessionSorageType");
	document.getElementById("maintenanceSessionType").textContent = sessionStorageType;
	if(sessionStorageType === 'mysql'){
		document.getElementById("mysqlRadio").checked = true;
	}else if(sessionStorageType === 'redis'){
		document.getElementById("redisRadio").checked = true;
	}
}


//Performs various actions when the 'Users' screen loads 
function processUsersOnLoad(){
	sessionStorageType = sessionStorage.getItem("sessionSorageType");
	document.getElementById("userSessionType").textContent = sessionStorageType;
	
	//Show only the appropriate division according to session type
	if(sessionStorageType === 'mysql'){
		document.getElementById("mysqlDiv").style.display = "block";
		document.getElementById("redisDiv").style.display = "none";
	}else if(sessionStorageType === 'redis'){
		document.getElementById("mysqlDiv").style.display = "none";
		document.getElementById("redisDiv").style.display = "block";		
	}
}


function setSessionType(){
	var sessionType = document.querySelector('input[name=sessionType]:checked').value;
	if(sessionType === null){
		window.alert("Please select a type.");
	}else{
		sessionStorage.setItem("sessionSorageType", sessionType);
		setCurrentMaintenanceSessionType();
	}
}