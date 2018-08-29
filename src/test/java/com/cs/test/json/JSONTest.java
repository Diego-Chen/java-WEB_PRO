package com.cs.test.json;

//import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSON;
import com.cs.test.model.ReqData;

/**
 * @author Administrator
 *
 */
public class JSONTest {
	public static void main(String[] args) {
		ReqData data = new ReqData();
		data.setTEST("test");
		data.setPRO("pro");
		data.setNAME("name");
		alibabaJSON(data);
	}
	
	
    public static void	alibabaJSON(ReqData data){
    	System.out.println(JSON.toJSONString(data));
    }
    
	// public static void netJSON(ReqData data){
	// System.out.println(JSONObject.fromObject(data));
	// }
	//
}
