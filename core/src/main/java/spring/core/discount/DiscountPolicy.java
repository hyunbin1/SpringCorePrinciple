package spring.core.discount;

import spring.core.member.Member;

public interface DiscountPolicy {

    /*
    * @return 할인 정책 금액
    */

    int discount(Member member, int price);
}
