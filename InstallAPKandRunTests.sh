export DISPLAY=:1
cat ~/.android/avd/*.avd/config.ini
adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
sleep 20
./gradlew test --info