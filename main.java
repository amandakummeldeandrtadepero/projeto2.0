import java.util.Scanner;

public class TransporteCaminhoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cidadesVERIFICAR = {"ARACAJU", "BELEM", "BELO HORIZONTE", "BRASILA", "CAMPO GRANDE", "CUIABA", "CURITIBA", "FLORIANOPOLIS", "FORTALEZA", "GOIANIA", "JOÃO PESSOA", "MACEIO", "MANAUS", "NATAL", "PORTO ALEGRE", "PORTO VELHO", "RECIFE", "RIO BRANCO", "RIO DE JANEIRO", "SALVADOR", "SÃO LUIS", "SÃO PAULO", "TEREZINHA", "VITORIA"};

        int[][] distancias = {
            {0, 2079, 1578, 1652, 2765, 2775, 2595, 2892, 1183, 1848, 611, 294, 5215, 788, 3296, 4230, 501, 4763, 1855, 356, 1578, 2187, 1142, 1408},
            {2079, 0, 2824, 2120, 2942, 2941, 3193, 3500, 1610, 2017, 2161, 2173, 5298, 2108, 3852, 4397, 2074, 4931, 3250, 2100, 806, 2933, 947, 3108},
            {1578, 2824, 0, 716, 1453, 1594, 1004, 1301, 2528, 906, 2171, 1854, 3951, 2348, 1712, 3050, 2061, 3584, 434, 1372, 2738, 586, 2302, 524},
            {1652, 2120, 716, 0, 1134, 1133, 1366, 1673, 2200, 209, 2245, 1930, 3490, 2422, 2027, 2589, 2135, 3123, 1148, 1446, 2157, 1015, 1789, 1239},
            {2765, 2942, 1453, 1134, 0, 694, 991, 1298, 3407, 935, 3357, 3040, 3051, 3534, 1518, 2150, 3247, 2684, 1444, 2568, 2979, 1014, 2911, 1892},
            {2775, 2941, 1594, 1133, 694, 0, 1679, 1986, 3406, 934, 3366, 3049, 2357, 3543, 2206, 1456, 3255, 1990, 2017, 2566, 2978, 1614, 2910, 2119},
            {1408, 2805, 1445, 2625, 1553, 3473, 2338, 4007, 0, 1649, 3015, 429, 2579, 521, 356, 2100, 1372, 1446, 2568, 2567, 2385, 2682, 1389, 1643},
            {949, 632, 5009, 1126, 3090, 4023, 839, 4457, 1649, 0, 1599, 1962, 1163, 1202, 1578, 806, 2738, 2157, 2979, 2978, 3230, 3537, 1070, 2054},
            {1660, 2770, 1224, 2001, 294, 2173, 1854, 1928, 3040, 3049, 2871, 3168, 1075, 2105, 395, 0, 5491, 572, 3572, 4505, 285, 5039, 2131, 632},
            {1672, 2453, 1236, 1684, 5215, 5298, 3951, 3490, 3051, 2357, 4036, 4343, 5763, 3291, 5808, 5491, 0, 5985, 4563, 901, 5698, 1445, 4374, 5009},
            {5335, 3971, 5267, 4476, 788, 2108, 2348, 2422, 3537, 3543, 3365, 3662, 537, 2619, 185, 572, 5985, 4563, 901, 5698, 1445, 4374, 5009, 5335},
            {3971, 5267, 4476, 788, 2108, 2348, 2422, 3537, 3543, 3365, 3662, 537, 2619, 185, 572, 5985, 4563, 901, 5698, 1445, 4374, 5009, 5335, 3971},
            {5267, 4476, 788, 2108, 2348, 2422, 3537, 3543, 3365, 3662, 537, 2619, 185, 572, 5985, 4563, 901, 5698, 1445, 4374, 5009, 5335, 3971, 5267},
            {788, 2108, 2348, 2422, 3537, 3543, 3365, 3662, 537, 2619, 185, 572, 5985, 4563, 901, 5698, 1445, 4374, 5009, 5335, 3971, 5267, 4476, 1267},
            {2108, 2348, 2422, 3537, 3543, 3365, 3662, 537, 2619, 185, 572, 5985, 4563, 901, 5698, 1445, 4374, 5009, 5335, 3971, 5267, 4476, 788, 2123},
            {3852, 4397, 2074, 4931, 3250, 2100, 806, 2933, 947, 3108, 1578, 2824, 1453, 1134, 0, 694, 991, 1298, 3407, 935, 3357, 3040, 3051, 0},
            {3752, 4771, 3449, 5270, 3941, 4770, 4802, 5157, 2011, 3381, 1227, 1299, 6872, 2791, 5341, 6031, 1440, 6331, 4949, 2077, 1153, 4256, 1778, 2871},
            {501, 2850, 1453, 2625, 1553, 3473, 2338, 4007, 0, 1649, 3015, 429, 2579, 521, 356, 2100, 1372, 1446, 2568, 2567, 2385, 2682, 1389, 1643},
            {949, 632, 5009, 1126, 3090, 4023, 839, 4457, 1649, 0, 1599, 1962, 1163, 1202, 1578, 806, 2738, 2157, 2979, 2978, 3230, 3537, 1070, 2054},
            {0, 2972, 1448, 2630, 1568, 3488, 2356, 4034, 358, 1605, 3017, 420, 2578, 580, 352, 2093, 1388, 1447, 2608, 2628, 2392, 2727, 1339, 1667}
        };

        double custoPequeno = 5.83;
        double custoMedio = 13.42;
        double custoGrande = 29.21;

        System.out.print("Digite a cidade de origem: ");
        String cidadeOrigem = scanner.nextLine().toUpperCase();
        System.out.print("Digite a cidade de destino: ");
        String cidadeDestino = scanner.nextLine().toUpperCase();
        System.out.print("Digite o tipo de caminhão (Pequeno, Médio, ou Grande): ");
        String tipoCaminhao = scanner.nextLine().toUpperCase();

        int indiceOrigem = -1;
        int indiceDestino = -1;

        for (int i = 0; i < cidadesVERIFICAR.length; i++) {
            if (cidadesVERIFICAR[i].equals(cidadeOrigem)) {
                indiceOrigem = i;
            }
            if (cidadesVERIFICAR[i].equals(cidadeDestino)) {
                indiceDestino = i;
            }
        }

        if (indiceOrigem != -1 && indiceDestino != -1) {
            int distancia = distancias[indiceOrigem][indiceDestino];

            double custoTransporte = 0;

            if (tipoCaminhao.equals("PEQUENO")) {
                custoTransporte = custoPequeno * distancia;
            } else if (tipoCaminhao.equals("MÉDIO")) {
                custoTransporte = custoMedio * distancia;
            } else if (tipoCaminhao.equals("GRANDE")) {
                custoTransporte = custoGrande * distancia;
            } else {
                System.out.println("Tipo de caminhão inválido. Use Pequeno, Médio ou Grande.");
                return;
            }

            System.out.println("O custo do transporte entre " + cidadeOrigem + " e " + cidadeDestino + " com um caminhão " + tipoCaminhao + " é de R$" + custoTransporte);
        } else {
            System.out.println("Uma das cidades não existe na lista.");
        }
    }
}


}

import java.util.Scanner;

public class TransporteProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] produtos = {"Celular", "Geladeira", "Air Fryer", "Cadeira", "Luminária", "Lavadora de roupa", "PlayStation 5", "Nintendo Switch"};
        double[] pesos = {0.7, 50.0, 3.5, 5.0, 0.8, 15.0, 3.9, 0.3};

        String[] modalidades = {"Aéreo", "Rodoviário", "Marítimo"};
        double[] custoKmPorPeso = {0.2, 0.1, 0.05};

        int numTransportes = 0;
        double custoTotal = 0;
        double pesoTotal = 0;
        double custoMedioKm = 0;

        System.out.println("Insira os dados de transporte (nome do produto, quantidade, modalidade):");
        while (true) {
            System.out.print("Nome do produto (ou 'fim' para encerrar): ");
            String produto = scanner.nextLine().toUpperCase();

            if (produto.equalsIgnoreCase("FIM")) {
                break;
            }

            int indexProduto = -1;
            for (int i = 0; i < produtos.length; i++) {
                if (produtos[i].equalsIgnoreCase(produto)) {
                    indexProduto = i;
                    break;
                }
            }

            if (indexProduto == -1) {
                System.out.println("Produto não encontrado na lista. Verifique a ortografia.");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            int indexModalidade = -1;
            System.out.print("Modalidade (Aéreo, Rodoviário, Marítimo): ");
            String modalidade = scanner.nextLine();
            for (int i = 0; i < modalidades.length; i++) {
                if (modalidades[i].equalsIgnoreCase(modalidade)) {
                    indexModalidade = i;
                    break;
                }
            }

            if (indexModalidade == -1) {
                System.out.println("Modalidade não encontrada na lista. Verifique a ortografia.");
                continue;
            }

            double custoTransporte = custoKmPorPeso[indexModalidade] * pesos[indexProduto] * quantidade;
            custoTotal += custoTransporte;
            pesoTotal += pesos[indexProduto] * quantidade;
            numTransportes++;

            System.out.println("Custo de transporte para " + quantidade + " " + produto + " via " + modalidade + ": R$" + custoTransporte);
        }

        if (numTransportes > 0) {
            custoMedioKm = custoTotal / pesoTotal;
            System.out.println("Custo médio por quilograma: R$" + custoMedioKm);
        } else {
            System.out.println("Nenhum transporte foi registrado.");
        }
    }
}
