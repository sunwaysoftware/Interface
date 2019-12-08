/**
 * 
 */
package com.sunway.service.impl;

import java.util.ArrayList;

import com.sunway.dao.ITree00000DAO;
import com.sunway.service.ITree00000Service;
import com.sunway.vo.Tree00000;

/**
 * @author Andy
 *
 */
public class Tree00000Service implements ITree00000Service {

	private ITree00000DAO tree00000Dao;
	
	/* (non-Javadoc)
	 * @see com.sunway.service.ITree00000Service#LoadTreeNode(com.sunway.vo.Tree00000)
	 */
	@Override
	public ArrayList<Tree00000> LoadZjlxTreeNode(Tree00000 bean) throws Exception {
		return tree00000Dao.LoadZjlxTreeNode(bean);
	}

	@Override
	public ArrayList<Tree00000> LoadJzjgTreeNode(Tree00000 bean) throws Exception {
		return tree00000Dao.LoadJzjgTreeNode(bean);
	}

	@Override
	public ArrayList<Tree00000> LoadGhytTreeNode(Tree00000 bean) throws Exception {
		return tree00000Dao.LoadGhytTreeNode(bean);
	}

	@Override
	public ArrayList<Tree00000> LoadFwlxTreeNode(Tree00000 bean) throws Exception {
		return tree00000Dao.LoadFwlxTreeNode(bean);
	}

	@Override
	public ArrayList<Tree00000> LoadJylxTreeNode(Tree00000 bean) throws Exception {
		return tree00000Dao.LoadJylxTreeNode(bean);
	}

	@Override
	public ArrayList<Tree00000> LoadPgfqTreeNode(Tree00000 bean) throws Exception {
		return tree00000Dao.LoadPgfqTreeNode(bean);
	}	
	
	@Override
	public ArrayList<Tree00000> LoadTreeNode(Tree00000 bean) throws Exception {
		
		return tree00000Dao.LoadTreeNode(bean);
	}

	/********************************************************/
	
	/**
	 * @param tree00000Dao the tree00000Dao to set
	 */
	public void setTree00000Dao(ITree00000DAO tree00000Dao) {
		this.tree00000Dao = tree00000Dao;
	}

	/**
	 * @return the tree00000Dao
	 */
	public ITree00000DAO getTree00000Dao() {
		return tree00000Dao;
	}

	
}
