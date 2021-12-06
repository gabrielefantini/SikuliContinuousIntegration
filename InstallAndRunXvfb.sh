ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)" 2> /dev/null
brew install xquartz
which xvbf
Xvfb :1337 & export DISPLAY=:1337 &