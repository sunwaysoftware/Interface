/**
 * 
 */
package com.sunway.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;

import com.sunway.dao.ITree00000DAO;
import com.sunway.vo.Tree00000;

/**
 * @author Andy
 *
 */
public class Tree00000DAO extends BaseDAO implements ITree00000DAO {

	
	private ArrayList<Tree00000> LoadTreeNode(String functionNm, Tree00000 bean) throws Exception {
		ArrayList<Tree00000> resultList = new ArrayList<Tree00000>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call TREE_GETINFO(:cur, " + functionNm + ", :infoID)}");
			//注册输出参数
			call.registerOutParameter("cur", OracleTypes.CURSOR);
			call.setString("infoID", bean.getId());
			call.execute();
			// 返回结果集
			rs = (ResultSet) call.getObject("cur"); 
			while (null!=rs && rs.next()) {
				Tree00000 b = new Tree00000();
				b.setId(rs.getString(1));
				b.setText(rs.getString(2));
				resultList.add(b);
				b = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return resultList;
	}
	
	/* (non-Javadoc)
	 * @see com.sunway.dao.ITree00000DAO#LoadTreeNode(com.sunway.vo.Tree00000)
	 */
	@Override
	public ArrayList<Tree00000> LoadZjlxTreeNode(Tree00000 bean) throws Exception {
		return LoadTreeNode("PGPKG_GLOBAL.FN_GetZJLX", bean);
	}

	@Override
	public ArrayList<Tree00000> LoadJzjgTreeNode(Tree00000 bean) throws Exception {
		return LoadTreeNode("PGPKG_GLOBAL.FN_GetJZJG", bean);
	}

	@Override
	public ArrayList<Tree00000> LoadGhytTreeNode(Tree00000 bean) throws Exception {
		return LoadTreeNode("PGPKG_GLOBAL.FN_GETSJYT_SC", bean);
	}

	@Override
	public ArrayList<Tree00000> LoadFwlxTreeNode(Tree00000 bean) throws Exception {
		return LoadTreeNode("PGPKG_GLOBAL.FN_GetFWLX_SC", bean);
	}

	@Override
	public ArrayList<Tree00000> LoadJylxTreeNode(Tree00000 bean) throws Exception {
		return LoadTreeNode("PGPKG_GLOBAL.FN_GetJYLX_SC", bean);
	}

	
	@Override
	public ArrayList<Tree00000> LoadPgfqTreeNode(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> resultList = new ArrayList<Tree00000>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call TREE_GETPGFQ(:cur, :szqy, :gjfq)}");
			//注册输出参数
			call.registerOutParameter("cur", OracleTypes.CURSOR);
			call.setString("szqy", bean.getAttributes());
			call.setString("gjfq", bean.getId());
			call.execute();
			// 返回结果集
			rs = (ResultSet) call.getObject("cur"); 
			while (null!=rs && rs.next()) {
				Tree00000 b = new Tree00000();
				b.setId(rs.getString(1));
				b.setText(rs.getString(2));
				b.setAttributes(rs.getString(3));
				resultList.add(b);
				b = null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return resultList;
	}
	/* (non-Javadoc)
	 * @see com.sunway.dao.ITree00000DAO#LoadTreeNode(com.sunway.vo.Tree00000)
	 */
	
	@Override
	public ArrayList<Tree00000> LoadTreeNode(Tree00000 bean) throws Exception {
		ArrayList<Tree00000> listResult = new ArrayList<Tree00000>();
		ResultSet rs = null;
		CallableStatement call = null;
		Connection conn = null;
		Session session = null;
		try {
			session = getSession();
			conn = super.getConnection();
			call = conn.prepareCall("{call PGSP_GETALLT000015(?,?,?)}");
			//注册输出参数
			call.registerOutParameter(1, OracleTypes.CURSOR);
			call.setString(2, bean.getAttributes());
			call.setString(3, bean.getId());
			call.execute();
			// 返回结果集
			rs = (ResultSet) call.getObject(1); 
			while(null!=rs && rs.next()){
				Tree00000 e = new Tree00000();
				e.setId(rs.getString(1));
				e.setText(rs.getString(2));
				e.setAttributes(rs.getString(3));
				listResult.add(e);
			}
		} catch (Exception e) {
//			LOG.error(e.getMessage());
			throw e;
		} finally {
			getFree(rs, call, conn, session);
		}
		return listResult;
	}
}
