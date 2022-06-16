public class Desafio04 {
    private static final EstadoFaturamento[] estadoFaturamentoArray = {
            new EstadoFaturamento("SP", 67836.43),
            new EstadoFaturamento("RJ", 36678.66),
            new EstadoFaturamento("MG", 29229.88),
            new EstadoFaturamento("ES", 27165.48),
            new EstadoFaturamento("Outros", 19849.53),
    };

    private static double FATURAMENTO_TOTAL;

    static {
        for (EstadoFaturamento estadoFaturamento : estadoFaturamentoArray) {
            FATURAMENTO_TOTAL += estadoFaturamento.getFaturamento();
        }
    }

    public static void main(String[] args) {
        for(EstadoFaturamento estadoFaturamento : estadoFaturamentoArray) {
            System.out.println(
                    estadoFaturamento + "  ===  " + calculaPorcentagemPorEstado(estadoFaturamento) + "%"
            );
        }
    }

    private static double calculaPorcentagemPorEstado(EstadoFaturamento estadoFaturamento) {
        return estadoFaturamento.getFaturamento() / FATURAMENTO_TOTAL * 100;
    }

    static class EstadoFaturamento {
        private String estado;
        private double faturamento;

        public EstadoFaturamento(String estado, double faturamento) {
            this.estado = estado;
            this.faturamento = faturamento;
        }

        @Override
        public String toString() {
            return "{" +
                    "estado='" + estado + '\'' +
                    ", faturamento=" + faturamento +
                    '}';
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public double getFaturamento() {
            return faturamento;
        }

        public void setFaturamento(double faturamento) {
            this.faturamento = faturamento;
        }
    }
}
