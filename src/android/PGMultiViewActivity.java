package phonegap.pgmultiview;

import android.os.Bundle;
import org.apache.cordova.CordovaActivity;

public class PGMultiViewActivity extends CordovaActivity {

    public String message;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("start URL");
        message = bundle.getString("Message to child");
        loadUrl("file:///android_asset/www/" + url);
    }

    public String getMessage() {
        return message;
    }
}

