package cn.kgc.utils.sms;
/**
 * @Title: http://www.smschinese.cn/api.shtml
 * @date 2011-3-22
 * @version V1.2  
 */
public class SentMsgUtil {
	
	//用户名
	private static String Uid = "小明90";
	
	//接口安全秘钥
	private static String Key = "ahfkljflahbfjdsajfyuer";


	/**
	 * @param tel 手机号码，多个号码如13800000000,13800000001,13800000002
	 * @param msg  短信息内容
	 * @return
	 */
	public static int  sendMsg(String tel,String msg) {
		HttpClientUtil client = HttpClientUtil.getInstance();
		//UTF发送
		int result = client.sendMsgUtf8(Uid, Key, msg, tel);
		return result;
	}
}
