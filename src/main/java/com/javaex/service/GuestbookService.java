package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestDao;
import com.javaex.vo.GuestVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestDao guestDao;
	
	public List<GuestVo> exeList() {
		System.out.println("GuestbookService.exeList()");
		
		List<GuestVo> guestList = guestDao.guestSelect();
		
		return guestList;
	}
	
	public int exeAdd(GuestVo guestVo) {
		System.out.println("GuestbookService.exeAdd()");
		
		int count = guestDao.insertGuestbook(guestVo);
		
		return count;
	}
	
	public int exeDelete(GuestVo guestVo) {
		System.out.println("GuestbookService.exeDelete()");
		
		int count = guestDao.guestDelete(guestVo);
		
		return count;
	}

}
