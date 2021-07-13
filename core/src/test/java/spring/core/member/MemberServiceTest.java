package spring.core.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import spring.core.memberImplement.MemberServiceImpl;

public class MemberServiceTest {
    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given
        Member member1 = new Member(1l, "hi", Grade.VIP);

        //when
        memberService.join(member1);
        // 가입된 회원의 아이디를 기입하여 멤버가 찾아지는지 확인하기 - 서로 같다면 찾아지는것!
        Member findMember = memberService.findMember(1l);

        //then
        Assertions.assertEquals(member1, findMember);
    }
}
