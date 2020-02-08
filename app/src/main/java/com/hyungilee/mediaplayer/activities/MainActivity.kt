package com.hyungilee.mediaplayer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hyungilee.mediaplayer.R
import com.hyungilee.mediaplayer.extensions.getBackStackTag
import com.hyungilee.mediaplayer.fragments.music.MusicPlayerFragment
import com.hyungilee.mediaplayer.fragments.navigation.DownloadFragment
import com.hyungilee.mediaplayer.fragments.navigation.MusicFragment
import com.hyungilee.mediaplayer.fragments.navigation.MyPageFragment
import com.hyungilee.mediaplayer.fragments.navigation.VideoFragment
import com.hyungilee.mediaplayer.fragments.video.VideoPlayerFragment
import com.hyungilee.mediaplayer.model.UserAccount
import com.hyungilee.mediaplayer.utilities.EXTRA_LOGIN_ACCOUNT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    /** ログインする時のアカウント情報*/
    private lateinit var loginAccount: UserAccount
    /** 画面に表示するフラグメント */
    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ログインアカウント情報を取得する
        loginAccount = intent.getParcelableExtra(EXTRA_LOGIN_ACCOUNT)

        // 初期画面に表示するフラグメントを設定する
        fragment = MusicFragment()
        loadFragment(fragment)

        // Bottom NavigationViewのアイテムリスナーを設定する
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
    }

    /**
     * @brief Bottom Navigationでのメニューイベント処理
     *
     * クリックしたBottom Navigationメニューによっと見せるフラグメントを切り替える
     *
     * @return @OnNavigationItemSelectedListener true
     */
    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                // Bottom Navigationメニューの中でMusic Tabをクリックした時の処理
                R.id.navigation_music -> {
                    Toast.makeText(this, "Music tab",Toast.LENGTH_SHORT).show()
                    fragment = MusicFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                // Bottom Navigationメニューの中でVideo Tabをクリックした時の処理
                R.id.navigation_movie -> {
                    Toast.makeText(this, "Video tab",Toast.LENGTH_SHORT).show()
                    fragment = VideoFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                // Bottom Navigationメニューの中でDownload Tabをクリックした時の処理
                R.id.navigation_download -> {
                    Toast.makeText(this, "Download tab",Toast.LENGTH_SHORT).show()
                    fragment = DownloadFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                // Bottom Navigationメニューの中でMyPage Tabをクリックした時の処理
                R.id.navigation_mypage -> {
                    Toast.makeText(this, "MyPage tab",Toast.LENGTH_SHORT).show()
                    fragment = MyPageFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    /**
     * @brief フラグメントを切り替える
     * @par 概要
     * 切り替えるフラグメント
     * @par 処理
     * 引数としてもらったフラグメント変数がヌルじゃない場合は
     * FragmentManagerを使ってフレイムレイアウトの中のフラグメントを切り替える
     * @param fragment 画面に表示するフラグメント
     * @return なし
     */
    private fun loadFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                // 引数としてもらったフラグメントの通りに表示するフラグメントを切り替える
                .replace(R.id.main_container, fragment)
                .addToBackStack(fragment.getBackStackTag())
                .commit()
    }
}
