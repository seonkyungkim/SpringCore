package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

/*
* 클라
* */
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // private DiscountPolicy discountPolicy;  //이렇게 바꿔주면 NullPointerException. 따라서 누군가 대신 구현객체를 생성/주입 해줘야함.

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy
            discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);    //회원정보 요청이 들어오면 회원정보 조회
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인가격 계산

        return new Order(memberId, itemName, itemPrice, discountPrice); //반환
    }

}
