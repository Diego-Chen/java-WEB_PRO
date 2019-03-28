/**
 * 
 */
package com.cs.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * @author Administrator
 *
 */
public class test {
	 public static void main(String[] args) {
	        String ftpHost = "61.175.124.26";
	        String ftpUserName = "1234";
	        String ftpPassword = "123456";
	        int ftpPort = 2121;
	        String ftpPath = "/";
	        String localPath = "F:\\";
	        String fileName = "JQA000100000001011201709070000000000";

	        //上传一个文件
	        try{
	            FileInputStream in=new FileInputStream(new File(localPath));
	            boolean test = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,in);
	            System.out.println(test);
	        } catch (FileNotFoundException e){
	            e.printStackTrace();
	            System.out.println(e);
	        }
//
//	        //在FTP服务器上生成一个文件，并将一个字符串写入到该文件中
//	        try {
//	            InputStream input = new ByteArrayInputStream("test ftp jyf".getBytes("GBK"));
//	            boolean flag = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,input);;
//	            System.out.println(flag);
//	        } catch (UnsupportedEncodingException e) {
//	            e.printStackTrace();
//	        }
//
//	        //下载一个文件
	        FtpUtil.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);
	    }
}
