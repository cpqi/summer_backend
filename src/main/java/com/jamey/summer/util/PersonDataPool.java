package com.jamey.summer.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jamey.summer.vo.PersonInfo;

public class PersonDataPool {

	private static List<PersonInfo> personList = new ArrayList<PersonInfo>();

	static {

//		String filePath = PersonDataPool.class.getClassLoader().getResource("0216.csv").getFile();
		String filePath ="/root/.m2/repository/com/jamey/summer_backend/0.0.1-SNAPSHOT/data/0216.csv";
		File file = new File(filePath);

		List<String> lines = CSVUtil.getCSVLines(file);

		PersonInfo personInfo = null;
		int i = 0;
		for (String line : lines) {
			System.out.println(++i);
			String[] personArray = line.split(",");
			personInfo = new PersonInfo();
			personInfo.setId(Integer.valueOf(personArray[0].trim()));
			personInfo.setName(personArray[1].trim());
			personInfo.setPhoneNum(personArray[2].trim());

			// 隔离
			personInfo.setIsolationProvince(personArray[5].trim());
			personInfo.setIsolationCity(personArray[6].trim());
			personInfo.setIsolationAddress(personArray[7].trim());

			// 工作
			personInfo.setWorkProvice(personArray[8].trim());
			personInfo.setWorkCity(personArray[9].trim());
			personInfo.setWorkAddress(personArray[10].trim());

			// 休假
			personInfo.setHolidayProvince(personArray[11].trim());
			personInfo.setHolidayCity(personArray[12].trim());
			personInfo.setHolidayAddress(personArray[13].trim());

			// 状态
			String _isoEndDate = personArray[4];
			try {
				Date computeDate = new SimpleDateFormat("yyyy/MM/dd").parse("2020/02/16");
				Date isoEndDate = new SimpleDateFormat("yyyy/MM/dd").parse(_isoEndDate);
				if (isoEndDate.after(computeDate)) {
					// 隔离中
					personInfo.setPersonStatus("1");
				} else {

					// 结束隔离
					personInfo.setPersonStatus("0");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

			personList.add(personInfo);
		}

	}

	public static List<PersonInfo> getPersonInfoList() {
		return personList;
	}
	
	public static PersonInfo getPersonInfoById(Integer id) {
		return personList.stream().filter(p->p.getId().equals(id)).findFirst().get();
	}
	

}
