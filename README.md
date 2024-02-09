# 99co Mobile Testing

## Installation On MacOs

### First we need to install Java.

Use the package manager [brew](https://brew.sh/) to install java on MacOs.

1. Install brew.
```bash
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```
2. Update brew.
```bash
brew update
```
3. Install java.
```bash
brew cask install java
```
4. Set JAVA_HOME after installation.

add or edit file .zshrc
```bash
vim .zshrc

export PATH=$PATH:$HOME/bin
export JAVA_HOME=$(/usr/libexec/java_home)
export PATH=$JAVA_HOME:$PATH
```

reload file .zshrc

```bash
source ~/.zshrc
```

5. Check java version.
```bash
java --version
```

### Second we need to install Gradle.

1. Install gradle
```bash
brew install gradle.
```

2. Check gradle version.
```bash
gradle --version
```

## Installation On Linux
### First we need to install Java.

Use the package manager apt to install java on Linux.

1. Update package.
```bash
sudo apt update
```
2. Update brew.
```bash
brew update
```
3. Install java.
```bash
sudo apt install default-jre
java -version

sudo apt install default-jdk
javac -version
```
4. Set JAVA_HOME after installation.


check java path installation
```bash
sudo update-alternatives --config java
```

add or edit file /etc/environment
```bash
sudo nano /etc/environment
JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
```
reload file  /etc/environment
```bash
source /etc/environment
```
5. Check java version.
```bash
java --version
```

### Second we need to install Gradle.

1. Install gradle.
```bash
VERSION=7.0

wget https://services.gradle.org/distributions/gradle-${VERSION}-bin.zip -P /tmp

sudo unzip -d /opt/gradle /tmp/gradle-${VERSION}-bin.zip
sudo ln -s /opt/gradle/gradle-${VERSION} /opt/gradle/latest

```
2. Set GRADLE_HOME after installation.
```bash
sudo nano /etc/profile.d/gradle.sh
export GRADLE_HOME=/opt/gradle/latest
export PATH=${GRADLE_HOME}/bin:${PATH}

sudo chmod +x /etc/profile.d/gradle.sh

source /etc/profile.d/gradle.sh
```


3. Check gradle version.
```bash
gradle -v
```

### Third we need to install Appium.

1. Install Node.js (if not already installed)
```bash
brew install node
```

2. Install Appium:
```bash
npm install -g appium
```

3. Install Appium Doctor (optional but recommended):
```bash
npm install -g appium-doctor
```

4. Check Appium Version:
```bash
appium -v
```

5. Install appium driver uiautomator2
```bash
appium driver install uiautomator2
```

### Fourth we need to install Carthage.
1. Install Chartage
```bash
brew install carthage
```

2. Chartage Version
```bash
carthage version
```

### Fifth we need to install Xcode.
1. Install Xcode from app store

2. Select Xcode Command Line Tools
```bash
xcode-select —install
```

### Last step we need to install Android Studio, Genymotion.
1. Install Android Studio, Genymotion
2. Set Android Home
```bash
   export ANDROID_HOME=/Users/ric/Library/Android/sdk
   export PATH=$ANDROID_HOME/tools/bin:$PATH
   export PATH=$ANDROID_HOME/build-tools/33.0.0:$PATH
   export PATH=$ANDROID_HOME/build-tools/33.0.0/bin:$PATH
   export PATH=$ANDROID_HOME:$PATH
```

## Run Project

###  Android Testing
1. extract project 99co_mobile_testing.zip

2. run project with all feature/scenario
```bash
gradle cucumber
```

3. run project with feature/scenario with spesific tag
```bash
gradle cucumber -P tags=@99co

example:
run scenario 1
gradle cucumber -P tags=@scenario-1

run scenario 2
gradle cucumber -P tags=@scenario-2
```