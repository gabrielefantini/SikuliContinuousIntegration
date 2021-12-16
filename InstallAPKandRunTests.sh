export DISPLAY=:1
sed -i "s/hw.keyboard=no/hw.keyboard=yes/g" /Users/runner/.android/avd/test.avd/config.ini
cat ~/.android/avd/*.avd/config.ini
adb -e reboot
sleep 180
adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
sleep 20
./gradlew test --info