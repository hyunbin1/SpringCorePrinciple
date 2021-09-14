package spring.core.scan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.AutoAppConfig;
import spring.core.member.MemberService;
import spring.core.memberImplement.MemberServiceImpl;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        // 실제로 잘 조회하는지 확인하기
        MemberService memberService = annotationConfigApplicationContext.getBean(MemberService.class);
        Assertions.assertTrue(memberService instanceof MemberService);
    }
}
