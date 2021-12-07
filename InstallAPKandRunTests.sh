adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
PATH=$PATH:/opt/X11/bin
xvfb-run --auto-servernum gradlew test --info