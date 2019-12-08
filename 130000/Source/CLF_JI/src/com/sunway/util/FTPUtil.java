/**
 * 
 */
package com.sunway.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

/**
 * @author Amani
 * 
 */
public class FTPUtil {

	private String ip = "";
	private String username = "";
	private String password = "";
	private int port;
	private FTPClient ftpClient = null;
	private FileOutputStream fos = null;
	private FileInputStream fis = null;
	
	public FTPUtil(String serverIP, String username, String password) {
		this.ip = serverIP;
		this.port = FTPClient.DEFAULT_PORT;
		this.username = username;
		this.password = password;
	}

	public FTPUtil(String serverIP, int port, String username, String password) {
		this.ip = serverIP;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	/**
	 * 连接ftp服务器
	 * @throws SocketException 
	 * 
	 * @throws IOException
	 */
	public boolean connectServer() throws SocketException, IOException {
		boolean bResult = false;
		ftpClient = new FTPClient(); 
		ftpClient.connect(this.ip, this.port);
		if (ftpClient.isConnected()) {
			System.out.println("FTP Connected.");
		}
		bResult = ftpClient.login(this.username, this.password);
		return bResult;
	}

	/**
	 * 断开与ftp服务器连接
	 * 
	 * @throws IOException
	 */
	public boolean closeServer() {
		try {
			if (ftpClient.isConnected()) {
				ftpClient.disconnect();
			}
			System.out.println("FTP Disconnect.");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

    /** 
     * FTP上传单个文件测试 
     */ 
    public boolean uploadFile(String localPath, String remotePath) {
    	Boolean bResult = false;

        try { 
            File srcFile = new File(localPath); 
            fis = new FileInputStream(srcFile); 
            //设置上传目录 
            ftpClient.changeWorkingDirectory(remotePath); 
            ftpClient.setBufferSize(1024); 
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.enterLocalPassiveMode();
            bResult = ftpClient.storeFile(new String(srcFile.getName().getBytes("GBK"), "iso-8859-1"), fis); 
        } catch (FileNotFoundException e) {    
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace(); 
        } finally { 
        	try {
				fis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
		return bResult; 
    } 

    /** 
     * FTP上传单个文件测试 
     */ 
    public boolean uploadFile(String fileName, File srcFile, String remotePath) {
    	Boolean bResult = false;

        try { 
            fis = new FileInputStream(srcFile); 
            //设置上传目录 
            ftpClient.changeWorkingDirectory(remotePath); 
            ftpClient.setBufferSize(1024); 
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.enterLocalPassiveMode();
            bResult = ftpClient.storeFile(new String(fileName.getBytes("GBK"), "iso-8859-1"), fis); 
        } catch (FileNotFoundException e) {    
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace(); 
        } finally { 
        	try {
				fis.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
        }
		return bResult; 
    }     
    
    /** 
     * FTP下载单个文件测试 
     */ 
    public boolean downloadFile(String localPath, String remotePath) { 
    	Boolean bResult = false;
        try { 
            fos = new FileOutputStream(localPath); 
            ftpClient.setBufferSize(1024); 
            //设置文件类型（二进制） 
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE); 
            ftpClient.retrieveFile(remotePath, fos); 
            bResult = true;
        } catch (FileNotFoundException e) {    
            e.printStackTrace();
        } catch (IOException e) { 
            e.printStackTrace(); 
        } finally { 
            try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
        }
		return bResult; 
    } 

}
