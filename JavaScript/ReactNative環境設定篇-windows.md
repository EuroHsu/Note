# Rect Native 環境設定篇 - Windows

## 安裝Cmder與Git版本控制

Cmder是一套含有Git套件的Console Emulator，我們使用它來取代Windows原生命令提示字元與PowerShell

到[Cmder](http://cmder.net)官網下載Full版壓縮檔(Full版才含有Git)

解壓縮之後執行`Cmder.exe`即可啟動程式

    git --version

常用快捷鍵

	Win+Alt+P \\ 打開設定頁面
	Alt+LShift+1 \\ 開新分頁(cmd) as Administrator
	Alt+LShift+2 \\ 開新分頁(cmd)
	Alt+LShift+3 \\ 開新分頁(PowerShell) as Administrator
	Alt+LShift+4 \\ 開新分頁(PowerShell)
	Ctrl+W \\ 關閉當前分頁

自訂分割視窗快捷鍵

修改 Settings/Keys&Macro (Win+Alt+P 可打開設定頁面)，右邊搜尋split

上下分割: 找到`Split: Duplicate active 'shell' split to bottom: Split(0,0,50)`這行

	設定快捷鍵為`Alt+LShift+Down`或其他習慣用法

左右分割: 找到`Split: Duplicate active 'shell' split to right: Split(0,50,0)`這行

	設定快捷鍵為`Alt+LShift+Right`或其他習慣用法

如果有遇到中文亂碼的問題

修改 Settings/Startup/Environment (Win+Alt+P 可打開設定頁面)，在底下新增一行 

    set LANG=zh_TW.UTF8

## 安裝Node Version Manager (nvm) for Windows

因為要固定專案使用的node.js版本以確保能在相同的環境下執行程式，故需安裝此套件來管理本機node.js版本

至Github下載[NVM for Windows](https://github.com/coreybutler/nvm-windows)的壓縮檔

執行`nvm-setup.exe`完成nvm的安裝

    nvm version 

## 使用NVM安裝Node.js

查看目前本地安裝的node.js版本，會列出目前有安裝的版本和預設的版本

    nvm list

	* 8.6.0 (Currently using 64-bit executable)

安裝node.js，目前本人使用node.js v8.6.0開發

    nvm install 8.6.0

安裝完成後應該就能看到本地端已經安裝的node.js執行效果

    node -v

將v8.6.0設為預設版本

    nvm use 8.6.0

## 安裝Python2

至[Python](https://www.python.org/)官網下載2.7.x版本並安裝

安裝完成後應該就能看到本地端已經安裝的Python2執行效果

	python

註: 記得要安裝的是2.7，不要安裝3的版本。

註: 另外在安裝過程中，會有一個Advanced的選項，是要不要把python放到系統環境變數的路徑(path)中，記得要選。

註: 這個python2是為了有些套件需要編譯才需要安裝的。

## 安裝Java SE Development Kit (JDK)

安裝1.8版本的，連到[Oracle](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)的網站下載安裝包與安裝

新增`JAVA_HOME`到系統環境變數的使用者環境變數中，XXX是版本編號，根據安裝的版本自行修正

	C:\Program Files\Java\jdk1.8.0_XXX

## 安裝Android Studio

Android Studio包含了運行和測試React Native應用所需的Android SDK和模擬器，請到[Android Studio](https://developer.android.com/studio/index.html)官網下載安裝包與安裝

安裝完成後，在Android Studio的歡迎界面中選擇`Configure` > `SDK Manager`

在SDK Platforms窗口中，勾選Show Package Details，然後在Android 6.0 (Marshmallow)中勾選`Google APIs`、`Android SDK Platform 23`、`Intel x86 Atom System Image`、`Intel x86 Atom_64 System Image`以及`Google APIs Intel x86 Atom_64 System Image`

在SDK Tools窗口中，勾選Show Package Details，然後在Android SDK Build Tools中勾選`Android SDK Build-Tools 23.0.1`。然後還要勾選最底部的`Android Support Repository`

新增`ANDROID_HOME`到系統環境變數的使用者環境變數中

	%USERPROFILE%\AppData\Local\Android\Sdk

把工具的路徑也加到`Path`使用者環境變數中

	%USERPROFILE%\AppData\Local\Android\Sdk\tools
	%USERPROFILE%\AppData\Local\Android\Sdk\platform-tools

重啟Cmder，使環境變數生效

## 安裝react-native-cli (React Native的命令工具)

輸入以下指令(npm工具你在安裝nodejs後就會有了)

	npm install -g react-native-cli
	react-native --version

## 建立新的Rect Native專案，然後執行

先切換到自己用來管理Rect Native專案的目錄中，然後輸入以下指令

	react-native init AwesomeProject
	cd AwesomeProject
	react-native run-android

註: `react-native init AwesomeProject`這個執行需要很長的時間

註: `react-native run-android`這個執行需要一點時間，記得要"先自行把模擬器啟動"