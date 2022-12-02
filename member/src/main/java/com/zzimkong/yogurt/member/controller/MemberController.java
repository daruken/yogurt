package com.zzimkong.yogurt.member.controller;

import com.zzimkong.yogurt.member.domain.dto.MemberDto;
import com.zzimkong.yogurt.member.service.MemberQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberController {
    MemberQueryService memberQueryService;

    @Autowired
    public MemberController(MemberQueryService memberQueryService) {
        this.memberQueryService = memberQueryService;
    }

    @GetMapping("")
    public Page<MemberDto> getMemberList(Pageable pageable) {
        return memberQueryService.selectAll(pageable);
    }
}
