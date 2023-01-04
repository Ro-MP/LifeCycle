package com.example.lifecycle

import timber.log.Timber
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.*

// Se agrega un contructor LifecycleObject y se implementa LifecycleObserver interface
//class Timer(lifecycle: Lifecycle) : LifecycleObserver {
class Timer : LifecycleEventObserver{

    var secondsCount = 0

    private var handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable

    // se conecta el lifecycle object a esta clase (observador)
    /*
    init {

        lifecycle.addObserver(this)
    }

     */


    // Anotacion que indica que el siguiente metodoo esta observando onStart lifecycle event
    //@OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer() {
        runnable = Runnable {
            secondsCount++
            Timber.i("Timer is at : $secondsCount")
            handler.postDelayed(runnable, 1000)
        }

        handler.postDelayed(runnable, 1000)
    }

    //@OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer() {
        handler.removeCallbacks(runnable)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_START -> {
                startTimer()
            }
            Lifecycle.Event.ON_STOP -> {
                stopTimer()
            }

            else -> { }
        }
    }


}


