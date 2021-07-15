package spring.core;

import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.memberImplement.MemberServiceImpl;
import spring.core.memberImplement.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.orderServiceImplement.OrderServiceImpl;

public class AppConfig {
// 실제 동작에 필요한 구현 객체를 생성한다. - SOLID 중 DIP를 실현하기 위한 것.
    public MemberService memberService(){
        // 필요한 데이터 생성자 주입
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

//    public void join(Member member){
//        MemberRepository.save(member);
//    }
}
