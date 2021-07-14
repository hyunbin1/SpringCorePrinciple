package spring.core.orderServiceImplement;

import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.memberImplement.MemoryMemberRepository;
import spring.core.order.Order;
import spring.core.order.OrderService;

// 주문생성: 할인을 적용하기 우해서 회원 등급이 필요하다.
//         -> 필요데이터: 회원 ID, 상품명, 상품 가격
public class OrderServiceImpl implements OrderService {
    // 필요한 데이터를 위해 메모리 회원 저장소 & 고정할인 정책을 가져와된다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        // 회원 저장소에서 아이디를 가져온다음에, 이를 discountPolicy에 던져주어 할인의 정도를 정한다.
        Member member = memberRepository.findById(memberId);
        // 구현체를 가져오지 않고 interface를 가져와서 사용하는 것은 할인정책 빌드에서 단일 체계를 잘 지킨 것이다.
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

}
