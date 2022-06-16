public class Desafio02 {

    private static final int FIB_TESTE = 14;

    public static void main(String[] args) {
        calculaSequenciaFib(FIB_TESTE);
    }

    public static void calculaSequenciaFib(int n) {
        int n1 = 0;
        int n2 = 1;
        int fib = 0;
        while (fib < n) {
            fib = n1 + n2;
            n1 = n2;
            n2 = fib;
            if (fib <= n) {
                System.out.print(fib + " ");
            }
        }
        System.out.println();
        if (fib != n) System.out.println(n + " nao pertence a sequencia de fibonacci.");

    }
}
