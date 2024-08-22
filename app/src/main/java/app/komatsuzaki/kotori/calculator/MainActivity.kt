package app.komatsuzaki.kotori.calculator

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.komatsuzaki.kotori.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //　バインディングクラスの変数
    private lateinit var binding: ActivityMainBinding

    // 1番目に入力される変数を作る
    var firstNumber = 0

    // 2番目に入力される変数を作る
    var secondNumber = 0

    // 合計を入れる変数を作る
    var totalNumber = 0

    // 符号の入力をもつ変数を、最初はempty(空)で作る
    var operator = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        // 画面起動時は、符号ボタンと等号ボタンを灰色にする
        binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
        binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))

        //　画面起動時は、符号ボタンと統合ボタンを利用できないようにする
        binding.plusButton.isEnabled = false
        binding.minusButton.isEnabled = false
        binding.multiplyButton.isEnabled = false
        binding.equalButton.isEnabled = false

        //一番目に入力される変数を、TextViewに反映する
        binding.numberText.text = firstNumber.toString()

        //ボタン0がタップされたら
        binding.numberButton0.setOnClickListener { inputNumber(0) }
        /*
            // 符号の入力状態をもつ変数が、empty(空)が、emptyでは内科で処理する
            if(operator == "empty") {inputNumber(0)}


                // １番目に入力された数字を10倍にして0を足し算する
                firstNumber = firstNumber * 10 + 0
                //数字を表示するTextViewに反映する
                binding.numberText.text = firstNumber.toString()
                // + - ×ボタンを黄色にする→緑にする
                binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,240,0))
                binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,240,0))
                binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(0,240,0))

                // 符号ボタンと等号ボタンを利用できるようにする
                binding.plusButton.isEnabled = true
                binding.minusButton.isEnabled = true
                binding.multiplyButton.isEnabled = true
                binding.equalButton.isEnabled = true
            } else {
                // 2番目に入力された数字を10倍にして0を足し算する
                secondNumber = secondNumber * 10 + 0
                //　数字を表示するTextViewに反映する
                binding.numberText.text = secondNumber.toString()
                // 等号ボタンを黄色にする
                binding.equalButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150,150,150))
            }

             */

        // ボタン1がタップされたら
        binding.numberButton1.setOnClickListener {
            inputNumber(1)
        }

        // ボタン2がタップされたら
        binding.numberButton2.setOnClickListener {
            inputNumber(2)
        }

        // ボタン3がタップされたら
        binding.numberButton3.setOnClickListener {
            inputNumber(3)
        }

        // ボタン4がタップされたら
        binding.numberButton4.setOnClickListener {
            inputNumber(4)
        }

        // ボタン5がタップされたら
        binding.numberButton5.setOnClickListener {
            inputNumber(5)
        }
        // ボタン6タップされたら
        binding.numberButton6.setOnClickListener {
            inputNumber(6)
        }

        // ボタン7がタップされたら
        binding.numberButton7.setOnClickListener {
            inputNumber(7)
        }

        // ボタン8がタップされたら
        binding.numberButton8.setOnClickListener {
            inputNumber(8)
        }

        // ボタン9がタップされたら
        binding.numberButton9.setOnClickListener {
            inputNumber(9)
        }

        // + ボタンがタップされたら
        binding.plusButton.setOnClickListener {
            // + ボタンを赤色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(220, 0, 100))
            // - かけるボタンを灰色にする
            binding.minusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            // 符号を入れる変数に　+ を表す「plus」という文字を入れる
            operator = "plus"
            // 2番目に入力された数字を、TextViewに反映する
            binding.numberText.text = secondNumber.toString()
        }


        // - ボタンがタップされたら
        binding.minusButton.setOnClickListener {
            // - ボタンを赤色にする
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(220, 0, 100))
            // + かけるボタンを灰色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            // 符号を入れる変数に　- を表す「minus」という文字を入れる
            operator = "minus"
            // 2番目に入力された数字を、TextViewに反映する
            binding.numberText.text = secondNumber.toString()
        }

        // × ボタンがタップされたら
        binding.multiplyButton.setOnClickListener {
            // + ボタンを赤色にする
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(220, 0, 100))
            // - かけるボタンを灰色にする
            binding.minusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            // 符号を入れる変数に　+ を表す「plus」という文字を入れる
            operator = "multiply"
            // 2番目に入力された数字を、TextViewに反映する
            binding.numberText.text = secondNumber.toString()
        }

        // = ボタンがタップされたら
        binding.equalButton.setOnClickListener {
            if (operator == "plus") {
                // 符号が+だったら足し算する
                totalNumber = firstNumber + secondNumber
            } else if (operator == "minus") {
                // 符号が-だったら、引き算する
                totalNumber = firstNumber - secondNumber
            } else if (operator == "multiply") {
                totalNumber = firstNumber * secondNumber
            }


            // 符号と等号ボタンを灰色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.minusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.equalButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))

            // 1,2番目に入力される数字を入れる変数を0にセット
            firstNumber = 0
            secondNumber = 0

            //符号の入力状態をもつ変数を、emptyにセット
            operator = "empty"
            // 合計をTextViewに表示
            binding.numberText.text = totalNumber.toString()
        }

        // Cボタンがタップされたら
        binding.clearButton.setOnClickListener {
            //符号と等号ボタンを灰色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.minusButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.multiplyButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))
            binding.equalButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(150, 150, 150))

            //1,2番目に入力される数字と、合計を入れる変数を0にセット
            firstNumber = 0
            secondNumber = 0
            totalNumber = 0
            //符号の入力状態を持つ変数をemptyにセット
            operator = "empty"
            // 合計をTextViewに表示
            binding.numberText.text = totalNumber.toString()
        }
    }

    private fun inputNumber(number: Int) {
        if (operator == "empty") {
            //1番目に入力された数字を10倍にして1を足し算する
            firstNumber = firstNumber * 10 + number
            // 数字を表示するTextViewに反映する
            binding.numberText.text = firstNumber.toString()
            // + - ×ボタンを黄色にする
            binding.plusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240, 240, 0))
            binding.minusButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240, 240, 0))
            binding.multiplyButton.backgroundTintList = ColorStateList.valueOf(Color.rgb(240, 240, 0))

            // 符号ボタンを統合ボタンを利用できるようにする
            binding.plusButton.isEnabled = true
            binding.minusButton.isEnabled = true
            binding.multiplyButton.isEnabled = true
            binding.equalButton.isEnabled = true
        } else {
            secondNumber = secondNumber * 10 + number
            //数字を表示するTextViewに反映する
            binding.numberText.text = secondNumber.toString()
            //等号ボタンを黄色にする
            binding.equalButton.backgroundTintList =
                ColorStateList.valueOf(Color.rgb(240, 240, 240))

        }


    }
}
