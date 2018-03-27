package com.bitcamp.open.member.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bitcamp.open.member.model.Member;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	// 생성자 방식으로 의존 설정
	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 회원가입
	public int insertMember(Member member) {

		String sql = "insert into member (member_id, member_name, password, photo ) " + " values ( ?, ?, ?, ? )";
		System.out.println(member.getMember_id());
		int resultCnt = jdbcTemplate.update(sql, member.getMember_id(), member.getMember_name(), member.getPassword(),
				member.getPhoto());

		return resultCnt;

	}

}
