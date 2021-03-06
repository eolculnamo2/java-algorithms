package com.rob.algoMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		if(answer == true) {
			solution = "Yes";
		}
		else {
			solution = "No";
		}
		
		model.addAttribute("solution", solution);
		return "answer1";
	}
	
	//ALGORITHM 4
	@RequestMapping("/greatest-product")
	public String greatestProduct(HttpServletRequest request, Model model) {
		
		String[] arr = request.getParameter("number-list").split(",", 0);
		int answer = 0;

		for(int i=0; i < arr.length - 1; i++) {
			int x = Integer.parseInt(arr[i]) * Integer.parseInt(arr[i+1]);
			if(x > answer) {
				answer = x;
			}
		}
		
		model.addAttribute("solution", answer);
		
		return "answer1";
	}
	
	//ALGORITHM 5: First duplicate
	@RequestMapping("/first-duplicate")
	public String firstDuplicate(HttpServletRequest request, Model model) {
		String[] arr = request.getParameter("duplicate-list").split(",", 0);
		
		//list stores values that we've seen previously.
		List<String> list = new ArrayList<String> ();
		String answer = "No Duplicate";
		for(int i = 0; i < arr.length; i++) {
			if(list.contains(arr[i]) == false) {
				list.add(arr[i]);
			}
			else {
				answer = arr[i];
				break;
			}
		}
		//returns a String, but it appears the same on the screen. 
		//casting to integer would be a wasted step.
		model.addAttribute("solution", answer);
		
		return "answer1";
	}
	
}