// (c)2016 Jesse MacFadyen,  Adobe Systems Incorporated
cordova.define("phonegap-plugin-multiview.multiview", function(require, exports, module) {
var exec = require('cordova/exec');

module.exports = {

  loadView:function(strPath) {
      var newUrl = strPath;
      if ( strPath.indexOf(":")  == -1 ) { //if its a url with a colon, so just load it
            var currentLocation = window.location.href;
            var lastSlash = currentLocation.lastIndexOf("/");
            console.log(currentLocation)
            console.log(lastSlash)
            console.log(strPath)
            console.log(currentLocation.substr(0,lastSlash))
            console.log('hi');
            newUrl = currentLocation.substr(0,lastSlash) + "/" + strPath;
            console.log('newURL: ' + newUrl);
      }

      exec(null,null,"PGMultiView","loadView",[newUrl]);
  },

    dismissView:function() {
        exec(null,null,"PGMultiView","dismissView",[]);
    }
}

});

