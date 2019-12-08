/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ITree00000Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Tree00000;

/**
 * 
 * 树型功能专用
 * 
 * @author Andy
 * 
 */
public class Tree00000Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1924221091428245147L;

	private ITree00000Service tree00000Service;
	private ArrayList<Tree00000> treeNodes = new ArrayList<Tree00000>();
	private String id;
	private String root;
	private String szqy;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	/**
	 * 读取《所在区域》列表
	 * 
	 * @return 所在区域列表
	 */
	public String readSzqyNode() {
		try {
			ArrayList<Pgv00052> szqyList = sessionCtrl.ReadSzqyList();
			for (Pgv00052 b : szqyList) {
				Tree00000 tree = new Tree00000();
				tree.setId(b.getCd00001Szqy());
				tree.setText(b.getSzqy());
				treeNodes.add(tree);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}

	/**
	 * 读取《证件类型》列表
	 * @return 所在区域列表
	 */
	public String readZjlxNode() {
		Tree00000 bean = new Tree00000();
		try {
			bean.setId(id);
			treeNodes = tree00000Service.LoadZjlxTreeNode(bean);
			for (Tree00000 b : treeNodes) {
				readZjlx(b);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	private void readZjlx(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> nodes = tree00000Service.LoadZjlxTreeNode(bean);
		if(nodes.size()>0) {
			bean.setChildren(nodes);
		} else {
			bean.setState("open");
		}
		for (Tree00000 b : nodes) {
			readZjlx(b);
		}
	}

	/**
	 * 读取《建筑结构》列表
	 * @return 所在区域列表
	 */
	public String readJzjgNode() {
		Tree00000 bean = new Tree00000();
		try {
			bean.setId(id);
			treeNodes = tree00000Service.LoadJzjgTreeNode(bean);
			for (Tree00000 b : treeNodes) {
				readJzjg(b);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}	
	private void readJzjg(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> nodes = tree00000Service.LoadJzjgTreeNode(bean);
		if(nodes.size()>0) {
			bean.setChildren(nodes);
		} else {
			bean.setState("open");
		}
		for (Tree00000 b : nodes) {
			readJzjg(b);
		}
	}	
	
	/**
	 * 读取《房屋类型》列表
	 * @return 所在区域列表
	 */
	public String readFwlxNode() {
		Tree00000 bean = new Tree00000();
		try {
			bean.setId(id);
			treeNodes = tree00000Service.LoadFwlxTreeNode(bean);
			for (Tree00000 b : treeNodes) {
				readFwlx(b);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}		
	private void readFwlx(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> nodes = tree00000Service.LoadFwlxTreeNode(bean);
		if(nodes.size()>0) {
			bean.setChildren(nodes);
		} else {
			bean.setState("open");
		}
		for (Tree00000 b : nodes) {
			readFwlx(b);
		}
	}
	
	/**
	 * 读取《规划用途》列表
	 * @return 所在区域列表
	 */
	public String readGhytNode() {
		Tree00000 bean = new Tree00000();
		try {
			bean.setId(id);
			treeNodes = tree00000Service.LoadGhytTreeNode(bean);
			for (Tree00000 b : treeNodes) {
				readGhyt(b);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}		
	private void readGhyt(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> nodes = tree00000Service.LoadGhytTreeNode(bean);
		if(nodes.size()>0) {
			bean.setChildren(nodes);
		} else {
			bean.setState("open");
		}
		for (Tree00000 b : nodes) {
			readGhyt(b);
		}
	}
	
	/**
	 * 读取《交易类型》列表
	 * @return 所在区域列表
	 */
	public String readJylxNode() {
		Tree00000 bean = new Tree00000();
		try {
			bean.setId(id);
			treeNodes = tree00000Service.LoadJylxTreeNode(bean);
			for (Tree00000 b : treeNodes) {
				readJylx(b);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}		
	private void readJylx(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> nodes = tree00000Service.LoadJylxTreeNode(bean);
		if(nodes.size()>0) {
			bean.setChildren(nodes);
		} else {
			bean.setState("open");
		}
		for (Tree00000 b : nodes) {
			readJylx(b);
		}
	}
	
	/**
	 * 读取《评估分区》列表
	 * @return 所在区域列表
	 */
	public String readPgfqNode() {
		Tree00000 bean = new Tree00000();
		
		try {
			if(!Common.isNullOrEmpty(szqy)){
				bean.setId(id);
				bean.setAttributes(szqy);
				treeNodes = tree00000Service.LoadPgfqTreeNode(bean);
				for (Tree00000 b : treeNodes) {
					readPgfq(b);
				}				
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}		
	private void readPgfq(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> nodes = tree00000Service.LoadPgfqTreeNode(bean);
		if(nodes.size()>0) {
			bean.setChildren(nodes);
		} else {
			bean.setState("open");
		}
		for (Tree00000 b : nodes) {
			readPgfq(b);
		}
	}	

	/**
	 * 读取《评估分区》列表
	 * @return 所在区域列表
	 */
	public String readPgfqNodeRemote() {
		Tree00000 bean = new Tree00000();
		
		try {
			if(!Common.isNullOrEmpty(szqy)){
				bean.setId(id);
				bean.setAttributes(szqy);
				treeNodes = tree00000Service.LoadPgfqTreeNode(bean);			
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}	
	
	/**
	 * 读取《税收管辖》节点
	 * @return
	 * @throws Exception
	 */
	public String readSsgxNode() throws Exception {
		Tree00000 bean = new Tree00000();
		if(Common.isNullOrEmpty(id))
			bean.setId(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		else
			bean.setId(id);
		bean.setAttributes(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
		treeNodes = tree00000Service.LoadTreeNode(bean);
		return SUCCESS;
	}
	/****************************** set and get ***********************************/

	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl = new SessionCtrl(session);
	}

	/**
	 * @param tree00000Service
	 *            the tree00000Service to set
	 */
	public void setTree00000Service(ITree00000Service tree00000Service) {
		this.tree00000Service = tree00000Service;
	}

	/**
	 * @return the tree00000Service
	 */
	@JSON(deserialize = false, serialize = false)
	public ITree00000Service getTree00000Service() {
		return tree00000Service;
	}

	/**
	 * @param treeNodes
	 *            the treeNodes to set
	 */
	public void setTreeNodes(ArrayList<Tree00000> treeNodes) {
		this.treeNodes = treeNodes;
	}

	/**
	 * @return the treeNodes
	 */
	public ArrayList<Tree00000> getTreeNodes() {
		return treeNodes;
	}

	/**
	 * @return the root
	 */
	public String getRoot() {
		return root;
	}

	/**
	 * @param root
	 *            the root to set
	 */
	public void setRoot(String root) {
		this.root = root;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the szqy
	 */
	public String getSzqy() {
		return szqy;
	}

	/**
	 * @param szqy the szqy to set
	 */
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}

}
