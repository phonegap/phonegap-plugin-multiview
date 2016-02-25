# phonegap-plugin-multiview

This plugin allows your PhoneGap app to create multiple views. Currently only iOS is supported.

Each view:

- has it's own global context
- has it's own collection of plugins (instances, classes are shared, so watch for statics )
- can communicate via localStorage ( assuming they are loaded from the same location )



This project includes a brief demo, to run it (iOS only!)

    cd demo
    cordova platform add ios
    cordova plugin add --link ..
    cordova run ios


The currently API is dead simple, expect it to change in the future

Open a new view:
===

    PGMultiview.loadView(srcUrl);

And remove it:
===

    PGMultiview.dismissView();

Currently there are no callbacks, or events.

