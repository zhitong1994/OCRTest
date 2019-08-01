package com.shtx.bean;

import java.util.List;

public class Items {
	
	  private String APLY_DT;
	    private String APLY_NM;
	    private List<List<String>> TABLE;
	    public void setAPLY_DT(String APLY_DT) {
	         this.APLY_DT = APLY_DT;
	     }
	     public String getAPLY_DT() {
	         return APLY_DT;
	     }

	    public void setAPLY_NM(String APLY_NM) {
	         this.APLY_NM = APLY_NM;
	     }
	     public String getAPLY_NM() {
	         return APLY_NM;
	     }

	    public void setTABLE(List<List<String>> TABLE) {
	         this.TABLE = TABLE;
	     }
	     public List<List<String>> getTABLE() {
	         return TABLE;
	     }

}
