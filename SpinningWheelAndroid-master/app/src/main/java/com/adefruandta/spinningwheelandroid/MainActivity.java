package com.adefruandta.spinningwheelandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.adefruandta.spinningwheel.SpinningWheelView;

public class MainActivity extends AppCompatActivity implements SpinningWheelView.OnRotationListener<String> {

    private SpinningWheelView wheelView;

    private Button rotate;
    private Button addItemButton;
    private EditText editItem;
    String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wheelView = (SpinningWheelView) findViewById(R.id.wheel);

        rotate = (Button) findViewById(R.id.rotate);

        editItem = (EditText) findViewById(R.id.editText);
        addItemButton = (Button) findViewById(R.id.addButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = editItem.getText().toString();
                wheelView.addNewItem(item);
            }
        } );

        //    wheelView.setItems(R.array.dummy);

        wheelView.setOnRotationListener(this);
        // wheelView.onTouchEvent()
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // max angle 50
                // duration 10 second
                // every 50 ms rander rotation
                wheelView.rotate(50, 3000, 50);
            }
        });
    }

    @Override
    public void onRotation() {
        Log.d("XXXX", "On Rotation");
    }

    @Override
    public void onStopRotation(String item) {
        Toast.makeText(this, item, Toast.LENGTH_LONG).show();
    }
}
