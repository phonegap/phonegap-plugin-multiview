/* global txtArea:true , btnDismiss:true,PGMultiView:true*/
document.addEventListener("DOMContentLoaded",function() {
 });

 document.addEventListener("deviceready",function() {
    var success = function(data) {
        var resultObj = JSON.parse(data);
        txtArea.value = resultObj.message;
    };

    var error = function(err) {
        alert("Oops, error getting message from sender : " + err);
    };

    PGMultiView.getMessage(success, error);  //when the device is ready send message to parent
         //when user clicks the "navigate to parent button", it sends contents of text area to dismissView() in parent
        btnDismiss.addEventListener("click",function(){
            var objToSend = {
                'message' : txtArea.value,
                'data' : 'some other info'
            };
            PGMultiView.dismissView(JSON.stringify(objToSend));
         });
    });