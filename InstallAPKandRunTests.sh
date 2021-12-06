#!/bin/bash
runXvfb() {
    PATH=$PATH:/opt/X11/bin
    Xvfb $1 &
    XVFB_PID=$!
    echo Launched Xvfb $1 as process $XVFB_PID >&2
    trap "echo killing process $XVFB_PID... >&2; kill $XVFB_PID" 0
    export DISPLAY=$1
    sleep 2
}
adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
./gradlew test --info