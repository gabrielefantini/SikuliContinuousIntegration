export DISPLAY=:1
for f in ~/.android/avd/*.avd/config.ini; do echo 'hw.keyboard=yes' >> "$f"; done
adb -e reboot
adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
sleep 20
./gradlew test --info