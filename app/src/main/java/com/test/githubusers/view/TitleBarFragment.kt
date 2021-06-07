package com.test.githubusers.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.test.githubusers.R


interface TitleBarFragListener {
    fun titleBarBackAction()
    fun titleBarRightAction()
}

enum class TitleLeftType {
    CLOSE, BACK
}

enum class TitleRightType {
    LIGHT_FOCUS, BLACK
}

class TitleBarFragment : Fragment() {

    val TAG: String = TitleBarFragment::class.java.simpleName
    private var mListener: TitleBarFragListener? = null
    private lateinit var rightButton: Button
    private var mTitleText: String? = null
    private var mRightText: String? = null
    private var mLeftType = TitleLeftType.CLOSE
    private var mRightType = TitleRightType.LIGHT_FOCUS

    companion object {
        fun newInstance(title: String, leftType: TitleLeftType, listener: TitleBarFragListener): TitleBarFragment {
            val fragment = TitleBarFragment()
            val args = Bundle()
            args.putString("title", title)
            args.putSerializable("leftType", leftType)
            args.putString("rightText", "")
            args.putSerializable("rightType", TitleRightType.LIGHT_FOCUS)
            fragment.setArguments(args)
            fragment.setListener(listener)
            return fragment
        }
        fun newInstance(title: String,
                        leftType: TitleLeftType,
                        rightText: String,
                        rightType: TitleRightType,
                        listener: TitleBarFragListener): TitleBarFragment {
            val fragment = TitleBarFragment()
            val args = Bundle()
            args.putString("title", title)
            args.putSerializable("leftType", leftType)
            args.putString("rightText", rightText)
            args.putSerializable("rightType", rightType)
            fragment.setArguments(args)
            fragment.setListener(listener)
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_title_bar, container, false)
        if (this.arguments != null) {
            mTitleText = this.arguments!!.getString("title")
            mLeftType = this.arguments!!.getSerializable("leftType") as TitleLeftType
            mRightText = this.arguments!!.getString("rightText")
            mRightType = this.arguments!!.getSerializable("rightType") as TitleRightType
        }
        //Log.d(TAG, "onCreateView, mTitleText=" + mTitleText + ", mLeftType=" + mLeftType + ", mRightText=" + mRightText)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
        setupLeftButton(view)
        setupRightButton(view)
        setupTitleText(view)
    }

    private fun setupLeftButton(view: View) {
        val imgClose: ImageButton = view.findViewById(R.id.id_title_left_close)
        val imgBack: ImageButton = view.findViewById(R.id.id_title_left_back)
        if (mLeftType == TitleLeftType.BACK) {
            imgClose.visibility = View.GONE
            imgBack.visibility = View.VISIBLE
        }
        else {
            imgClose.visibility = View.VISIBLE
            imgBack.visibility = View.GONE
        }
        val leftButton: FrameLayout = view.findViewById(R.id.id_title_left_view)
        leftButton!!.setOnClickListener { view ->
            Log.d(TAG, "leftButton onClick")
            mListener?.titleBarBackAction()
        }
    }

    private fun setupRightButton(view: View) {
        rightButton = view.findViewById(R.id.id_title_right_button)
        if (!mRightText.isNullOrEmpty()) {
            rightButton.text = mRightText
            if (mRightType == TitleRightType.BLACK) {
                rightButton.setTextColor(getResources().getColor(R.color.darkText))
            }
            rightButton!!.setOnClickListener { view ->
                Log.d(TAG, "rightButton onClick")
                if (mRightType == TitleRightType.LIGHT_FOCUS) {
                    rightButton.setTextColor(getResources().getColor(R.color.darkText))
                }
                mListener?.titleBarRightAction()
            }
        }
        else {
            rightButton.text = ""
        }
    }

    private fun setupTitleText(view: View) {
        val txtView = view.findViewById<TextView>(R.id.id_title_txtview)
        if (mTitleText != null) {
            txtView.text = mTitleText
        }

    }

    fun updateRightColor(color: Int) {
        rightButton.setTextColor(color)
    }

    fun setListener(listener: TitleBarFragListener) {
        mListener = listener
    }



}