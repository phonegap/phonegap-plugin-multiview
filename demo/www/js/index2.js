document.addEventListener("DOMContentLoaded",function() {
});

document.addEventListener("deviceready",function() {

    var success = function(data) {
        txtArea.value = data;
    };
    var error = function(e) {
    };

    PGMultiView.getMessage(success, error);

    btnDismiss.addEventListener("click",function(){
        data = txtArea.value;
        PGMultiView.dismissView(data);
    });
});