/**
 * @file IntroductionFragments.kt
 * @brief アプリ説明画面の内部で配置しているViewPagerでのフラグメント処理クラス
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package jp.co.bravogroup.leap.fragments.introduction

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hyungilee.mediaplayer.R
import com.hyungilee.mediaplayer.activities.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_app_intro_first.*

/** 画面遷移Key マイページから遷移してきたかどうか true マイページから遷移 / false それ以外(初回チュートリアル) */
const val NAVIGATION_KEY_IS_FROM_MY_PAGE = "navigation_key_is_from_my_page"

/**
 * @brief アプリ説明画面の内部で配置しているViewPagerでの１番目のフラグメント
 *
 * @par 概要
 * G-1-2-1 walk_through_fragment　フラグメントにセット
 */
class IntroductionFragmentFirst : Fragment() {

    companion object {
        fun newInstance(isFromMyPage: Boolean) = IntroductionFragmentFirst().apply {
            arguments = Bundle().apply {
                putBoolean(NAVIGATION_KEY_IS_FROM_MY_PAGE, isFromMyPage)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_app_intro_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close_btn.setOnClickListener {
            actionCloseButton(activity = activity, arguments = arguments)
        }
    }
}

/**
 * @brief アプリ説明画面の内部で配置しているViewPagerでの２番目のフラグメント
 *
 * @par 概要
 * G-1-2-2 walk_through_fragment　フラグメントにセット
 */
class IntroductionFragmentSecond : Fragment() {

    companion object {
        fun newInstance(isFromMyPage: Boolean) = IntroductionFragmentSecond().apply {
            arguments = Bundle().apply {
                putBoolean(NAVIGATION_KEY_IS_FROM_MY_PAGE, isFromMyPage)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_app_intro_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close_btn.setOnClickListener {
            actionCloseButton(activity = activity, arguments = arguments)
        }
    }

}

/**
 * @brief アプリ説明画面の内部で配置しているViewPagerでの３番目のフラグメント
 *
 * @par 概要
 * G-1-2-3 walk_through_fragment　フラグメントにセット
 */
class IntroductionFragmentThird : Fragment() {

    companion object {
        fun newInstance(isFromMyPage: Boolean) = IntroductionFragmentThird().apply {
            arguments = Bundle().apply {
                putBoolean(NAVIGATION_KEY_IS_FROM_MY_PAGE, isFromMyPage)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_app_intro_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close_btn.setOnClickListener {
            actionCloseButton(activity = activity, arguments = arguments)
        }
    }

}

/**
 * @brief アプリ説明画面の内部で配置しているViewPagerでの４番目のフラグメント
 *
 * @par 概要
 * G-1-2-4 walk_through_fragment　フラグメントにセット
 */
class IntroductionFragmentFourth : Fragment() {

    companion object {
        fun newInstance(isFromMyPage: Boolean) = IntroductionFragmentFourth().apply {
            arguments = Bundle().apply {
                putBoolean(NAVIGATION_KEY_IS_FROM_MY_PAGE, isFromMyPage)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_app_intro_fourth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        close_btn.setOnClickListener {
            actionCloseButton(activity = activity, arguments = arguments)
        }
    }

}

/**
 * 閉じるボタン処理実行
 *
 * チュートリアルの処理が同じ挙動になるため共通化
 *
 * @param activity Activity
 * @param arguments Fragmentのarguments
 */
private fun actionCloseButton(activity: Activity?, arguments: Bundle?) {

    val isFromMyPage = arguments?.getBoolean(NAVIGATION_KEY_IS_FROM_MY_PAGE) ?: false
    if (isFromMyPage) {
        // マイページ画面から遷移した場合はLoginではなくfinishのみ
        activity?.finish()
    } else {
        // ログイン画面に遷移する
        activity?.also {
            val intent = Intent(it, LoginActivity::class.java)
            it.startActivity(intent)
            it.finish()
        }
    }
}