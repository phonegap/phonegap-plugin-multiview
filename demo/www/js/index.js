

document.addEventListener("DOMContentLoaded",function() {


});

document.addEventListener("deviceready",function() {

    btnShowNext.addEventListener("click",function(){
        alert("showing it");
        PGMultiView.loadView("index2.html");
    });

    // btnDismiss.addEventListener("click",function(){
    //     localStorage.setItem("currentDepth",--currentDepth);
    //     PGMultiView.dismissView();
    // });
});



