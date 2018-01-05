package com.diaoyan.android.kotlin

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.diaoyan.android.BaseActivity
import com.diaoyan.android.R
import kotlinx.android.synthetic.main.activity_my_test_kotlin.*
import org.jetbrains.anko.*

/**
 * Created by chenshaolong on 2018/1/2.
 */
class TestKotlinActivity : BaseActivity() {

    internal var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_test_kotlin)
//        mContext = this
//        recycler_view.layoutManager = LinearLayoutManager(mContext)

        doAsync {
            uiThread {
                alert("你确定删除吗？", "删除信息") {
                    okButton {

                    }

                    noButton {

                    }
                }.show()
            }
        }


//        val items = listOf(
//                "1111",
//                "2222",
//                "3333",
//                "4444"
//        )
//        recycler_view.adapter = TestKotlinAdapter(items)
    }


}