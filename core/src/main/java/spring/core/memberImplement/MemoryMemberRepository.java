package spring.core.memberImplement;

public class MemoryMemberRepository {
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

*/