package com.zzimkong.yogurt.member.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResultDto {
    private boolean isLogin;
    private String token;
}
