package com.kms2.controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SidServlet extends HttpServlet {
	private final static char[] cs = { '石','A','b','油','2','3','4','5','6','7','大','学'};
	private final static Random random = new Random(new Date().getTime());
	private String sid(){
		String string = "";
		StringBuffer sb = new StringBuffer();
		//用StringBuffer性能比较好，速度比较快
		for(int i = 0; i < 4; i++){
			sb.append(cs[random.nextInt(cs.length)]);
		}
		string = sb.toString();
		return string;
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("img/jpeg");
		//产生随机的验证码
		String sid = sid();
		//在session中保存验证码
		HttpSession session = req.getSession();
		session.setAttribute("sid", sid);
		//session.setMaxInactiveInterval(30);
		//生成验证码图片
		//这个方法实现验证码的生成
		BufferedImage bi = new BufferedImage(68,22,BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();//通过缓冲区创建一个画布
		g.drawString(sid, 0, 20);
		//向IE子写入图片
		ImageIO.write(bi, "JPG", resp.getOutputStream());
	}
}
