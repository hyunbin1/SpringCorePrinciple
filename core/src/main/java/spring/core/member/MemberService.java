package spring.core.member;

// 회원 서비스 기능: 1. 가입, 2. 조회
public interface MemberService {
    // 1. 가입
    void join(Member member);

    // 2. 조회
    Member findMember(Long memberId);
}
