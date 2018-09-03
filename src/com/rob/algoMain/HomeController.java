package com.rob.algoMain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	//ALGORITHM 1
	@RequestMapping("/add-two-numbers")
	public String addTwoNumbers() {
		return "add-two-numbers";
	}
	
	@RequestMapping("/processForm")
	public String processForm(HttpServletRequest request, Model model) {
		int valueOne = Integer.parseInt(request.getParameter("numberOne"));
		int valueTwo = Integer.parseInt(request.getParameter("numberTwo"));
		int solution = valueOne + valueTwo;
		model.addAttribute("solution", solution);
		
		return "answer1";
	}
	
	//ALGORITHM2 
	@RequestMapping("/century-from-year")
	public String centuryFromYear(HttpServletRequest request, Model model) {
		int year = Integer.parseInt(request.getParameter("year"));
		int solution;
		
		if(year % 2 == 0) {
			solution = year/100;
		}
		else {
			//integer to double example in note 
			//Double x = new Double((year/100)-1);
			//cast double type to integer
			solution = (int) Math.floor((year/100)+1);
		}
		model.addAttribute("solution", solution);
		return "answer1";
	}
	
	//ALGORITHM 3
	@RequestMapping("/check-palindrome")
	public String checkPalindrome(HttpServletRequest request, Model model) {
		String value1 = request.getParameter("palindromeCandidate");
		StringBuilder value2 = new StringBuilder();
		String solution;
		for(int i = value1.length()-1; i >= 0; i--) {
			value2.append(value1.charAt(i));
		}
		
		Boolean answer = value1.equals(value2.toString());
		System.out.println("answer"+answer);
		System.out.println(value2.toString());
		if(answer == true) {
			solution = "Yes";
		}
		else {
			solution = "No";
		}
		
		model.addAttribute("solution", solution);
		return "answer1";
	}
	
	
}
