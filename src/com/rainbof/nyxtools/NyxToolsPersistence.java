package com.rainbof.nyxtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.rainbof.nyxtools.util.S;

public class NyxToolsPersistence {

	private SharedPreferences preferences;

	protected NyxToolsPersistence(Context _context) {
		preferences = PreferenceManager.getDefaultSharedPreferences(_context);
	}

	private SharedPreferences.Editor edit() {
		return preferences.edit();
	}

	private boolean commit() {
		return edit().commit();
	}

	private SharedPreferences.Editor putString(String key, String value) {
		return edit().putString(key, value);
	}

	private String getString(String key, String defValue) {
		return preferences.getString(key, defValue);
	}

	// Username
	
	protected boolean setUsername(String username) {
		if (username == null || username.length() <= 3) {
			Log.e(S.TAG + "setUsername",
					"Username must not be null or shorter than 3 letters");
			return false;
		}
		putString(S.P_USERNAME, username);
		return commit();
	}

	protected String getUsername() {
		return getString(S.P_USERNAME, null);
	}

	protected boolean setAuthToken(String authToken) {
		if (authToken == null || authToken.length() < 1) {
			Log.e(S.TAG + "setAuthToken", "AuthToken must not be null");
			return false;
		}
		putString(S.P_AUTH_TOKEN, authToken);
		return commit();
	}

	protected String getAuthToken() {
		return getString(S.P_AUTH_TOKEN, null);
	}
	
	protected boolean setUserAgentPrefix(String uaPrefix){
		putString(S.P_USER_AGENT, uaPrefix);
		return commit();
	}
	
	protected String getUserAgentPrefix(){
		return getString(S.P_USER_AGENT, "NyxTools");
	}

}
