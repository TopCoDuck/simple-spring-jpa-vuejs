package com.example.security;

/** ���� ������ ������ �о�´�.
 *  Threadlocal�� �ִ� ������ ��������� @Ansyc �������� ������ ����� �Ұ����ϴ�.
 *  ���� ���� ������ ���� ��Ȳ�� �߻��ϸ�
 *  0 �Ǵ� null�� ��ȯ�Ѵٴ� �Ϳ� ���� �ؾ��Ѵ�.
 */
public class CurrentUser {
	
	public  static String getUserName(){
		return "TESTER";
		//return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
}
