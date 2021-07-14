# SpringCorePrinciple

### 비지니스 요구사항:
    회원:
        1. 회원을 가입하고 조회할 수 있다.
        2. 회원은 일반과 VIP 두 가지 등급이 있다.
        3. 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)

    주문과 할인정책:
        1. 회원은 상품을 주문할 수 있다.
        2. 회원 등급에 따라 할인 정책을 적용할 수 있다.
        3. 할인 정책은 모든 VIP는 1000원을 할인해주는 고정 금액 할인을 적용해달라고 한다.(나중에 변경 가능)
        주의!: 할인 정책의 변경가능성은 높다. 회사의 기본 할인 정책을 아직 정하지 못했고, 오픈 직전까지 고민을 미루고 싶다.
               최악의 경우 할인을 적용하지 않을 수도 있다.(미확정)


### 설계:
#### 1. 요구사항을 보면 회원 데이터, 할인 정책 같은 부분은 지금 결정하기 어렵다. 하지만 정책이 결정된 후 개발을 하면 늦는다.
    => 따라서 객체 지향 설계 방법을 사용하여 개발을 먼저 할 것!
#### 2. 인터페이스를 만들고 구현체를 언제든지 갈아끼울 수 있도록 설계하면된다.



### 회원 도메인 설계

 #### *회원 도메인 협력관계: 도메인 구현을 위한 큰 그림

![image](https://user-images.githubusercontent.com/63040492/125378973-a79e4b00-e3ca-11eb-8e7f-50c1b65a3229.png)

    클라이언트는 회원 서비스를 통해 회원 가입과 조회를 한다. 
    1단계로 회원 저장소는 개발을 위해 우선 메모리 회원 저장소에 저장을 해둔다. 
    그 후 저장소의 위치가 정해지면, 자체 DB회원 저장소 혹은 외부 시스템 연동 회원 저장소로 저장소 위치를 변경해준다.
    
 #### *회원 클래스 다이어그램: 실제 개발 레벨에서 구현을 위한 설계도
 
 ![image](https://user-images.githubusercontent.com/63040492/125379970-745cbb80-e3cc-11eb-960f-cd9f30ddb37f.png)
 
    1. 회원 서비스와 저장소를 인터페이스를 통해 추상화하여 역할을 만들어준다.
    2. 이후 MemberServiceImpl에 회원 서비스 실제 구현체를 만들어 준다.
    3. 객체지향을 위해 서비스의 구현체는 회원 저장소의 추상화된 인터페이스를 기준으로 연결한다.
        => MemoryMemberRepository 혹은 DbMemberRepository와 같은 구현체를 기준으로 연결하면 좋은 객체지향 개발방법이 아니다. 
            이는 SOLID에 근거한다.
            
 #### *회원 객체 다이어그램: 객체 간의 실제 참조가 어떻게 되는지 서술한 설계도
 
 ![image](https://user-images.githubusercontent.com/63040492/125380299-f2b95d80-e3cc-11eb-81a8-4c4e88637f8f.png)

    즉 실제 구현은: 클라이언트 -> MemberServiceImpl -> MemoryMemberRepository 로 구현된다.
    

![image](https://user-images.githubusercontent.com/63040492/125545268-113bc350-92c4-4f46-a462-fbe751be1d55.png)

![image](https://user-images.githubusercontent.com/63040492/125545313-36fcf173-b663-437e-a9be-ce69efd61e50.png)

![image](https://user-images.githubusercontent.com/63040492/125545337-7e7bfb26-517a-4eb2-9633-caff89adeb5e.png)

![image](https://user-images.githubusercontent.com/63040492/125545387-520cd2e6-a546-45c1-8383-3552388fcead.png)

![image](https://user-images.githubusercontent.com/63040492/125545415-0306f8df-6762-4dce-b4df-819d766dc7dd.png)


