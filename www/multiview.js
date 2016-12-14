/*global previousResult:true */
var exec = require('cordova/exec');
var urlutil = require('cordova/urlutil');
var channel = require('cordova/channel');

module.exports = {
    previousResult:null,
    getMessage:function(success, error) {
        exec(success,error,"PGMultiView","getMessage",[]);
    },
    loadView:function(strUrl, message, success, error) {
        strUrl = urlutil.makeAbsolute(strUrl);
        exec(success, error,"PGMultiView","loadView",[strUrl, message]);
    },
    dismissView:function(message) {
        exec(null,null,"PGMultiView","dismissView",[message]);
   } 
};
channel.onCordovaReady.subscribe(function() {
    module.exports.getMessage( function(res){
        previousResult = res;
    }, function(err) {
   //Either parent is being loaded for the first time or there is no previous result
    });
});
