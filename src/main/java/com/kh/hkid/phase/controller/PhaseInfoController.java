package com.kh.hkid.phase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.phase.service.PhaseService;
import com.kh.hkid.product.model.vo.Product;
import com.kh.hkid.product.model.vo.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PhaseInfoController {
	private final PhaseService phaseService;	
	
	@Autowired
	public PhaseInfoController(PhaseService phaseService) {
		this.phaseService = phaseService;
	}
	
	// 결제 화면 이동
	@ResponseBody
	@RequestMapping("phaseInfo.li")
	public String selectPhaseInfo(@RequestParam(value="phaseList") String phaseList,
								HttpSession session, Model model, Phase p) {
		
		
//		Member m = (Member)session.getAttribute("loginMember");		
//		if(m == null) {
//			session.setAttribute("alertMsg","로그인 이후 이용 가능한 서비스입니다.");
//			return "redirect:/loginForm.me";
//		}
		
		
//		HashMap<String, Object> order1= new HashMap<>();
//		order1.put("memberNo", (m));
//		order1.put("productNo", session.getAttribute("productNo"));
//		 
//		ArrayList<Phase> order = phaseService.selectList(order1);		 
//		 
//		model.addAttribute("order",order);
		
		return "order/orderInfo";
	}

	
	
//	@GetMapping("phase.in")
//	public String CompletePage(Phase p,HttpSession session, Model model, ModelAndView mv) {
//		int result = phaseService.insertPhase(p);
//		
//		if(result > 0) {
//			model.getAttribute("p", phaseService.selectList(p));
//		} else {
//			
//		}
//		session.setAttribute("",p);
//		return "order/orderComplete";
//	}
	
	// 구매 리스트 불러오기
	@RequestMapping("phase.li")
	public String phasepage(@RequestParam(value="cpage", defaultValue="1")int currentPage,int memberNo, Model model) {
		int phaseCount = phaseService.selectListCount(memberNo);
		
		PageInfo pi = Template.getPageInfo(phaseCount, currentPage, 10, 10);
		ArrayList<Phase> list = phaseService.phaseList(memberNo, pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		if(memberNo == 0) {
			model.addAttribute("alertMsg", "사용자 정보를 불러 올 수 없습니다.");
			return "redirect:/";
		}
		System.out.println("Current Page: " + currentPage);
		System.out.println("Member No: " + memberNo);
		System.out.println(list);
		return "Products/phaseList";
	}
	
	// 리뷰
	@GetMapping("selectReview.r")
	public String selectReview(@RequestParam(required = false) int memberNo, Model model) {
		if(memberNo != 0) {
			Review r = phaseService.selectReview(memberNo);
			model.addAttribute("r", r);
		}
		return "Products/review";
	}
	
	// 리뷰 등록
	@ResponseBody
	@PostMapping(value="addReview.r", produces = "application/json; charset=UTF-8")
	public String reviewAdd(@RequestParam int memberNo,
							   @RequestParam int productNo,
							   @RequestParam String reviewContent,
							   Review r, Model model) {
			
		if(r.getReviewNo() == 0) {
			
			phaseService.addReview(r);
			return "정보가 새로 저장되었습니다.";
		}
		
		// 시퀸스가 아닌 UUID 를 사용하여 시퀸스에 의존하지 않음
		//setReviewNo(UUID.randomUUID().hashCode()); 
				
	
		return "Products/review";
	}
}
