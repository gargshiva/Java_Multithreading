package com.sapient.ace.downloadmanager;

public class RandomFile {
	private int fileId;
	private boolean status;

	public RandomFile(int fileId, boolean status) {
		super();
		this.fileId = fileId;
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "RandomFile [fileId=" + fileId + ", status=" + status + "]";
	}

}
