package com.china.hcg.http;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.*;

/**
 * @autor hecaigui
 * @date 2021-3-15
 * @description
 */
public class AsyncHttpClientUtil {
	// 请求线程池
	static ExecutorService postForJsonThreadPool = new ThreadPoolExecutor(2, 100, 0L, TimeUnit.MICROSECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setName("post异步请求线程池");
			System.out.println("创建线程："+t);
			return  t;
		}
	});
	static class postForJsonRunnable implements Runnable{
		String postUrl;
		JSONObject postObj;
		postForJsonRunnable(String postUrl , JSONObject postObj){
			this.postUrl = postUrl;
			this.postObj = postObj;
		}
		@Override
		public void run(){
			HttpClientUtil.postOfJson(postUrl,postObj);
		}
	}
	/**
	 * @description 异步发起一个json格式的post请求
	 */
	public static void asyncPostForJson (String postUrl , JSONObject postObj){
		postForJsonThreadPool.execute(new postForJsonRunnable(postUrl,postObj));
	}
}
