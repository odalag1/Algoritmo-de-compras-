import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        armazenamento saldo = new armazenamento();
        ArrayList<armazenamento> listacartao = new ArrayList<>();
        System.out.println("Digite o limite do cartão: ");
        saldo.setLimite(sc.nextDouble());

        if (saldo.getLimite() <= 0) {
            while (saldo.getLimite() < 0) {
                System.out.println("Limite inválido. O limite deve ser maior que zero.");
                System.out.println("Digite o limite do cartão novamente: ");
                saldo.setLimite(sc.nextDouble());
            }
            System.out.println("Limite valido, pode continuar a compra");
        }
        while (opcao != 2) {
            armazenamento cartao = new armazenamento();
            sc.nextLine();

            System.out.println("Digite o nome do produto: ");
            cartao.setNomeCompra(sc.nextLine());
            while (!cartao.getNomeCompra().matches("[a-zA-Z\\s]+")) {
                System.out.println("Entrada inválida. Por favor, digite um nome válido para o produto:");
                cartao.setNomeCompra(sc.nextLine());
            }

            System.out.print("Digite o valor da compra: ");
            cartao.setValorCompra(sc.nextDouble());

            if (saldo.getLimite() < cartao.getValorCompra()) {
                saldo.terminal();
                System.out.println("Saldo insuficiente\n" + "Produtos comprados: \n");
                ArrayList<armazenamento> listaOrdenadaCasoDinheiroInsuficiente = new ArrayList<>(listacartao);
                Collections.sort(listaOrdenadaCasoDinheiroInsuficiente);
                for (armazenamento produtos : listaOrdenadaCasoDinheiroInsuficiente) {
                    System.out.println(produtos);

                }
                break;
            }
            saldo.setLimite(saldo.getLimite() - cartao.getValorCompra());
            listacartao.add(cartao);

            System.out.println("Compra realizada com sucesso!\nSaldo restante: " + saldo.getLimite());
            System.out.println("Deseja fazer mais compras? (1 - Sim, 2 - Não)");
            opcao = sc.nextInt();
            saldo.terminal();
            if (opcao == 2) {
                System.out.println("Produtos comprados");
                ArrayList<armazenamento> listaordArmazenamentos = new ArrayList<>(listacartao);
                Collections.sort(listaordArmazenamentos);
                for (armazenamento produtos : listaordArmazenamentos) {

                    System.out.println(produtos);

                }
                System.out.println("Limite atual do cartão: " + saldo.getLimite());
                break;
            }

        }
        sc.close();
    }

}
