package com.example.youdothemath;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	//level names
	String[] levelNames = {"Beginner", "Intermediate", "Pro"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//retrieve references
		Button playBtn = (Button) findViewById(R.id.play_btn);
		Button helpBtn = (Button) findViewById(R.id.help_btn);
		Button highBtn = (Button) findViewById(R.id.high_btn);
		Button aboutBtn = (Button) findViewById(R.id.about_btn);
		Button practiceBtn = (Button) findViewById(R.id.practice_btn);

		//listen for clicks
		playBtn.setOnClickListener(this);
		helpBtn.setOnClickListener(this);
		highBtn.setOnClickListener(this);
		aboutBtn.setOnClickListener(this);
		practiceBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if(view.getId()==R.id.play_btn){
			//play button
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Select your difficulty")
					.setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.dismiss();
							//start gameplay
							startPlay(which);
						}
					});
			AlertDialog ad = builder.create();
			ad.show();
		}
		else if(view.getId()==R.id.help_btn){
			//how to play button
			Intent helpIntent = new Intent(this, HowToPlay.class);
			this.startActivity(helpIntent);
		}
		else if(view.getId()==R.id.high_btn){
			//high scores button
			Intent highIntent = new Intent(this, HighScores.class);
			this.startActivity(highIntent);
		}
		else if(view.getId()==R.id.about_btn){
			//about button
			Intent aboutIntent = new Intent(this, About.class);
			this.startActivity(aboutIntent);
		}
		else if(view.getId()==R.id.practice_btn){
			//about button
			Intent practiceIntent = new Intent(this, Practice.class);
			this.startActivity(practiceIntent);
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
