package com.hyun.jdbc.chap03;

/**
 * MemberRegisterService를 테스트한다.<br>
 * new를 사용해서 직접 인스턴스를 생성한다.
 * 
 * @author 
 */
public class MemberMain {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();
		MemberRegisterService regService = new MemberRegisterService();
		regService.setMemberDao(memberDao);

		// registerRequest 초기화
		RegisterRequest req = new RegisterRequest();
		req.setEmail("kanghw95@naver.com");
		req.setPassword("xxxx");
		req.setName("kanghw95");

		// 회원 등록
		regService.regist(req);
	}
}