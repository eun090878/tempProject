package com.min.edu.ctrl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.AnswerBoard_Impl;
import com.min.edu.dao.AnswerBoard_Interface;
import com.min.edu.dto.AnswerBoard_Dto;

public class DetailBoardCtrl extends HttpServlet {

	private static final long serialVersionUID = -4893628252686380076L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String seq = req.getParameter("seq");
		AnswerBoard_Interface dao = new AnswerBoard_Impl();
		AnswerBoard_Dto dto = dao.selectDetailBoard(seq);
		Date nowDate = new Date();
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		dto.setRegdate(sdFormat.format(nowDate));
		req.setAttribute("dto", dto);
		forward(req, resp, "/WEB-INF/view/detailboard.jsp");
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}


}
