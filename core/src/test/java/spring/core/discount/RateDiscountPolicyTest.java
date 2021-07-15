package spring.core.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import spring.core.AppConfig;
import spring.core.member.Grade;
import spring.core.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
//    RateDiscountPolicy discountPolicy;
//
//    @BeforeEach
//    public void beforeEach(){
//        AppConfig appConfig = new AppConfig();
//        discountPolicy = new appConfig.discountPolicy();


    @Test
    @DisplayName("VIP는 할인이 적용되어야 한다.")
    void vip_yes(){
        // given
        Member member = new Member(1L, "member1", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member, 10000);
        // then
        Assertions.assertEquals(discount, 1000);
    }

    @Test
    @DisplayName("ViP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_no() {
        //given
        Member member2 = new Member(1L, "member2", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member2, 10000);
        //then
        Assertions.assertEquals(discount, 0);
    }
}