package com.example.demo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertMember(Member member) {
		return this.sqlSession.insert("com.example.demo.dao.MemberDao.insertMember", member);
	}
}
