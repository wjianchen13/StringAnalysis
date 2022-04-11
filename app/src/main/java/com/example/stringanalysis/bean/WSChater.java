package com.example.stringanalysis.bean;

import org.json.JSONObject;


public class WSChater {
    protected int uid = 0;        //如果是主播，这个就是房间ID
    protected String sessionId = "";
    protected String nickName = "";
    protected String avatar_url = "";
    protected int starLev = 0;
    protected int wealthLev = 0;
    protected long star_previous_integral = 0L;
    protected long star_integral = 0L;
    protected long star_next_integral = 0L;
    protected long wealth_integral = 0L;
    protected long wealth_next_integral = 0L;
    protected int carId = 0;
    protected int vipType = 0; //0 1 vip 2 s vip 3 d vip
    protected int uType = 0; // 0:普通用户；1：主播；2：巡管；3：销售;4：官方发言人
    protected int freeGiftCount = 0;
    protected int addFreeGiftNum = 0; // 当前用户增加或送出的阳光
    protected int coins = 0;
    protected boolean isGuarder = false;
    protected boolean isGrubSeat = false;
    protected String familyName = "";
    protected int familyLevel;
    public String contribution_val = ""; // 贡献值
    protected int diamond;//秀钻
    protected JSONObject object;
    /**
     * 骑士类型
     * 1：爱的骑士 2：白马王子
     *
     * @return
     */
    protected int KnightType;

    // 帮会成员在帮会了的头衔
    protected int memberActor;

    //徽章id
    protected String badgeIds = "";
    //是否隐身
    protected boolean isHide;
    //是否被禁言
    protected boolean isGag;

    /*标注出跳转的类型，不同的跳转类型同时会附带其他参数，比如webviewurl，用来打开webview*/
    protected String extra_msg = "";            //表示跳转类型
    protected String extra_arg_url = "";       //跳转类型参数url

    //靓号
    protected int sid;
    //是否是靓号 0否，1是
    protected int liang;
    /**
     * 本地字段用于气氛判断数据是否来至礼物榜单，和观众列表数据区分
     */
    protected boolean isGiftRanking;

    protected int has_linkmic;  // has_linkmic：0 本场没申请过连麦 1 本场有申请过音频连麦 2 本场有申请过视频连麦
    protected boolean link_mic; // 如果是主播，表示是否开启了连麦

    protected boolean isFaceuSupport;   // 主播是否支持faceu
    protected int pkPriority;            // 主动pk
    protected int roomUsers;             // 直播间真正的人数

    public boolean isGiftRanking() {
        return isGiftRanking;
    }

    public void setGiftRanking(boolean giftRanking) {
        isGiftRanking = giftRanking;
    }

    public boolean isGag() {
        return isGag;
    }

    public void setGag(boolean isGag) {
        this.isGag = isGag;
    }

    public String getBadgeIds() {
        return badgeIds;
    }

    public void setBadgeIds(String badgeIds) {
        this.badgeIds = badgeIds;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFreeGiftCount() {
        return freeGiftCount;
    }

    public int getKnightType() {
        return KnightType;
    }

    public void setKnightType(int knightType) {
        KnightType = knightType;
    }

    public void setFreeGiftCount(int freeGiftCount) {
        this.freeGiftCount = freeGiftCount;
    }

    public int getAddFreeGiftNum() {
        return addFreeGiftNum;
    }

    public void setAddFreeGiftNum(int addFreeGiftNum) {
        this.addFreeGiftNum = addFreeGiftNum;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getStarLev() {
        return starLev;
    }

    public void setStarLev(int starLev) {
        this.starLev = starLev;
    }

    public long getStar_previous_integral() {
        return star_previous_integral;
    }

    public void setStar_previous_integral(long star_previous_integral) {
        this.star_previous_integral = star_previous_integral;
    }

    public int getWealthLev() {
        return wealthLev;
    }

    public void setWealthLev(int wealthLev) {
        this.wealthLev = wealthLev;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getVipType() {
        return vipType;
    }

    public void setVipType(int vipType) {
        this.vipType = vipType;
    }

    public boolean isGuarder() {
        return isGuarder;
    }

    public void setGuarder(boolean isGuarder) {
        this.isGuarder = isGuarder;
    }

    public boolean isGrubSeat() {
        return isGrubSeat;
    }

    public void setGrubSeat(boolean isGrubSeat) {
        this.isGrubSeat = isGrubSeat;
    }

    public String getExtra_msg() {
        return extra_msg;
    }

    public void setExtra_msg(String extra_msg) {
        this.extra_msg = extra_msg;
    }

    public int getuType() {
        return uType;
    }

    public void setuType(int uType) {
        this.uType = uType;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getContribution_val() {
        return contribution_val;
    }

    public void setContribution_val(String contribution_val) {
        this.contribution_val = contribution_val;
    }

    public long getStar_integral() {
        return star_integral;
    }

    public void setStar_integral(long star_integral) {
        this.star_integral = star_integral;
    }

    public long getStar_next_integral() {
        return star_next_integral;
    }

    public void setStar_next_integral(long star_next_integral) {
        this.star_next_integral = star_next_integral;
    }

    public long getWealth_integral() {
        return wealth_integral;
    }

    public void setWealth_integral(long wealth_integral) {
        this.wealth_integral = wealth_integral;
    }

    public long getWealth_next_integral() {
        return wealth_next_integral;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setWealth_next_integral(long wealth_next_integral) {
        this.wealth_next_integral = wealth_next_integral;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int getFamilyLevel() {
        return familyLevel;
    }

    public void setFamilyLevel(int familyLevel) {
        this.familyLevel = familyLevel;
    }

    public boolean isHide() {
        return isHide;
    }

    public void setHide(boolean isHide) {
        this.isHide = isHide;
    }

    public String getExtra_arg_url() {
        return extra_arg_url;
    }

    public void setExtra_arg_url(String extra_arg_url) {
        this.extra_arg_url = extra_arg_url;
    }

    public int getHasLinkmic() {
        return has_linkmic;
    }

    public void setHasLinkmic(int has_linkmic) {
        this.has_linkmic = has_linkmic;
    }

    public boolean isLinkmic() {
        return link_mic;
    }

    public void setLinkmic(boolean link_mic) {
        this.link_mic = link_mic;
    }

    public WSChater() {
    }

    protected WSChater(JSONObject obj) {

            this.uid = obj.optInt("uid", 0);
            this.sessionId = obj.optString("session_id", "");
            this.nickName = obj.optString("nickname", "");
            this.starLev = obj.optInt("star_lev", 0);
            this.wealthLev = obj.optInt("wealth_lev", 0);
            this.carId = obj.optInt("car_id", 0);
            this.vipType = obj.optInt("vip", 0);
            this.uType = obj.optInt("user_type", 0);
            this.isGrubSeat = obj.optInt("seat", 0) != 0;
            this.isGuarder = obj.optInt("guard", 0) != 0;
            this.coins = obj.optInt("gold", 0);
            this.freeGiftCount = obj.optInt("sunlight", 0);
            this.addFreeGiftNum = obj.optInt("mUserAddSunLight", 0);
            this.avatar_url = obj.optString("avatar_url", "");
            this.contribution_val = obj.optString("contribution_val", "0");

            this.star_integral = obj.optLong("star_integral", 0L);
            this.star_next_integral = obj.optLong("star_next_integral", 0L);
            this.wealth_integral = obj.optLong("wealth_integral", 0L);
            this.wealth_next_integral = obj.optLong("wealth_next_integral", 0L);
            this.star_previous_integral = obj.optLong("star_begin_integral", 0L);
            this.familyName = obj.optString("badge_name");
            this.diamond = obj.optInt("diamond");
            this.familyLevel = obj.optInt("family_level");
            this.memberActor = obj.optInt("honour");
            this.setBadgeIds(obj.optString("badge"));
            this.setKnightType(obj.optInt("knight"));
            //1为禁言 0无
            this.isGag = (obj.optInt("talk_status") == 1);

            this.setSid(obj.optInt("sid"));
            this.setLiang(obj.optInt("liang"));

            this.has_linkmic = obj.optInt("has_linkmic");
            this.link_mic = obj.optInt("link_mic") > 0;

            this.isFaceuSupport = obj.optInt("faceu_status", 0) == 1;
            this.pkPriority = obj.optInt("pk_priority", 0);
            this.roomUsers = obj.optInt("room_users", 0);

            this.object = obj;

    }

    public int getMemberActor() {
        return memberActor;
    }

    public void setMemberActor(int memberActor) {
        this.memberActor = memberActor;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getLiang() {
        return liang;
    }

    public void setLiang(int liang) {
        this.liang = liang;
    }

    public boolean isFaceuSupport(){
        return isFaceuSupport;
    }

    public boolean isPkPriority(){
        return pkPriority > 0;
    }

    public int getRoomUsers() {
        return roomUsers;
    }



}
