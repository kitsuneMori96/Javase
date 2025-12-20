package AbstractclassMethodoverriding;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class GoldCard extends Card {

    public GoldCard(String cardId){
        this.setCardId(cardId);
        this.setBalance(10000);
    }

    @Override
    void pay(double amount) {
        System.out.println("优惠前金额:"+amount);
        if(amount*0.8>this.getBalance()){
            System.out.println("余额不足，无法支付");
        }
        else{
            this.setBalance(this.getBalance()-amount*0.8);
            System.out.println("支付成功，优惠后金额:"+amount*0.8);
            System.out.println("余额:"+this.getBalance());
        }
    }
}
