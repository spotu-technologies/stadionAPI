package com.stadion.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stadion.api.entity.FaqBoard;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.WodInfo;
import com.stadion.api.entity.WodInfoWithFile;
import com.stadion.api.mapper.WodInfoMapper;


@Service
public class WodInfoService {
	@Autowired
	private WodInfoMapper wodInfoMapper;
	
	
	
	public WodInfo getWodInfo(long idx) {
		if(wodInfoMapper==null) {return null;}
		
		WodInfo wodInfo = wodInfoMapper.getWodInfo(idx);
		
		return wodInfo;
	}
	
	
	public List<WodInfo> getWodInfoAll() {
		if(wodInfoMapper==null) {return null;}
		
		List<WodInfo> wodInfoList = wodInfoMapper.getWodInfoAll();
		
		return wodInfoList;
	}
	
	public List<WodInfoWithFile> getWodInfoToday() {
		if(wodInfoMapper==null) {return null;}
		
		List<WodInfoWithFile> wodInfoList = wodInfoMapper.getWodInfoToday();
		
		return wodInfoList;
	}
	public List<WodInfoWithFile> getwodInfoTomorrow() {
		if(wodInfoMapper==null) {return null;}
		
		List<WodInfoWithFile> wodInfoList = wodInfoMapper.getwodInfoTomorrow();
		
		return wodInfoList;
	}
	public List<WodInfoWithFile> getwodInfoPast() {
		if(wodInfoMapper==null) {return null;}
		
		List<WodInfoWithFile> wodInfoList = wodInfoMapper.getwodInfoPast();
		
		return wodInfoList;
	}
	
	public List<WodInfo> getWodInfoClass() {
		if(wodInfoMapper==null) {return null;}
		
		List<WodInfo> wodInfoList = wodInfoMapper.getWodInfoClass();
		
		return wodInfoList;
	}
	
	public List<WodInfo> getwodInfoSearch(String keyword) 
	{
		if(wodInfoMapper==null) {return null;}
		
		List<WodInfo> wodInfoList = wodInfoMapper.getwodInfoSearch(keyword);
		
		return wodInfoList;
	}
	
}
