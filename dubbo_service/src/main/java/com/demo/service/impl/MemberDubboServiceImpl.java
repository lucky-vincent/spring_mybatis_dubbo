package com.demo.service.impl;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.demo.dao.MemberDao;
import com.demo.entity.Member;
import com.demo.page.Page;
import com.demo.service.MemberDubboService;

/**
 * 
 * @Description : MemberService接口实现类
 * @author : liwenjian
 * @version : 1.0
 * @Date : 2016年1月28日 下午3:26:18
 */
public class MemberDubboServiceImpl implements MemberDubboService {

	private MemberDao<Member, Integer> memberDao;

	/**
	 * 
	 * private static final String REDIS_MEMBER_BASE_PREFIX = "MEMBER"; /**
	 * 用户集合key
	 */
	private static final String REDIS_MEMBER_LIST_KEY = "member_list:";

	/**
	 * redis缓存时间(秒为单位)
	 */
	private static final long REDIS_TIME_OUT_SECONDS = 60L;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public List<Member> getMembers() {
		List<Member> list = null;
		try {
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int addMember(Member member) {
		try {
			boolean isNull = member == null || member.getMemberName() == null || "".equals(member.getMemberName())
					|| member.getMemberPassword() == null || "".equals(member.getMemberPassword()) ? true : false;
			if (isNull) {
				return 0;
			}
			member.setMemberPassword(DigestUtils.md5Hex(member.getMemberPassword()));
			return memberDao.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int updateMember(Member member) {
		try {
			return memberDao.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Member findMemberById(Integer id) {
		Member member = new Member();
		member.setId(10000);
		member.setMemberName("张三");
		return member;
		//return (Member) memberDao.get(id);
	}

	public Member findMemberByName(String name) {
		try {
			return (Member) memberDao.findMemberByName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Member> findListByEmail(String email) {
		try {
			return memberDao.findListByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Page<Member> findListByPage(Page<Member> page) {
		try {
			return memberDao.findListByPage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
