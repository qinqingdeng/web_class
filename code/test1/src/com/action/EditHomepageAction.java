package com.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.pojo.UserEdit;
import com.dao.UserEditDao;

public class EditHomepageAction extends HttpServlet {
	UserEditDao dao = new UserEditDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
//从表单获取各项信息的内容字段-季宇恒
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("userid");
		String name = req.getParameter("name");
		name = new String(name.getBytes("iso-8859-1"),"utf-8");
		String sex = req.getParameter("sex");
		sex = new String(sex.getBytes("iso-8859-1"),"utf-8");
		System.out.println(sex);
		String province = req.getParameter("province");
		province = new String(province.getBytes("iso-8859-1"),"utf-8");
		String city = req.getParameter("city");
		city = new String(city.getBytes("iso-8859-1"),"utf-8");
		String birthday = req.getParameter("birthday");
		String school = req.getParameter("school");
		school = new String(school.getBytes("iso-8859-1"),"utf-8");
		String profession = req.getParameter("profession");
		profession = new String(profession.getBytes("iso-8859-1"),"utf-8");
		String introduce = req.getParameter("introduce");
		introduce = new String(introduce.getBytes("iso-8859-1"),"utf-8");
		UserEdit u = new UserEdit();
		u.setUid(id);
		u.setUname(name);		   
		u.setUsex(sex);
		u.setUprovince(province);
		u.setUcity(city);
		u.setUbirthday(birthday);
		u.setUschool(school);
		u.setUprofession(profession);
		u.setUintroduce(introduce);
		dao.doEdit(u);
		session.setAttribute("username", name);
		Cookie nameCookie = opCookie.getCookieByName(req, "username");
		opCookie.addCookie(resp, "username", name, nameCookie.getMaxAge());
		resp.sendRedirect("homePage.jsp");
	}
}