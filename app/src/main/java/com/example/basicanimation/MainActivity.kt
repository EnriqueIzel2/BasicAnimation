package com.example.basicanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val sanji = findViewById<LottieAnimationView>(R.id.sanji_anim)
    val blogging = findViewById<LottieAnimationView>(R.id.blogging_anim)
    val btnController = findViewById<Button>(R.id.btn_controller)

    sanji.repeatCount = LottieDrawable.INFINITE
    blogging.repeatCount = LottieDrawable.INFINITE

    btnController.setOnClickListener {
      if (btnController.text == "Start Animation") {
        btnController.setText("Pause Animation")
      } else {
        btnController.setText("Start Animation")
      }

      animatorManager(sanji)
      animatorManager(blogging)
    }
  }

  private fun animatorManager(anim: LottieAnimationView) {
    if (anim.isAnimating) {
      anim.pauseAnimation()
    } else {
      anim.playAnimation()
    }
  }
}
