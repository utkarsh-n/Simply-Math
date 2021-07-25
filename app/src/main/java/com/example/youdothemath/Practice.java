package com.example.youdothemath;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Practice extends Activity implements OnClickListener {

    //level names
    String[] levelNames = {"Beginner", "Intermediate", "Pro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        //retrieve references
        Button additionBtn = (Button) findViewById(R.id.addition_btn);
        Button subtractionBtn = (Button) findViewById(R.id.subtraction_btn);
        Button multiplicationBtn = (Button) findViewById(R.id.multiplication_btn);
        Button divisionBtn = (Button) findViewById(R.id.division_btn);
        Button allBtn = (Button) findViewById(R.id.all_btn);
        Button sqrtBtn = (Button) findViewById(R.id.sqrt_btn);
        ImageView home = (ImageView) findViewById(R.id.ok_btn);

        //listen for clicks
        additionBtn.setOnClickListener(this);
        subtractionBtn.setOnClickListener(this);
        multiplicationBtn.setOnClickListener(this);
        divisionBtn.setOnClickListener(this);
        allBtn.setOnClickListener(this);
        home.setOnClickListener(this);
        sqrtBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.addition_btn){
            //play button
            Intent additionIntent = new Intent(this, Addition.class);
            this.startActivity(additionIntent);
        }
        else if(view.getId()==R.id.subtraction_btn){
            //how to play button
            Intent subtractionIntent = new Intent(this, Subtraction.class);
            this.startActivity(subtractionIntent);
        }
        else if(view.getId()==R.id.multiplication_btn){
            //high scores button
            Intent multiplicationIntent = new Intent(this, Multiplication.class);
            this.startActivity(multiplicationIntent);
        }
        else if(view.getId()==R.id.division_btn){
            //about button
            Intent divisionIntent = new Intent(this, Division.class);
            this.startActivity(divisionIntent);
        }
        else if(view.getId()==R.id.all_btn){
            //about button
            Intent allIntent = new Intent(this, All.class);
            this.startActivity(allIntent);
        }
        else if(view.getId()==R.id.ok_btn){
            //home button
            Intent mainactivityIntent = new Intent(this, MainActivity.class);
           this.startActivity(mainactivityIntent);
        }
        else if(view.getId()==R.id.sqrt_btn){
            //home button
            Intent sqrtIntent = new Intent(this, SquareRoot.class);
            this.startActivity(sqrtIntent);
        }
    }

    private void startPlay(int chosenLevel){
        //start gameplay
        Intent playIntent = new Intent(this, PlayGame.class);
        playIntent.putExtra("level", chosenLevel);
        this.startActivity(playIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
