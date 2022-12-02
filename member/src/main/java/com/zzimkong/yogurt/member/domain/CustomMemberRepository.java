package com.zzimkong.yogurt.member.domain;

import com.zzimkong.yogurt.member.domain.dto.MemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomMemberRepository {
    Page<MemberDto> findAllMembers(Pageable pageable);
}
