/*global PGMultiView , txtArea */
document.addEventListener("DOMContentLoaded",function() {
});

document.addEventListener("deviceready",function() {

    var btnShowNext = document.getElementById("btnShowNext");

    btnShowNext.addEventListener("click",function(){
        var success = function(data) {
            var receivedObj = JSON.parse(data);
            txtArea.value= receivedObj.message;
        };
        var error = function(error) {
            alert("Oops, an error happened : " + error);
        };

        var objToSend = {'message': txtArea.value,
                         'whatever':'some value'};

        //contents of text area is sent to the Child Activity (PGMultiViewActivity.java)
        PGMultiView.loadView("index2.html", JSON.stringify(objToSend), success, error);
    });
});

