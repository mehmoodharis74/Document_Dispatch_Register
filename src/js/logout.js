function logout(){
    window.location.href = "login.html";
    localStorage.clear();
    history.replaceState(null, null, '/src/html/login.html');
      }
      function moveBack() {
        window.history.back();
      }