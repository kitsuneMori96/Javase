package AbstractclassMethodoverriding;

public class Test {
    public static void main(String[] args) {
        Card goldCard = new GoldCard("1234567890");
        Card silverCard = new SilverCard("9876543210");

        goldCard.pay(5000);
        System.out.println("----------------");
        silverCard.pay(2000);
        goldCard.pay(9000);
        System.out.println("----------------");
        silverCard.pay(5000);
    }
}
