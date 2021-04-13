package com.tripaneer.catalog.constants;

public enum CatalogServiceDefaultExceptionCodes {
	INTERNAL_SERVER("CS-100", "Internal Server Exception");

	private final String errCode;
	private final String errMsg;

	CatalogServiceDefaultExceptionCodes(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String errCode() {
		return this.errCode;
	}

	public String errMsg() {
		return this.errMsg;
	}
}
