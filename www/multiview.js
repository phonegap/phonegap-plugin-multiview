// (c)2016 Jesse MacFadyen,  Adobe Systems Incorporated

var exec = require('cordova/exec');
var urlutil = require('cordova/urlutil');
module.exports = {
    loadView:function(url, message, success, error) {
        strPath = urlutil.makeAbsolute(url);
       // window.alert("URL = " + url);

        exec(success, error,"PGMultiView","loadView",[url, message]);
    },
    dismissView:function(message) {
        exec(null,null,"PGMultiView","dismissView",[message]);
    },
    getMessage:function(success, error) {
        exec(success,error,"PGMultiView","getMessage",[]);
    }
};
