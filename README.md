# SpringCorePrinciple

##비지니스 요구사항:
    ###- 회원:
        1. 회원을 가입하고 조회할 수 있다.
        2. 회원은 일반과 VIP 두 가지 등급이 있다.
        3. 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)

    ###- 주문과 할인정책:
        1. 회원은 상품을 주문할 수 있다.
        2. 회원 등급에 따라 할인 정책을 적용할 수 있다.
        3. 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라고 한다.(나중에 변경 가능)
        주의!: 할인 정책의 변경가능성은 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다.
               최악의 경우 할인을 적용하지 않을 수도 있다.(미확정)


##설계:
###1. 요구사항을 보면 회원 데이터, 할인 정책 같은 부분은 지금 결정하기 어렵다. 하지만 정책이 결정된 후 개발을 하면 늦는다.
    => 따라서 객체 지향 설계 방법을 사용하여 개발을 먼저 할 것!

###2. 인터페이스를 만들고 구현체를 언제든지 갈아끼울 수 있도록 설계하면된다.
