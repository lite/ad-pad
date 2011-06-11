pre
====

brew install android

android create project --package com.fssle.adpad \
  --activity .AdPadActivity \
  --target "Google Inc.:Google APIs:4" \
  --path AdPad
   
build  
====

android update project -t "Google Inc.:Google APIs:4" --path `pwd` 
ant clean
ant install  

emulator
====

android create avd -t "Google Inc.:Google APIs:4" -n android-api-r4
emulator @android-api-r4 &                
        
adb
====
                
adb logcat -c
adb logcat -v time * 

adb uninstall com.fssle.adpad
adb install bin/AdPad-release.apk
    
key
==== 
keytool -delete -alias mykeystore 
keytool -list -v | more
keytool -genkey -keyalg RSA -alias mykeystore -dname "CN=lite, OU=dev, O=FssLe, L=NJ, S=JS, C=CN" -keystore "my.keystore"
keytool -list -alias mykeystore -keystore "my.keystore" 

jarsigner -verbose -keystore mykeystore my_application.apk mykeystore
jarsigner -verify my_signed.apk

map
====
025aHjnrl521frBloxRW7_Iwcrc_nixLiMj_Ktw
   
ads
====
a14deccf77dab80

ui
====
Hierarchyviewer
                  
Catagories
----

* News	
* Map Screen	
* Events	
* Schedule	
* Riders	
* Partners	
* Photos/videos	
* Social feed

News
----

* Advertisement 
* Event news feed	

Map Screen
----

* Advertisement
* City
* Advertisement
* Event
* Advertisement

Events
----
* Advertisement
* Event 6	
* Details 
* Event 7	
* Details
* Event 8	
* Details
* Ticket giveaways
* Details
* Road Tours	
* Details
  
Schedule
----

* Advertisement
* Day 1		
* Day 2	 
* Day 3	
* Day 4
* Brackets	
            
Riders
----         

* Advertisement
* Pic and basic bio for each	
  
Partners
----

* Advertisement
* Pick and basic web link/phone number for each	

Photos/videos	
----

* Advertisement	
* Share
* Current uploads (event coordinator posted)	

Social 
----

* Advertisement 
* RSS/facebook/Twitter/youtube/foursquare links 
* Check  in  Four square
* Feed from your website
