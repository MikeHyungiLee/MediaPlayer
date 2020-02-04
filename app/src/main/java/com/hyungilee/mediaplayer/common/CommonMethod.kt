/**
 * @file CommonMethod.kt
 * @brief 共通的に使うメソットを含むクラス
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package com.hyungilee.mediaplayer.common

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * @brief 共通的に使うメソットを含むクラス
 *
 * @par 概要
 * 色んな画面で共通的に使っているメソットを再使用できるように管理
 */
class CommonMethod {
    /**
     * 画面上に表示されているキーボード表示を閉じるメソット
     *
     * @param context 現在活性化されているActivityのcontext　
     * @param view    現在活性化されている画面のView情報
     *
     * 処理：① Application SingletonでgetSystemServiceを呼び出してActivityのINPUT_METHOD_SERVICEと関するサービスを取得する
     * 　　　② 取得したサービス情報を使ってSoft Input AreaをClose/Hide(windowToken : システム内のウィンドウを特定するToken)
     */
    fun hideKeyboard(context: Context, view: View){
        val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }

    fun hideKeyboard(activity: Activity){
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if(view == null){
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}