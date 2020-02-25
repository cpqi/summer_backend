package com.jamey.summer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jamey.summer.util.CityDataPool;
import com.jamey.summer.util.PersonDataPool;
import com.jamey.summer.vo.CityInfo;
import com.jamey.summer.vo.PersonInfo;

@RestController
public class NCPMapController {

	/*
	 * CityInfo
	 */
	@RequestMapping(value = "/summer/ncp/cityList", method = RequestMethod.GET)
	public List<CityInfo> getCityList() {
		return CityDataPool.getCityList();
	}

	@RequestMapping(value = "/summer/ncp/cityList/province/{province}", method = RequestMethod.GET)
	public List<CityInfo> getCityList(@PathVariable("province")  String province) {
		return CityDataPool.getCityListByProvince(province);
	}
	
	@RequestMapping(value = "/summer/ncp/cityList/{id}", method = RequestMethod.GET)
	public CityInfo getCityListByID(@PathVariable("id") Integer id) {
		return CityDataPool.getCityInfoById(id);
	}
	
	/*
	 * PersonInfo
	 */
	@RequestMapping(value = "/summer/ncp/personList", method = RequestMethod.GET)
	public List<PersonInfo> getPersonInfoList(){
		return PersonDataPool.getPersonInfoList();
	}
	
	
	@RequestMapping(value = "/summer/ncp/personList/{id}", method = RequestMethod.GET)
	public PersonInfo getPersonInfoById(@PathVariable("id") Integer id) {
		return PersonDataPool.getPersonInfoById(id);
	}
	
	
	
	
}
