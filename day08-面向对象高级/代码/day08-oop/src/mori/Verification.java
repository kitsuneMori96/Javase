package mori;

public class Verification {
    private static final String charPool = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String generateCode(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("长度必须是一个正整数");
        }

        StringBuilder codeBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            codeBuilder.append(charPool.charAt((int) (Math.random() * charPool.length())));
        }
        return codeBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateCode(8));
    }
}
