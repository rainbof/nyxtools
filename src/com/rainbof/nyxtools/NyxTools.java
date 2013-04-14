package com.rainbof.nyxtools;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.rainbof.nyxtools.calls.test.TestCall;
import com.rainbof.nyxtools.calls.test.TestCallListener;
import com.rainbof.nyxtools.util.S;

public class NyxTools {

	private volatile static NyxTools mInstance;
	private NyxToolsPersistence persistence;

	public static NyxTools getInstance(Context _context) {
		if (mInstance == null) {
			synchronized (NyxTools.class) {
				mInstance = new NyxTools(_context);
			}
		}
		return mInstance;
	}

	protected NyxTools(Context _context) {
		try {
			if (_context.getApplicationContext() != null)
				_context = _context.getApplicationContext();
		} catch (Exception e) {
			Log.e(S.TAG + "getApplicationContext",
					"You must call getInstance() after super.onCreate(...)");
			throw new IllegalStateException();
		}
		persistence = new NyxToolsPersistence(_context);
	}

	public boolean setUsername(String username) {
		return persistence.setUsername(username);
	}

	public String getUsername() {
		return persistence.getUsername();
	}

	public boolean setAuthToken(String authToken) {
		return persistence.setAuthToken(authToken);
	}

	public String getAuthToken() {
		return persistence.getAuthToken();
	}

	public String getUserAgentPrefix() {
		return persistence.getUserAgentPrefix();
	}

	public boolean setUserAgentPrefix(String uaPrefix) {
		return persistence.setUserAgentPrefix(uaPrefix);
	}
	
	public void runTestAsyncCall(TestCallListener listener){
		new TestCall().execute(getClient(), listener);
	}

	private volatile AsyncHttpClient client;
	
	private synchronized AsyncHttpClient getClient() {
		if(client == null)
			client = new AsyncHttpClient();
		return client;
	}

}
