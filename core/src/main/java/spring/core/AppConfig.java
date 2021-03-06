package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.memberImplement.MemberServiceImpl;
import spring.core.memberImplement.MemoryMemberRepository;
import spring.core.order.OrderService;
import spring.core.orderServiceImplement.OrderServiceImpl;

@Configuration
public class AppConfig {
// 실제 동작에 필요한 구현 객체를 생성한다. - SOLID 중 DIP를 실현하기 위한 것.
    // 필요한 데이터 생성자 주입
    // return에는 구현체에 어떤 인터페이스를 연결해줄 것인지 파라미터로 설정해준다

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // 메모리 구현체 가져오기
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        // 비율 할인제
        return new RateDiscountPolicy();
//      return new FixDiscountPolicy();
    }
}

