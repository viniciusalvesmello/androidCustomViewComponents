package io.github.viniciusalvesmello.test.extension

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.textfield.TextInputLayout
import io.github.viniciusalvesmello.test.R

fun View.tilCustomEditText(): TextInputLayout = findViewById(R.id.tilCustomEditText)

fun View.pbCustomButton(): ProgressBar = findViewById(R.id.pbCustomButton)

fun View.ivCustomButton(): AppCompatImageView = findViewById(R.id.ivCustomButton)

fun View.tvCustomButton(): AppCompatTextView = findViewById(R.id.tvCustomButton)