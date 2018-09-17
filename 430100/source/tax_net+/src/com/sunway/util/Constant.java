/**
 * 
 */
package com.sunway.util;

import java.io.Serializable;

/**
 * @author Andy.Gao
 *
 */
public class Constant implements Serializable {

	private static final long serialVersionUID = -3156353164238866486L;
	
	/**
	 * 操作模式：新增
	 */
	public static final String MOD_CREATE = "C"; 
	/**
	 * 操作模式：删除
	 */
	public static final String MOD_DELETE = "D";
	/**
	 * 操作模式：只读
	 */
	public static final String MOD_READONLY = "R";
	/**
	 * 操作模式：修改
	 */
	public static final String MOD_UPDATE = "U";
	/**
	 * 操作模式：变更
	 */
	public static final String MOD_MODIFY = "M";
	/**
	 * 空字符串("")
	 */
	public static final String STRING_EMPTY = "";
	/**
	 * 数据页面大小（记录数）
	 */
	public static final Integer PAGE_SIZE = 20;
	/**
	 * 数据页面第一页（默认显示的当前页）
	 */
	public static final String PAGE_FIRST = "1";
	/**
	 * 通配符%[模糊查询用]
	 */
	public static final String STRING_PERCENT = "%";
	
	/**
	 * 逗号
	 */
	public static final String STRING_COMMA = ",";
	
	/**
	 * 回车换行符
	 */
	public static final String STRING_ENTER = "\n";
	
	/**
	 * 日期格式
	 */
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	
	/**
	 * DES密钥
	 */
	public static final String DES_KEY = "SUNWAY99";
	
	/**
	 * 新增成功信息
	 */
	public static final String MSG_CREATE_OK = "app.msg.create.ok";
	
	/**
	 * 新增失败信息
	 */
	public static final String MSG_CREATE_NG = "app.msg.create.ng";
	
	/**
	 * 数据选择成功
	 */
	public static final String MSG_CHOISE_OK = "app.msg.choise.ok";
	
	/**
	 * 数据选择失败
	 */
	public static final String MSG_CHOISE_NG = "app.msg.choise.ng";
	
	/**
	 * 检验成功信息
	 */
	public static final String MSG_CHECKOUT_OK = "app.msg.checkout.ok";
	
	/**
	 * 检验失败信息
	 */
	public static final String MSG_CHECKOUT_NG = "app.msg.checkout.ng";
	
	/**
	 * 更新成功信息
	 */
	public static final String MSG_UPDATE_OK = "app.msg.update.ok";
	
	/**
	 * 更新失败信息
	 */
	public static final String MSG_UPDATE_NG = "app.msg.update.ng";	
	
	/**
	 * 删除成功信息
	 */
	public static final String MSG_DELETE_OK = "app.msg.delete.ok";
	
	/**
	 * 删除失败信息
	 */
	public static final String MSG_DELETE_NG = "app.msg.delete.ng";

	/**
	 * 删除成功信息
	 */
	public static final String MSG_COPY_OK = "app.msg.copy.ok";
	
	/**
	 * 删除失败信息
	 */
	public static final String MSG_COPY_NG = "app.msg.copy.ng";
	
	/**
	 * 审核执行完毕
	 */
	public static final String MSG_AUDIT_EXEC_OK = "app.msg.audit.exec.ok";
	
	/**
	 * 审核执行失败
	 */
	public static final String MSG_AUDIT_EXEC_NG = "app.msg.audit.exec.ng";	
	
	/**
	 * 重新审核执行完毕
	 */
	public static final String MSG_AUDIT_EXECR_OK = "app.msg.audit.execR.ok";

	/**
	 * 重新审核执行失败
	 */
	public static final String MSG_AUDIT_EXECR_NG = "app.msg.audit.execR.ng";

	/**
	 * 计税比率：70%
	 */
	public static final String JSBL = "70";

	/**
	 * 税率：1.2%
	 */
	public static final String SL = "1.2";
	
	public static final String CHARSET_UTF8 = "UTF-8";
	
	public static final String CHARSET_GBK = "GBK";

	/**
	 * 添加执行完毕
	 */
	public static final String MSG_ADD_EXEC_OK = "app.msg.add.exec.ok";

	/**
	 * 添加执行失败
	 */
	public static final String MSG_ADD_EXEC_NG = "app.msg.add.exec.ng";

	/**
	 * 重新添加执行完毕
	 */
	public static final String MSG_ADD_EXECR_OK = "app.msg.add.execR.ok";

	/**
	 * 重新添加执行失败
	 */
	public static final String MSG_ADD_EXECR_NG = "app.msg.add.execR.ng";
	
	/**
	 * 失败信息(重复)
	 */
	public static final String MSG_NG_ITERANCE = "app.msg.ng.iterance";

	/**
	 * 状态默认值(-1)
	 */
	public static final String ZT_DEFAULT = "-1";

	/**
	 * 备份执行完毕
	 */
	public static final String MSG_BACKUP_EXEC_OK = "app.msg.backup.exec.ok";

	/**
	 * 备份执行失败
	 */
	public static final String MSG_BACKUP_EXEC_NG = "app.msg.backup.exec.ng";

	/**
	 * 重新计算执行完毕
	 */
	public static final String MSG_SS_EXECR_OK = "app.msg.ss.execR.ok";

	/**
	 * 重新计算执行失败
	 */
	public static final String MSG_SS_EXECR_NG = "app.msg.ss.execR.ng";
	
	/**
	 * 重新评税执行完毕
	 */
	public static final String MSG_PG_EXECR_OK = "app.msg.pg.execR.ok";

	/**
	 * 重新评税执行失败
	 */
	public static final String MSG_PG_EXECR_NG = "app.msg.pg.execR.ng";
}
