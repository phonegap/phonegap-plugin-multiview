

document.addEventListener("DOMContentLoaded",function() {
});

document.addEventListener("deviceready",function() {

    btnShowNext.addEventListener("click",function(){
        var txt = txtArea.value;
        PGMultiView.loadView("index2.html",txt);
    });
});

