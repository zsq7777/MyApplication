package com.able

import android.content.DialogInterface
import android.util.Log

/**
 * Create by 赵思琦 on 2022/3/28
 * email zsqandzyr@gmail.com
 */
class Test {
    lateinit var mListener: (String) -> Unit

    fun setListener(listener: (String) -> Unit) {
        this.mListener = listener
    }

    fun work(){
        mListener.invoke("测试")
    }

}