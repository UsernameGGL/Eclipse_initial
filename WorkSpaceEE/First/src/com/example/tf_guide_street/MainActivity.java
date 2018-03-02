package com.example.tf_guide_street;

import com.example.tf.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn_one;
	private Button btn_two;
	private Button btn_three;
	private Button btn_four;
	private Button btn_five;
	private Button btn_six;
	private Button btn_seven;
	private Button btn_eight;
	private Button btn_nine;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn_one=(Button) findViewById(R.id.btn_one);
		btn_two=(Button) findViewById(R.id.btn_two);
		btn_three=(Button) findViewById(R.id.btn_three);
		btn_four=(Button) findViewById(R.id.btn_four);
		btn_five=(Button) findViewById(R.id.btn_five);
		btn_six=(Button) findViewById(R.id.btn_six);
		btn_seven=(Button) findViewById(R.id.btn_seven);
		btn_eight=(Button) findViewById(R.id.btn_eight);
		btn_nine=(Button) findViewById(R.id.btn_nine);
		btn_one.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity01.class);   		//上下文
				startActivity(intent);			//打开activity01
			}
		});
		
		btn_two.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity02.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
		btn_three.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity03.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
		btn_four.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity04.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
		btn_five.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity05.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
		btn_six.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity06.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
		btn_seven.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity07.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
		btn_eight.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity08.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
		btn_nine.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Activity09.class);   		//上下文
				startActivity(intent);			//打开activity02
			}
		});
		
	}

	
	}

