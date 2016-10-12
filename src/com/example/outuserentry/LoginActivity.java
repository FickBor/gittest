package com.example.outuserentry;

import android.Manifest.permission;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseAcitivity {
	private SharedPreferences  Preference;
	private SharedPreferences.Editor editor;
	private EditText et_user,et_ps;
	private Button button1;
	private CheckBox remeber_ps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 Preference= PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
		et_user=(EditText) findViewById(R.id.etuesr);
		et_ps=(EditText) findViewById(R.id.etps);
		button1=(Button) findViewById(R.id.button1);
		remeber_ps=(CheckBox) findViewById(R.id.remember_ps);
		boolean isremeber= Preference.getBoolean("remeber_ps", false);
		if (isremeber) {
			String user=  Preference.getString("user", "");
			String password= Preference.getString("password", "");
			et_user.setText(user);
			et_ps.setText(password);
			remeber_ps.setChecked(true);
			//Toast.makeText(this, "读取了没", Toast.LENGTH_SHORT).show();
		}
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String user= et_user.getText().toString();
				String password= et_ps.getText().toString();
				if(user.equals("admin")&&password.equals("123456"))
				{
					editor =Preference.edit();
					if(remeber_ps.isChecked())
					{
						editor.putBoolean("remeber_ps", true);
						editor.putString("user", user);
						editor.putString("password", password);
					}
					else {
						editor.clear();
						
					}
					editor.commit();
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
				}else {
					Toast.makeText(LoginActivity.this, "账户或密码不正确", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
	}

}
