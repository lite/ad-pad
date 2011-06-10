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
ad-p-ad
    
key
==== 
keytool -delete -alias androiddebugkey 
keytool -list -v | more
keytool -genkey -keyalg RSA -alias androiddebugkey -dname "CN=lite, OU=dev, O=FssLe, L=NJ, S=JS, C=CN"
keytool -list -alias androiddebugkey -keystore "debug.keystore" 
 
map
====
"025aHjnrl520Td3m_FQKdcIBO2vaEwCmnfSk3aw"
   
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
