/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 const password = document.getElementById("password");
 const confPassword = document.getElementById("confpassword");
 const form = document.getElementById("form");
const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
const email = document.getElementById("email");
const username = document.getElementById("username");

function checkPassword(passwd, confpasswd){
    var n = passwd.localeCompare(confpasswd);
    if(n===0) return true;
    return false;
}

//username 4-20
//passwd 5-32

form.addEventListener('submit', event =>{
        let n = checkPassword(password.value, confPassword.value);
        if(n === false){
            event.preventDefault();
            document.getElementById("confpassMsg").style.display = "table-row";
            confPassword.value = "";
            const confPassMSG = document.getElementById("confpassMsg").childNodes[1].textContent;
            console.log(confPassMSG);
        }
        else if(password.value.length<5 || password.value.length>32){
            event.preventDefault();
            document.getElementById("passMsg").style.display = "table-row";
        }
        if(emailRegex.test(email.value) === false){
            event.preventDefault();
            document.getElementById("emailMsg").style.display = "table-row";
        }
        if(username.value.length<4 || username.value.length>20){
            event.preventDefault();
            document.getElementById("usernameMsg").style.display = 'table-row';
        }
});

const confPassMSG = document.getElementById("confpassMsg");
confPassword.addEventListener('input', ()=>{
   confPassMSG.style.display = 'none'; 
});

password.addEventListener('input', ()=>{
   document.getElementById("passMsg").style.display = 'none'; 
});

email.addEventListener('input', () =>{
   document.getElementById("emailMsg").style.display = 'none'; 
    if(document.getElementById("duplicatedEmailMsg") !== null){
        document.getElementById("duplicatedEmailMsg") .style.display='none';
    }
});

username.addEventListener('input', () =>{
   document.getElementById("usernameMsg").style.display = 'none'; 
});


//if(n === false){
//    
//}


