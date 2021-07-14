package spring.core.discount;

import spring.core.member.Grade;
import spring.core.member.Member;

// 정액 할인 정책 - 회원 등급에 따라 할인 금액 지정하기
public class FixDiscountPolicy implements DiscountPolicy {
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price){
        // enum type은 ==을 사용하는 것이 맞다.
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else{
            return 0;
        }
    }


}
