package kr.co.pk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JSONController {
	@RequestMapping("rest/text")
	public String text() {
		return "DataFormat : csv, xml, json";
	}

	@RequestMapping("rest/json")
	public List<Map<String, Object>> json() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("csv", "구분자로 구분한 문자열");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("xml", "태그 형식으로 데이터를 표현하는 방법");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("json", "자바스크립트 객체를 표현하는 방법");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		return list;
	}

	@RequestMapping("rest/ajax")
	public List<Map<String, Object>> ajax() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("title", "반응형 웹 디자인");
		map1.put("content", "하나의 뷰를 여러 디바이스에 맞게 보여주는 것 - CSS 이용");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("title", "크로스 브라우징");
		map2.put("content", "모든 브라우저에서 동일한 컨텐츠를 사용할 수 있도록 하는 것 - jQuery 이용");
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("title", "웹 접근성");
		map3.put("content", "누구나 동일한 컨텐츠를 사용할 수 있도록 하는 것");
		list.add(map1);
		list.add(map2);
		list.add(map3);
		return list;
	}
}
