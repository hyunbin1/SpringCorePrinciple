package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberService;
import spring.core.memberImplement.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService;
        // annotaiton = @주석을 찾아준다
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 첫 인자: AppConfig에서 참조 변수명, 두번째 인자: 객체.class
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member1 = new Member(1L, "hyun", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member1 = " + member1.getName());
        System.out.println("find member1 = " + findMember.getName());
    }
}
