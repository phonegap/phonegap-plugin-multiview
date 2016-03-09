
var currentDepth = 1;


var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();

        currentDepth = localStorage.getItem("currentDepth") || 1;

        localStorage.setItem("currentDepth",currentDepth);

        hdrDepth.innerText = hdrDepth.innerText +  " : " + currentDepth;
    },
    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicitly call 'app.receivedEvent(...);'
    onDeviceReady: function() {

        app.receivedEvent('deviceready');

        btnShowNext.addEventListener("touchend",function(){
            localStorage.setItem("currentDepth",++currentDepth);
            PGMultiview.loadView("www/index.html");
        });

        btnDismiss.addEventListener("touchend",function(){
            localStorage.setItem("currentDepth",--currentDepth);
            PGMultiview.dismissView();
        });

    },
    // Update DOM on a Received Event
    receivedEvent: function(id) {
        var parentElement = document.getElementById(id);
        var listeningElement = parentElement.querySelector('.listening');
        var receivedElement = parentElement.querySelector('.received');

        listeningElement.setAttribute('style', 'display:none;');
        receivedElement.setAttribute('style', 'display:block;');

        console.log('Received Event: ' + id);
    }
};

app.initialize();