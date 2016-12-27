package net.hoyoung.controller;

public class Result {
	private boolean valid;
	private String errMessage;
	
	Result(){
		this(true, null);
	}
	
	Result(boolean valid, String errMessage){
		this.valid = valid;
		this.errMessage = errMessage;
	}
	
	public static Result ok(){
		return new Result();
	}
	
	public static Result fail(String errMessage){
		return new Result(false, errMessage);
	}
}
