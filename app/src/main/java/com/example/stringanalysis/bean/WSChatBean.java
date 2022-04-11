package com.example.stringanalysis.bean;

/**
 * 聊天
 *
 * @author chenjie
 */
public class WSChatBean {

    public static final int PUBLIC_CHAT = 0;

    public static final int PRIVATE_CHAT = 1;

    /**
     * 聊天发送状态
     */
    public static final int CHAT_STATE_SUCCESS = 1; // 成功
    public static final int CHAT_STATE_VIP_SPACE = 2; // 非vip用户发言时间间隔10s
    public static final int CHAT_STATE_LEAVE = 3; // 用户离开
    public static final int CHAT_STATE_FORBIDDEN = 4; // 你已被禁言

    /**
     * 发送者消息
     */
    private WSChater mSender;

    /**
     * 接受者消息
     */
    private WSChater mReciever;

    /**
     * 消息内容
     */
    private String mMsgContent;

    /**
     * 聊天类型
     * 0： 公聊
     * 1 私聊
     */
    private int mChatType;

    /**
     * 聊天发送状态
     * 字段由服务端定义好，目前手机端只用到3
     * 1,成功 2,非vip用户发言时间间隔10s 3,用户离开 4,你已被禁言
     *
     * @return
     */
    private int mChatState;

    private boolean mIsDanmu;

    public WSChater getSender() {
        return mSender;
    }

    public void setSender(WSChater mSender) {
        this.mSender = mSender;
    }

    public WSChater getReciever() {
        return mReciever;
    }

    public void setReciever(WSChater mReciever) {
        this.mReciever = mReciever;
    }

    public String getMsgContent() {
        return mMsgContent;
    }

    public void setMsgContent(String mMsgContent) {
        this.mMsgContent = mMsgContent;
    }

    public int getChatType() {
        return mChatType;
    }

    public void setChatType(int mChatType) {
        this.mChatType = mChatType;
    }

    public WSChatBean() {

    }

    public int getChatState() {
        return mChatState;
    }

    public void setChatState(int mChatState) {
        this.mChatState = mChatState;
    }

    public boolean isIsDanmu() {
        return mIsDanmu;
    }


}
