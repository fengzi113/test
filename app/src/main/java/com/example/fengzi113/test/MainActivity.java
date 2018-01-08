package com.example.fengzi113.test;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view) {
        int score = 0;
        int question5Input = 0;
        String correct = "";
        RadioButton question1Answer = findViewById(R.id.rb_question1_answer);
        RadioButton question2Answer = findViewById(R.id.rb_question2_answer);
        CheckBox question3A = findViewById(R.id.cb_question3A);
        CheckBox question3Answer1 = findViewById(R.id.cb_question3_answer1);
        CheckBox question3Answer2 = findViewById(R.id.cb_question3_answer2);
        CheckBox question4Answer1 = findViewById(R.id.cb_question4_answer1);
        CheckBox question4Answer2 = findViewById(R.id.cb_question4_answer2);
        CheckBox question4Answer3 = findViewById(R.id.cb_question4_answer3);
        EditText question5 = findViewById(R.id.et_question5_answer);

        //        单选
        if (question1Answer.isChecked()) {
            score += 20;
        } else {
            correct = "1-B\n";
        }
        if (question2Answer.isChecked()) {
            score += 20;
        } else {
            correct = correct + "2-C\n";
        }
        //        多选
        if ((!question3A.isChecked()) & (question3Answer1.isChecked()) & (question3Answer2.isChecked())) {
            score += 20;
        } else {
            correct = correct + "3-BC\n";
        }
        if ((question4Answer1.isChecked()) & (question4Answer2.isChecked()) & (question4Answer3.isChecked())) {
            score += 20;
        } else {
            correct = correct + "4-ABC\n";
        }
        //        填空
        if (!question5.getText().toString().isEmpty()) {
            question5Input = Integer.parseInt(question5.getText().toString());
        }
        if (question5Input == 300000) {
            score += 20;
        } else {
            correct = correct + "5-300000\n";
        }
        //        更正
        if (score == 100) {
            correct = "无";
        }

        // 创建构建器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 设置参数
        builder.setTitle(R.string.alert_title);
        builder.setIcon(R.drawable.ic);
        builder.setMessage("\n\n错误更正：\n" + correct);
        final int finalScore = score;
        builder.setPositiveButton(R.string.score, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toasty.success(MainActivity.this, "\n满分100\n你的得分是： " + finalScore).show();

            }
        });
        builder.setNegativeButton(R.string.again, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setContentView(R.layout.activity_main);
            }
        });
        //        使alertDialog.builder不会点击外面和按返回键消失
        builder.setCancelable(false);
        builder.show();

    }

}
