package com.zzimkong.yogurt.member.service;

import com.zzimkong.yogurt.member.domain.MemberRepository;
import com.zzimkong.yogurt.member.domain.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberQueryService {
    MemberRepository memberRepository;

    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Page<MemberDto> selectAll(Pageable pageable) {
        return memberRepository.findAllMembers(pageable);
    }
}
