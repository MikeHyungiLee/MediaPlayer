/**
 * @file PrivacyPolicyFragment.kt
 * @brief プライバシーポリシーの内容を表示するフラグメント
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
import com.hyungilee.mediaplayer.extensions.backFragment

/**
 * @brief プライバシーポリシーの内容を表示するフラグメント
 */
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PrivacyPolicyFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PrivacyPolicyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrivacyPolicyFragment : Fragment() {

    private lateinit var privacyPolicyTextView: TextView

    private lateinit var backButton: ImageView

    companion object {
        val TAG = PrivacyPolicyFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = PrivacyPolicyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_privacy_policy, container, false)
        // プライバシーポリシーの内容を表示するテキストビュー
        privacyPolicyTextView = view.findViewById(R.id.privacy_policy_text_view)
        val privacyPolicyText = getString(R.string.privacy_policy_text)
        // string.xmlからプライバシーポリシーのテキストを取得
        privacyPolicyTextView.text = privacyPolicyText
        // テキストのサイズを設定
        privacyPolicyTextView.textSize = 12.0f
        // 以前の画面に遷移するボタン
        backButton = view.findViewById(R.id.back_button)
        // backButtonのクリックイベント
        backButton.setOnClickListener {
            backFragment()
        }

        return view
    }

}
