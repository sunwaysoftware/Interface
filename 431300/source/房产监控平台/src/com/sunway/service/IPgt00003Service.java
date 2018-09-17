package com.sunway.service;

import com.sunway.vo.Pgt00003;

public interface IPgt00003Service {
	/**
	 * 进行数据更新操作
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public boolean GetUpdateCommand(Pgt00003 expriyDays) throws Exception;
	public Pgt00003 LoadByPrimaryKey() throws Exception;
}
