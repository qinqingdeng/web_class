package com.action;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.dao.CommentDao;
import com.dao.VideoDao;
import com.pojo.Comment;
import com.pojo.Video;

public class Create {
	public StringBuilder createVideo() throws SQLException, ParseException {
		VideoDao vd=new VideoDao();
		ArrayList<Video> videos = new ArrayList<Video>();
		videos=vd.getAll();
		StringBuilder sh = new StringBuilder();
		try{
			
			PrintStream printStream = new PrintStream(new FileOutputStream("home.jsp"));
			sh.append("<div id='videos'>");
			sh.append("<ul class='ul1'>");
			for(int j=0;j<videos.size();j++) {
			sh.append("<li>");
			sh.append("<div class='box1'>");
			sh.append("<a class='avatar_pic' target='_self' href='video.jsp?id=");
			sh.append(videos.get(j).getId());
			sh.append("&useid=");
			sh.append(videos.get(j).getUserId());
			sh.append("'>");
			sh.append("<img src='");
			sh.append("cover/cover.png");
			sh.append("'>");
			sh.append("</a>");
			sh.append("<div class='first'>");
			sh.append("<p class='top2'>");
			sh.append(videos.get(j).getTitle());
			sh.append("</p>");
			sh.append("<p class='bottom2'>更新至7-14<span>课程时长:");
			sh.append(videos.get(j).getDuration());
			sh.append("</span></p>");
			sh.append("</div>");
			sh.append("<div class='last'>");
			sh.append("<p class='top2'>");
			sh.append(videos.get(j).getIntroduce());
			sh.append("</p>");
			sh.append("<p class='bottom2'>2015-08-17<span>272648人学习</span></p>");
			sh.append("</div>");
			sh.append("</div>");
			sh.append("</li>");
			}
			sh.append("</ul>");
			sh.append("</div>");
			printStream.println(sh.toString()); 
			printStream.close();
			}catch(FileNotFoundException e){
			   e.printStackTrace();
			}
			return sh;	
	}
	public StringBuilder createComment(String videoId) throws SQLException, ParseException {
		CommentDao dao=new CommentDao();
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comments=dao.getByVideo("12");//videoId
		StringBuilder sh = new StringBuilder();
		try{
			
			PrintStream printStream = new PrintStream(new FileOutputStream("dynamic.jsp"));
			sh.append("<ul id=\"pn\">");
			sh.append("<li class=\"list0\">");
			for(int j=0;j<comments.size();j++) {
				sh.append("<div class=\"comment-list\">");
				sh.append("<div class=\"comment\" user=\"self\">");
				sh.append("<div class=\"comment-right\">");
				sh.append("<div class=\"comment-text\">");
				sh.append("<span class=\"user\">");
				sh.append("<a href=\"hisHome.jsp?ownerid=");
				sh.append(comments.get(j).getUserId());
				sh.append("\">");
				sh.append(comments.get(j).getUserId());
				sh.append("</a>");
				sh.append("</span><br>");
				sh.append(comments.get(j).getContent());
				sh.append("</div>");
				sh.append("<div class=\"comment-date\">");
				sh.append(comments.get(j).getTime());
				sh.append("<input type=\"button\" class=\"comment-zan\" onclick=\"dianzan()\" value=\"");
				sh.append(comments.get(j).getAgree());
				sh.append(" 赞\">");
				sh.append("<a class=\"comment-dele\" href=\"#C1\">回复</a>");
				sh.append("</div>");
				sh.append("</div>");
				sh.append("</div>");
				sh.append("</div>");
			}
			sh.append("<form name=\"form1\" method=\"post\" action=\"\">");
			sh.append("<div class=\"hf\">");
			sh.append("<textarea name=\"C1\" id=\"te\" class=\"hf-text\" autocomplete=\"off\" maxlength=\"100\" rows=\"10\" cols=\"50\"></textarea>");
			sh.append("<input type=\"submit\" class=\"comment-dele\" value=\"提交回复\" onclick=\"return check()\"/>");
			sh.append("<span class=\"hf-nub\">0/100</span> </div>");
			sh.append("</form>");
			sh.append("</div>");
			sh.append("</li>");
			sh.append("</ul>");
			printStream.println(sh.toString()); 
			printStream.close();
		}catch(FileNotFoundException e){
			   e.printStackTrace();
		}
		return sh;	

	}
}

