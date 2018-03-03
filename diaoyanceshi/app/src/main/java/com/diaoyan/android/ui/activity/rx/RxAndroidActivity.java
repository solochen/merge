package com.diaoyan.android.ui.activity.rx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.diaoyan.android.R;
import com.diaoyan.android.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenshaolong on 2018/3/1.
 */

public class RxAndroidActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxandroid);
//        schedulerDemo1();
        demo();
    }


    private void flowableMethod1() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {

            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {

                for (int i = 0; i < 10000; i++) {
                    e.onNext(i);
                }
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("RxAndroid", integer.toString());
                        Thread.sleep(1000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("RxAndroid", throwable.toString());
                    }
                });
    }

    private void flowableMethod2() {
        Flowable.range(0, 10000)
                .onBackpressureDrop()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("RxAndroid", integer.toString());
                    }
                });
    }

    private void schedulerDemo1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 5; i++) {
                    Log.e("RxAndroid", "发射线程：" + Thread.currentThread().getName() + "-->" + i);
                    Thread.sleep(1000);
                    e.onNext(i);
                }
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
          .observeOn(Schedulers.newThread())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        integer = integer + 1000;
                        Log.e("RxAndroid", "处理线程：" + Thread.currentThread().getName() + "-->" + integer);
                        return integer;
                    }
                })
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.e("RxAndroid", "接收线程：" + Thread.currentThread().getName() + "-->" + integer);
                    }
          });
    }

    private void demo(){

        Integer[] a = new Integer[] {1, 2, 3, 4};
        String[] str = new String[] {"苹果", "香蕉", "梨", "火龙果", "猕猴桃"};

        Disposable disposable = Observable
                .fromArray(a)
                .zipWith(Observable.fromArray(str), new BiFunction<Integer, String, String>() {
                    @Override
                    public String apply(Integer integer, String s) throws Exception {

                        return s + integer;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Log.e("RxAndroid", "接收线程：" + Thread.currentThread().getName() + "-->" + s);
                    }
                });

    }
}
