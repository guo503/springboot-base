package com.tsyj.thread;

public class ReqThreadLocal {
	/**
	 * accessToken
	 */
	private final static ThreadLocal<String> ACCESS_TOKEN = new ThreadLocal<String>();
	/**
	 * 请求用户的id
	 */
	private final static ThreadLocal<Integer> USER_ID = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};
	/**
	 * 请求用户的名字
	 */
	private final static ThreadLocal<String> USER_NAME = new ThreadLocal<String>() {
		public String initialValue() {
			return "system";
		}
	};

	/**
	 * 请求的ip地址
	 */
	private final static ThreadLocal<String> IP = new ThreadLocal<String>() {
		public String initialValue() {
			return "unknown";
		}
	};

	public static void removeAll() {
		ACCESS_TOKEN.remove();
		USER_ID.remove();
		USER_NAME.remove();
		IP.remove();
	}

	public static void setAccessToken(String accessToken) {
		ACCESS_TOKEN.set(accessToken);
	}

	public static String getAccessToken() {
		return ACCESS_TOKEN.get();
	}

	public static void setUserId(Integer userId) {
		USER_ID.set(userId);
	}

	public static void setIp(String ip) {
		IP.set(ip);
	}

	public static Integer getUserId() {
		return USER_ID.get();
	}

	public static void setUserName(String userName) {
		USER_NAME.set(userName);
	}

	public static String getUserName() {
		return USER_NAME.get();
	}

	public static String getIp() {
		return IP.get();
	}

}
