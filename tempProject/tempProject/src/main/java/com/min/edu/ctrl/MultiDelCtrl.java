package com.min.edu.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.AnswerBoard_Impl;
import com.min.edu.dao.AnswerBoard_Interface;

public class MultiDelCtrl extends HttpServlet {

	private static final long serialVersionUID = 9136929595630859705L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		AnswerBoard_Interface dao = new AnswerBoard_Impl();
		String[] seqs = req.getParameterValues("check");
		if(seqs == null) {
			forward(req, resp, "./error.jsp");
		}else {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seq_", seqs);
		dao.multiDelete(map);
		forward(req, resp, "./boardlist.do");
		}
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

}
