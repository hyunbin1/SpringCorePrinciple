package spring.core.singleton;

public class SingletonService {

    // private = 내부에 static = 자기 자신을 하나만 클래스 레벨로 가지게 된다.
    // 자바를 키면 바로 객체를 하나 생성한 다음, instance에 참조를 넣어놓는다.
    private static final SingletonService instance = new SingletonService();

    // instance 참조를 꺼낼 수 있는 방법은 바로 아래 코드뿐이 없다. 어느 곳에서도 instance 참조를 꺼내서 사용할 수 없다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 이렇게 자기 자신(singletonService)을 private으로 생성하여 다른 파일에서 singletonService 함수에 new를 사용할 수 없게 만들어 객체 생성을 금지한다.
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
