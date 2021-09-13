package com.example.mergetablelayout_slidelayout_inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* [ Init ] : inflate & button & List view  */
        button = findViewById(R.id.button);
        LayoutInflater I = getLayoutInflater();
        TableLayout tl = findViewById(R.id.myTableLayout);

        button.setOnClickListener( (View view) -> {
            TextView textView = findViewById(R.id.editText);  //textView = editText
            TableRow tr = new TableRow(getBaseContext()); // create TableRow

    /**/    View v = I.inflate(R.layout.activity_slide_layout, null); //inflate slideLayout in a view
            SwipeLayout sl = v.findViewById(R.id.swipeLayout); // swipeLayout = swipeLayout from xml Files keep inflate in view
    /**/    sl.setShowMode(SwipeLayout.ShowMode.PullOut); // edit style of swipeLayout
            sl.addDrag(SwipeLayout.DragEdge.Left, sl.findViewById(R.id.linear_sol));// same thing
            sl.addDrag(SwipeLayout.DragEdge.Right, sl.findViewById(R.id.linear_sag));// same thing
            //sl.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    /**/    TextView tv = sl.findViewById(R.id.textInside); // get text from swipeLayout
            tv.setText(textView.getText().toString()); // edit text from swipeLayout
            if (tv.getText().length() == 0)
                tv.setHint("void");
            tv.setGravity(Gravity.CENTER);// edit gravityText from swipeLayout
            tr.setGravity(Gravity.CENTER);// edit gravityTableRow create before
            tr.addView(v);

            tl.addView(tr);
        });

    }
}