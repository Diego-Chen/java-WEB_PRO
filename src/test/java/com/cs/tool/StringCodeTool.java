/**
 * 
 */
package com.cs.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/**
 * @author Administrator
 *
 */
public class StringCodeTool {
	static byte[] mask = new byte[128];

	static
	{
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
	static byte[] asciiMask = new byte[]
	{ '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	

	private static String[] binaryArray =
	{ "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111" };

	
	
	public static void main(String[] args) {
		//进制转换
		{	
			int n = 130000;
			String bit2 = Integer.toBinaryString(n);
			String bit8 = Integer.toOctalString(n);
			String bit16 = Integer.toHexString(n);
			System.out.println("2进制:" + bit2);
			System.out.println("8进制:" + bit8);
			System.out.println("16进制:" + bit16);
			//前一个参数为各进制字符串，后一个参数标识字符串的进制
			int int10 = Integer.parseInt(bit2, 2);
			System.out.println("转10进制:" + int10);
		}
		
		byte[] bs = hexStr2Byte("FFFF");
		for (byte b : bs) {
			System.out.println(b);
		}
		System.out.println();
		
	}
	

	public static byte[] hexStr2Byte(String hex)
	{
		int len = (hex.length() / 2);
		byte[] result = new byte[len];
		char[] achar = hex.toCharArray();
		for (int i = 0; i < len; i++)
		{
			int pos = i * 2;
			result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
		}
		return result;
	}

	public static int revAsciiHexToInt(byte[] ah)
	{
		int ret = 0;
		for (int i = 0; i < ah.length / 2; i++)
		{
			int hex = (mask[ah[i * 2]] << 4) + (mask[ah[i * 2 + 1]]);
			ret += (hex << (8 * i));
		}
		return ret;
	}

	public static int revHexToInt(byte[] data, int off, int len)
	{
		int ret = 0;
		for (int i = 0; i < len; i++)
		{
			ret += (data[off + i] & 0xff) << (8 * i);
		}

		return ret;
	}

	public static int revAsciiHexToInt(byte[] ah, int off, int len)
	{
		int ret = 0;
		for (int i = 0, n = len / 2; i < n; i++)
		{
			int hex = (mask[ah[i * 2 + off]] << 4) + (mask[ah[i * 2 + off + 1]]);
			ret += (hex << (8 * i));
		}
		return ret;
	}

	public static byte[] intToRevAsciiHex(int value, int hexlen)
	{
		byte[] ret = new byte[hexlen * 2];

		for (int i = 0; i < hexlen; i++)
		{
			if (value > 0)
			{
				ret[i * 2] = asciiMask[((value & 0xf0) >> 4)];
				ret[i * 2 + 1] = asciiMask[(value & 0xf)];
				value >>= 8;
			}
			else
			{
				ret[i * 2] = '0';
				ret[i * 2 + 1] = '0';
			}
		}
		return ret;
	}

	public static String intToRevHexString(int value, int hexlen)
	{

		byte[] ret = new byte[hexlen];
		for (int i = 0; i < hexlen; i++)
		{
			ret[i] = (byte) (value & 0xff);
			value >>= 8;
			if (value == 0)
				break;
		}
		return hexToStr(ret);
	}

	public static byte[] intToAsciiHex(int value, int len)
	{
		byte[] ret = new byte[len * 2];
		for (int i = 0; i < len; i++)
		{
			ret[i * 2] = asciiMask[((value & 0xf0) >> 4)];
			ret[i * 2 + 1] = asciiMask[value & 0xf];
			value >>= 8;
		}
		return ret;
	}

	public static byte[] intToHex(int value, int len)
	{
		byte[] ret = new byte[len];
		for (int i = 0; i < len; i++)
		{
			ret[i] = (byte) ((value >> 8 * (len - i - 1)) & 0xff);
		}
		return ret;
	}
	

	public static byte[] intToRevHex(int value, int len)
	{
		byte[] ret = new byte[len];
		for (int i = 0; i < len; i++)
		{
			ret[i] = (byte) (value & 0xff);
			// if(ret[i]==0)
			// ret[i]=(byte) 0xff;
			value >>= 8;
		}
		return ret;
	}

	public static int hexToInt(byte[] buf, int idx, int len)
	{
		int ret = 0;

		final int e = idx + len;
		for (int i = idx; i < e; ++i)
		{
			ret <<= 8;
			ret |= buf[i] & 0xFF;
		}
		return ret;
	}

	public static int hexToInt(byte[] buf)
	{
		return hexToInt(buf, 0, buf.length);
	}

	public static String hexToStr(byte[] buf)
	{
		return hexToStr(buf, 0, buf.length);
	}

	public static String hexToStr(byte[] buf, int idx, int len)
	{
		StringBuffer sb = new StringBuffer();
		int n;
		for (int i = 0; i < len; i++)
		{
			n = buf[i + idx] & 0xff;
			if (n < 0x10)
			{
				sb.append("0");
			}
			sb.append(Integer.toHexString(n));
		}

		String data = sb.toString();
		if (null != data)
			data = data.toUpperCase(Locale.getDefault());
		return data;
	}

	private static byte toByte(char c)
	{
		return mask[c];
	}

	public static String strToHex(String str)
	{
		try
		{
			byte[] bytes = str.getBytes("GBK");
			StringBuilder sb = new StringBuilder(bytes.length * 2);
			// 转换hex编码
			for (byte b : bytes)
			{
				sb.append(Integer.toHexString(b + 0x800).substring(1));
			}
			return sb.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 替换手机号中间四位数字为星号
	 * 
	 * @param index
	 * @param res
	 * @param str
	 * @return
	 */
	public static String replaceIndex(String res)
	{
		return res.substring(0, 3) + "****" + res.substring(7);
	}

	// /**
	// * 按行打印字节
	// *
	// * @Title: printByte
	// * @author: Administrator
	// * @Description: TODO
	// * @param: @param len
	// * @param: @param bt
	// * @param: @param name
	// * @return: void
	// * @throws:
	// */
	// public static void printByte(int len, byte[] bt, String name)
	// {
	// System.out.println("*******************" + name + "*******************");
	// if (bt != null)
	// {
	// String log = "";
	// for (int i = 0; i < bt.length; i++)
	// {
	// // System.out.print(" "+Integer.toHexString(bt[i]));
	// log += Integer.toHexString(bt[i]);
	// if ((i + 1) % len == 0)
	// {
	// LogUtils.i("SEND:", log);
	// log = "";
	// // System.out.println();
	// }
	// }
	// }
	// }

	/**
	 * 按行打印字节
	 * 
	 * @Title: printByte
	 * @author: Administrator
	 * @Description: TODO
	 * @param: @param len
	 * @param: @param bt
	 * @param: @param name
	 * @return: void
	 * @throws:
	 */
	public static void printByte(int len, byte[] bt, String name)
	{
		System.out.println("*******************" + name + "*******************");

		try
		{
			// FileOutputStream fo = new FileOutputStream("d:/logs.txt");

			File file = new File("/sdcard/error/out.txt");
			FileWriter fo = new FileWriter(file);

			fo.write("*******************" + name + "*******************" + bt.length);
			fo.write("\r\n");

			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < bt.length; i++)
			{
				buf.append(Integer.toHexString(bt[i]));
				// System.out.print(" "+Integer.toHexString(bt[i]));

				if ((i + 1) % len == 0)
				{
					String a = new String(buf);

					fo.write(a);
					// System.out.println();
					// f.append("/r/n");
					fo.write("\r\n");

					buf = new StringBuffer();
				}
			}

			// String xx = new String(buf);

			// System.out.println(xx);

			// fo.write(xx.getBytes());

			fo.flush();

			fo.close();

		}
		catch (IOException e1)
		{
			e1.printStackTrace();
		}

	}

	/**
	 * 转换返回值类型为UTF-8格式.
	 * 
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is)
	{
		StringBuilder sb1 = new StringBuilder();
		byte[] bytes = new byte[4096];
		int size = 0;

		try
		{
			while ((size = is.read(bytes)) > 0)
			{
				String str = new String(bytes, 0, size, "UTF-8");
				sb1.append(str);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return sb1.toString();
	}

	/**
	 * 
	 * @param str
	 * @return 转换为二进制字符串
	 */
	public static String bytes2BinaryStr(byte[] bArray)
	{

		String outStr = "";
		int pos = 0;
		for (byte b : bArray)
		{
			// 高四位
			pos = (b & 0xF0) >> 4;
			outStr += binaryArray[pos];
			// 低四位
			pos = b & 0x0F;
			outStr += binaryArray[pos];
		}
		return outStr;
	}

	/**
	 * 文本转ascii码
	 * 
	 * @param value
	 * @return
	 */
	public static String stringToAscii(String value)
	{
		StringBuffer sbu = new StringBuffer();
		char[] chars = value.toCharArray();
		for (int i = 0; i < chars.length; i++)
		{
			if (i != chars.length - 1)
			{
				sbu.append((int) chars[i]).append(",");
			}
			else
			{
				sbu.append((int) chars[i]);
			}
		}
		return sbu.toString();
	}


	/**
	 * ASCII转字符串
	 * 
	 * @param value
	 * @return
	 */
	public static String asciiToString(String value)
	{
		StringBuffer sbu = new StringBuffer();
		int len = value.length() / 2;
		for (int i = 0; i < len; i++)
		{
			int xx = Integer.valueOf(value.substring(i * 2, i * 2 + 2)) - 30;
			sbu.append(xx);
		}
		return sbu.toString();
	}

}
