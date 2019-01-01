package com.example.pcw69.pabixreproject;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView = null;
    private EditText editText = null;
    private Button button = null;
    private ImageButton black = null;
    private ImageButton gray = null;
    private ImageButton white = null;
    private ImageButton red = null;
    private ImageButton yellow = null;
    private ImageButton green = null;
    private ImageButton blue = null;
    private ImageButton purple = null;
    private TextView textView4 = null;
    private SeekBar seekBar = null;
    private Button color = null;
    private Button textsize = null;
    String sfName = "myFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textView = (TextView) this.findViewById(R.id.textView);
        this.editText = (EditText) this.findViewById(R.id.editText1);
        this.button = (Button) this.findViewById(R.id.button);
        this.black = (ImageButton) this.findViewById(R.id.black);
        this.gray = (ImageButton) this.findViewById(R.id.gray);
        this.white = (ImageButton) this.findViewById(R.id.white);
        this.red = (ImageButton) this.findViewById(R.id.red);
        this.yellow = (ImageButton) this.findViewById(R.id.yellow);
        this.green = (ImageButton) this.findViewById(R.id.green);
        this.blue = (ImageButton) this.findViewById(R.id.blue);
        this.purple = (ImageButton) this.findViewById(R.id.purple);
        this.textView4 = (TextView) this.findViewById(R.id.textView4);
        this.seekBar = (SeekBar) this.findViewById(R.id.seekBar);
        this.color = (Button) this.findViewById(R.id.color);
        this.textsize = (Button) this.findViewById(R.id.size);
        final ConstraintLayout colortap = (ConstraintLayout) findViewById(R.id.colortap);
        final ConstraintLayout sizetap = (ConstraintLayout) findViewById(R.id.sizetap);
        int size = 15;

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.pcw69.pabixreproject.sharedPreferences", Context.MODE_PRIVATE);
        size=sharedPreferences.getInt("size",35);
        textView4.setText(sharedPreferences.getString("textbox", "빠른메모"));
        editText.setText(sharedPreferences.getString("textbox", "빠른메모"));
        textView4.setTextColor(Color.parseColor(sharedPreferences.getString("color", "#FF000000")));

        seekBar.setMax(30);
        seekBar.setProgress(size-20);
        textView4.setTextSize(size-5);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textView4.setTextSize(progress + 15);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences sharedPreferences
                        = MainActivity.this.getSharedPreferences("com.example.pcw69.pabixreproject.sharedPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("size", seekBar.getProgress() + 20);
                editor.commit();

                Intent intent = new Intent(MainActivity.this, NewAppWidget.class);
                intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
                MainActivity.this.sendBroadcast(intent);
            }
        });

        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences
                        = MainActivity.this.getSharedPreferences("com.example.pcw69.pabixreproject.sharedPreferences", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                switch (v.getId()) {
                    case R.id.black:
                        editor.putString("color", "#FF000000");
                        textView4.setTextColor(Color.parseColor("#FF000000"));
                        break;
                    case R.id.gray:
                        editor.putString("color", "#FFAAAAAA");
                        textView4.setTextColor(Color.parseColor("#FFAAAAAA"));
                        break;
                    case R.id.white:
                        editor.putString("color", "#FFFFFFFF");
                        textView4.setTextColor(Color.parseColor("#FFFFFFFF"));
                        break;
                    case R.id.red:
                        editor.putString("color", "#FFFF4444");
                        textView4.setTextColor(Color.parseColor("#FFFF4444"));
                        break;
                    case R.id.yellow:
                        editor.putString("color", "#FFFFBB33");
                        textView4.setTextColor(Color.parseColor("#FFFFBB33"));
                        break;
                    case R.id.green:
                        editor.putString("color", "#FF99CC00");
                        textView4.setTextColor(Color.parseColor("#FF99CC00"));
                        break;
                    case R.id.blue:
                        editor.putString("color", "#FF33B5E5");
                        textView4.setTextColor(Color.parseColor("#FF33B5E5"));
                        break;
                    case R.id.purple:
                        editor.putString("color", "#FFAA66CC");
                        textView4.setTextColor(Color.parseColor("#FFAA66CC"));
                        break;
                }
                editor.commit();

                Intent intent = new Intent(MainActivity.this, NewAppWidget.class);
                intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
                MainActivity.this.sendBroadcast(intent);
            }
        };
        black.setOnClickListener(onClickListener);
        gray.setOnClickListener(onClickListener);
        white.setOnClickListener(onClickListener);
        red.setOnClickListener(onClickListener);
        yellow.setOnClickListener(onClickListener);
        green.setOnClickListener(onClickListener);
        blue.setOnClickListener(onClickListener);
        purple.setOnClickListener(onClickListener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView4.setText(editText.getText());
                Toast.makeText(MainActivity.this, "휴~ 까먹지 않았어", Toast.LENGTH_LONG).show();
                SharedPreferences sharedPreferences
                        = MainActivity.this.getSharedPreferences("com.example.pcw69.pabixreproject.sharedPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("textbox", MainActivity.this.textView4.getText().toString());
                editor.commit();

                Intent intent = new Intent(MainActivity.this, NewAppWidget.class);
                intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
                MainActivity.this.sendBroadcast(intent);
            }
        });
        color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sizetap.setVisibility(sizetap.INVISIBLE);
                if (colortap.getVisibility() == colortap.INVISIBLE)
                    colortap.setVisibility(colortap.VISIBLE);
                else if (colortap.getVisibility() == colortap.VISIBLE)
                    colortap.setVisibility(colortap.INVISIBLE);
            }
        });
        textsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                colortap.setVisibility(colortap.INVISIBLE);
                if (sizetap.getVisibility() == sizetap.INVISIBLE)
                    sizetap.setVisibility(sizetap.VISIBLE);
                else if (sizetap.getVisibility() == sizetap.VISIBLE)
                    sizetap.setVisibility(sizetap.INVISIBLE);
            }
        });
    }


    @Override
    public void onBackPressed() {
        //Toast.makeText(MainActivity.this, "휴~ 까먹지 않았어", Toast.LENGTH_LONG).show();

        super.onBackPressed();

        //위젯으로 브로드 캐스트를 보내는 코드
        Intent intent = new Intent(getApplicationContext(), NewAppWidget.class);
        intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        MainActivity.this.sendBroadcast(intent);
    }

}
