package com.rdvmedecin.model;

/**
 * 
 * @author SKAN
 * 
 */
public class Response {
	private int status;
	private Object data;

	public Response() {
	}

	public Response(int status, Object data) {
		this.status = status;
		this.data = data;
	}

	public void incrStatusBy(int increment) {
		this.status += increment;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
