
package phonegap.pgmultiview;

import android.annotation.SuppressLint;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.Config;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaHttpAuthHandler;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginManager;
import org.apache.cordova.PluginResult;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;


@SuppressLint("SetJavaScriptEnabled")
public class PGMultiView extends CordovaPlugin {

    protected static final String LOG_TAG = "PGMultiView";

    protected Intent intent;

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action the action to execute.
     * @param args JSONArry of arguments for the plugin.
     * @param callbackContext the callbackContext used when calling back into JavaScript.
     * @return boolean success or fail
     */
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("loadView")) {
            final String url = args.getString(0);

            Log.d(LOG_TAG, "url = " + url);

            intent = new Intent(this.cordova.getActivity(), com.phonegap.PGMultiViewdemo.MainActivity.class);
            // todo: figure out how to pass this in
            //intent.putExtra("startUrl", "http://www.phonegap.com");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            this.cordova.getActivity().startActivity(intent);

            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);


        }
        else if (action.equals("dismissView")) {
            // todo: more to it than this
            this.cordova.getActivity().finish();
        }
        return true;
    }

}
