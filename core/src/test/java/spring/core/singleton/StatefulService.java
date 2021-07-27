package spring.core.singleton;

public class StatefulService {

    // 어떤 서비스에 가격이라는 필드를 가지고 있다.

//    private int price; // 상태를 유지하는 필드

    // 값을 유지시킨다.
    public int order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; // 여기서 문제가 발생한다.
        // 무상태 설계 = order에 price를 바로 리턴 보내버리면 된다.
        return price;

    }
//
//    public int getPrice(){
//        return price;
//    }

}
