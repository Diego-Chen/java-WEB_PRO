/**
 * 
 */
package com.cs.test.http;

import java.net.MalformedURLException;


import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

/**
 * @author Administrator
 *
 */
public class AxisTest {
		public static void main(String[] args) {
//	        String inConditions = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><ROWS><INFO><SBM>*</SBM></INFO><ROW><GMSFHM>公民身份号码</GMSFHM><XM>姓名</XM></ROW><ROW><GMSFHM>110101******</GMSFHM><XM>李闻</XM><FSD>100600</FSD><YWLX>个人贷款</YWLX></ROW><ROW><GMSFHM>3624221952123***</GMSFHM><XM>李一闻</XM><FSD>100600</FSD><YWLX>个人贷款</YWLX></ROW><ROW><GMSFHM>1234********</GMSFHM><XM>王龙</XM><FSD>100600</FSD><YWLX>银行开户</YWLX></ROW><ROW><GMSFHM>110101******</GMSFHM><XM></XM><FSD>100600</FSD><YWLX>个人车贷</YWLX></ROW><ROW><GMSFHM>110101******</GMSFHM><XM></XM><FSD>100600</FSD><YWLX></YWLX></ROW><ROW><GMSFHM>230602***</GMSFHM><XM></XM><FSD>100600</FSD><YWLX>个人车贷</YWLX></ROW></ROWS>";
//	        String inLicense = "********";  
//	         try{       
//	                //调用webservice地址      
//	                String url = "https://www.****.com/services/NciicServices"; 
//	                //调用方法名
//	                String method="nciicCheck";
//	                Service service = new Service();
//	                //通过service创建call对象     
//	                Call call = (Call) service.createCall();
//	                //设置服务地址
//	                call.setTargetEndpointAddress(new java.net.URL(url)); 
//	                //设置调用方法
//	                call.setOperationName(method);
//	                call.setUseSOAPAction(true);
//	                //添加方法的参数，有几个添加几个
//	                //inLicense是参数名，XSD_STRING是参数类型，IN代表传入
//	                call.addParameter("inLicense", org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN); 
//	                call.addParameter("inConditions", org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
//	                //设置返回类型  
//	                call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
//	                Object ret= null;
//	                try{
//	                    //使用invoke调用方法，Object数据放传入的参数值
//	                    ret = call.invoke(new Object[] {inLicense,inConditions});  
//	                }catch(Exception e){
//	                    e.printStackTrace();
//	                }
//	                //输出SOAP请求报文
//	                System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
//	                //输出SOAP返回报文
//	                System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
//	                //输出返回信息
//	                System.out.println("result==="+ret.toString()); 
//	        }catch(Exception e){
//	        e.printStackTrace();
//	        }
	    	
//	    	System.out.println("去去去");
	    	try {
				axisRequest();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }   
	    
	    
	    
	    public static void axisRequest() throws Exception{
	    	String url = "https://www.sxssmk.com/online_webservice/services/dispatchService";
			StringBuffer sb = new StringBuffer();
			sb.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
			sb.append("<root>");
			sb.append("<header desc=\"消息头\">");
				sb.append("<msgtype desc=\"消息类型码\">OLTP1001</msgtype>");
				sb.append("<unitid desc=\"商户编码\">111111000000001</unitid>");
				sb.append("<posid desc=\"终端编码\">999000000000</posid>");
				sb.append("<date desc=\"交易日期\">20181108</date>");
				sb.append("<time desc=\"交易时间\">212944</time>");
				sb.append("<mac desc=\"安全报文标识\">F8A2D1DA0BCFB311</mac>");
				sb.append("<version desc=\"版本号\">1.0</version>");
			sb.append("</header>");
			sb.append("<body desc=\"消息体\">");
				sb.append("<knh desc=\"非接应用序列号-卡内号\">3121800000670983</knh>");
				sb.append("<jyfs desc=\"交易方式\"></jyfs>");
				sb.append("<jylsh desc=\"交易流水号\">20181108093712</jylsh>");
				sb.append("<shddh desc=\"商户订单号\"></shddh>");
				sb.append("<kzhulx desc=\"IC卡数据域-卡主类型\">10</kzhulx>");
				sb.append("<kzilx desc=\"IC卡数据域-卡子类型\">01</kzilx>");
				sb.append("<yyyxrq desc=\"IC卡数据域-应用有效日期\">20181108</yyyxrq>");
				sb.append("<csdm desc=\"IC卡数据域-城市代码\">3121</csdm>");
				sb.append("<sjs desc=\"随机数\">12345678</sjs>");
				sb.append("<ljjyxh desc=\"非接触芯片-电子钱包联机交易序号\">00000001</ljjyxh>");
				sb.append("<jyqje desc=\"交易前金额(当前余额)\">00000000</jyqje>");
				sb.append("<jyje desc=\"交易金额\">100</jyje>");
				sb.append("<mac1 desc=\"非接触芯片-MAC1\">12345678</mac1>");
				sb.append("<ljzhmm desc=\"联机账户密码（密文）\">12345678</ljzhmm>");
			sb.append("</body>");
			sb.append("</root>");
			
			
			
				try {
					//调用方法名
					String method="service";
					Service service = new Service();
					//通过service创建call对象     
					Call call = (Call) service.createCall();
					//设置服务地址
					call.setTargetEndpointAddress(new java.net.URL(url)); 
					//设置调用方法
					call.setOperationName(method);
//					call.setUseSOAPAction(true);
					//添加方法的参数，有几个添加几个
					//inLicense是参数名，XSD_STRING是参数类型，IN代表传入
					//call.addParameter("inLicense", org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN); 
					call.addParameter("xml", org.apache.axis.encoding.XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
					//设置返回类型  
					call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
					Object ret= null;
					try{
					    //使用invoke调用方法，Object数据放传入的参数值
					    ret = call.invoke(new Object[]{sb.toString()});  
					}catch(Exception e){
					    e.printStackTrace();
					}
       
					//输出SOAP请求报文
					System.out.println("--SOAP Request: " + call.getMessageContext().getRequestMessage().getSOAPPartAsString());
					//输出SOAP返回报文
					System.out.println("--SOAP Response: " + call.getResponseMessage().getSOAPPartAsString());
					
					//输出返回信息
					System.out.println("result==="+ret.toString());
				} catch (AxisFault e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	    }
	    
}
