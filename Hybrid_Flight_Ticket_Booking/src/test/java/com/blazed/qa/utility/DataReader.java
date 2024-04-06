/*Author : Suman Das
Date : 29/03/2024*/

package com.blazed.qa.utility;

import java.io.FileReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class DataReader {

	public static List<String[]> getCSVData(String fileName, int skipLines) {

		List<String[]> allData = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(skipLines).build();
			allData = csvReader.readAll();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return allData;
	}

}
