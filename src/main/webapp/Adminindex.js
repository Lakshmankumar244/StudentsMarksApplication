const aid=document.getElementById('aid');
const password=document.getElementById('password');

form.addEventListener('submit',e=>{
	e.preventDefault();
	validateInputs();
}
);
const setError =(element,message)=>{
	const inputControl=element.parentelement;
	const errorDisplay=inputControl.querySelector('.error');
	errorDisplay.innerText=message;
	inputControl.classList.add('error');
	inputControl.classList.remove('success');
}
const setSuccess=(element)=>{
	const inputControl=element.parentelement;
	const errorDisplay=inputControl.querySelector('.error');
	errorDisplay.innerText='';
	inputControl.classList.add('success');
	inputControl.classList.remove('error');
}

const validateInputs=()=>{
	 aidValue=aid.value.trim();
	 passwordValue=password.value.trim();
	
}
if(aidValue===''){
	setError(aid,'id is required');
}
else{
	setSuccess(aid);
}
if(passwordValue===''){
	setError(password,'password is required');
}else if(passwordvalue.length<8){
	setError(password,'password should be atleast 8 characters');
}
else{
	setSuccess(password);
	}