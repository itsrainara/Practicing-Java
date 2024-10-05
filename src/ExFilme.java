import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ExFilme {
    Map<String, Double> avaliacoes = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    public void adicionarAvaliacao(String filme, double avaliacao) {
        avaliacoes.put(filme, avaliacao);
    }
    public void atualizarAvaliacao(String filme, double novaAvaliacao) {
        if (avaliacoes.containsKey(filme)) {
            avaliacoes.put(filme, novaAvaliacao);
            System.out.println("Avaliação do filme atualizada com sucesso!");
        } else {
            System.out.println("Filme não encontrado!");
        }
    }
    public double calcularMediaAvaliacoes() {
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        double soma = 0;
        for (double avaliacao : avaliacoes.values()) {
            soma += avaliacao;
        }
        return soma / avaliacoes.size();
    }
    public void exibirFilmesMaisBemAvaliados() {
        double melhorAvaliacao = Double.MIN_VALUE;
        String melhorFilme = null;
        for (Map.Entry<String, Double> entry : avaliacoes.entrySet()) {
            if (entry.getValue() > melhorAvaliacao) {
                melhorAvaliacao = entry.getValue();
                melhorFilme = entry.getKey();
            }
        }
        if (melhorFilme != null) {
            System.out.println("Filme mais bem avaliado: " + melhorFilme + " (Avaliação: " + melhorAvaliacao + ")");
        } else {
            System.out.println("Nenhum filme avaliado ainda.");
        }
    }