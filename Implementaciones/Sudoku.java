package Implementaciones;

import Implementaciones.ClasesUtiles.Par;
import java.util.ArrayList;

public class Sudoku {
    int[][] tablero = {{2, 1, 3, 4}, {1, 3, 4, 2}, {0, 2, 1, 3}, {0, 4, 2, 0}};
    int n = 4;
    int contadorTableros = 0;
    public void generarTodosLosSudokus() {
        ArrayList<Par<Integer, Integer>> posicionesVacias = new ArrayList<>();
        //Encontrar todas las posiciones vacías
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tablero[i][j] == 0) {
                    posicionesVacias.add(new Par<>(i, j));
                }
            }
        }
        generarSudokus(posicionesVacias, 0);
    }

    //Método recursivo.
    private void generarSudokus(ArrayList<Par<Integer, Integer>> posicionesVacias, int index) {
        //Caso base, si está lleno, lo imprimo.
        if (index == posicionesVacias.size()) {
            if (esValido(tablero)) {
            imprimirTablero();
            System.out.println("Tablero válido.");
            }
        return;
        }

        //Elijo una pos. vacía.
        Par<Integer, Integer> posicionActual = posicionesVacias.get(index);
        int fila = posicionActual.getFirst();
        int columna = posicionActual.getSecond();

        //Meto los números del 1 al n.
        for (int num = 1; num <= n; num++) {
            tablero[fila][columna] = num;

            //Llamado recursivo para la sig pos. vacía.
            generarSudokus(posicionesVacias, index + 1);

            //Backtracking
            tablero[fila][columna] = 0;
        }
    }

    //Imprimir
    public void imprimirTablero() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean esValido(int[][] tablero) {
            // Verificar filas
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                for (int j = 0; j < n; j++) {
                    int num = tablero[i][j];
                    if (num != 0) {
                        if (seen[num]) {
                            return false; //Número repetido en la fila
                        }
                        seen[num] = true;
                    }
                }
            }
            //Verificar columnas
            for (int j = 0; j < n; j++) {
                boolean[] seen = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    int num = tablero[i][j];
                    if (num != 0) {
                        if (seen[num]) {
                            return false; //Número repetido en la columna
                        }
                        seen[num] = true;
                    }
                }
            }
            return true;
    }
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.generarTodosLosSudokus();
    }
}
//Luego deberíamos hacer un método para comprobar que cada tablero es válido.
