package com.min.edu.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class SqlDaoSupport {

	private static SqlSessionFactory factory;
	private static Logger log = Logger.getLogger(SqlDaoSupport.class);
	
	static {
		try {
			log.info("SqlSessionFactory 객체 생성 시작");
			String path = "com/min/edu/mybatis/Configuration.xml";
			Reader read = Resources.getResourceAsReader(path);
			factory = new SqlSessionFactoryBuilder().build(read);
			read.close();
			log.info("SqlSessionFactory 객체 생성 완료");
		} catch (IOException e) {
			log.info("SqlSessionFactory 객체 생성 실패");
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	
	
}
