import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public String moedaEscolhida;

    public  void mostraMenu(){

        ApiRequest api = new ApiRequest();

        Scanner scanner = new Scanner(System.in);

        int opcaoMenu = 1;

        double valor;

        System.out.println("Seja Bem-vindo/a ao conversor de moeda.");

        try {

            while (opcaoMenu != 0){

                System.out.println("""
                        1 - Dólar =>> Peso argentino
                        2 - Peso argentino =>> Dólar
                        3 - Dólar =>> Real brasileiro
                        4 - Real brasileiro =>> Dólar
                        5 - Dólar =>> Peso colombiano
                        6 - Peso colombiano =>> Dólar
                        0 - Sair
                        """);

                opcaoMenu = scanner.nextInt();

                if (opcaoMenu > 6 || opcaoMenu < 0){
                    System.out.println("Digite uma opção válida.");
                } else if (opcaoMenu == 0) {
                    break;
                } else {
                    if (opcaoMenu == 1 || opcaoMenu == 3 || opcaoMenu == 5){
                        moedaEscolhida = "USD";
                    } else if (opcaoMenu == 2) {
                        moedaEscolhida = "ARS";
                    } else if (opcaoMenu == 4) {
                        moedaEscolhida = "BRL";
                    } else if (opcaoMenu == 6) {
                        moedaEscolhida = "COP";
                    }

                    api.requestsApi(moedaEscolhida);

                    System.out.println("*****************************************");

                    System.out.println("Qual valor deseja converter?");

                    valor= scanner.nextDouble();

                    switch (opcaoMenu){
                        case 1:
                            System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>> " + valor * api.moeda.getConversion_rates().getArs() + " [ARS]");
                            break;
                        case 2:
                            System.out.println("Valor " + valor + " [ARS] corresponde ao valor final de =>> " +valor * api.moeda.getConversion_rates().getUsd() + " [USD]");
                            break;
                        case 3:
                            System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>> " +valor * api.moeda.getConversion_rates().getBrl() + " [BRL]");
                            break;
                        case 4:
                            System.out.println("Valor " + valor + " [BRL] corresponde ao valor final de =>> " +valor * api.moeda.getConversion_rates().getUsd() + " [USD]");
                            break;
                        case 5:
                            System.out.println("Valor " + valor + " [USD] corresponde ao valor final de =>> " +valor * api.moeda.getConversion_rates().getCop() + " [COP]");
                            break;
                        case 6:
                            System.out.println("Valor " + valor + " [COP] corresponde ao valor final de =>> " +valor * api.moeda.getConversion_rates().getUsd() + " [USD]");
                            break;
                    }

                    System.out.println("*****************************************");
                    System.out.println(" ");
                }

            }
        } catch (InputMismatchException e){
            System.out.println("A opção deve ser um número válido.");
        }
    }
}
