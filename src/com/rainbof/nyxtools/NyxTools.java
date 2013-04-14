package com.rainbof.nyxtools;

public class NyxTools {

	private static NyxTools mInstance;

	public static NyxTools getInstance() {
		if (mInstance == null) {
			synchronized (NyxTools.class) {
				mInstance = new NyxTools();
			}
		}
		return mInstance;
	}
	
	private NyxTools(){
		
	}

}
