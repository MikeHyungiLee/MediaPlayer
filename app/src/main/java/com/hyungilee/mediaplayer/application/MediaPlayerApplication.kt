/**
 * @file MediaPlayerApplication.kt
 * @brief ログイン画面
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package com.hyungilee.mediaplayer.application

import android.app.Application
import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.AssetManager
import androidx.annotation.StringRes

/**
 * BravoアプリのApplicationクラス
 */
class MediaPlayerApplication: Application() {

    companion object {
        /** Singletonインスタンス */
        lateinit var instance: Application private set
    }

    override fun onCreate() {
        super.onCreate()
    }
}

/**
 * Context操作ユーティリティ
 *
 * AndroidのContextのうち、ApplicationContext と ActivityContext の使い分けを行うためのクラス
 * このクラスでInterfaceを用意しているものは ApplicationContext を使用し、
 * それ以外の場合は ActivityContext を使用すること。
 * 追加・修正は必要に応じて可能とする。
 *
 * NOTE:
 * ・getColor、getDrawable はThemeを参照するためApplicationContextを使用しない
 * ・SharedPreference は Preference クラスが管理するため ContextUtil ではInterfaceを持たない(むやみに広い範囲で使用させないため)
 *
 */
class ContextUtil {

    companion object {

        /**
         * ApplicationContext取得
         *
         * @return ApplicationContext ApplicationクラスのSingletonインスタンス
         */
        fun getApplicationContext() : Context {
            return MediaPlayerApplication.instance
        }

        /**
         * Assets取得
         *
         * @return assets
         */
        fun getAssets() : AssetManager {
            return getApplicationContext().assets
        }

        /**
         * 文字列リソース取得
         *
         * @param resId stringResId
         * @return 文字列
         * @see Context.getString
         */
        fun getString(@StringRes resId: Int): String {
            return getApplicationContext().getString(resId)
        }

        /**
         * 文字列リソース取得
         *
         * @param resId stringResId
         * @param formatArgs 変換文字列部分の配列
         * @return 文字列
         * @see Context.getString
         */
        fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
            return getApplicationContext().getString(resId, *formatArgs)
        }

        /**
         * パッケージ情報取得
         *
         * @return パッケージ情報
         */
        fun getPackageInfo(): PackageInfo {
            return getApplicationContext().packageManager.getPackageInfo(getApplicationContext().packageName, PackageManager.GET_META_DATA)
        }

    }
}