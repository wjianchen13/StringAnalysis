package com.example.stringanalysis.bean;

import android.os.SystemClock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 广告用户实体
 */
public class AdUserBean implements Serializable {

	/**
	 * 发言用户id
	 */
	private int uid = 0;

	/**
	 * 所有发言
	 */
	private List<AdChatBean> chatBeans = new ArrayList<>();

	/**
	 * 是否上传，上传之后以后不用保存或者上传？？
	 */
	private boolean isUpload;


	public AdUserBean() {

	}

	public AdUserBean(int uid) {
		this.uid = uid;
	}

	public void addChatBean(WSChatBean wsBean) {
		if(chatBeans != null && wsBean != null) {
			chatBeans.add(new AdChatBean(wsBean.getMsgContent(), SystemClock.elapsedRealtime()));
		}
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public List<AdChatBean> getChatBeans() {
		return chatBeans;
	}

	public void setChatBeans(List<AdChatBean> chatBeans) {
		this.chatBeans = chatBeans;
	}

	public boolean isUpload() {
		return isUpload;
	}

	public void setUpload(boolean upload) {
		isUpload = upload;
	}
}
