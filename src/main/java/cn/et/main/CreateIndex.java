package cn.et.main;

import java.util.Timer;

/**
 * 定时刷新首页
 * @author Administrator
 *
 */
public class CreateIndex {

	public static void main(String[] args) {
		Timer timer = new Timer();
		// 一秒钟后执行，5秒刷新一次
		timer.schedule(new Task(), 1000, 20000);
	}
}
