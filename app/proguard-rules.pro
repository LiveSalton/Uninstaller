# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# 极致压缩的ProGuard配置 - 目标200KB

# 基础混淆设置
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-verbose

# 优化相关
-allowaccessmodification
-dontpreverify
-optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizationpasses 5

# 移除日志
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int i(...);
    public static int w(...);
    public static int d(...);
    public static int e(...);
}

# 移除XLog调试信息
-assumenosideeffects class com.salton123.log.XLog {
    public static void v(...);
    public static void d(...);
    public static void i(...);
    public static void w(...);
    public static void e(...);
}

# 保留Application类
-keep public class com.salton123.uninstaller.XApp
-keep public class * extends android.app.Application

# 保留Activity类
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment

# 保留实体类（防止序列化问题）
-keep class com.salton123.uninstaller.entity.** { *; }

# 保留R类
-keep class **.R
-keep class **.R$* {
    <fields>;
}

# 保留Manifest中声明的类
-keep class com.salton123.uninstaller.MainActivity
-keep class com.salton123.uninstaller.BackupActivity

# 保留点击事件相关
-keepclassmembers class * {
    public void onClick(android.view.View);
}

# 保留View相关
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}

# ImmersionBar库相关
-keep class com.gyf.barlibrary.** { *; }
-dontwarn com.gyf.barlibrary.**

# 系统相关
-keep class android.** { *; }
-keep class androidx.** { *; }
-dontwarn android.**
-dontwarn androidx.**

# 移除未使用的类和方法
-dontwarn java.lang.invoke.**
-dontwarn **CompatHoneycomb
-dontwarn **CompatHoneycombMR2
-dontwarn **CompatCreatorHoneycombMR2

# 激进的资源压缩
-keepresources
-printusage unused.txt
-printmapping mapping.txt

# 移除调试信息
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable
-keepattributes *Annotation*

# 压缩级别
-keep,allowobfuscation @interface androidx.annotation.Keep
-keep @androidx.annotation.Keep class *
-keepclassmembers class * {
    @androidx.annotation.Keep *;
}