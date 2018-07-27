package com.cs.test.mapTest;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ObjUtils {
	@SuppressWarnings("rawtypes")
	public static String getString(Object obj) {

		Map<String, Object> map = new HashMap<String, Object>();
		Class userCla = obj.getClass();
		Field[] fs = userCla.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true); 
			Object val = new Object();
			try {
				val = f.get(obj);
				if (null != val && val instanceof String)
					map.put(f.getName(), val);// ���ü�ֵ
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String data = "";
		if (null != map && map.size() > 0) {
			Map<String, Object> sortMap = new TreeMap<String, Object>(
					new MapKeyComparator());
			sortMap.putAll(map);

			for (String key : sortMap.keySet()) {
				Object va = sortMap.get(key);
				if (va instanceof String) {
					data = data + "&" + key + "=" + va;
				}
			}
			data = data.substring(1, data.length());
		}
		return data;
	}
}
