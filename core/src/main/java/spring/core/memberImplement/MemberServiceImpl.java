package spring.core.memberImplement;

import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;

public class MemberServiceImpl implements MemberService {
    // 저장소 구현체를 선언하여 회원 정보 사용하기
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원 정보 db에 저장하기
    @Override
    public void join(Member member){
        memberRepository.save(member);
    }

    // 회원 아이디 db에서 가져오기
    @Override
    public Member findMember(Long memberId){
        return memberRepository.findById(memberId);
    }
}