// (c) 2011-2016 Jesse MacFadyen,  Adobe Systems Incorporated

var exec = require('cordova/exec');

module.exports = {

	loadView:function(strPath) {
        var onSuccess = function(res) {
            // window.alert("loadView::onSuccess " + res);
        }
		exec(onSuccess,null,"PGMultiView","loadView",[strPath]);
	},

    dismissView:function() {
        var onSuccess = function(res) {
            // window.alert("dismissView::onSuccess " + res);
        }
        exec(onSuccess,null,"PGMultiView","dismissView",[]);
    }
}
