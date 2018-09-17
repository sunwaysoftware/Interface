/**
 * 
 */
package com.sunway.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author Andy.Gao
 * 
 */
public class Common implements Serializable {

	private static final long serialVersionUID = -4863487906623284777L;

	/**
	 * 将集合输出为CSV
	 * 
	 * @param list
	 * @return
	 */
	public static InputStream exportCSV(StringBuffer strBuf) {
		InputStream resultStream = null;
		if (strBuf != null && strBuf.length() > 0) {
			try {
				byte[] excelString = strBuf.toString().getBytes(Constant.CHARSET_GBK);
				resultStream = new ByteArrayInputStream(excelString, 0, excelString.length);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultStream;
	}

	/**
	 * 输出为TEXT
	 * 
	 * @param strBuf
	 * @return
	 */
	public static InputStream exportTEXT(StringBuffer strBuf) {
		InputStream resultStream = null;
		if (strBuf != null && strBuf.length() > 0) {
			try {
				byte[] excelString = strBuf.toString().getBytes(Constant.CHARSET_UTF8);
				resultStream = new ByteArrayInputStream(excelString, 0, excelString.length);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				byte[] excelString = "".getBytes(Constant.CHARSET_UTF8);
				resultStream = new ByteArrayInputStream(excelString, 0, excelString.length);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resultStream;
	}

	public static Integer getPageSize(Integer pageSize) {
		if (pageSize == null) {
			return 20;
		} else {
			return pageSize;
		}
	}

	/**
	 * 去掉逗号
	 * 
	 * @param oldStr
	 * @return
	 */
	public static String removeComma(String oldStr) {
		if (!CheckUtil.chkEmpty(oldStr)) {
			String newStr = oldStr.substring(0, oldStr.length() - 1);
			return newStr;
		}
		return Constant.STRING_EMPTY;
	}

	/**
	 * 装载文件路径
	 * 
	 * @param path
	 */
	@SuppressWarnings("unchecked")
	public static void addUploadFiles(String path) {
		ArrayList<String> uploadFileArray = (ArrayList<String>) ActionContext.getContext().getSession().get("uploadFileArrayList");
		if(null==uploadFileArray){
			uploadFileArray = new ArrayList<String>();
		}
		uploadFileArray.add(path);
		ActionContext.getContext().getSession().put("uploadFileArrayList", uploadFileArray);
	}

	/**
	 * SESSION失效删除该SESSION上传的文件
	 * 
	 * @param filePaths
	 */
	public static void removeUploadFiles(ArrayList<String> filePaths) {
		if (null != filePaths && filePaths.size() > 0) {
			for (int i = 0; i < filePaths.size(); i++) {
				(new File(filePaths.get(i))).delete();
			}
		}

	}

	/**
	 * 转换丘地号格式
	 * 
	 * @param value
	 * @return
	 */
	public static String formatQDH(String value) {
		if (!CheckUtil.chkEmpty(value)) {
			return value.replace(",", " ");
		} else {
			return value;
		}
	}

	public static String converType(String str){
		String tmpStr = "";
		try {
			int i = str.indexOf("--");
			if(i!=-1){
				tmpStr = str.substring(0,i);
			}else{
				tmpStr = str;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmpStr;
	}	
	
	/**
	 * 用户权限转换String
	 * 
	 * @param roleList
	 * @return roleString
	 */
	public static String converRoleListToString(ArrayList<String> roleList)
	{
		String userRole = null;
		try {
			for (Integer i = 0; i < roleList.size(); i++) {
				userRole = CheckUtil.chkNull(userRole) + roleList.get(i)
						+ Constant.STRING_COMMA;
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return userRole;
	}	
	
	//得到模板的文件路径
	public static String excelPath(String fileName)
	{
		String root_path = ServletActionContext.getServletContext()
				.getRealPath("/");
		root_path = root_path.replace('\\', '/');
		return root_path + "/reports/" + fileName;
	}
	
}
