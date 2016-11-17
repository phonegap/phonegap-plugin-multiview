
module.exports = {};

var execProxy = require('cordova/exec/proxy');
var href = window.location.href;
var oldGet = execProxy.get;

// if we are loaded from app-data we need to shim in a new bridge
if (href.indexOf("ms-appdata") === 0) {
    execProxy.get = function (service, action) {
        // we will only replace apis that exist
        if(oldGet(service,action)) {
            return function (onSuccess, onError, args) {
                var obj = { service: service, action: action, args: args };
                window.external.notify("gap:" + JSON.stringify(obj));
            };
        }
    };
}