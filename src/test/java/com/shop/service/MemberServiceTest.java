package com.shop.service;

import com.shop.dto.MemberFormDto;
import com.shop.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.transaction.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setEmail("jks2024@gmail.com");
        memberFormDto.setName("곰돌이사육사");
        memberFormDto.setAddress("경기도 수원시 권선구");
        memberFormDto.setPassword("sphb8250");
        return Member.createMember(memberFormDto, passwordEncoder);
    }
    @Test
    @DisplayName("회원가입테스트")
    public void saveMemberTest() {
        Member member = createMember();
        Member savedMember = memberService.saveMember(member);
        assertEquals(member.getEmail(), savedMember.getEmail());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
        assertEquals(member.getRole(), savedMember.getRole());
    }
}
