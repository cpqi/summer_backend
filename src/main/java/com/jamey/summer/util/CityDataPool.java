package com.jamey.summer.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;

import com.jamey.summer.vo.CityInfo;

public class CityDataPool {
	private static List<CityInfo> cityList = new ArrayList<CityInfo>();

	static {

		String filePath = CityDataPool.class.getClassLoader().getResource("city.csv").getFile();
		File file = new File(filePath);

		List<String> lines = CSVUtil.getCSVLines(file);

		CityInfo cityInfo = null;
		for (String line : lines) {
			String[] cityArray = line.split(",");
			cityInfo = new CityInfo();
			cityInfo.setId(Integer.valueOf(cityArray[0].trim()));
			cityInfo.setLat(Double.valueOf(cityArray[1].trim()));
			cityInfo.setLng(Double.valueOf(cityArray[2].trim()));
			cityInfo.setProvince(cityArray[3].trim());
			cityInfo.setCity(cityArray[4].trim());

			cityList.add(cityInfo);
		}

	}

	public static List<CityInfo> getCityList() {
		return cityList;
	}
	
	public static List<CityInfo> getCityListByProvince(String province) {
		return cityList.stream().filter(c->c.getProvince().equals(province)).collect(Collectors.toList());
	}
	
	public static CityInfo getCityInfoById(Integer id) {
		return cityList.stream().filter(c->c.getId().equals(id)).findFirst().get();
	}
	

}
