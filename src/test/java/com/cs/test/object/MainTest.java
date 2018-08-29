/**
 * 
 */
package com.cs.test.object;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.cs.test.model.ReqData;
import com.cs.test.model.SortBean;



/**
 * @author Administrator
 *
 */
public class MainTest {
	public static void main(String[] args) {
		
		List<SortBean>  sorts = new ArrayList<SortBean>();
		List<ReqData>  datas = new ArrayList<ReqData>();
		for (int t= 0   ;  t < 5 ; t++) {
			SortBean sort = new SortBean();
			ReqData data = new ReqData();
			sort.setId(t);
			sort.setDesc("描述" + t);
			data.setNAME("真的" + t);
			sorts.add(sort);
			datas.add(data);
			
		}
		
		System.out.println(JSON.toJSONString(sorts));
		int i = 0;
		do {
			SortBean lz = sorts.get(i);
			
			
			int j = 0;
			do {
				ReqData zx = datas.get(j);
				if(lz.getId() == 3){
					lz.setDesc(zx.getNAME());
				}
				j ++ ;
			} while (j < datas.size());
			
			i++;
		} while (i < sorts.size());
		
		
		
		System.out.println(JSON.toJSONString(sorts));
	}
	
	
}
