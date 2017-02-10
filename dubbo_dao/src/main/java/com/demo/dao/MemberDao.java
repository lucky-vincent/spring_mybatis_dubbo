package com.demo.dao;

import java.io.Serializable;
import java.util.List;

import com.demo.entity.Member;
import com.demo.page.Page;

public interface MemberDao<T, PK extends Serializable> extends BaseDao<Member, Integer> {
	public List<Member> getMembers() throws Exception;

	public int insertMember(Member member) throws Exception;

	public int updateMember(Member member) throws Exception;

	public Member findMemberByName(String name) throws Exception;

	public List<Member> findListByEmail(String email) throws Exception;

	public Page<Member> findListByPage(Page<Member> page) throws Exception;

}
