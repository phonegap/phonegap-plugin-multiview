/* global txtArea:true*/
/*global btnDismiss:true*/
/*global PGMultiView:true*/
/*global data:true*/
document.addEventListener("DOMContentLoaded",function() {
 });

 document.addEventListener("deviceready",function() {
    var success = function(data) {
         txtArea.value = data;
         };
         var error = function(e) {
         };

         PGMultiView.getMessage(success, error);  //when the device is ready send message to parent

         //when user clicks the "navigate to parent button", it sends contents of text area to dismissView() in parent
         btnDismiss.addEventListener("click",function(){
             data = txtArea.value;
             PGMultiView.dismissView(data);
         });
     });