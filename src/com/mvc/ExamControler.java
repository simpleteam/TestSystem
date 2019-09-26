package com.mvc;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dto.AnswerListDto;
import com.service.Exam;
import com.util.Helper;



@Controller
@RequestMapping("/exam")
@Scope("session")
public class ExamControler {

	private static final Logger log = Logger.getLogger(ExamControler.class);
	
	@Autowired
	private Helper helper;

	@Autowired
	private Exam exam;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showQuestions(Model model){
		log.debug("/exam  httpMethod:GET");
		AnswerListDto answers = new AnswerListDto();
		answers = helper.convertQuestionsToModelAttribute(exam.getTasks());
		model.addAttribute("answers",answers);
		return "test";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String getResult(@ModelAttribute AnswerListDto answers ,BindingResult binding, Model model){
		log.debug("/exam  httpMethod:POST");
		exam.setAnswers(helper.convertModelAttributeToQuestions(answers));
		model.addAttribute("result", exam.getResult());
		return "result";
	}
	
}


