Xvfb :1337 & export DISPLAY=:1337 &
adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
./gradlew test --info