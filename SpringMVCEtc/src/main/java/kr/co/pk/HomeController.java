package kr.co.pk;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.pk.domain.DataStructure;
import kr.co.pk.domain.Item;
import kr.co.pk.domain.ItemReport;
import kr.co.pk.domain.Member;
import kr.co.pk.service.ItemService;
import kr.co.pk.service.ViewService;
import kr.co.pk.validator.MemberValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("list", itemService.getAll());
		return "home";
	}

	@RequestMapping("/detail.html")
	public String detail(@RequestParam("itemid") int itemid, Model model) {
		Item item = itemService.getItem(itemid);
		// 데이터를 저장
		model.addAttribute("item", item);
		return "detail";
	}

	@Autowired
	private ViewService viewService;

	@RequestMapping("/download")
	public String download(@RequestParam("filename") String filename, Model model, HttpServletRequest request) {
		File downloadFile = new File(request.getServletContext().getRealPath("/img") + "/" + filename);
		model.addAttribute("downloadFile", downloadFile);
		return "download";
	}

	@RequestMapping("/fileview")
	public String fileview(Model model, HttpServletRequest request) {
		List<String> list = viewService.fileView(request);
		model.addAttribute("list", list);
		return "fileview";
	}

	@RequestMapping("/item.xls")
	public String excel(Model model) {
		List<Item> list = itemService.getAll();
		model.addAttribute("list", list);
		return "excel";
	}

	@RequestMapping("/excelread")
	public String excelread(Model model, HttpServletRequest request) {
		List<Map<String, Object>> list = viewService.excelRead(request);
		model.addAttribute("list", list);
		return "excelread";
	}

	@RequestMapping("/pdf")
	public String pdfReport(Model model) {
		List<Item> list = itemService.getAll();
		model.addAttribute("list", list);
		return "pdf";
	}

	@RequestMapping("/itemlist.json")
	public String jsonReport(Model model) {
		List<Item> list = itemService.getAll();
		model.addAttribute("list", list);
		return "itemlist";
	}

	@RequestMapping("/item.xml")
	public String xmlReport(Model model) {
		List<Item> list = itemService.getAll();
		model.addAttribute("list", new ItemReport(list));
		return "itemReport";
	}

	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public String input(Model model) {
		return "input";
	}

	@RequestMapping(value = "/cal", method = RequestMethod.GET)
	public String cal(@RequestParam("dividend") int dividend, @RequestParam("divisor") int divisor, Model model) {
		model.addAttribute("result", dividend / divisor);
		return "result";
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error/exception");
		System.out.println(e.getMessage());
		mav.addObject("result", e.getMessage());
		return mav;
	}

	/*
	 * @RequestMapping(value = "/message", method = RequestMethod.GET) public String
	 * form() { return "loginform"; }
	 */

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String form(@ModelAttribute("command") Member member) {
		return "loginform";
	}

	@ModelAttribute("loginTypes")
	public List<String> loginTypes() {
		List<String> list = new ArrayList<String>();
		list.add("일반회원");
		list.add("기업회원");
		list.add("비회원");
		return list;
	}

	/*
	@RequestMapping(value = "/message",method = RequestMethod.POST)
	public String created(@ModelAttribute("command") Member member,
			BindingResult result) {
		new MemberValidator().validate(member, result);
		if (result.hasErrors()) {
			return "loginform";
		}
		return "redirect:/";
	}
	*/
	
	@RequestMapping(value = "/message",method = RequestMethod.POST)
	public String created(@Valid @ModelAttribute("command") Member member,
			Errors errors) {
		if (errors.hasErrors()) {
			return "loginform";
		}
		return "redirect:/";
	}
	
}
