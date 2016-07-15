
package phonegap.PGMultiView;

import android.annotation.SuppressLint;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint("SetJavaScriptEnabled")
public class PGMultiView extends CordovaPlugin {

    protected static final String LOG_TAG = "PGMultiView";

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action the action to execute.
     * @param args JSONArry of arguments for the plugin.
     * @param callbackContext the callbackContext used when calling back into JavaScript.
     * @return A PluginResult object with a status and message.
     */
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("loadView")) {
            final String url = args.getString(0);

            Log.d(LOG_TAG, "url = " + url);
            // PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, result);
            // pluginResult.setKeepCallback(true);
            // callbackContext.sendPluginResult(pluginResult);

        }
        else if (action.equals("dismissView")) {
            //closeDialog();
        }

        return true;

    }



}
