package com.example.outuserentry;

import android.app.Activity;
import android.os.Bundle;

public class BaseAcitivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActivityCollector.addavtivity(this);
		ActivityCollector.setActivityy(this);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeactivity(this);
	}

}
