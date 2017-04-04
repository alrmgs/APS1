/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizesarquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aléxia Gomes
 */
public class MatrizesArquivos {

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = null;

        while (true) {
            try {
                Scanner e = new Scanner(System.in);

                System.out.println(" ");
                System.out.println("Nome do arquivo: (example_1, example_2, example_3 ou example_4)");
                String nomeArquivo = e.next();

                buffer = new BufferedReader(new FileReader(nomeArquivo + ".txt"));

                String arquivoLinhas = buffer.readLine();
                String[] tamanhoMatriz = arquivoLinhas.split(" ");
                int coluna = Integer.parseInt(tamanhoMatriz[0]);
                int linha = Integer.parseInt(tamanhoMatriz[1]);
                String[][] matriz = new String[linha][coluna];

                int indiceColuna = 0;

                while ((arquivoLinhas = buffer.readLine()) != null) {
                    String[] testaLinhas = arquivoLinhas.split("");
                    for (int indiceLinha = 0; indiceLinha < testaLinhas.length; indiceLinha++) {
                        matriz[indiceColuna][indiceLinha] = testaLinhas[indiceLinha];
                    }
                    indiceColuna++;
                }

                System.out.println(" ");
                System.out.println("--- MATRIZ ORIGINAL ---");
                matrizOriginal(matriz);

            } finally {
                buffer.close();
            }

        }
    }

    private static void matrizOriginal(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "|");
            }
            System.out.println("");
        }
    }
}
