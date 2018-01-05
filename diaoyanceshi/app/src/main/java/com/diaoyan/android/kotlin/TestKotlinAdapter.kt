package com.diaoyan.android.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.diaoyan.android.R

/**
 * Created by chenshaolong on 2018/1/4.
 */
class TestKotlinAdapter(val items : List<String>) : RecyclerView.Adapter<TestKotlinAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.adapter_my_test_kotlin, parent))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.mTvName?.text = items[position]
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val mTvName = view.findViewById(R.id.tv_name) as  TextView
    }
}