package spring.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.AppConfig;
import spring.core.member.MemberService;
import spring.core.memberImplement.MemberServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        // memberService라고 지정한 빈의 내용을 가져온다
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // 검증 - memberService에 등록된 객체 인스턴스가 memberServiceImple이면 통과!
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름 없이 타입으로만 조회")
    void findBeanByType(){
        // memberService라고 지정한 빈의 내용을 가져온다
        MemberService memberService = ac.getBean(MemberService.class);
        // 검증 - memberService에 등록된 객체 인스턴스가 memberServiceImple이면 통과!
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


    // 이 코드는 역할이 아니라 구현에 의존을 하는 것이기 때문에 좋은 코드는 아니다. 하지만 예외경우를 위해 알려줌
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2(){
        // memberService라고 지정한 빈의 내용을 가져온다
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        // 검증 - memberService에 등록된 객체 인스턴스가 memberServiceImple이면 통과!
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회가 안된다.") // 검색하려는 빈이 존재하지 않기 때문에
    void cantFindBeanByName(){
//        ac.getBean("xxxx", MemberService.class);
        // NosuchBeanDefinitionException이 실행이 되면 그것이 테스트 성공한 것이라고 여긴다. 람다를 통하여 오른쪽에는 내용을 정해준다.
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }


}
