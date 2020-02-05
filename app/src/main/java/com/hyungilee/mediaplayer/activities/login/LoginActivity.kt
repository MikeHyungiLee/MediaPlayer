/**
 * @file LoginActivity.kt
 * @brief ログイン画面
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package com.hyungilee.mediaplayer.activities.login

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.hyungilee.mediaplayer.R
import com.hyungilee.mediaplayer.common.CommonMethod
import com.hyungilee.mediaplayer.extensions.getBackStackTag
import jp.co.bravogroup.leap.fragments.mypage.PrivacyPolicyFragment
import jp.co.bravogroup.leap.fragments.mypage.TermsOfUseFragment

/**
 * @brief ログイン画面
 *
 * @par 概要
 * アプリ説明画面の後に表示される、ログイン画面。
 * ログインID、パスワードの入力欄とパスワードを忘れた時のリンクそしてログインボタンを持つ。
 */
class LoginActivity : AppCompatActivity() {

    /**ログイン画面のID入力欄*/
    private lateinit var loginId: TextView
    /**ログイン画面のパスワード入力欄*/
    private lateinit var loginPassword: TextView
    /**ログイン画面の下に配置しているログインボタン*/
    private lateinit var loginButton: Button
    /** パスワードを忘れた時のリンク  */
    private lateinit var passwordFind: TextView
    /** 利用規約とプライバシーポリシーのチャックボックスのテキスト */
    private lateinit var checkBoxInstruction: TextView
    /** チェックボックス */
    private lateinit var checkBox: CheckBox

    /**
     * LoginActivity生成時に呼び出される処理
     *
     * @param savedInstanceState Activity再生成時の保持データ
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        // ログイン画面のID入力欄を初期化
        loginId = findViewById(R.id.login_id)
        // ログイン画面のパスワード入力欄を初期化
        loginPassword = findViewById(R.id.login_password)
        // ログイン画面のログインボタンを初期化
        loginButton = findViewById(R.id.login_button)
        loginButton.isEnabled = false
        loginButton.setBackgroundResource(R.drawable.login_button_inactive_design)
        // チェックボックスの初期化
        checkBox = findViewById(R.id.checkbox)

        loginId.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                checkEditText()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                checkEditText()
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEditText()
            }
        })

        loginPassword.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                checkEditText()
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                checkEditText()
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEditText()
            }
        })

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            // ログインIDの値
            val id = loginId.text.toString()

            // ログインパスワードの値
            val password = loginPassword.text.toString()

            when(isChecked && id.isNotEmpty() && password.isNotEmpty()) {
                true-> {
                    loginButton.isEnabled = true
                    loginButton.setBackgroundResource(R.drawable.login_button_design)
                }
                false->{
                    loginButton.isEnabled = false
                    loginButton.setBackgroundResource(R.drawable.login_button_inactive_design)
                }
            }
        }

        // ログイン画面のログインボタンを初期化
        loginButton = findViewById(R.id.login_button)
        // パスワードを忘れた時
        passwordFind = findViewById(R.id.find_password)

        passwordFind.setOnClickListener {

        }
        /** 利用規約とプライバシーポリシーのチャックボックスのTextViewの初期化 */
        checkBoxInstruction = findViewById(R.id.checkbox_instruction)
        val instructionText = "続行することで、利用規約およびプライバシーに同意するものとみなされます。"
        val spannableString = SpannableString(instructionText)
        val spannableStringBuilder = SpannableStringBuilder(instructionText)
        // Clickable テキストに設定する色
        spannableStringBuilder.setSpan(object : ClickableSpan(){

            override fun onClick(widget: View) {

                // 画面上に表示されているSoft Keyboardを閉じる
                CommonMethod().hideKeyboard(this@LoginActivity)

                val termsOfUseFragment = TermsOfUseFragment.newInstance()

                loadFragment(termsOfUseFragment)
            }
            override fun updateDrawState(ds: TextPaint) {
                ds.color = Color.BLUE
            }
        },8,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableStringBuilder.setSpan(object : ClickableSpan(){
            override fun onClick(widget: View) {
                // 画面上に表示されているSoft Keyboardを閉じる
                CommonMethod().hideKeyboard(this@LoginActivity)
                val privacyPolicyFragment = PrivacyPolicyFragment.newInstance()
                loadFragment(privacyPolicyFragment)
            }
            override fun updateDrawState(ds: TextPaint) {
                ds.color = Color.BLUE
            }

        },15,21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        checkBoxInstruction.movementMethod
        checkBoxInstruction.text = spannableStringBuilder
        checkBoxInstruction.movementMethod= LinkMovementMethod.getInstance()
        // ログイン画面のID入力欄の背景色にAlpha値を設定
        loginId.alpha = 0.4f
        // ログイン画面のパスワード入力欄の背景色にAlpha値を設定
        loginPassword.alpha = 0.4f

    }

    private fun checkEditText(){
        if(loginId.text.isNotEmpty() && loginPassword.text.isNotEmpty() && checkBox.isChecked){
            loginButton.isEnabled = true
            loginButton.setBackgroundResource(R.drawable.login_button_design)
        }else{
            loginButton.isEnabled = false
            loginButton.setBackgroundResource(R.drawable.login_button_inactive_design)
        }
    }

    /**
     * @brief フラグメントを切り替える
     *
     * @par 概要
     * 切り替えるフラグメント
     *
     * @par 処理
     * 引数としてもらったフラグメント変数がヌルじゃない場合は
     * FragmentManagerを使ってフレイムレイアウトの中のフラグメントを切り替える
     *
     * @param fragment 画面に表示するフラグメント
     * @return なし
     */
    fun loadFragment(fragment : Fragment){

        // 引数としてもらったfragment変数がヌルじゃない場合

        supportFragmentManager
            .beginTransaction()
            // 引数としてもらったフラグメントの通りに表示するフラグメントを切り替える
            .replace(R.id.first_login_container,fragment)
            .addToBackStack(fragment.getBackStackTag())
            .commit()

    }
}