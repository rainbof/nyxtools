package com.rainbof.nyxtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class NyxToolsPersistence {

	private SharedPreferences preferences;
	
	public NyxToolsPersistence(Context _context){
		preferences = PreferenceManager.getDefaultSharedPreferences(_context);
	}
	
	private SharedPreferences.Editor edit() {
		return preferences.edit();
	}
	
	private boolean commit(){
		return edit().commit();
	}
	
}
