package com.example.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class SimpleAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("SimpleAuthenticationFailureHandler");
		
		// TODO Auto-generated method stub
        Map<String, Object> dummyData1 = new HashMap<String,Object>();
        dummyData1.put("error", true);
        dummyData1.put("message", exception.getLocalizedMessage());
		
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        ObjectMapper om = new ObjectMapper();
        PrintWriter out = response.getWriter();
        out.print(om.writeValueAsString(dummyData1));
        out.flush();
        out.close();
	}

}
