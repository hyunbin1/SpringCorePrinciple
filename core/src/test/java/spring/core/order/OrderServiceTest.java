package spring.core.order;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.memberImplement.MemberServiceImpl;
import spring.core.orderServiceImplement.OrderServiceImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void creatOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "hi", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemem", 10000);
        Assertions.assertEquals(order.getDiscountPrice(), 1000);
    }
}
