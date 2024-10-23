package com.example.a0927

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var ed_Name: EditText
    private lateinit var tv_Text: TextView
    private lateinit var tv_Name: TextView
    private lateinit var tv_Winner: TextView
    private lateinit var tv_Mmora: TextView
    private lateinit var tv_Cmora: TextView
    private lateinit var btn_Scissor: RadioButton
    private lateinit var btn_Stone: RadioButton
    private lateinit var btn_Paper: RadioButton
    private lateinit var btn_Mora: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed_Name = findViewById(R.id.ed_name)

        tv_Text = findViewById(R.id.tv_text)
        tv_Name = findViewById(R.id.tv_name)
        tv_Winner = findViewById(R.id.tv_winner)
        tv_Mmora = findViewById(R.id.tv_mmora)
        tv_Cmora = findViewById(R.id.tv_cmora)

        btn_Scissor = findViewById(R.id.btn_scissor)
        btn_Stone = findViewById(R.id.btn_stone)
        btn_Paper = findViewById(R.id.btn_paper)

        btn_Mora = findViewById(R.id.btn_mora)

        btn_Mora.setOnClickListener {
            if (ed_Name.length() < 1) {
                tv_Text.text = "請輸入玩家姓名"
            } else {
                tv_Name.text = "名字\n${ed_Name.text}"

                tv_Mmora.text = when {
                    btn_Scissor.isChecked -> "我方出拳\n剪刀"
                    btn_Stone.isChecked -> "我方出拳\n石頭"
                    else -> "我方出拳\n布"
                }

                val computerRandom = (0..2).random()
                tv_Cmora.text = when (computerRandom) {
                    0 -> "電腦出拳\n剪刀"
                    1 -> "電腦出拳\n石頭"
                    else -> "電腦出拳\n布"
                }

                when {
                    (btn_Scissor.isChecked && computerRandom == 2) ||
                            (btn_Stone.isChecked && computerRandom == 0) ||
                            (btn_Paper.isChecked && computerRandom == 1) -> {
                        tv_Winner.text = "勝利者\n${ed_Name.text}"
                        tv_Text.text = "恭喜您獲勝了！！！"
                    }
                    (btn_Scissor.isChecked && computerRandom == 1) ||
                            (btn_Stone.isChecked && computerRandom == 2) ||
                            (btn_Paper.isChecked && computerRandom == 0) -> {
                        tv_Winner.text = "勝利者\n電腦"
                        tv_Text.text = "可惜，電腦獲勝了！"
                    }
                    else -> {
                        tv_Winner.text = "勝利者\n平手"
                        tv_Text.text = "平局，請再試一次！"
                    }
                }
            }
        }
    }
}
