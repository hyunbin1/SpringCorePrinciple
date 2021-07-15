package spring.core;

import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.memberImplement.MemberServiceImpl;
import spring.core.order.Order;
import spring.core.order.OrderService;
import spring.core.orderServiceImplement.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "hyunbin", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "iceCream", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }

}
