package com.example.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class SimpleLogoutSuccessHandler implements LogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
        Map<String, Object> dummyData1 = new HashMap<String,Object>();
        dummyData1.put("error", false);
        dummyData1.put("message", "정상적으로 로그 아웃 되었습니다.");
		
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        ObjectMapper om = new ObjectMapper();
        PrintWriter out = response.getWriter();
        out.print(om.writeValueAsString(dummyData1));
        out.flush();
        out.close();
	}

}
