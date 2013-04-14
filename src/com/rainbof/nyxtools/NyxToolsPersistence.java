package com.rainbof.nyxtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.rainbof.nyxtools.util.S;

public class NyxToolsPersistence {

	private SharedPreferences preferences;

	public NyxToolsPersistence(Context _context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(_context);
	}

	private SharedPreferences.Editor edit() {
		return preferences.edit();
	}

	private boolean commit() {
		return edit().commit();
	}

	protected boolean setUsername(String username) {
		if (username == null || username.length() <= 3) {
			Log.e(S.TAG + "setUsername", "Username must not be null or shorter than 3 letters");
			return false;
		}
		return edit().putString(S.P_USERNAME, username).commit();
	}
	
	protected String getUsername(){
		return preferences.getString(S.P_USERNAME, null);
	}
	
	protected boolean setAuthToken(String authToken) {
		if(authToken == null || authToken.length() < 1){
			Log.e(S.TAG + "setAuthToken", "AuthToken must not be null");
			return false;
		}
		return edit().putString(S.P_AUTH_TOKEN, authToken).commit();
	}
	
	protected String getAuthToken(){
		return preferences.getString(S.P_AUTH_TOKEN, null);
	}

}
