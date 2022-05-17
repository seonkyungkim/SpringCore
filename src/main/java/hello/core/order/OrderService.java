package hello.core.order;

public interface OrderService {
    //클라이언트가 넘기는 정보 1.회원아이디 2.아이템이름 3.가격
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
