
var exec = require('cordova/exec');
var urlutil = require('cordova/urlutil');
var channel = require('cordova/channel');

var alias = module.exports = {
    previousResult:null,
    getMessage:function(success, error) {
        exec(success,error,"PGMultiView","getMessage",[]);
    },
    loadView:function(strUrl, strPayload, success, error) {
        strUrl = urlutil.makeAbsolute(strUrl);
        exec(success, error,"PGMultiView","loadView",[strUrl, strPayload]);
    },
    dismissView:function(strPayload) {
        exec(null,null,"PGMultiView","dismissView",[strPayload]);
   } 
};

channel.onCordovaReady.subscribe(function() {
    alias.getMessage( function(res){
        alias.previousResult = res;
    }, function(err) {
        //Either parent is being loaded for the first time or there is no previous result
    });
});
