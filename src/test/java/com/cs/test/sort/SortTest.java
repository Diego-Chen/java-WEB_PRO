/**
 * 
 */
package com.cs.test.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.cs.test.model.SortBean;


/**
 * @author Administrator
 *
 */
public class SortTest {

	
	public static void main(String[] args) {
		List<SortBean> sorts = new ArrayList<SortBean>();
		for(int i = 0 ; i < 5 ; i++){
			SortBean sortBean = new SortBean();
			sortBean.setId(i);
			sortBean.setTime("2018070112000" + i);
			sorts.add(sortBean);
		}
		for(int i = 0 ; i < 5 ; i++){
			SortBean sortBean = new SortBean();
			sortBean.setId(i);
			sortBean.setTime("2018070112000" + i);
			sorts.add(sortBean);
		}
		
		
		sorts = toHeavy(sorts);
		sort(sorts);
		
		System.err.println(JSON.toJSONString(sorts));
	}
	
	
	
	/**
	 * 对object根据字段升序排列
	 * 
	 * @param records
	 */
	public static void sort(List<SortBean> records)
	{
		// 自定义Comparator对象，自定义排序
		Comparator<SortBean> comp = new Comparator<SortBean>()
		{
			public int compare(SortBean orderA, SortBean orderB)
			{
				String orderTimeA = orderA.getTime();
				String orderTimeB = orderB.getTime();
				if (orderTimeA.compareTo(orderTimeB) < 0)
					return -1;
				// 注意！！返回值必须是一对相反数，否则无效。jdk1.7以后就是这样。
				// else return 0; //无效
				else
					return 1;
			}
		};
		// 排序，根据月份降序
		Collections.sort(records, comp);
	}
	
	
	public static List<SortBean> toHeavy(List<SortBean> list){
        HashMap<String,SortBean> tempMap = new HashMap<String,SortBean>();
        for (SortBean bean : list) {
            String key = bean.getTime();
			//containsKey(Object key) 该方法判断Map集合对象中是否包含指定的键名。如果Map集合中包含指定的键名，则返回true，否则返回false
			//containsValue(Object value)    value：要查询的Map集合的指定键值对象.如果Map集合中包含指定的键值，则返回true，否则返回false
            if(tempMap.containsKey(key)){
            	//HashMap是不允许key重复的，所以如果有key重复的话，那么前面的value会被后面的value覆盖                    
                tempMap.put(key, bean);
            }else{
                tempMap.put(key, bean);
            }
        }
        List<SortBean> tempList = new ArrayList<SortBean>();
        for(String key : tempMap.keySet()){
            tempList.add(tempMap.get(key));
        }
        return tempList;
    }
	
	
}



