package com.example.security;

/** 현재 유저의 정보를 읽어온다.
 *  Threadlocal에 있는 로직을 사용함으로 @Ansyc 로직같은 곳에서 사용이 불가능하다.
 *  또한 값을 못가져 오는 상황이 발생하면
 *  0 또는 null을 반환한다는 것에 주의 해야한다.
 */
public class CurrentUser {
	
	public  static String getUserName(){
		return "TESTER";
		//return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
}
