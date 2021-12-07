export DISPLAY=:0.0
DISPLAY=:0 xwd -root -silent | convert xwd:- png:/tmp/screenshot.png

adb install app/OmniNotes-alphaDebug-6.1.0.apk
sleep 1
adb shell am start -n it.feio.android.omninotes.alpha/it.feio.android.omninotes.MainActivity
./gradlew test --info