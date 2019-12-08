package com.sunway.service;

import com.sunway.vo.Cz00042;

/**
 * 税率测算
 * @category 评税结果处理
 * @author Lee
 * @version 1.0
 *
 */
public interface ICz00042Service {

	/**
	 * 进行数据提取操作
	 */
	public Cz00042 LoadAll(Cz00042 cz00042) throws Exception;
}
