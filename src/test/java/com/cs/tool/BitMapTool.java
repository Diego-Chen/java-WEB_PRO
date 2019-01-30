/**
 * 
 */
package com.cs.tool;

import java.util.Locale;


/**
 * @author Administrator
 * 64域位图计算
 */
public class BitMapTool {
	
	static byte[] mask = new byte[128];
	static {
		for (int i = 0; i <= 9; i++)
		{
			mask[i + 48] = (byte) i;
		}
		for (int i = 0; i <= 5; i++)
		{
			mask[i + 97] = (byte) (10 + i);
		}
		for (int i = 0; i <= 5; i++)
		{
			mask[i + 65] = (byte) (10 + i);
		}
	}
	
	
	static String bitmap(int... vs){
		//第一步  将域序号塞入byte域组中，每个byte标识一个域，此方法用于64域数据
		byte[] map = new byte[64];
		for (int i = 0; i < vs.length; i++)
		{
			if (0 != vs[i])
			{
				int b = vs[i];
				map[b-1] = 1;
			}
		}
		
		StringBuffer buff = new StringBuffer();
		//64个字节分为8块，每块的8个字节转为16进制hex
		for(int j = 0 ; j < map.length/8 ; j++){
			byte[] temp = new byte[8];
			System.arraycopy(map, j*8, temp, 0, 8);
			StringBuffer sb = new StringBuffer();
			for (byte b : temp) {
				sb.append(b);
			}
			byte ret = (byte) (Integer.valueOf(sb.toString(), 2)  & 0xff);
			StringBuffer f = new StringBuffer();
			int n = ret & 0xff;
			if (n < 0x10)
				f.append("0");
			f.append(Integer.toHexString(n));

			String t =  f.toString();
			if (null != t)
				t = t.toUpperCase(Locale.getDefault());
			
			buff.append(t);
		}
		return buff.toString();
	}
	
	
	//解析位图
	public static int[] analysisBitmap(String va){
		
		int len = (va.length() / 2);
		byte[] hex = new byte[len];
		char[] achar = va.toCharArray();
		for (int i = 0; i < len; i++)
		{
			int pos = i * 2;
			hex[i] = (byte) (mask[achar[pos]] << 4 | mask[achar[pos + 1]]);
		}
	    int[] x = new int[64];
	    int p = 0;
		for (int i = 0; i < hex.length; i++) {
			if(0 != hex[i]){
				String t = Integer.toBinaryString(hex[i]&0xFF);
				StringBuffer sb = new StringBuffer();
				for (int j = 0; j < 8-t.length(); j++) {
					sb.append("0");
				}
				sb.append(t);
				t = sb.toString();
				char[] c = t.toCharArray();
				for (int j = 0 ; j < c.length ; j++) {
					if(c[j]=='1'){
						x[p] = 8*i + j+1;
						p++;
					}
				}
			}
		}
		int[] re = new int[p];
		System.arraycopy(x, 0, re, 0, p);
		return re;
	}
	
	
	public static void main(String[] args) {
		String re = bitmap(4,10,17,28,36,48,53,60);
		System.out.println(re);
		int[] s = analysisBitmap(re);
		for (int i = 0; i < s.length; i++) {
			System.out.println("解析位图之后:" + s[i]);
		}
	}
}
