package com.example.twittersplash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.transition.Transition

class SplashFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var motionLayout: MotionLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        motionLayout = view.findViewById(R.id.motionLayout)

        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                Log.d(TAG, "onTransitionStarted")
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                Log.d(TAG, "onTransitionChange")
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId != R.id.start) {
                    Handler(Looper.myLooper()!!).post {
                        navController.navigate(R.id.action_splashFragment_to_homeFragment2)
                    }
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                Log.d(TAG, "onTransitionTrigger")
            }

        })

//        Handler(Looper.myLooper()!!).postDelayed({
//            navController.navigate(R.id.action_splashFragment_to_homeFragment2)
//        }, 5000)
    }

    companion object {
        private const val TAG = "SplashFragment"
    }


}