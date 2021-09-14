package spring.core.memberImplement;

import org.springframework.stereotype.Component;
import spring.core.member.Member;
import spring.core.member.MemberRepository;

import java.util.HashMap;
import java.util.Map;

@Component
// 메모리에 저장되는 저장소를 실제로 구현해주기
public class MemoryMemberRepository implements MemberRepository {

    // 회원 번호와 회원 정보를 매칭 시켜주기
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    // 회원 아이디에 따라 회원 정보 저장해주기
    public void save(Member member){
        store.put(member.getId(), member);
    }

    @Override
    // 회원 아이디 찾기
    public Member findById(Long memberId){
        return store.get(memberId);
    }




}






/*
1. HashMap: Map 인터페이스를 구현한 대표적인 Map 컬렉션이다. 이는 Map 인터페이스를 상송하고 있기에 Map의 성질을 그대로 가지고 있다.

    값 추가: .put(key, value)
    값 삭제: .remove(key),
    모든 값 삭제: .clear();
    키값의 value 출력: .get(key)
    많은 양의 key+value: .entrySet() 아니라면 .keySet()

   + Map은 key와 value로 구성된 Entry객체를 저장하는 자료구조이다. 이때, key와 value는 모두 객체이다.
     value는 중복 저장이 가능하지만 key는 불가능하다.
   + 해시함수: key값을 value로 값을 바꿔주기 위한 수식이다.
   + 해싱: 해시 테이블을 생서앟여 저장된 정보를 빠르게 검색할 수 있다.


2. Implements: 상속의 일종으로, 부모의 메소드를 반드시 오버라이딩(재정의)해야한다. 이는 다중 상속을 대신해준다.
    extends는 일반 클래스와 추상 클래스 상속에 사용되고, implement는 interface 상속에 사용된다.
*/