// (c)2016 Jesse MacFadyen,  Adobe Systems Incorporated
var exec = require('cordova/exec');
var urlutil = require('cordova/urlutil');
module.exports = {
loadView:function(strPath) {
strPath = urlutil.makeAbsolute(strPath);
window.alert("strPath = " + strPath);
      exec(null,null,"PGMultiView","loadView",[strPath]);
  },
    dismissView:function() {
        exec(null,null,"PGMultiView","dismissView",[]);
    }
}




