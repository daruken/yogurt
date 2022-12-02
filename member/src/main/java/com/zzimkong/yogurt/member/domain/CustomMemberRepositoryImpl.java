package com.zzimkong.yogurt.member.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zzimkong.yogurt.member.domain.dto.MemberDto;
import com.zzimkong.yogurt.member.domain.dto.QMemberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.zzimkong.yogurt.member.domain.QMember.member;

public class CustomMemberRepositoryImpl implements CustomMemberRepository {
    private final JPAQueryFactory queryFactory;

    public CustomMemberRepositoryImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
    }

    @Override
    public Page<MemberDto> findAllMembers(Pageable pageable) {
        List<MemberDto> content = queryFactory.select(new QMemberDto(
                                member.id,
                                member.name,
                                member.email,
                                member.createdDate,
                                member.updatedDate
                        )
                ).from(member)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long totalCount = queryFactory.select(member.count())
                .from(member)
                .fetchOne();
        if (totalCount == null) {
            totalCount = 0L;
        }

        return new PageImpl<>(content, pageable, totalCount);
    }
}
