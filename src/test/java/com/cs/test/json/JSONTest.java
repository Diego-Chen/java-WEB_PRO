package com.cs.test.json;

//import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cs.test.model.ReqData;

/**
 * @author Administrator
 *
 */
public class JSONTest {
	
	


	
	
//	public static void main(String[] args) {
//		alibabaJSONArray();
//	}
	
	
    public static void	alibabaJSON(){
    	ReqData data = new ReqData();
		data.setTEST("test");
		data.setPRO("pro");
		data.setNAME("name");
    	System.out.println(JSON.toJSONString(data));
    }
    
	// public static void netJSON(ReqData data){
	// System.out.println(JSONObject.fromObject(data));
	// }
	//
    
    
    public static void alibabaJSONArray(){
    	HashMap<String, List<String>> threeMechMap = new HashMap<String, List<String>>();
		String relation = "[{\"busiCode\":\"100231\",\"mchID\":\"你们\",\"mchName\":\"ttttt\"},{\"busiCode\":\"100231\",\"mchID\":\"他们\",\"mchName\":\"fffff\",\"subMchs\": [{\"busiCode\":\"100231\",\"mchID\":\"233333\",\"mchName\":\"岭南通·惠州通\"},{\"busiCode\":\"100231\",\"mchID\":\"33333\",\"mchName\":\"岭南通·肇庆通\"}]}]";
        JSONArray arr=JSON.parseArray(relation);
		
		Iterator<Object> it = arr.iterator();
		System.out.println(arr);
        while (it.hasNext()) {
            JSONObject ob = (JSONObject) it.next();
            if(ob.getString("mchName")!=null){
            	String mchName = ob.getString("mchName");
            	List<String> list=new ArrayList<String>();
                if(ob.getString("subMchs")!=null){
                	JSONArray subArr = JSON.parseArray(ob.getString("subMchs"))  ;
					Iterator<Object> that = subArr.iterator();
                	while(that.hasNext()){
                		JSONObject sub = (JSONObject) that.next();
                		list.add(sub.getString("mchName"));
                	}
                	threeMechMap.put(mchName, list);
                	
                }else{
                	list.add(mchName);
                	threeMechMap.put(mchName, list);
                }
            }
        }
			
		System.out.println("结果map:"+threeMechMap);
    }
    
    
    
    
    
}
