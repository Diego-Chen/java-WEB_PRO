/**
 * 
 */
package com.cs.test.http;

/**
 * @author Administrator
 *
 */
import java.io.*;  
import java.net.*;  
  
public class TestSopa1_2 {  
    /** 
     * @param args 
     * @throws Exception 
     */  
    public static void main(String[] args) throws Exception {  
        String urlString = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx";  
        String xmlFile = "soap1.2.xml";// 要发送的soap格式文件  
        URL url = new URL(urlString);  
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
        File fileToSend = new File(xmlFile);  
        byte[] buf = new byte[(int) fileToSend.length()];// 用于存放文件数据的数组  
        new FileInputStream(xmlFile).read(buf);  
//      httpConn.setRequestProperty("Content-Length",  
//              String.valueOf(buf.length));//这句话可以不用写，即使是随便写  
        //根据我的测试，过去的请求头中的Content-Length长度也是正确的，也就是说它会自动进行计算  
        httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");  
        httpConn.setRequestMethod("POST");  
        httpConn.setDoOutput(true);  
        httpConn.setDoInput(true);  
        OutputStream out = httpConn.getOutputStream();  
        out.write(buf);  
        out.close();  
        InputStreamReader is = new InputStreamReader(httpConn.getInputStream(),  
                "utf-8");  
        BufferedReader in = new BufferedReader(is);  
        String inputLine;  
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(  
                new FileOutputStream("result.xml")));// 将结果存放的位置  
        while ((inputLine = in.readLine()) != null) {  
            System.out.println(inputLine);  
            bw.write(inputLine);  
            bw.newLine();  
        }  
        bw.close();  
        in.close();  
        httpConn.disconnect();  
    }  
}  