package com.zzimkong.yogurt.member.domain.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.zzimkong.yogurt.member.domain.dto.QMemberDto is a Querydsl Projection type for MemberDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberDto extends ConstructorExpression<MemberDto> {

    private static final long serialVersionUID = 497119256L;

    public QMemberDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> email, com.querydsl.core.types.Expression<java.time.LocalDateTime> createdDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> updatedDate) {
        super(MemberDto.class, new Class<?>[]{long.class, String.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class}, id, name, email, createdDate, updatedDate);
    }

}

