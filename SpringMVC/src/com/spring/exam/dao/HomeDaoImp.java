package com.spring.exam.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HomeDaoImp implements HomeDao {
	@Autowired
	public SqlSession sqlSession;
	public String getCustomer(String id) {
		return sqlSession.selectOne("SystemMapper");
	}
}
