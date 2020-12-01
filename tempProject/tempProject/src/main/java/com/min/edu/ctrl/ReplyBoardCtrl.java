package com.min.edu.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.AnswerBoard_Impl;
import com.min.edu.dao.AnswerBoard_Interface;
import com.min.edu.dto.AnswerBoard_Dto;

public class ReplyBoardCtrl extends HttpServlet {

	private static final long serialVersionUID = -810274070743733993L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String seq = req.getParameter("seq");
		String title = req.getParameter("title");
		String id = req.getParameter("id");
		String content = req.getParameter("content");
		AnswerBoard_Interface dao = new AnswerBoard_Impl();
		AnswerBoard_Dto dto = new AnswerBoard_Dto();
		dto.setSeq(Integer.parseInt(seq));
		dto.setId(id);
		dto.setTitle(title);
		dto.setContent(content);
		dao.replayBoard(dto);
		forward(req, resp, "./boardlist.do");
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}



}
