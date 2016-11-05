
/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/

//this is the main (parent) view from which the second webview will launch from.
package org.apache.cordova.pgmultiview;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;


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


import android.manifest;
import android.app.Activity;
import android.os.Build;
import android.content.Intent;
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



    //cordova is context of main activity.  webView is the webview we are running the main Activity (cordova) inside of.
     public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
  }
    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("loadView") &&args.length() > 0) {
            final String url = args.getString(0);

            Log.d(LOG_TAG, "url = " + url);
            openWebView(url);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
        }
        else if (action.equals("dismissView")) {
            quit();

    private void viewWebView(final String url){ //url is passed in from execute, its args.getstring(0)
      Intent intent = new Intent(this.cordova.getActivity(), PGMultiViewActivity.class);  //initialized intent as variable of type 'Intent' updated to send to secondary activity, not another class.
           intent.putExtra("start URL", url);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); //updated to 'set' tabs
            this.cordova.getActivity().startActivity(intent);
    }

    private void quit(){
      Log.d("you are now exiting the app");
      this.cordova.getActivity.finish();
    }


}
