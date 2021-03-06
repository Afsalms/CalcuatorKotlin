package com.example.qbuser.calcuatorkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var isLastNumber = true
    var isLastDot = false
    var isError = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonOne = findViewById<Button>(R.id.button_first)
        val buttonTwo = findViewById<Button>(R.id.button_two)
        val buttonThree = findViewById<Button>(R.id.button_three)
        val buttonFour = findViewById<Button>(R.id.button_four)
        val buttonFive = findViewById<Button>(R.id.button_five)
        val buttonSix = findViewById<Button>(R.id.button_six)
        val buttonSeven = findViewById<Button>(R.id.button_seven)
        val buttonEight = findViewById<Button>(R.id.button_eight)
        val buttonNine = findViewById<Button>(R.id.button_nine)
        val buttonDot = findViewById<Button>(R.id.button_dot)
        val buttonZero = findViewById<Button>(R.id.button_zero)
        val buttonClear = findViewById<Button>(R.id.button_clear)
        val buttonPlus = findViewById<Button>(R.id.button_plus)
        val buttonMinus = findViewById<Button>(R.id.button_minus)
        val buttonDivision = findViewById<Button>(R.id.button_division)
        val buttonMultiplcation = findViewById<Button>(R.id.button_multiply)
        val buttonEqual = findViewById<Button>(R.id.button_result)

        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
        buttonFour.setOnClickListener(this)
        buttonFive.setOnClickListener(this)
        buttonSix.setOnClickListener(this)
        buttonSeven.setOnClickListener(this)
        buttonEight.setOnClickListener(this)
        buttonNine.setOnClickListener(this)
        buttonDot.setOnClickListener(this)
        buttonZero.setOnClickListener(this)
        buttonClear.setOnClickListener(this)
        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonDivision.setOnClickListener(this)
        buttonMultiplcation.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)
    }

    override  fun onClick(v: View?){
        val resultTextView = findViewById<TextView>(R.id.result)
        val clickedButton = v as Button
        when(v.id){
            R.id.button_first, R.id.button_two,
            R.id.button_three, R.id.button_four,
            R.id.button_five, R.id.button_six,
            R.id.button_seven, R.id.button_eight,
            R.id.button_nine, R.id.button_zero -> {
                                    if(!isError){
                                        resultTextView.text = resultTextView.text.toString() +
                                                clickedButton.text.toString()
                                        isLastNumber = true
                                    }
                                 }
            R.id.button_dot -> {
                                    if(!isError && !isLastDot){
                                        resultTextView.text = resultTextView.text.toString() +
                                                getString(R.string.dot)
                                        isLastDot = true

                                    }
                                }
            R.id.button_clear -> {
                                    resultTextView.text = ""
                                    isLastDot = false
                                    isLastNumber = true
                                    isError = false

                                    }
            R.id.button_multiply, R.id.button_plus,
            R.id.button_minus, R.id.button_division -> {
                                            if(isLastNumber && !isError){
                                                resultTextView.text = resultTextView.text.toString() +
                                                        clickedButton.text.toString()
                                                isLastNumber = false
                                                isLastDot = false
                                            }
                                    }
            R.id.button_result -> {
                if (isLastNumber && !isError) {
                    var experssionString = resultTextView.text.toString()
                    val expression = ExpressionBuilder(experssionString).build()
                    try {
                        var result = expression.evaluate()
                        resultTextView.text = result.toString()
                        isLastDot = true
                    } catch (e:Exception) {
                        isError = true
                        val errorString = "Error"
                        resultTextView.text = errorString
                    }
                }

            }
        }
    }
}
