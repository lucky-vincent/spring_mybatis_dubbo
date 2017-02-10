package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.Member;
import com.demo.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/find")
	public String find() {
		try {
			Member member = memberService.findMemberById(1);
			System.out.println("输出：" + member.getMemberName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/list";
	}

}
