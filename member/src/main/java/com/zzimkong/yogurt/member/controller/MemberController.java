package com.zzimkong.yogurt.member.controller;

import com.zzimkong.yogurt.member.domain.dto.MemberDto;
import com.zzimkong.yogurt.member.domain.dto.SignInDto;
import com.zzimkong.yogurt.member.domain.dto.SignInResultDto;
import com.zzimkong.yogurt.member.domain.dto.SignUpDto;
import com.zzimkong.yogurt.member.service.MemberCommandService;
import com.zzimkong.yogurt.member.service.MemberQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {
    MemberCommandService memberCommandService;
    MemberQueryService memberQueryService;

    @Autowired
    public MemberController(MemberCommandService memberCommandService, MemberQueryService memberQueryService) {
        this.memberCommandService = memberCommandService;
        this.memberQueryService = memberQueryService;
    }

    @GetMapping("")
    public Page<MemberDto> getMemberList(Pageable pageable) {
        return memberQueryService.selectAll(pageable);
    }

    @PostMapping("/sign-up")
    public MemberDto signUp(@RequestBody SignUpDto signUpDto) {
        return memberCommandService.signUp(signUpDto);
    }

    @PostMapping("/sign-in")
    public SignInResultDto signIn(@RequestBody SignInDto signInDto) {
        return memberCommandService.signIn(signInDto);
    }
}
