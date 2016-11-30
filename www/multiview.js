// (c)2016 Jesse MacFadyen,  Adobe Systems Incorporated

var exec = require('cordova/exec');
var urlutil = require('cordova/urlutil');

module.exports = {
    loadView:function(strUrl, message, success, error) {
        strUrl = urlutil.makeAbsolute(strUrl);
        exec(success, error,"PGMultiView","loadView",[strUrl, message]);
    },
    dismissView:function(message) {
        exec(null,null,"PGMultiView","dismissView",[message]);
    },
    getMessage:function(success, error) {
        exec(success,error,"PGMultiView","getMessage",[]);
    }
};
