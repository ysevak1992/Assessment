package com.mediaocean.prokabaddi.vo;

import javax.validation.constraints.NotNull;

public class ProKabaddiInputVO {
	@NotNull
	private String ids;
	@NotNull
	private String date;
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
