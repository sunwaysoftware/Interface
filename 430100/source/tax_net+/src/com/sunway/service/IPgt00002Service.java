package com.sunway.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00002;


/**
 * @category 用户表维护
 * @author Lee
 * @version 1.0
 */
public interface IPgt00002Service {

	/**
	 * 进行数据增加操作
	 * @return
	 * @throws Exception
	 */
	public boolean GetInsertCommand(Pgt00002 user) throws Exception;
	
	/**
	 * 进行数据删除操作
	 * @return
	 * @throws Exception
	 */
	public boolean GetDeleteCommand(Pgt00002 user) throws Exception;
	
	/**
	 * 进行数据更新操作
	 * @return
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00002 user) throws Exception;
	
	/**
	 * 进行数据提取操作
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00002> LoadAll(Pgv00002 user) throws Exception;
	
	/**
	 * 根据PK进行数据提取操作
	 * @return
	 * @throws Exception
	 */
	public Pgt00002 LoadByPrimaryKey(Pgt00002 user) throws Exception;
	
	/**
	 * 根据用户组ID取得用户
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00002> LoadUsersByRole(Pgt00003 role) throws Exception;
	
	/**
	 * 根据权限ID取得用户
	 * @param role
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Pgv00002> LoadUsersByRight(Pgt00004 right) throws Exception;
	
	/**
	 * 验证用户
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Pgt00002 CheckLogin(Pgt00002 user) throws Exception;
	
	/**
	 * 根据用户ID取得权限列表(用户自身和所在用户组)
	 * @param user 用户ID
	 * @return 权限列表
	 * @throws Exception
	 */
	public ArrayList<String> LoadRightByUser(Pgt00002 user) throws Exception;
	
	/**
	 * 初始化用户密码
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean InitPWD(Pgt00002 user) throws Exception;
	
	/**
	 * 设置用户常规设置
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean SettingPersonal(Pgt00002 user) throws Exception;
	
	
	/**
	 * 修改用户密码
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public String ChangePWD(Pgt00002 user) throws Exception;
	
	/**
	 * 进行数据导出操作.
	 */
	public ByteArrayOutputStream ExportAll(Pgv00002 user) throws Exception;
	
	/**
	 * 验证用户是否有审核权限
	 * @return
	 * @throws Exception
	 */
	public Pgt00002 ChkVerify(Pgt00002 user) throws Exception;
}
