/**
 * @file SplashActivity.kt
 * @brief Splash画面
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package jp.co.bravogroup.leap.activities.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.hyungilee.mediaplayer.activities.MainActivity
import com.hyungilee.mediaplayer.R
import com.hyungilee.mediaplayer.activities.intro.IntroActivity


/**
 * @brief Splash画面のクラス
 *
 * @par 概要
 * アプリを起動する時に初期表示されるSplash画面のクラス
 * 画面上には真ん中でロゴが配置されています。
 */
class SplashActivity : AppCompatActivity() {

    // Splash画面を何秒ぐらい遅延表示する為のHandler
    private var mDelayHandler: Handler? = null

    //2秒遅延して画面表示
    private val splashDelay: Long = 2000

    private val mRunnable: Runnable = Runnable {

        // Splash画面を表示する時に初期化することを作成する部分
        val intent = Intent(this@SplashActivity, IntroActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Handlerを初期化する
        mDelayHandler = Handler()
        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, splashDelay)
    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

}



