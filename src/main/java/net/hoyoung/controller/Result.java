package net.hoyoung.controller;

public class Result {
	@Override
	public String toString() {
		return "Result [valid=" + valid + ", errMessage=" + errMessage + "]";
	}

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

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
}
