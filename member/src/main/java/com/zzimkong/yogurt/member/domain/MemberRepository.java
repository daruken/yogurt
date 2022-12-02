package com.zzimkong.yogurt.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, CustomMemberRepository {
    Member getMemberByName(String name);
}
