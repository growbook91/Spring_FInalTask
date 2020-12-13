package com.mycom.batisapp.lab14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Lab14Controller {
	
	@Autowired
	Lab14ServiceImpl lab14Service;
	
	@RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
	public String boardlist(Model model) {
		model.addAttribute("list", lab14Service.getBoardList());
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addPost() {
		return "addpostform";
	}
	
	@RequestMapping(value = "/addok", method = RequestMethod.POST)
	public String addPostOK(Lab14VO vo) {
		if(lab14Service.insertBoard(vo) == 0)
			System.out.println("데이터 추가 실패");
		else
			System.out.println("데이터 추가 성공!!!");
		return "redirect:list";
	}
	
	@RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
	public String editPost(@PathVariable("id") int id, Model model) {
		Lab14VO lab14VO = lab14Service.getBoard(id);
		model.addAttribute("u", lab14VO);
		return "editform";
	}
	
	@RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") int id, Model model) {
		Lab14VO lab14VO = lab14Service.getBoard(id);
		model.addAttribute("u", lab14VO);
		return "detail";
	}
	
	@RequestMapping(value = "editform/editok", method = RequestMethod.POST)
	public String editPostOk(Lab14VO vo) {
		if(lab14Service.updateBoard(vo) == 0)
			System.out.println("데이터 수정 실패");
		else
			System.out.println("데이터 수정 성공!!!");
		return "redirect:../../batisapp/list";
	}
	
	@RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
	public String deletePostOk(@PathVariable("id") int id) {
		if(lab14Service.deleteBoard(id) == 0)
			System.out.println("데이터 삭제 실패");
		else
			System.out.println("데이터 삭제 성공!!!");
		return "redirect:../../batisapp/list";
	}
}
