package com.rainbof.nyxtools.calls.test;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class TestCall {

	public void execute(AsyncHttpClient client, final TestCallListener listener){
		client.get("http://www.google.com", new AsyncHttpResponseHandler(){
			@Override
			public void onSuccess(int arg0, String arg1) {
				if(listener != null){
					listener.onTestCallFinished(new TestCallResponse("nejaka data vracena z pozadavku", 302));
				}
			}
		});
	}
	
}
