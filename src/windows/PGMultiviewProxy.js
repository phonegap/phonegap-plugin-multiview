
var webview;

// creates a webview to host content
function createWebview(url) {
    webview = document.createElement('x-ms-webview');
    var style = webview.style;
    style.position = 'absolute';
    style.top = '10%';
    style.left = '10%';
    style.zIndex = 100;
    style.width = '80%';
    style.height = '80%';
    style.background = "#F03";

    webview.addEventListener("MSWebViewNavigationCompleted", navigationCompletedEvent, false);
    webview.addEventListener("MSWebViewNavigationStarting", navigationStartingEvent, false);
    webview.addEventListener("MSWebViewScriptNotify", scriptNotify);

    document.body.appendChild(webview);
    webview.src = url;
    return webview;
}

// handles webview's navigation starting event
function navigationStartingEvent(evt) {
    if (evt.uri && evt.uri !== "") {
		// TODO: possibly block navigation to non whitelisted content
    }
}

function navigationCompletedEvent(evt) {
    if (evt.uri && evt.uri !== "") {
        if (evt.isSuccess) {
			// fire device ready ourselves (experimental)
            var evalScript = 'cordova.require(\"cordova/channel\").onDeviceReady.fire(); cordova.fireDocumentEvent(\"activated\", {}, true)';
            var asyncOp = webview.invokeScriptAsync('eval',[evalScript]);
            asyncOp.oncomplete = function (res) {
                console.log("success firing document event");
            };
            asyncOp.onerror = function (err) {
                console.log("onerror firing document event " + err);
            };
            asyncOp.start();
        }
        else {
            console.log("Error:" + evt.webErrorStatus + " url: " + evt.uri);
        }
    }
}

function scriptNotify(e) {
    console.log('scriptNotify e: ' + e.value);
	// TODO: duh
    // var opts = JSON.parse(e.value);
}


// the visible interface
module.exports = {
	loadView:function(win, fail, args) {
	    console.log("loadview proxy called with " + args);
	    createWebview(args[0]);
	},
	dismissView:function(win, fail, args) {
		console.log("dismissView proxy called with " + args);
	}
};

require("cordova/exec/proxy").add("PGMultiView", module.exports);
