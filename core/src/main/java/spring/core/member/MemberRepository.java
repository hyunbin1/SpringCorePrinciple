package spring.core.member;

// 회원 저장소
public interface MemberRepository {
    // 회원 저장, 찾기 기능 - 인터페이스로 추상화
    void save(Member member);
    Member findById(Long memberId);
}

