package com.fg.NETWORK;

public class MultiThreadeDown {
	public static void main(String[] args) throws Exception {
		// 初始化DownUtil对象
		final DownUtil downUtil = new DownUtil("http://img.dwstatic.com/wow/1710/371556283717/" + "1507601091633.jpg",
				"1507601091633.jpg", 4);
		final DownUtil downUtil2 = new DownUtil("http://img.dwstatic.com/wow/1710/371556283717/" + "1507601093889.jpg",
				"1507601093889.jpg", 4);
		// 开始下载
		downUtil.download();
		downUtil2.download();
		new Thread(() -> {
			while (downUtil.getCompleteRate() < 1 && downUtil2.getCompleteRate() < 1) {
				// 每隔0.1s查询一次任务进度
				// GUI程序中可根据该进度来绘制进度条
				System.out.println("已完成:" + downUtil.getCompleteRate());
				System.out.println("已完成:" + downUtil2.getCompleteRate());
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
		}).start();
	}
}
