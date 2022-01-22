package com.djetops.flightsupportclient.common.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import helper.kotlin.android.com.newyorktimesarticles.databinding.ViewTopBarBinding


public class CustomTopBar : RelativeLayout, View.OnClickListener {

    internal lateinit var binding: ViewTopBarBinding
    internal var mContext: Context

    constructor(context: Context) : super(context) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mContext = context
        init()
    }


    private fun init() {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = ViewTopBarBinding.inflate(inflater, this, true)
        binding.btnBack.setOnClickListener(this)
    }

    public fun showBackBtn()
    {
        binding.btnBack.visibility=View.VISIBLE
    }


    override fun onClick(view: View) {
        when (view.id) {
        }
    }

}



