# phonegap-plugin-multiview
***

This plugin allows your PhoneGap app to create multiple views.  This is only Version 1 of the MultiView Plugin, stay tuned because we will be continually adding more functionality as we incorporate feedback!

## Please check out a demo video which illustrates the passing of data between webviews:
***

### *Android*

[![Youtube - Android Demo](androidscreenshot.png)](https://youtu.be/_ZzBA28QO4s "Youtube -Android Demo Movie")

### *iOS*

[![Youtube - iOS Demo](iosscreenshot.png)](https://youtu.be/WVbxFIGBh0Y "Youtube -iOS Demo Movie")

## Each View:
***

- has it's own global context
- has it's own collection of plugins (instances, classes are shared, so watch for statics )
- can communicate via localStorage ( assuming they are loaded from the same location )
-has access to all Cordova resources

## Currently Supported Platforms:
***

- iOS
- Android

## This Repo Includes a Brief Demo Project, to Run it in iOS/Android:
***

```bash
$ cd demo
$ cordova platform add iOS (or) cordova platform add android
$ cordova plugin add --link .. (Android does not link)
$ cordova run iOS (or) cordova run android
```

The Demo application illustrates the passing of data between a parent-view and child-view, however the API provides support for 
*multiple* views in a stack.  Each additional view must have it's own JavaScript file that corresponds with native portions of the plugin.

## Installation Instructions
 ***
Please download the latest version date version of our plugin directly from NPM:
[NPM PhoneGap-Plugin-MultiView](https://www.npmjs.com/package/phonegap-plugin-multiview)

## Quickstart Guide to Using the MultiView Plugin
***

- ### To launch a new webview make this call in your application's JavaScript:
      PGMultiView.loadView(url, strPayload, success, error);

            @param 'url' the location of your html file.  The MultiView plugin automatically adds the prefix of :///android_asset/www/ if your url does not start with js
            @param  'strPayload', data stored in a JSON object to be passed between views.  
            @param 'success', a sucessful plugin callback
            @param 'error', the plugin was not called

- ### Please note that you must make two separate JavaScript files which correspond respectively to the native portions of the plugin(PGMultiview.java and PGMultiviewActivity.java) if you want to utilize both views.

- ### To *dismiss* a webview make this call in your application's JS:
      PGMultiView.dismissView(data);

            @param 'data' is currently a string - will be JSON object in next release.

- ### The MultiView Sequence:
![MultiViewSequence](MultiViewSequence.png)

## Issues
***
Currently data is stored to memory (not disc).  Under most operating conditions this should not be an issue.
However, in an extreme low memory state you do risk losing data between views if either PGMultiView.java or or PGMultiViewActivity crash before reaching onStop() in the activity lifecycle.
This should be resolved in the near future, the next release of this plugin bindsEvents() and writes the saved view state to local storage so that it can be retrieved at OnPause() in the Cordova Activities' lifecycle.

## Contact Us
***
Your feedback is graciously accepted and appreciated!  We welcome all of your issues and pull requests.
