package com.jsp.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jsp.dao.MemberDAO;
import com.jsp.dao.MemberDAOImpl;
import com.jsp.datasource.OracleMybatisSqlSessionFactory;
import com.jsp.dto.MemberVO;



public class TestMemberDAOImpl {

	private SqlSessionFactory SqlSessionFactory = new OracleMybatisSqlSessionFactory();
	private SqlSession session;
	
	private MemberDAO memberDAO; // Before, Test 등 써야해서 전역으로 선언
	
	@Before
	public void init() {
		session = SqlSessionFactory.openSession(false);
		memberDAO = new MemberDAOImpl();
		
	}

	@Test
	public void testSelectMmberById() throws SQLException{
		String testID = "mimi";
		
		MemberVO member = memberDAO.selectMemberById(session, testID);
		
		Assert.assertEquals(testID,  member.getId());
	}
	
	
	@After
	public void complete() {
		session.rollback();
		session.close();
	}
	
}
