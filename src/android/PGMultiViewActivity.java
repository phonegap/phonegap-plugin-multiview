package org.apache.cordova.pgmultiview;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.ProgressBar;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import org.apache.cordova.CordovaActivity;
import android.content.DialogInterface;
import android.view.KeyEvent;

public class PGMultiViewActivity extends CordovaActivity {

    Activity secondActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondActivity=this;

        Bundle bundle =getIntent().getExtras();
        String url = bundle.getString("start URL");
        loadUrl(url);
    }

}

