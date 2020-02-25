package com.jamey.summer.util;

import java.util.List;
import java.util.stream.Collectors;

import com.jamey.summer.vo.MessageInfo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

public class MessageDataPool {
	
	private static List<MessageInfo> messageList = new ArrayList<MessageInfo>();
	
	static {
		MessageInfo msgInfo;
		
			
			try {
				
				msgInfo = new MessageInfo();
				msgInfo.setId(1);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-07-28").getTime()));
				msgInfo.setMessageInfo("第一次送她礼物-体脂称，知道她体重大概多少，身体健康，不用减肥");
				messageList.add(msgInfo);
				
				msgInfo = new MessageInfo();
				msgInfo.setId(2);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-09").getTime()));
				msgInfo.setMessageInfo("第一次把钥匙给她，这算“女主人”吗？，想什么呢，你个二货🤕");
				messageList.add(msgInfo);
				
				msgInfo = new MessageInfo();
				msgInfo.setId(3);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-20").getTime()));
				msgInfo.setMessageInfo("第一次请她吃饭，有人作陪的那种，烤肉，烤鳗鱼，她好像没有感觉很好吃，坐在她对面看着她好可爱");
				messageList.add(msgInfo);
				
				msgInfo = new MessageInfo();
				msgInfo.setId(4);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-25").getTime()));
				msgInfo.setMessageInfo("第一次去机场接她，她应该是我唯一自己去接的女孩了，也是第一次单独吃饭，餐厅环境不错，同时今天我表白了，脑子可能抽筋了吧，谁知道呢，就这样吧，真的越来越喜欢她️");
				messageList.add(msgInfo);
				
				msgInfo = new MessageInfo();
				msgInfo.setId(5);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-27").getTime()));
				msgInfo.setMessageInfo("第一次做饭给她吃，虽然不是给她一个人，她吃了不少，好开心😀");
				messageList.add(msgInfo);
				
				msgInfo = new MessageInfo();
				msgInfo.setId(6);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-29").getTime()));
				msgInfo.setMessageInfo("第一次在她的窗下，她身体不舒服，也取消了本来我们计划好出游的行程，有点失望，不过我更关心她身体有没有好点，站了数个小时终于有了消息，好多了，我也该回去了");
				messageList.add(msgInfo);		
				
				msgInfo = new MessageInfo();
				msgInfo.setId(7);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-01").getTime()));
				msgInfo.setMessageInfo("她第一次比较正式的“拒绝”我，“如果我还能给您解解闷，您可以找我说”，我不是想找你解闷，我也不希望你给我解闷");
				messageList.add(msgInfo);	
				
				msgInfo = new MessageInfo();
				msgInfo.setId(8);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-22").getTime()));
				msgInfo.setMessageInfo("她第一次决定不再和我说话了，她是对的，但我已经不能用对错衡量了，不是所有事情都要靠理智去解决");
				messageList.add(msgInfo);	
				
				msgInfo = new MessageInfo();
				msgInfo.setId(9);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-09-28").getTime()));
				msgInfo.setMessageInfo("第一次和她逛公园，好几天没说话，能在北京一起吃饭，一起在公园漫步这可能真的是在梦里才能有的画面🤗");
				messageList.add(msgInfo);			
				
				msgInfo = new MessageInfo();
				msgInfo.setId(10);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-19").getTime()));
				msgInfo.setMessageInfo("第一次拉她的手，今天参观铁人纪念馆的路上，在车上拉了她的手，太愚蠢了，后面还有两个人呢，你个傻子就这么控制不了自己吗！🤫");
				messageList.add(msgInfo);	
				
				msgInfo = new MessageInfo();
				msgInfo.setId(11);
				msgInfo.setRecordDate(new Date(new SimpleDateFormat("yyyy-MM-dd").parse("2019-10-31").getTime()));
				msgInfo.setMessageInfo("第一次抱了她，今天是我的生日，虽然没办法跟她一起过，但能送她去机场已经挺好了，在机场的停车厂上我抱了她，我离不开她了～～");
				messageList.add(msgInfo);	
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			
	}
	
	public static MessageInfo getMessageInfoById(Integer id){
		return messageList.stream().filter(m->m.getId() == id).findFirst().get();
	}
	
	public static MessageInfo getMessageInfoByDate(String date){
		Date _date = sqlDateConvert(date);
		return messageList.stream().filter(m->m.getRecordDate().compareTo(_date) == 0).findFirst().get();
	}
	
	public static List<MessageInfo> getMessageInfoByDateRange(String startdate,String enddate){
		Date _startdate =sqlDateConvert(startdate);
		Date _enddate = sqlDateConvert(enddate);
		return messageList.stream().filter(m->m.getRecordDate().after(_startdate) && m.getRecordDate().before(_enddate)).collect(Collectors.toList());
	}
	
	public static Date sqlDateConvert(String date) {
		Date _date = Date.valueOf("2019-07-28");
		try {
			_date = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return _date;
	}
	
}
