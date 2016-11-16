// (c)2016 Jesse MacFadyen,  Adobe Systems Incorporated

var exec = require('cordova/exec');
var urlutil = require('cordova/urlutil');

module.exports = {

    loadView:function(strPath) {
        // make sure it is absolute using cordova.js util method.
        strPath = urlutil.makeAbsolute(strPath);
        exec(null,null,"PGMultiView","loadActivity",[strPath]);
    },

    dismissView:function() {
        exec(null,null,"PGMultiView","dismissActivity",[]);
    }
}
