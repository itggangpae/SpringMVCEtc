package kr.co.pk.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ViewService {
	public List<String> fileView(HttpServletRequest request);
	public List<Map<String, Object>> excelRead(HttpServletRequest request);
}
