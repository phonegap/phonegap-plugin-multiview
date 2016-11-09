// (c)2016 Jesse MacFadyen and Sterling Gerritz,  Adobe Systems Incorporated
cordova.define("phonegap-plugin-multiview.multiview", function(require, exports, module) {
var exec = require('cordova/exec');

module.exports = {

  loadView:function(strPath) {
    exec(null,null,"PGMultiView","loadActivity",[strPath]);
  },

    dismissView:function() {
        exec(null,null,"PGMultiView","dismissActivity",[]);
    }
}

});
