package com.Homework.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.Homework.demo.model.Enrollment;



public class ReadCSV {

	public static void main(String[] args) {
		String path = "C:/csvFile/Book1.csv";
		String data = "";
		List<Enrollment> ermList = new ArrayList<>();	
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			while((data = br.readLine()) != null) {
				String[] values = data.split(",");
				Enrollment  erm = new Enrollment();
				for(int i = 0; i < values.length ; i++) {	
					switch (i) {
					case 0:
						erm.setUserId(Integer.parseInt(values[i]));
						break;
					case 1:
						erm.setFirstName(values[i]);
						break;
					case 2:
						erm.setLastName(values[i]);
						break;
					case 3:
						erm.setVersion(Integer.parseInt(values[i]));
						break;
					case 4:
						erm.setInsuranceCompany(values[i]);
						break;
					default:						
						break;
					}					
					
				}
				ermList.add(erm);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Map<String,List<Enrollment>> ernMap = ermList.stream().collect(Collectors.groupingBy(Enrollment::getInsuranceCompany));
		
		
		for(Map.Entry enroll : ernMap.entrySet()) {
			path =	"C:/csvFile/";
			List<Enrollment> insList = new ArrayList<>();
			insList = (List<Enrollment>) enroll.getValue();
			
			insList = insList.stream().sorted((e1,e2) -> e2.getVersion().compareTo(e1.getVersion())).
					filter(distinctByKey(p -> p.getUserId() )).
					sorted((e1,e2) -> e1.getLastName().compareTo(e2.getLastName())).
					sorted((e1,e2) -> e1.getFirstName().compareTo(e2.getFirstName()))
					.collect(Collectors.toList());
			
			
			path +=enroll.getKey()+".csv";
			BufferedWriter wr = null;
			try{
				wr = new BufferedWriter(new FileWriter(path,true));
				for(Enrollment e : insList) {
					String str = e.getUserId() + "," +e.getFirstName()+","+e.getLastName()+","+e.getVersion()+","+e.getInsuranceCompany()+"\n";
					wr.write(str);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					wr.flush();
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			
		}	
		

	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

}
