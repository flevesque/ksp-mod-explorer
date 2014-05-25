package com.criticalweb.ksp.mod.explorer.notifications;

/**
 * Created by Francois Levesque <francois@critical-web.com>
 */
public class NotificationStatus {

	private boolean success;
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
