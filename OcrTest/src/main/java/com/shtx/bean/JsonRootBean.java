package com.shtx.bean;

public class JsonRootBean {
	
	 private String config_str;
	    private Items items;
	    private String request_id;
	    private boolean success;
	    public void setConfig_str(String config_str) {
	         this.config_str = config_str;
	     }
	     public String getConfig_str() {
	         return config_str;
	     }

	    public void setItems(Items items) {
	         this.items = items;
	     }
	     public Items getItems() {
	         return items;
	     }

	    public void setRequest_id(String request_id) {
	         this.request_id = request_id;
	     }
	     public String getRequest_id() {
	         return request_id;
	     }

	    public void setSuccess(boolean success) {
	         this.success = success;
	     }
	     public boolean getSuccess() {
	         return success;
	     }
}
