package com.example.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_result;
    private Button button_calculate;
    private Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_square;
    private ImageView iv_circle;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedShape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator"); //sets the title of the app (green part at the top

        //get the view by ID
        et_length1 = findViewById(R.id.et_length1);
        et_length2 = findViewById(R.id.et_length2);
        tv_result = findViewById(R.id.tv_result);
        tv_shape = findViewById(R.id.tv_shapeSelection);
        button_calculate = findViewById(R.id.button_calculate);
        button_clear = findViewById(R.id.button_clear);
        iv_triangle = findViewById(R.id.iv_triangle);
        iv_square = findViewById(R.id.iv_square);
        iv_circle = findViewById(R.id.iv_circle);

        clearButton();

        final float length1;
        final float length2;

        String tempLength1 = et_length1.getText().toString();
        String tempLength2 = et_length2.getText().toString();

        if (tempLength1 != null && !tempLength1.equals(""))
            length1 = Float.parseFloat(tempLength1);         //parse length 1 as a float because it would be returning a string if not

        if (tempLength2 != null && !tempLength2.equals(""))
            length2 = Float.parseFloat(tempLength2);

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });

        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "triangle";
                tv_shape.setText("Triangle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.VISIBLE);
            }
        });

//        TODO: On CLICK for Square...
//        TODO: On CLICK for Circle...

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_length1.getText().toString().equals("")) {
                    et_length1.setError("Hey I need a value");
                }

                if(et_length2.getText().toString().equals("")) {
                    et_length2.setError("Hey I need a value");
                }


                switch(selectedShape) {
                    case "triangle";
                    float result = (float) (0.5 * length1 * length2);   //TODO: FIX AS DOUBLE
                    tv_result.setText(result+"");
                }
            }
        });

    }

    //set back to the default state when clear is selected
    public void clearButton() {
        et_length1.setVisibility(View.VISIBLE); //makeing sure the length labels are visible
        et_length2.setVisibility(View.VISIBLE);
        et_length1.setText("");
        et_length2.setText("");
        tv_shape.setText("Select a shape");
        tv_result.setText("");
        selectedShape = "none";
    }

    public void calculateButton() {

    }

}
