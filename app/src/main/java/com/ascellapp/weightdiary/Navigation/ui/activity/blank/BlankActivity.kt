package com.ascellapp.weightdiary.Navigation.ui.activity.blank

import android.content.Context
import android.content.Intent
import android.os.Bundle

import com.omegar.mvp.presenter.InjectPresenter
import com.ascellapp.weightdiary.Navigation.R
import com.ascellapp.weightdiary.Navigation.presentation.view.blank.BlankView
import com.ascellapp.weightdiary.Navigation.presentation.presenter.blank.BlankPresenter

import                  com.ascellapp.weightdiary.Navigation.ui.activity.BaseActivity;


class BlankActivity : BaseActivity(), BlankView {
    companion object {
        const val TAG = "BlankActivity"
        fun getIntent(context: Context): Intent = Intent(context, BlankActivity::class.java)
    }

    @InjectPresenter
    lateinit var mBlankPresenter: BlankPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blank)
    }
}
