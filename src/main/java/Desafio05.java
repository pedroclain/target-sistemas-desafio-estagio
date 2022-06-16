public class Desafio05 {

    private static final String STRING_TESTE = "Target Sistemas";

    public static void main(String[] args) {
        System.out.println(inverterString(STRING_TESTE));
    }

    private static String inverterString(String msg) {
        StringBuilder builder = new StringBuilder(msg.getBytes().length);
        String[] msgSplit = msg.split("");

        for(int i = msgSplit.length-1; i >= 0; i--) {
            builder.append(msgSplit[i]);
        }
        return builder.toString();
    }
}
