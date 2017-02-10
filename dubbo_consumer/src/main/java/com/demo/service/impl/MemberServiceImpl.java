package com.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.entity.Member;
import com.demo.page.Page;
import com.demo.service.MemberDubboService;
import com.demo.service.MemberService;

/**
 * 
 * @Description : MemberService接口实现类
 * @author : liwenjian
 * @version : 1.0
 * @Date : 2016年1月28日 下午3:26:18
 */
@Service("memberServiceImpl")
public class MemberServiceImpl implements MemberService {

	@Resource(name = "memberDubboService")
	private MemberDubboService memberDubboService;

	public List<Member> getMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	public int addMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Member findMemberById(Integer id) {
		return memberDubboService.findMemberById(id);
	}

	public Member findMemberByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Member> findListByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Member> findListByPage(Page<Member> page) {
		// TODO Auto-generated method stub
		return null;
	}
}
