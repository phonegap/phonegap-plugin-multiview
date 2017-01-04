package phonegap.pgmultiview;

        import android.os.Bundle;
        import org.apache.cordova.CordovaActivity;
        import android.content.Intent;
        import android.app.Activity;

public class PGMultiViewActivity extends CordovaActivity {

    public String strPayload;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("start URL");
        strPayload = bundle.getString("Message to child");
        loadUrl(url);
    }

    @Override
    public void onBackPressed() {
        if(appView.canGoBack()){
            appView.backHistory();
        }
        else if(appView.canGoBack()==false) {
            Intent result = new Intent();
            result.putExtra("Message to parent", "");
            this.setResult(Activity.RESULT_OK, result);
            this.finish();
        }}

    public String getMessage() {
        return strPayload;
    }
}

