package com.company01.springEx01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company01.springEx01.logic.Board;
import com.company01.springEx01.service.BoardService;


@Controller
@RequestMapping("view/*")
public class ViewController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("view/dashboard")
	public ModelAndView dashboard() {
		List<Board> result = boardService.getBoardList(); 
		System.out.println(result);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result); 
		
		return mav;
	}
	
	@RequestMapping(value="view/boardwrite",method = RequestMethod.GET)
	public ModelAndView boardwrite() {
		ModelAndView mav = new ModelAndView();
		return mav; 
	}
	
	@RequestMapping(value="view/boardDetail",method = RequestMethod.GET)
	public ModelAndView boardDetail(int id) {
		boardService.viewsUpdate(id);
		Board result = boardService.getBoardDetail(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("result",result);
		return mav;
	}
	
}