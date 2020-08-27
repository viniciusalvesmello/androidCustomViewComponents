package io.github.viniciusalvesmello.androidcustomviewcomponents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        cbEditText.setOnClickListener {
            startActivity(Intent(this, CustomEditTextActivity::class.java))
        }
        cbButton.setOnClickListener {

        }
        cbContact.setOnClickListener {

        }
    }
}