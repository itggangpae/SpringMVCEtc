package kr.co.pk.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ViewServiceImpl implements ViewService {

	public List<String> fileView(HttpServletRequest request){
		String path = request.getServletContext().getRealPath("/img");
		File f = new File(path);
		String [] s = f.list();
		List <String> list = new ArrayList<String>();
		for(String sub : s){
			if(sub.indexOf('.') != -1)
				list.add(sub);
		}
		return list;
	}
	
	public List<Map<String, Object>> excelRead(HttpServletRequest request) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		System.out.println(list);
		try {
			// 엑셀파일 경로 설정
			File file = new File(request.getServletContext().getRealPath("/") + "/item.xls");
			// 엑셀 파일 오픈
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
			
			for (Row row : wb.getSheetAt(0)) {
				if (row.getRowNum() > 0) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("itemname", row.getCell(0));
					map.put("description", row.getCell(1));
					map.put("price", row.getCell(2));
					System.out.println(map);
					list.add(map);
				}
			}
			wb.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return list;
	}

}
