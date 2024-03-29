package com.zbmf.groupro.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.zbmf.groupro.R;

/**
 * Created by xuhao on 2016/12/14.
 */

public class SettingDefaultsManager {
    private static final String TAG="UserDefaultsManager";
    private static SettingDefaultsManager defaultInstance=null;
    private static SharedPreferences sharedPreferences=null;
    SharedPreferences.Editor editor=null;

    public static final String CLIENT_ID="client_id";
    // 用户authtoken
    public static final String USER_AUTHTOKEN = "User_AuthToken";
    //用户名
    public static final String USER_NICK_NAME="User_Nick_name";
    //真实名字
    public static final String TRUE_NAME="true_name";
    //idcard
    public static final String IDCARD="idcard";
    //用户头像
    public static final String USER_AVATAR="User_Avatar";
    //用户ID
    public static final String USER_ID="User_Id";
    //用户手机
    public static final String USER_PHONE="user_phone";
    //用户设置字体大小
    public static final String TEXT_SIZE="Text_Size";
    //用户设置字体大小
    public static final String  BLOG_TEXT_SIZE="Blog_Text_Size";
    //设置用户声音是否提示
    public static final String MESSAGE_VEDIO="message_vedio_";
    //设置用户群聊声音是否提示
    public static final String CHAT_MESSAGE_VEDIO="chat_message_vedio_";
    //设置用户可用魔方宝
    public static final String PAYS="pays";
    //设置用户可用积分
    public static final String POINT="point";

    public static final String LIVE_IMG ="live_img";

    //设置用户声音是否提示
    public static final String MESSAGE_All="message_all";

    public static  final String PUSH_CILENT_ID="push_client_id";
    public static  final String CURRENT_CHAT="current_chat";



    public void clearUserInfo(){
        editor.remove(USER_AUTHTOKEN);
        editor.remove(USER_ID);
        editor.remove(USER_PHONE);
        editor.remove(USER_AVATAR);
        editor.remove(USER_NICK_NAME);
        editor.remove(POINT);
        editor.remove(PAYS);
        editor.commit();
    }

    public static SettingDefaultsManager getInstance()
    {
        if (defaultInstance == null)
        {
            defaultInstance = new SettingDefaultsManager();
        }
        return defaultInstance;
    }
    //存储为Group_UserInformation的文件中
    public void setSharedPreferences(Context context)
    {
        sharedPreferences = context.getSharedPreferences(context.getPackageName()+"Group_SettingDefaultsManager", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    //设置直播室图片宽度
    public void setLiveImg(String liveImg){
        editor.putString(LIVE_IMG, liveImg);
        editor.commit();
    }
    public String getLiveImg(){
        return  sharedPreferences.getString(LIVE_IMG,Constants.LIVE_IMG_350);
    }
    // 设置当前用户的USER_PHONE
    public void setUserPhone(String userPhone)
    {
        editor.putString(USER_PHONE, userPhone);
        editor.commit();
    }

    // 获得当前用户的phone
    public String getUserPhone()
    {
        return sharedPreferences.getString(USER_PHONE,"");
    }
    // 设置当前用户的PUSH_CILENT_ID
    public void setPushCilentId(String authToken)
    {
        editor.putString(PUSH_CILENT_ID, authToken);
        editor.commit();
    }

    // 获得当前用户的authtoken
    public String PUSH_CILENT_ID()
    {
        //return "d02f7b60b65a27f4224197e56d8bdb75";
        return sharedPreferences.getString(PUSH_CILENT_ID,"");
    }
    // 设置当前用户的authtoken
    public void setAuthtoken(String authToken)
    {
        editor.putString(USER_AUTHTOKEN, authToken);
        editor.commit();
    }

    // 获得当前用户的authtoken
    public String authToken()
    {
        //return "d02f7b60b65a27f4224197e56d8bdb75";
        return sharedPreferences.getString(USER_AUTHTOKEN,"");
    }
    //设置用户名
    public void setNickName(String userName){
        editor.putString(USER_NICK_NAME, userName);
        editor.commit();
    }
    public void setTrueName(String trueName){
        editor.putString(TRUE_NAME, trueName);
        editor.commit();
    }


    public void setIdcard(String idcard){
        editor.putString(IDCARD, idcard);
        editor.commit();
    }
    public String getIdcard(){return sharedPreferences.getString(IDCARD,null);}
    public String getTrueName(){
        return sharedPreferences.getString(TRUE_NAME,null);
    }
    public String NickName(){
        return  sharedPreferences.getString(USER_NICK_NAME,null);
    }
    //设置用户头像
    public void setUserAvatar(String useravatar){
        editor.putString(USER_AVATAR, useravatar);
        editor.commit();
    }
    public String UserAvatar(){
        return  sharedPreferences.getString(USER_AVATAR,null);
    }
    //设置用户ID
    public void setUserId(String userId){
        editor.putString(USER_ID, userId);
        editor.commit();
    }
    public String UserId(){
        return  sharedPreferences.getString(USER_ID,"");
    }
    //设置博文字体大小
    public void setBlogTextSize(int textsize)
    {
        editor.putInt(BLOG_TEXT_SIZE, textsize);
        editor.commit();
    }
    //用户设置博文字体大小
    public int getBlogTextSize(){
        return sharedPreferences.getInt(BLOG_TEXT_SIZE,2);
    }
     //设置直播字体大小
    public void setTextSize(int textSize)
    {
        editor.putInt(TEXT_SIZE, textSize);
        editor.commit();
    }
    //用户设置字体大小
    public int getTextSize(){
        return sharedPreferences.getInt(TEXT_SIZE, R.dimen.live_text_size_small);
    }
    //设置client_id
    public void setClientId(String clientId)
    {
        Log.e("TAG","设置clientid"+clientId);
        editor.putString(CLIENT_ID, clientId);
        editor.commit();
    }
    //获取client_id
    public String getClientId(){
        return sharedPreferences.getString(CLIENT_ID,null);
    }

    /**
     * 设置消息是否提示声音
     * @param group_id
     * @param vedio
     */
    public void setNewMessageVedio(String group_id,boolean vedio){
        editor.putBoolean(MESSAGE_VEDIO+group_id,vedio);
        editor.commit();
    }

    /**
     * 获取圈子是否提示声音
     * @param group_id
     * @return
     */
    public boolean getNewMessageVedio(String group_id){
        return sharedPreferences.getBoolean(MESSAGE_VEDIO+group_id,false);
    }

    //设置全局消息
    public void setMessageAll(boolean vedio){
        editor.putBoolean(MESSAGE_All,vedio);
        editor.commit();
    }

    //全局消息获取
    public boolean getMessageAll(){
        return sharedPreferences.getBoolean(MESSAGE_All,false);
    }
    /**
     * 设置消息是否提示声音
     * @param group_id
     * @param vedio
     */
    public void setNewChatMessageVedio(String group_id,boolean vedio){
        editor.putBoolean(CHAT_MESSAGE_VEDIO+group_id,vedio);
        editor.commit();
    }

    /**
     * 获取圈子是否提示声音
     * @param group_id
     * @return
     */
    public boolean getNewChatMessageVedio(String group_id){
        return sharedPreferences.getBoolean(CHAT_MESSAGE_VEDIO+group_id,false);
    }

    /**
     * 设置可用魔方宝
     * @param pays
     */
    public void setPays(String pays){
        editor.putString(PAYS+UserId(),pays);
        editor.commit();
    }

    /**
     * 获取可用魔方宝
     * @return
     */
    public String getPays(){
        return sharedPreferences.getString((PAYS+UserId()),"0.00");
    }
    /**
     * 设置可用积分
     * @param pays
     */
    public void setPoint(long pays){
        editor.putLong(POINT+UserId(),pays);
        editor.commit();
    }

    /**
     * 获取可用积分
     * @return
     */
    public long getPoint(){
        return sharedPreferences.getLong(POINT+UserId(),0);
    }


    public void setCurrentChat(String currentChat) {
        editor.putString(CURRENT_CHAT, currentChat);
        editor.commit();
    }

    public String getCurrentChat() {
        return sharedPreferences.getString(CURRENT_CHAT,"");
    }
}
