/**
 * 
 */
package com.christ.tts.controller;

/**
 * @author spallai
 *
 */
public class Response {
	private String status;
	private Object data1;
	private Object data2;
	
	public Response(){
		
	}
	
	public Response(String status, Object data1){
		this.status = status;
		this.data1 = data1;
	}
	
	public Response(String status, Object data1, Object data2){
		this.status = status;
		this.data1 = data1;
		this.data2 = data2;
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
 
	public Object getData1() {
		return data1;
	}
 
	public void setData1(Object data1) {
		this.data1 = data1;
	}

	/**
	 * @return the data2
	 */
	public Object getData2() {
		return data2;
	}

	/**
	 * @param data2 the data2 to set
	 */
	public void setData2(Object data2) {
		this.data2 = data2;
	}
	
	
}