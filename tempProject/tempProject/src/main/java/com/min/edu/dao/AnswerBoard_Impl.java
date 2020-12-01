package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.RainbowBoardPagingDto;
import com.min.edu.mybatis.SqlDaoSupport;

public class AnswerBoard_Impl implements AnswerBoard_Interface {

	private final String NS = "edu.application.exam.";
	private Logger log = Logger.getLogger(AnswerBoard_Impl.class);
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();

	@Override
	public List<AnswerBoard_Dto> selectAllBoard() {
		log.info("전체 게시글 조회");
		List<AnswerBoard_Dto> lists = null;
		SqlSession session = manager.openSession();
		lists = session.selectList(NS+"selectAllBoard");
		session.close();
		log.info("전체 게시글 조회");
		return lists;
	}

	@Override
	public AnswerBoard_Dto selectDetailBoard(String seq) {
		log.info("게시글 상세 보기");
		AnswerBoard_Dto dto = null;
		SqlSession session = manager.openSession();
		dto = session.selectOne(NS+"selectDetailBoard", seq);
		session.close();
		log.info("게시글 상세 보기");
		return dto;
	}

	@Override
	public boolean replayBoard(AnswerBoard_Dto dto) {
		log.info("답글입력");
		int n = 0;
		SqlSession session = manager.openSession(true);
		n = session.update(NS+"replyBoardUp", dto);
		n = session.insert(NS+"replyBoardIn", dto);
		session.close();
		log.info("답글입력");
		return (n>0)?true:false;
	}

	@Override
	public boolean modifyBoard(AnswerBoard_Dto dto) {
		log.info("게시글 수정");
		int n = 0;
		SqlSession session = manager.openSession(true);
		n = session.update(NS+"modifyBoard", dto);
		session.close();
		log.info("게시글 수정");
		return (n>0)?true:false;
	}

	@Override
	public boolean inserBoard(AnswerBoard_Dto dto) {
		log.info("Root글 입력");
		int n = 0;
		SqlSession session = manager.openSession(true);
		n = session.insert(NS+"inserBoard", dto);
		session.close();
		log.info("Root글 입력");
		return (n>0)?true:false;
	}

	@Override
	public boolean deleteBoardReal(String seq) {
		log.info("진짜삭제");
		int n = 0;
		SqlSession session = manager.openSession(true);
		n = session.delete(NS+"deleteBoardReal", seq);
		session.close();
		log.info("진짜삭제");
		return (n>0)?true:false;
	}

	@Override
	public boolean multiDelete(Map<String, String[]> map) {
		log.info("다중삭제");
		int n = 0;
		SqlSession session = manager.openSession(true);
		n = session.delete(NS+"multiDelete", map);
		session.close();
		log.info("다중삭제");
		return (n>0)?true:false;
	}

	@Override
	public int getListCount() {
		log.info("전체 게시글 수 조회");
		int n = 0;
		SqlSession session = manager.openSession();
		n = session.selectOne(NS+"getListCount");
		session.close();
		log.info("전체 게시글 수 조회");
		return n;
	}

	@Override
	public List<AnswerBoard_Dto> getPageList(Map<String, Integer> map) {
		log.info("현재 페이지에 뿌릴 게시글");
		List<AnswerBoard_Dto> lists = null;
		SqlSession session = manager.openSession();
		lists = session.selectList(NS+"getPageList", map);
		session.close();
		log.info("현재 페이지에 뿌릴 게시글");
		return lists;
	}

}
