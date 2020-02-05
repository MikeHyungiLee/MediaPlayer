/**
 * @file IntroductionPagerAdapter.kt
 * @brief アプリ説明画面の内部で配置しているViewPagerに使うAdapter
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package com.hyungilee.mediaplayer.adapter.introduction

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hyungilee.mediaplayer.R
import jp.co.bravogroup.leap.fragments.introduction.IntroductionFragmentFirst
import jp.co.bravogroup.leap.fragments.introduction.IntroductionFragmentFourth
import jp.co.bravogroup.leap.fragments.introduction.IntroductionFragmentSecond
import jp.co.bravogroup.leap.fragments.introduction.IntroductionFragmentThird

/**
 * @brief IntroductionPagerに使うIntroductionPagerAdapterクラス
 *
 * @par 概要
 * ViewPagerのchildFragmentの設定
 */
class IntroductionPagerAdapter(fm: FragmentManager, isFromMyPage: Boolean) : FragmentPagerAdapter(fm) {

    // Fragmentを要素として持つArrayList変数
    private var childFragment = arrayListOf<Fragment>()

    init {
        childFragment.add(IntroductionFragmentFirst.newInstance(isFromMyPage))
        childFragment.add(IntroductionFragmentSecond.newInstance(isFromMyPage))
        childFragment.add(IntroductionFragmentThird.newInstance(isFromMyPage))
        childFragment.add(IntroductionFragmentFourth.newInstance(isFromMyPage))
    }

    override fun getItem(position: Int): Fragment {

        return childFragment[position]
    }

    override fun getCount(): Int {

        return childFragment.size
    }

}