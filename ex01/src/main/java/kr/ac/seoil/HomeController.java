package kr.ac.seoil;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.seoil.sample.vo.SampleVO;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
//@Log4j
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	
	@RequestMapping("/sample.do")
	public String sample(HttpServletRequest request, SampleVO sampleVO) {
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		
		System.out.println(userName + ", " + userAge);
		System.out.println(sampleVO.getUserName() + ", " + sampleVO.getUserAge());
		for(int i=0; i< sampleVO.getHobby().length; i++) {
			System.out.println("hobby" + "[" + i + "]" + sampleVO.getHobby()[i]);
		}
		System.out.println(sampleVO.getRegDate());
		return "sample";
	}
	
	@GetMapping("/sample/ex04.do")
	public String ex04(SampleVO vo, @ModelAttribute("page") int page) {
		logger.info("vo:" + vo.toString());
		logger.info("page: " + page);
		
		return "sample/ex04";
	}
	
	@GetMapping("/sample/ex05.do")
	public @ResponseBody SampleVO ex05() {
		SampleVO sampleVO = new SampleVO();
		sampleVO.setUserName("홍길동");
		sampleVO.setUserAge(111);
		return sampleVO;
	}
	
	@GetMapping("/sample/ex06.do")
	public @ResponseBody List<SampleVO> ex06() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		SampleVO vo = new SampleVO();
		vo.setUserName("최석원");
		vo.setUserAge(111);
		list.add(vo);
		logger.debug(vo.toString());
		
		vo = new SampleVO();
		vo.setUserName("김구");
		vo.setUserAge(22);
		list.add(vo);
		logger.debug(vo.toString());
		return list;
	}
	
	@GetMapping("/sample/ex07.do")
	public ResponseEntity<String> ex07() {
		
		String msg = "{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
}
