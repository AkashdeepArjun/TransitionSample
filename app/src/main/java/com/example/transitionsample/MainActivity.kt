package com.example.transitionsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.ViewGroup
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.example.transitionsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding?=null
    //          ANIMATION LAYOUT VARIABLES


    private  lateinit var scene_root:ViewGroup

    private lateinit var scene_a:androidx.transition.Scene

    private lateinit var scene_b:androidx.transition.Scene


    private lateinit var transition:androidx.transition.Transition


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        initializeStuff()
        setupListeners()
    }


    fun initializeStuff(){
        scene_root=binding!!.sceneRoot
        scene_a= androidx.transition.Scene.getSceneForLayout(scene_root,R.layout.scene_a,this)
        scene_b=androidx.transition.Scene.getSceneForLayout(scene_root,R.layout.scene_b,this)
//        transition=AutoTransition()             // WAY 1: auto transition
        transition=androidx.transition.TransitionInflater.from(this).inflateTransition(R.transition.fade_one_transition)

    }

    fun setupListeners(){

        binding!!.transitionButton.setOnClickListener {

            TransitionManager.go(scene_b,transition)

        }


    }



    override fun onDestroy() {
        super.onDestroy()
        binding=null
    }
}