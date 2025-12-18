package day06;

/**
 * 银卡类，继承自Card
 * 银卡消费享受9折优惠
 */
public class SliverCard extends Card {
    /**
     * 重写消费方法
     * 银卡消费打9折优惠
     * @param n 消费金额
     */
    @Override
    public void consume(double n){
        System.out.println("您当前银卡消费：" + n);
        n*=0.9; // 银卡享受9折优惠
        System.out.println("优惠后的价格：" + n);
        if(n>super.getMoney()){
            System.out.println("余额不足，请充值");
            return ;
        }
        System.out.println("成功消费");
        super.consume(n); // 调用父类方法扣除余额
    }

    /**
     * 无参构造方法
     */
    public SliverCard(){

    }

    /**
     * 有参构造方法
     * @param carid 卡号
     * @param name 姓名
     * @param phone 电话号码
     * @param money 余额
     */
    public SliverCard(String carid, String name, int phone, double money) {
        super(carid, name, phone, money);
    }
}
