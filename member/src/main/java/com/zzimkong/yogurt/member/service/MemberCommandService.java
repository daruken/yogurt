package com.zzimkong.yogurt.member.service;

import com.zzimkong.yogurt.member.domain.Member;
import com.zzimkong.yogurt.member.domain.MemberRepository;
import com.zzimkong.yogurt.member.domain.dto.MemberDto;
import com.zzimkong.yogurt.member.domain.dto.SignInDto;
import com.zzimkong.yogurt.member.domain.dto.SignInResultDto;
import com.zzimkong.yogurt.member.domain.dto.SignUpDto;
import com.zzimkong.yogurt.member.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@Transactional
public class MemberCommandService {
    public JwtTokenProvider jwtTokenProvider;
    public MemberRepository memberRepository;
    public PasswordEncoder passwordEncoder;

    @Autowired
    public MemberCommandService(JwtTokenProvider jwtTokenProvider,
                                MemberRepository memberRepository,
                                PasswordEncoder passwordEncoder) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberDto signUp(SignUpDto signUpDto) {
        Member member = Member.builder()
                .name(signUpDto.getName())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .email(signUpDto.getEmail())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Member memberEntity = memberRepository.save(member);
        return MemberDto.builder()
                .id(memberEntity.getId())
                .name(memberEntity.getName())
                .email(memberEntity.getEmail())
                .createdDate(memberEntity.getCreatedDate())
                .updatedDate(memberEntity.getUpdatedDate())
                .build();
    }

    public SignInResultDto signIn(SignInDto signInDto) throws RuntimeException {
        Member member = memberRepository.getMemberByName(signInDto.getName());
        if (!passwordEncoder.matches(signInDto.getPassword(), member.getPassword())) {
            return SignInResultDto.builder()
                    .isLogin(false)
                    .build();
        }

        return SignInResultDto.builder()
                .isLogin(true)
                .token(jwtTokenProvider.createToken(member.getName(), new ArrayList<>()))
                .build();
    }
}
