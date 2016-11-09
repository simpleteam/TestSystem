package com.mvc;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Main {

	private static final Logger log = Logger.getLogger(Main.class);

	@RequestMapping(method = RequestMethod.GET)
	public String showHomePage(Model model) {
		log.debug("/  httpMethod:GET");
		return "index";
	}

}
