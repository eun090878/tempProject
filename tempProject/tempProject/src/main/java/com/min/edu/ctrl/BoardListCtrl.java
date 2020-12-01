package com.min.edu.ctrl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.edu.dao.AnswerBoard_Impl;
import com.min.edu.dao.AnswerBoard_Interface;
import com.min.edu.dto.AnswerBoard_Dto;
import com.min.edu.dto.RainbowBoardPagingDto;

public class BoardListCtrl extends HttpServlet {

	private static final long serialVersionUID = 7117297641002042854L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String page = req.getParameter("page");
		if (page == null) {
			page = "1";
		}
		if (Integer.parseInt(page) < 1) {
			page = "1";
		}
		AnswerBoard_Impl dao = new AnswerBoard_Impl();
		int totalCount = dao.getListCount();
		Map<String, Integer> map = new HashMap<String, Integer>();
		RainbowBoardPagingDto PDto = new RainbowBoardPagingDto(Integer.parseInt(page), totalCount);
		int last = Integer.parseInt(page) * PDto.getCountList();
		int first = last - (PDto.getCountList() - 1);
		map.put("first", first);
		map.put("last", last);
		System.out.println(map);
		List<AnswerBoard_Dto> lists = dao.getPageList(map);
		Date nowDate = new Date();
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < lists.size(); i++) {
			lists.get(i).setTitle(lists.get(i).getBoardListTitle());
			lists.get(i).setRegdate(sdFormat.format(nowDate));
		}
		req.setAttribute("lists", lists);
		req.setAttribute("page", page);
		req.setAttribute("PDto", PDto);
		forward(req, resp, "/WEB-INF/view/boardlist.jsp");
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp, String url)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);
	}

}
