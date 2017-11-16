-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5 #指定代码的压缩级别
-allowaccessmodification
-dontpreverify  #预校验

-dontusemixedcaseclassnames #包明不混合大小写
-dontskipnonpubliclibraryclasses #不去忽略非公共的库类
-verbose #混淆时是否记录日志

#保护注解
-keepattributes *Annotation*


#-keep class com.xiandanjia.android.model.** { *; } #实体类不参与混淆
#-keep class com.xiandanjia.android.widget.** { *; } #自定义控件不参与混淆




####################support.v4#####################
#-libraryjars libs/android-support-v4.jar
#-keep class android.support.v4.** { *; }
#-dontwarn android.support.v4.**

#-keep interface android.support.v4.app.** { *; }
#-keep public class * extends android.support.v4.**
-keep public class * extends android.app.Fragment

# 保持哪些类不被混淆
-keep public class MainActivity
#-keep public class * extends android.app.Fragment
#-keep public class * extends android.app.Activity
#-keep public class * extends android.app.Application
#-keep public class * extends android.app.Service
#-keep public class * extends android.content.BroadcastReceiver
#-keep public class * extends android.content.ContentProvider
#-keep public class * extends android.app.backup.BackupAgentHelper
#-keep public class * extends android.preference.Preference
#-keep public class com.android.vending.licensing.ILicensingService