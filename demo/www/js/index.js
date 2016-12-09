/*global PGMultiView , txtArea */
document.addEventListener("DOMContentLoaded",function() {
});

document.addEventListener("deviceready",function() {

    var btnShowNext = document.getElementById("btnShowNext");

    btnShowNext.addEventListener("click",function(){
        var success = function(data) {
            txtArea.value= data;
        };
        var error = function(error) {
            alert(error);
        };

        var txt = txtArea.value;
        //contents of text area is sent to the Child Activity (PGMultiViewActivity.java)
        PGMultiView.loadView("index2.html", txt, success, error);
    });
});

