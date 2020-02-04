/**
 * @file TermsOfUseFragment.kt
 * @brief 利用規約に関する内容を表示するフラグメント
 *
 * @author 李 鉉基(LEE HYUNGI)
 * @date 2020.02.04
 */
package jp.co.bravogroup.leap.fragments.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hyungilee.mediaplayer.R
import com.hyungilee.mediaplayer.activities.login.LoginFirstActivity
import com.hyungilee.mediaplayer.extensions.backFragment

/**
 * @brief 利用規約内容を表示するフラグメント
 */
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TermsOfUseFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TermsOfUseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TermsOfUseFragment : Fragment() {

    // 利用規約の内容を表示するテキストビュー
    private lateinit var termsOfUseTextView: TextView

    // 以前の画面に遷移するボタン
    private lateinit var backButton: ImageView

    companion object {
        val TAG = TermsOfUseFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = TermsOfUseFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_terms_of_use, container, false)
        // 利用規約のテキスト表示(TextView)
        termsOfUseTextView =view.findViewById(R.id.terms_of_use_text_view)
        // String.xmlでの利用規約のStringを取得
        val termsOfUseText = getString(R.string.terms_of_use_text)
        // テキストビューに利用規約の内容を設定
        termsOfUseTextView.text = termsOfUseText
        // テキストビューに表示するテキストのサイズを設定
        termsOfUseTextView.textSize = 12.0f
        backButton = view.findViewById(R.id.back_button)
        // backButtonのクリックイベント
        backButton.setOnClickListener {
            if(activity is LoginFirstActivity){
               val loginActivity = activity as LoginFirstActivity
                   loginActivity.supportFragmentManager.popBackStack()
            }else {
                backFragment()
            }
        }
        return view
    }

}
