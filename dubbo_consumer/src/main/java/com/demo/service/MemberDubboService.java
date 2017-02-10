package com.demo.service;

import java.util.List;

import com.demo.entity.Member;
import com.demo.page.Page;

/**
 * 
 * @Description : memberService接口
 * @author : liwenjian
 * @version : 1.0
 * @Date : 2016年1月28日 下午3:23:47
 */
public interface MemberDubboService {
	public List<Member> getMembers();

	public int addMember(Member member);

	public int updateMember(Member member);

	public Member findMemberById(Integer id);

	public Member findMemberByName(String name) ;

	public List<Member> findListByEmail(String email);

	public Page<Member> findListByPage(Page<Member> page);
}
