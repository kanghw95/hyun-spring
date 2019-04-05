package com.hyun.jdbc.chap08_scan;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyun.jdbc.chap03.Member;

/**
 * p.204 [리스트 8.13]를 Main과 Service로 분리한 Service 부분
 * 
 * @author Jacob
 */
@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao=null;
	
	Logger logger = LogManager.getLogger();

	/**
	 * memberDao setter for injection
	 */

	public void selectAll() {
		List<Member> members = memberDao.selectAll(0, 100);
		logger.debug(members);
	}

	public void updateMember() {
		Member member = memberDao.selectByEmail("sunha0822@naver.com");
		member.setPassword("b");
		memberDao.update(member);
		logger.debug("Update complete.");
	}

	public void insertMember() {
		Member member = new Member();
		member.setEmail("qtqt@naver.com");
		member.setPassword("qtqt");
		member.setName("강현우");
		memberDao.insert(member);
		logger.debug("Insert complete.");
	}
}