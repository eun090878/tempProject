package com.min.edu.dao;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.RainbowBoardPagingDto;

public interface AnswerBoard_Interface {
	
	
	//전체조회 (페이징이 없는)
	public List<AnswerBoard_Dto> selectAllBoard();
	//상세조회
	public AnswerBoard_Dto selectDetailBoard(String seq);
	// 답글 작성
	public boolean replayBoard(AnswerBoard_Dto dto);
	// 글 수정 
	public boolean modifyBoard(AnswerBoard_Dto dto);
	// 글 입력 
	public boolean inserBoard(AnswerBoard_Dto dto);
	// 진짜삭제(상세보기)
	public boolean deleteBoardReal(String seq);
	// 다중삭제(전체조회)
	public boolean multiDelete(Map<String, String[]> map);
	
	
	// 페이징관련 메소드
	// 전체 글의 갯수
	public int getListCount();
	// 페이징 DTO를 이용한 글범위 리스트 조회
	public List<AnswerBoard_Dto> getPageList(Map<String, Integer> map);
	
	
}












