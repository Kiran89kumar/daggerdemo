package com.kiran.daggerpoc

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kiran.data.db.BlogDAO
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity2 : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var demo: String

    @Inject
    lateinit var blogDAO: BlogDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("KIRAN", "Demo 2: $demo")
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}