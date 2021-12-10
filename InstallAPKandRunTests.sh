adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
export DISPLAY=:1
sleep 20
screencapture screenshot.png
./gradlew test --info