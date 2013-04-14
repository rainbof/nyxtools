package com.example.nyxtools_demo;

import com.rainbof.nyxtools.NyxTools;
import com.rainbof.nyxtools.calls.test.TestCallListener;
import com.rainbof.nyxtools.calls.test.TestCallResponse;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	public NyxTools tools;// = NyxTools.getInstance(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tools = NyxTools.getInstance(this);
		tools.setUserAgentPrefix("demo");
		if (!tools.setUsername("rainbof")) {
			Log.d("setUsername", "fail");
		} else {
			Log.d("setUsername", "username" + tools.getUsername());
		}
		tools.runTestAsyncCall(new TestCallListener() {
			
			@Override
			public void onTestCallFinished(TestCallResponse result) {
				// TODO Auto-generated method stub
				//Log.d("onTestCallFinished","done:"+result.responseText);
				
			}
		});
			
		Log.d("auth", "txt");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
