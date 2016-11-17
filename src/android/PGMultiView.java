
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
        this.callbackContext = callbackContext;

         if (action.equals("loadView")) {
            final String url = args.getString(0);
            final String message = args.getString(1);
           // LOG.d(LOG_TAG, "url = " + url);
            startCordovaActivity(url, message);
        } else if (action.equals("dismissView")) {
           final String message = args.getString(0);
            quit(message);
        } else if(action.equals("getMessage")) {
            LOG.d(LOG_TAG, "getMessage");
            PGMultiViewActivity act = (PGMultiViewActivity) this.cordova.getActivity();
            String message = act.getMessage();
            LOG.d(LOG_TAG, "getMessage "+message);
            callbackContext.success(message);
        }
        return true;
    }

   private void startCordovaActivity(final String url, final String messageToChild) { //url is passed in from execute, its args.getstring(0)
        Intent intent = new Intent(this.cordova.getActivity(), PGMultiViewActivity.class);
        intent.putExtra("start URL", url);
        intent.putExtra("Message to child", messageToChild);
        cordova.startActivityForResult(this, intent, RESULT_CODE);
    }

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
    
   private void quit(String message) {
        Intent result = new Intent();
        result.putExtra("Message to parent", message);
        this.cordova.getActivity().setResult(Activity.RESULT_OK, result);
        this.cordova.getActivity().finish();
    }

}
