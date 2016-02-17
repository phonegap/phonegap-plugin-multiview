

module.exports = {
	loadView:function(win, fail, args) {
		console.log("loadview proxy called with " + args);
	},
	dismissView:function(win, fail, args) {
		console.log("dismissView proxy called with " + args);
	}
}

require("cordova/exec/proxy").add("PGMultiview", module.exports);