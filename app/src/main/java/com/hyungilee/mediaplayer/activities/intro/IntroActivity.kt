/**
 * @file IntroActivity.kt
 * @brief アプリ説明画面
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package com.hyungilee.mediaplayer.activities.intro

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.hyungilee.mediaplayer.R
import com.hyungilee.mediaplayer.activities.login.LoginFirstActivity
import com.hyungilee.mediaplayer.adapter.introduction.IntroductionPagerAdapter
import com.hyungilee.mediaplayer.utilities.NAVIGATION_KEY_IS_FROM_MY_PAGE

/**
 * @brief アプリ説明画面
 *
 * @par 概要
 * アプリの説明を表示する画面。
 * IntroductionFragmentを格納するためのViewPagerを持つ。
 *
 */
class IntroActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    /** スプラッシュ表示時間（ミリ秒）  */
    private val splashTime = 1000L
    /** Startボタン */
    private lateinit var startButton: Button
    /** ViewPager */
    private lateinit var pager: ViewPager
    /** TabLayout表示部分(４つのドットとして表示) */
    /** １番目のドット(imgPage1) */
    private lateinit var imgPage1: ImageView
    /** ２番目のドット(imgPage2) */
    private lateinit var imgPage2: ImageView
    /** ３番目のドット(imgPage3) */
    private lateinit var imgPage3: ImageView
    /** ４番目のドット(imgPage4) */
    private lateinit var imgPage4: ImageView

    /**
     * Activity生成時に呼び出される処理
     *
     * @param savedInstanceState Activity再生成時の保持データ
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val isFromMyPage = intent.getBooleanExtra(NAVIGATION_KEY_IS_FROM_MY_PAGE, false)
        // スプラッシュ画面を表示する。
        try {
            // Splash画面の表示遅延時間の設定
            Thread.sleep(splashTime)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        // スプラッシュ表示をメイン画面に切り替える
        setTheme(R.style.AppTheme)
        // レイアウトのセット
        setContentView(R.layout.activity_app_intro)
        // Navigation barを消す
//        ScreenSetting().immersiveMode(window)

        // アプリ説明画面の下に配置しているStartボタンの初期化
        startButton = findViewById(R.id.start_button)

        // アプリ説明イメージを見せるViewPagerの初期化
        pager = findViewById(R.id.pager)

        // TabLayoutの表示部分(４つのドットの初期化)
        // １番目のドットを初期化
        imgPage1 = findViewById(R.id.img_page1)

        // ２番目のドットを初期化
        imgPage2 = findViewById(R.id.img_page2)

        // ３番目のドットを初期化
        imgPage3 = findViewById(R.id.img_page3)

        // ４番目のドットを初期化
        imgPage4 = findViewById(R.id.img_page4)

        // ViewPagerにAdapterを設定
        pager.adapter = IntroductionPagerAdapter(supportFragmentManager, isFromMyPage)

        // ViewPagerにイベントリスナーを設定
        pager.addOnPageChangeListener(this)

        // Startボタンのイベント処理を設定
        startButton.setOnClickListener {


            // Startボタンを押したらログイン画面に遷移する
//            val intent = Intent(this, LoginFirstActivity::class.java)
//            startActivity(intent)

            if (isFromMyPage) {
                // マイページ画面から遷移した場合はLoginではなくfinishのみ
                finish()
            } else {
                // Startボタンを押したらログイン画面に遷移する
                val intent = Intent(this, LoginFirstActivity::class.java)

                startActivity(intent)
                finish()
            }

        }

        // TabLayoutのドットの初期表示設定
        // １番目のドットを黒色の丸形でセット
        imgPage1.setImageResource(R.drawable.black_circle)
        // ２番目のドットをグレー色の丸形でセット
        imgPage2.setImageResource(R.drawable.gray_circle)
        // ３番目のドットをグレー色の丸形でセット
        imgPage3.setImageResource(R.drawable.gray_circle)
        // ４番目のドットをグレー色の丸形でセット
        imgPage4.setImageResource(R.drawable.gray_circle)

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {


        when (position) {

            // 選択したページが１番目の場合
            0 -> {
                // １番目のドットを黒色の丸形でセット
                imgPage1.setImageResource(R.drawable.black_circle)
                // ２番目のドットをグレー色の丸形でセット
                imgPage2.setImageResource(R.drawable.gray_circle)
                // ３番目のドットをグレー色の丸形でセット
                imgPage3.setImageResource(R.drawable.gray_circle)
                // ４番目のドットをグレー色の丸形でセット
                imgPage4.setImageResource(R.drawable.gray_circle)

                startButton.text = getString(R.string.intro_activity_button_arrow_text)
            }

            // 選択したページが２番目の場合
            1 -> {
                // １番目のドットをグレー色の丸形でセット
                imgPage1.setImageResource(R.drawable.gray_circle)
                // ２番目のドットを黒色の丸形でセット
                imgPage2.setImageResource(R.drawable.black_circle)
                // ３番目のドットをグレー色の丸形でセット
                imgPage3.setImageResource(R.drawable.gray_circle)
                // ４番目のドットをグレー色の丸形でセット
                imgPage4.setImageResource(R.drawable.gray_circle)

                startButton.text = getString(R.string.intro_activity_button_arrow_text)
            }

            // 選択したページが３番目の場合
            2 -> {
                // １番目のドットをグレー色の丸形でセット
                imgPage1.setImageResource(R.drawable.gray_circle)
                // ２番目のドットをグレー色の丸形でセット
                imgPage2.setImageResource(R.drawable.gray_circle)
                // ３番目のドットを黒色の丸形でセット
                imgPage3.setImageResource(R.drawable.black_circle)
                // ４番目のドットをグレー色の丸形でセット
                imgPage4.setImageResource(R.drawable.gray_circle)

                startButton.text = getString(R.string.intro_activity_button_arrow_text)
            }

            // 選択したページが４番目の場合
            3 -> {
                // １番目のドットをグレー色の丸形でセット
                imgPage1.setImageResource(R.drawable.gray_circle)
                // ２番目のドットをグレー色の丸形でセット
                imgPage2.setImageResource(R.drawable.gray_circle)
                // ３番目のドットをグレー色の丸形でセット
                imgPage3.setImageResource(R.drawable.gray_circle)
                // ４番目のドットを黒色の丸形でセット
                imgPage4.setImageResource(R.drawable.black_circle)

                startButton.text = getString(R.string.intro_activity_button_text)
            }
        }
    }
}