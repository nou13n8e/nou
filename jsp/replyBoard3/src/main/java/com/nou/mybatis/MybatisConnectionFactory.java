package com.nou.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnectionFactory {
	//Factory Pattern
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/nou/mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}
}
