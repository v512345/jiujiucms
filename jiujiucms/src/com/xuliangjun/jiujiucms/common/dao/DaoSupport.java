package com.xuliangjun.jiujiucms.common.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("daoSupport")
public class DaoSupport implements DAO {

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object findForObject(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}


}


