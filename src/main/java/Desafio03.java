import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Desafio03 {
    private static final ObjectMapper objMapper = new ObjectMapper();
    private static final List<DiaFaturamento> diaFaturamentoList;

    static {
        try {
            diaFaturamentoList = objMapper.readValue(Paths.get("dados.json").toFile(),
                    new TypeReference<>() {
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(buscaMaior());
        System.out.println(buscaMenor());
        System.out.println(quantidadeSuperiorMedia());
    }

    private static int quantidadeSuperiorMedia() {
        double media = calculaMedia();
        int contador = 0;
        for(DiaFaturamento diaFaturamento : diaFaturamentoList) {
            if(diaFaturamento.getValor() > media) {
               contador++;
            }
        }
        return contador;
    }

    private static double calculaMedia() {
        double soma = 0.0;
        int quantDias = 0;

        for(DiaFaturamento diaFaturamento : diaFaturamentoList) {
            if(diaFaturamento.getValor() != 0) {
                quantDias++;
                soma += diaFaturamento.getValor();
            }
        }
        return soma / quantDias;
    }

    private static DiaFaturamento buscaMenor() {
        DiaFaturamento menorDiaFaturamento = new DiaFaturamento();
        menorDiaFaturamento.setValor(Double.MAX_VALUE);

        for(DiaFaturamento diaFaturamento : diaFaturamentoList) {
            if (diaFaturamento.getValor() != 0.0 && diaFaturamento.getValor() < menorDiaFaturamento.getValor()) {
                menorDiaFaturamento = diaFaturamento;
            }
        }
        return menorDiaFaturamento;
    }

    private static DiaFaturamento buscaMaior() {
        DiaFaturamento maiorFaturamento = new DiaFaturamento();
        maiorFaturamento.setValor(Double.MIN_VALUE);

        for(DiaFaturamento diaFaturamento : diaFaturamentoList) {
            if (diaFaturamento.getValor() > maiorFaturamento.getValor()) {
                maiorFaturamento = diaFaturamento;
            }
        }
        return maiorFaturamento;
    }

    static class DiaFaturamento {
        private int dia;
        private double valor;

        @Override
        public String toString() {
            return "DiaFaturamento{" +
                    "dia=" + dia +
                    ", valor=" + valor +
                    '}';
        }

        public int getDia() {
            return dia;
        }

        public void setDia(int dia) {
            this.dia = dia;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }
}