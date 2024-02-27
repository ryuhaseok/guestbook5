package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	
	
	@RequestMapping(value="/guest/addlistform", method= {RequestMethod.GET, RequestMethod.POST})
	public String addListForm(Model model) {
		System.out.println("GuestbookController.addListForm()");
		
		List<GuestVo> guestList = guestbookService.exeList();
		model.addAttribute("guestList", guestList);
		
		return "/WEB-INF/views/addList.jsp";
	}
	
	@RequestMapping(value="/guest/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.add()");
		
		guestbookService.exeAdd(guestVo);
		
		return "redirect:/guest/addlistform";
	}
	
	@RequestMapping(value="/guest/deleteform", method= {RequestMethod.GET, RequestMethod.POST})
	public String deleteForm(@RequestParam(value="no") int no,
							 Model model) {
		System.out.println("GuestbookController.deleteForm()");
		
		model.addAttribute("no", no);
		
		return "/WEB-INF/views/deleteForm.jsp";
	}
	
	@RequestMapping(value="/guest/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@ModelAttribute GuestVo guestVo) {
		System.out.println("GuestbookController.delete()");
		
		guestbookService.exeDelete(guestVo);
		
		return "redirect:/guest/addlistform";
	}

}
