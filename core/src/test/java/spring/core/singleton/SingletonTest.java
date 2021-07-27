package spring.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.AppConfig;
import spring.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없은 순수한 DI 컨테이너 - 문제점 보기")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        // 객체1. 조회: 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        // 객체2. 조회: 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 서로 다른 것을 확인 == 객체 생성시 새로운 객체를 호출하는 것을 의미한다.
        System.out.println("memberService = " + memberService1);
        System.out.println("memberService = " + memberService2);

        // => memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
//      new SingletonService(); - 이렇게 하면 오류난다.
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("SingletonService = " + singletonService1);
        System.out.println("SingletonService = " + singletonService2);
        // => 출력: 참조 결과가 서로 동일한 것을 볼 수 있다.

        /*
        * .isSameAs: 실제 참조값이 같은지 비교하는 것이다. == 과 동일한 것
        * .isEqualto: 자바에 equals 메서드 오버라이드 한 것을 비교하는 것이다.
        * 즉,
        * isSameAs - 객체가 동일한지 확인(예: 객체가 동일한 참조를 가리키는지 확인 )
        * isEqualTo - 객체가 같은지 확인합니다(예: 값을 기반으로 객체가 같은지 확인 )
        * */
        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        // 객체1. 조회: 호출할 때마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 객체2. 조회: 호출할 때마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 서로 다른 것을 확인 == 객체 생성시 새로운 객체를 호출하는 것을 의미한다.
        System.out.println("memberService = " + memberService1);
        System.out.println("memberService = " + memberService2);

        // => memberService1 != memberService2
        assertThat(memberService1).isSameAs(memberService2);

    }
}



