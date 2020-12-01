package com.min.edu.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import com.min.edu.dao.AnswerBoard_Impl;
import com.min.edu.dao.AnswerBoard_Interface;
import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.RainbowBoardPagingDto;
import com.min.edu.mybatis.SqlDaoSupport;

public class AnswerBoard_TestMain {

	public static void main(String[] args) {
		// Mybatis 연결 확인
//		SqlSessionFactory manager =  SqlDaoSupport.getFactory();
//		manager.openSession();
		
		AnswerBoard_Interface dao = new AnswerBoard_Impl();
		AnswerBoard_Dto dto = new AnswerBoard_Dto();
		Map<String, String[]> map = new HashMap<String, String[]>();
		// 전체조회
//		dao.selectAllBoard();
		// 게시글 상세
//		dao.selectDetailBoard("100");
		// 답글입력
		dto.setId("zz");
//		dto.setSeq(100);
//		dto.setTitle("zz");
//		dto.setContent("zz");
//		dao.replayBoard(dto);
		// 게시글 수정
//		dto.setSeq(100);
//		dto.setTitle("zz");
//		dto.setContent("zz");		
//		dao.modifyBoard(dto);
		// Root글 입력
//		dto.setId("zz");
//		dto.setTitle("zz");
//		dto.setContent("zz");	
//		dao.inserBoard(dto);
		// 진짜삭제
//		dao.deleteBoardReal("100");
		// 다중삭제
//		String [] seqs = {"100","101","102"};
//		map.put("seq_", seqs);
//		dao.multiDelete(map);
		

	}

}
