package com.hyungilee.mediaplayer.extensions

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.hyungilee.mediaplayer.activities.MainActivity
import com.hyungilee.mediaplayer.application.ContextUtil
import com.hyungilee.mediaplayer.common.CommonMethod

/**
 * Fragment遷移
 *
 * @param fragment 遷移先のFragment
 */
fun Fragment.moveFragment(fragment: Fragment) {
    val myActivity = activity
}

/**
 * ダイアログ表示
 *
 * supportFragmentManagerのチェックを共通化したダイアログ表示処理
 *
 * @param dialogFragment DialogFragment
 */
fun Fragment.showDialog(dialogFragment: DialogFragment) {

    // supportFragmentManager の nullチェック
    val supportFragmentManager = checkNotNull(activity?.supportFragmentManager) {
        return
    }

    dialogFragment.show(supportFragmentManager, dialogFragment.tag)
}

/**
 * Fragmentで1つ前の状態に戻す
 *
 * TODO 前の画面に戻った場合に変更したデータが反映されることなどは未確認
 */
fun Fragment.backFragment() {
    activity?.supportFragmentManager?.popBackStack()

    val context = ContextUtil.getApplicationContext()
    // フラグメント上に表示されたキーボードの表示を閉じるメソット適用
    CommonMethod().hideKeyboard(context, view!!)
}

/**
 * 2つ以上前の画面遷移
 *
 * @param clearTargetFragment stackを消す対象のFragment
 *
 * 参考
 *  https://www.nsunrise.work/2017/07/fragmentbackstack.html
 *  http://java-lang-programming.com/ja/articles/89
 *
 * A -> B -> C と画面遷移をして、CからAに戻りたい場合に使用可能。
 * 引数のclearTargetFragment には Aの一つ前の BのFragmentを指定する。
 * Bまでのstack(BとC)がクリアされるため、Aが表示される。
 */
fun Fragment.popBackStackInclusive(clearTargetFragment : Fragment) {
    activity?.supportFragmentManager!!.popBackStack(clearTargetFragment.getBackStackTag(), FragmentManager.POP_BACK_STACK_INCLUSIVE)
}

/**
 * popBackStackに登録するためのtag
 *
 * @return Fragment名 例. PlaylistEditFragment
 */
fun Fragment.getBackStackTag(): String {
    return this.javaClass.simpleName
}