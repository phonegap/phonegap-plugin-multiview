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
    static Dialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        secondActivity=this;

        Bundle bundle =getIntent().getExtras();
        String url = bundle.getString("start URL");
       // launchWebView();
        loadUrl(url);

    }
    public void launchWebView() {

        secondActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog = new Dialog(secondActivity,android.R.style.Theme_Translucent_NoTitleBar);


                LinearLayout linearLayout = new LinearLayout(secondActivity);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                RelativeLayout layoutMain = new RelativeLayout(secondActivity);
                layoutMain.setBackgroundColor(Color.CYAN);
                RelativeLayout.LayoutParams setup = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                setup.addRule(RelativeLayout.CENTER_IN_PARENT);
                linearLayout.setLayoutParams(setup);
                layoutMain.addView(linearLayout);
                dialog.setContentView(layoutMain);
                dialog.show();
            }
        });


    }

}