// (c)2016 Jesse MacFadyen,  Adobe Systems Incorporated

var exec = require('cordova/exec');

module.exports = {

    loadView:function(strPath) {
        exec(null,null,"PGMultiView","loadActivity",[strPath]);
    },

    dismissView:function() {
        exec(null,null,"PGMultiView","dismissActivity",[]);
    }
}
