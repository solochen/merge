package com.diaoyan.android.kotlin

import android.app.Activity
import android.widget.Toast
import com.diaoyan.android.DesApp
import com.sololibrary.library.utils.NetUtil

/**
 * Created by chenshaolong on 2018/1/2.
 */
fun main(args: Array<String>) {

}



class Demo(var name:String, var age:Int) {

    init {
        name = name + "123"
        age = age + 100
    }

    companion object {
        private val APP_ID = "asdf4123324asdfgas5d4gewrbde"
    }


    fun show(){
        println(name)
        println(age)
    }


}


class Worker(private val s: () -> Unit){
    fun work () {
        println("start")
        s.invoke()
        println("end")
    }
}
