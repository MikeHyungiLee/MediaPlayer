package com.hyungilee.mediaplayer.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hyungilee.mediaplayer.R
import com.hyungilee.mediaplayer.model.UserAccount

class MainActivity : AppCompatActivity() {

    /** ログインする時のアカウント情報*/
    private lateinit var loginAccount: UserAccount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
