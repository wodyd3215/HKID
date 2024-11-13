package com.kh.hkid.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor{

	/*
	 * HandlerInterceptor
	 * 
	 * -Controller�� ����Ǳ� ��/�Ŀ� ����ä�� ����ȴ�.
	 * -�α��� ��/���Ǵ�, ȸ������üũ 
	 * 
	 * preHandle(��ó��) : DispatcherServlet�� ��Ʈ�ѷ��� ȣ���ϱ� ���� ����ä�� ����
	 * postHandle(��ó��) : ��Ʈ�ѷ����� ��û �� DispatcherServlet���� view������ �����ϴ� ���� ����ä�� ����
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//return : true -> ������û�帧��� ����(Controller�� �̵�)
		//return : false -> ��û�ߴ��� ��ȯ
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null) {		// �α����� �Ǿ������� ������û ����
			return true;
		} else {	// �α��� �� �������� 
			session.setAttribute("alertMsg", "�α��� �� �̿밡���� �����Դϴ�.");
			response.sendRedirect(request.getContextPath()+"/loginForm.me");
			return false;
		}
	}
	
}