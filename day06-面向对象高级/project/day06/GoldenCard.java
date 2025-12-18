package day06;

/**
 * 金卡类，继承自Card
 * 金卡消费享受8折优惠，并且累计消费满200元可获得免费洗车票
 */
public class GoldenCard extends Card {
    /** 累计消费金额 */
    private double sumcost;
    
    /**
     * 重写消费方法
     * 金卡消费打8折优惠，累计消费满200元赠送免费洗车票
     * @param n 消费金额
     */
    @Override
    public void consume(double n){
        System.out.println("您当前金卡消费：" + n);
        n*=0.8; // 金卡享受8折优惠
        System.out.println("优惠后的价格：" + n);
        if(n>super.getMoney()){
            System.out.println("余额不足，请充值");
            return ;
        }
        super.consume(n); // 调用父类方法扣除余额
        sumcost+=n; // 累加消费金额
        if(sumcost>=200) { // 判断累计消费是否满200元
            System.out.println("免费洗车票");
            sumcost -= 200; // 扣除已兑换的200元
        }
    }
    
    /**
     * 无参构造方法
     */
    public GoldenCard(){

    }
    
    /**
     * 有参构造方法
     * @param carid 卡号
     * @param name 姓名
     * @param phone 电话号码
     * @param money 余额
     */
    public GoldenCard(String carid, String name, int phone, double money){
        super(carid, name, phone, money);
    }
}
