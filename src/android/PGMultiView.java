
package phonegap.pgmultiview;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

// import android.manifest;
import android.app.Activity;
import android.os.Build;
import android.content.Intent;

public class PGMultiView extends CordovaPlugin {

    protected static final String LOG_TAG = "PGMultiView";

    protected Intent intent;

// @param action the action to execute.
// @param args JSONArry of arguments for the plugin.
// @param the context used when calling back to JS .
// @return boolean success or fail

//cordova is context of main activity.  webView is the webview we are running the main Activity (cordova) inside of.
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("loadView")) {
            final String url = args.getString(0);

            //LOG.d(LOG_TAG, "url = " + url);
            startCordovaActivity(url);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
        }
        else if (action.equals("dismissView")) {
            quit();
        }
        return true;
    }

    private void startCordovaActivity(final String url){ //url is passed in from execute, its args.getstring(0)
        Intent intent = new Intent(this.cordova.getActivity(), PGMultiViewActivity.class);
        intent.putExtra("start URL", url);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //updated to 'set' tabs
        this.cordova.getActivity().startActivity(intent);
    }

    private void quit(){
        //LOG.d(LOG_TAG, "Closing the secondary View/Activity");
        this.cordova.getActivity().finish();
    }

}
