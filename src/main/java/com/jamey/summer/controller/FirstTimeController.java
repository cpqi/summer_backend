package com.jamey.summer.controller;


import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jamey.summer.util.MessageDataPool;
import com.jamey.summer.vo.MessageInfo;

@RestController
public class FirstTimeController {
	
	@RequestMapping(value = "/messageInfo/{id}" ,method = RequestMethod.GET)
	public MessageInfo getMessageInfoById(@PathVariable("id") Integer id) {		
		return MessageDataPool.getMessageInfoById(id);
	}
	
	@RequestMapping(value = "/messageInfo",method = RequestMethod.GET)
	public MessageInfo getMessageInfoByDate(@RequestParam(name="date") String date) {
		return MessageDataPool.getMessageInfoByDate(date);
	}
	
	@RequestMapping(value = "/messageInfoList",method = RequestMethod.GET)
	public List<MessageInfo> getMessageInfoByDate(@RequestParam(name="startdate") String startdate,
			@RequestParam(name="enddate") String enddate) {
		return MessageDataPool.getMessageInfoByDateRange(startdate,enddate);
	}
	
}
