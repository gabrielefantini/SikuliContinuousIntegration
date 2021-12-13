export DISPLAY=:1
adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
sleep 20
screencapture screenshot1.png
./gradlew test --info
screencapture screenshot2.png