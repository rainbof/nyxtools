package com.rainbof.nyxtools;

import android.content.Context;

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
		if (_context.getApplicationContext() != null)
			_context = _context.getApplicationContext();
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

}
