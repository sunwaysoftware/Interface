/**
 * 
 */
package com.sunway.dao;

import java.util.ArrayList;

import com.sunway.vo.Tree00000;

/**
 * @author Andy
 *
 */
public interface ITree00000DAO {

	/**
	 * 读取[证件类型]子节点
	 * @param bean 父节点ID
	 * @return 子节点列表
	 * @throws Exception
	 */
	public ArrayList<Tree00000> LoadZjlxTreeNode(Tree00000 bean) throws Exception;

	/**
	 * 读取[建筑结构]子节点
	 * @param bean 父节点ID
	 * @return 子节点列表
	 * @throws Exception
	 */
	public ArrayList<Tree00000> LoadJzjgTreeNode(Tree00000 bean) throws Exception;
	
	/**
	 * 读取[规划用途]子节点
	 * @param bean 父节点ID
	 * @return 子节点列表
	 * @throws Exception
	 */
	public ArrayList<Tree00000> LoadGhytTreeNode(Tree00000 bean) throws Exception;	

	/**
	 * 读取[房屋类型]子节点
	 * @param bean 父节点ID
	 * @return 子节点列表
	 * @throws Exception
	 */
	public ArrayList<Tree00000> LoadFwlxTreeNode(Tree00000 bean) throws Exception;
	
	/**
	 * 读取[交易类型]子节点
	 * @param bean 父节点ID
	 * @return 子节点列表
	 * @throws Exception
	 */
	public ArrayList<Tree00000> LoadJylxTreeNode(Tree00000 bean) throws Exception;	
	
	/**
	 * 读取[评估分区]子节点
	 * @param bean 父节点ID
	 * @return 子节点列表
	 * @throws Exception
	 */
	public ArrayList<Tree00000> LoadPgfqTreeNode(Tree00000 bean) throws Exception;

	/**
	 * 根据树节点读取子节点
	 * @param bean 父节点ID
	 * @return 子节点列表
	 * @throws Exception
	 */
	public ArrayList<Tree00000> LoadTreeNode(Tree00000 bean) throws Exception;
}
