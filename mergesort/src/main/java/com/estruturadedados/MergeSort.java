package com.estruturadedados;

public class MergeSort {
    //Função que combina duas sub-listas ordenadas em uma única lista ordenada
    public static void merge(int[] arr, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] ArrayEsquerdo = new int[n1];
        int[] ArrayDireito = new int[n2];

        for (int i = 0; i < n1; i++) {
            ArrayEsquerdo[i] = arr[esquerda + i];
        }

        for (int j = 0; j < n2; j++) {
            ArrayDireito[j] = arr[meio + 1 + j];
        }

        int i = 0, j = 0;
        int k = esquerda;

        while (i < n1 && j < n2) {
            if (ArrayEsquerdo[i] <= ArrayDireito[j]) {
                arr[k] = ArrayEsquerdo[i];
                i++;
            } else {
                arr[k] = ArrayDireito[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = ArrayEsquerdo[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = ArrayDireito[j];
            j++;
            k++;
        }
    }

    //Função principal para realizar o Merge Sort em um array
    public static void mergeSort(int[] arr, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;

            //Ordena a metade esquerda do array
            mergeSort(arr, esquerda, meio);
            //Ordena a metade direita do array
            mergeSort(arr, meio + 1, direita);
            //Combina as duas metades ordenadas
            merge(arr, esquerda, meio, direita);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.println("Array antes da ordenação: ");
        for (int elemento : arr) {
            System.out.print(elemento + " ");
        }
        
        //Chama o Merge Sort para ordenar o array
        mergeSort(arr, 0, n - 1);

        System.out.println("\nArray depois da ordenação: ");
        for (int elemento : arr) {
            System.out.print(elemento + " ");
        }
    }
}
