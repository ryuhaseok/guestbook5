package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestVo;

@Repository
public class GuestDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//삭제
	public int guestDelete(GuestVo guestVo) {
		System.out.println("GeustDao.guestDelete()");
		
		int count = sqlSession.delete("guestbook.delete", guestVo);
		
		return count;
	}
	
	
	//등록
	public int insertGuestbook(GuestVo guestVo) {
		System.out.println("GeustDao.insertGuestbook()");
		
		int count = sqlSession.insert("guestbook.insert", guestVo);
		
		return count;
	}//
	
	
	//전체 가져오기
	public List<GuestVo> guestSelect() {
		System.out.println("GeustDao.guestSelect()");
		
		List<GuestVo> guestList = sqlSession.selectList("guestbook.select");
		System.out.println(guestList);
		
		return guestList;
	}//
	
	
}
