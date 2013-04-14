package com.rainbof.nyxtools.calls.test;

public class TestCallResponse {

	public TestCallResponse(String response, int code){
		this.responseCode = code;
		this.responseText = response;
	}
	
	public String responseText;
	public int responseCode;
	
}
