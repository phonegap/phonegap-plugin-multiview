
package phonegap.pgmultiview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.LOG;
import org.json.JSONException;

import static android.app.Activity.RESULT_OK;

public class PGMultiView extends CordovaPlugin {
    public CallbackContext callbackContext;
    protected static final String LOG_TAG = "PGMultiView";
    public static int RESULT_CODE =42;

// @param action the action to execute.
// @param args JSONArry of arguments for the plugin.
// @param the context used when calling back to JS .
// @return boolean success or fail

//Cordova is context of main activity.  webView is the webview we are running the main Activity (cordova) inside of.

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;

        if (action.equals("loadView")) {
            final String url = args.getString(0);
            final String message = args.getString(1);
            startCordovaActivity(url, message);
        } else if (action.equals("dismissView")) {
            final String message = args.getString(0);
            quit(message);
            //getMessage() is for the child activity (PGMultiViewActivity.java), not the parent
        } else if(action.equals("getMessage")) {
            PGMultiViewActivity act = (PGMultiViewActivity) this.cordova.getActivity();
            String message = act.getMessage();
            callbackContext.success(message);
        }
        return true;
    }

    //Launch child activity(PGMultiViewActivity.java), send start url and message in an intent
    private void startCordovaActivity(final String url, final String messageToChild) { //url is passed in from execute, its args.getstring(0)
        Intent intent = new Intent(this.cordova.getActivity(), PGMultiViewActivity.class);
        intent.putExtra("start URL", url);
        intent.putExtra("Message to child", messageToChild);
        cordova.startActivityForResult(this, intent, RESULT_CODE);
    }

    //when we get the result of the child activity back, create a bundle that we unpack the "message to parent" from
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Bundle bundle = intent.getExtras();
        if (requestCode == RESULT_CODE) {
            if (resultCode == RESULT_OK) {
                String messageFromChild = bundle.getString("Message to parent");
                callbackContext.success(messageFromChild);
            }
        }
    }

    //required to make callbacks work with the plugin
    public void onRestoreStateForActivityResult(Bundle state, CallbackContext callbackContext) {
        this.callbackContext = callbackContext;
    }

    //in the child activity when the user clicks the "navigate to parent button":
    private void quit(String message) {
        Intent result = new Intent();
        result.putExtra("Message to parent", message);
        this.cordova.getActivity().setResult(Activity.RESULT_OK, result);
        this.cordova.getActivity().finish();
    }
}
