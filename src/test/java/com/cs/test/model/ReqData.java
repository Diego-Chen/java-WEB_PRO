/**
 * 
 */
package com.cs.test.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Administrator
 *
 */
public class ReqData {
	@JSONField  (name = "TEST")
	private String TEST;
	@JSONField  (name = "PRO")
	private String PRO;
	@JSONField  (name = "NAME")
	private String NAME;
	
	
	
	
	
	public String getTEST() {
		return TEST;
	}
	public void setTEST(String tEST) {
		TEST = tEST;
	}
	public String getPRO() {
		return PRO;
	}
	public void setPRO(String pRO) {
		PRO = pRO;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	
	
	
	
}
