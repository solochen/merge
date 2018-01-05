package com.sololibrary.library.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.telephony.TelephonyManager
import java.io.File
import java.util.HashMap

/**
 * Created by chenshaolong on 2018/1/5.
 */
class AppUtil {

    companion object {

        /**
         * 获取应用程序名称
         */
        fun getAppName(context: Context): String? {
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
                val labelRes = packageInfo.applicationInfo.labelRes
                return context.resources.getString(labelRes)
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return null
        }

        /**
         * 获取应用程序版本名称信息
         * versionName
         */
        fun getVersionName(context: Context): String? {
            try {
                val packageManager = context.packageManager
                val packageInfo = packageManager.getPackageInfo(context.packageName, 0)
                return packageInfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }
            return null
        }

        /**
         * 取到应用程序build 号
         * versionCode
         */
        fun getVersionCode(context: Context): Int {
            var systemversion = 0
            try {
                systemversion = context.packageManager.getPackageInfo(context.packageName, 0).versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }

            return systemversion
        }


        /**
         * 取 channel  渠道名
         */
        fun getChannelName(context: Context, channelId: String): String {
            return context.packageManager.getApplicationInfo(context.packageName,
                    PackageManager.GET_META_DATA).metaData.getString(channelId)
        }


        /**
         * 某程序是否安装
         */
        fun isInstalledApp(context: Context, packageName: String): Boolean {
            try {
                val pm = context.packageManager
                val pkgs = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES)
                for (pkg in pkgs) {
                    // 当找到了名字和该包名相同的时候，返回
                    if (pkg.packageName == packageName) {
                        return true
                    }
                }
            } catch (e: Exception) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
            return false
        }


        /**
         * 安装.apk文件
         *
         */
        fun install(context: Context, file: File) {
            try {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive")
                context.startActivity(intent)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        /**
         * 获取手机及SIM卡相关信息
         */
        fun getPhoneInfo(context: Context): Map<String, String> {
            val map = HashMap<String, String>()
            val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            val imei = tm.deviceId
            val imsi = tm.subscriberId
            val phoneMode = android.os.Build.MODEL
            val phoneSDk = android.os.Build.VERSION.RELEASE
            map.put("imei", imei)
            map.put("imsi", imsi)
            map.put("phoneMode", phoneMode + "##" + phoneSDk)
            map.put("model", phoneMode)
            map.put("sdk", phoneSDk)
            return map
        }

        /**
         * 获取AndroidId
         */
        fun getAndroidId(context: Context): String {
            return "" + android.provider.Settings.Secure.getString(context.getContentResolver(),
                    android.provider.Settings.Secure.ANDROID_ID)
        }

    }
}