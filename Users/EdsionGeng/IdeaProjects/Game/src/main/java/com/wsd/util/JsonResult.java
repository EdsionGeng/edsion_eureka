package com.wsd.util;
import java.io.Serializable;
public class JsonResult implements Serializable{
	private static final long serialVersionUID = 1L;
	private int code;//0代表成功,1或其他值代表处理失败。
	private Object content;//接收返回的数据
	private String message;//定义提示信
	public static final int SUCCESS=0;
	public static final int ERROR=1;

	public JsonResult(){}

	public JsonResult(int code, Throwable e){
		this.code=code;
		content=null;
		message=e.getMessage();
	}

	public JsonResult(int code, Object content, String message) {
		this.code =code;
		this.content = content;
		this.message = message;
	}

	public JsonResult(Throwable e){
		code=ERROR;
		content=null;
		message=e.getMessage();
	}
	public JsonResult(Object content){
		code=SUCCESS;
		this.content=content;
		message="";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	@Override
	public String toString() {
		return "JsonResult{" +
				"code=" + code +
				", content=" + content +
				", message='" + message + '\'' +
				'}';
	}
}
