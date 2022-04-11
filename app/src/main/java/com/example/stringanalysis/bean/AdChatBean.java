package com.example.stringanalysis.bean;

import java.io.Serializable;

/**
 * 广告内容实体
 */
public class AdChatBean implements Serializable {

	/**
	 * 消息内容
	 */
	private String mMsgContent;

	/**
	 * 发言时间
	 */
	private long realTime;



	public AdChatBean() {

	}

	public AdChatBean(String content, long time) {
		this.mMsgContent = content;
		this.realTime = time;
	}

	public String getmMsgContent() {
		return mMsgContent;
	}

	public void setmMsgContent(String mMsgContent) {
		this.mMsgContent = mMsgContent;
	}

	public long getRealTime() {
		return realTime;
	}

	public void setRealTime(long realTime) {
		this.realTime = realTime;
	}
}
