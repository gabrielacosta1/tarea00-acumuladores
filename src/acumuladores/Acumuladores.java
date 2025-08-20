package acumuladores;

import java.util.Arrays;

public class Acumuladores {

	/**
	 * Dada una matriz de enteros y un número, verifica si existe alguna fila donde
	 * todos sus elementos sean múltiplos del número recibido por parámetro.
	 * 
	 * Si la matriz está vacía o si el número no es positivo, devuelve falso.
	 * 
	 * @param mat
	 * @param num
	 * @return
	 */
	public boolean todosMultiplosEnAlgunaFila(int[][] mat, int num) {
		if (mat == null || num <= 0)
			return false;
		boolean algunaFilaMultiplo = false;
		for (int i = 0; i < mat.length; i++) {
			boolean filaMultiplo = true;
			for (int j = 0; j < mat[0].length; j++) {
				filaMultiplo = filaMultiplo && mat[i][j] % num == 0;
			}
			algunaFilaMultiplo = algunaFilaMultiplo || filaMultiplo;
		}
		return algunaFilaMultiplo;
	}

	/**
	 * Dado 2 matrices se verifica si hay intersección entre las filas de cada
	 * matriz, fila a fila.
	 * 
	 * Si las matrices tienen distinta cantidad de filas o si alguna matriz está
	 * vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorFila(int[][] mat1, int[][] mat2) {
		if (mat1 == null || mat2 == null || mat1.length == 0 || mat2.length == 0 || mat1.length != mat2.length)
			return false;

		boolean interseccionEnTodas = true;
		for (int i = 0; i < mat2.length; i++) {
			boolean interccionFila = false;
			for (int j = 0; j < mat1[0].length; j++) {
				interccionFila = interccionFila || hayInterseccionEnFila(mat1[i][j], mat2[i]);
			}
			interseccionEnTodas = interseccionEnTodas && interccionFila;
		}

		return interseccionEnTodas;
	}

	private boolean hayInterseccionEnFila(int mat1, int[] mat2) {
		boolean interseccionEnFila = false;
		for (int i = 0; i < mat2.length; i++) {
			interseccionEnFila = interseccionEnFila || mat2[i] == mat1;
		}
		return interseccionEnFila;
	}

	/**
	 * Dada una matriz y el índice de una columna, se verifica si existe alguna fila
	 * cuya suma de todos sus elementos sea mayor estricto que la suma de todos los
	 * elementos de la columna indicada por parámetro.
	 * 
	 * Si el índice de la columna es inválido o la matriz está vacía, devuelve
	 * falso.
	 * 
	 * @param mat
	 * @param nColum
	 * @return
	 */
	public boolean algunaFilaSumaMasQueLaColumna(int[][] mat, int nColum) {
		if (mat.length == 0 || mat.length < nColum || 0 > nColum) {
			return false;
		}

		int sumaColumnasTotal = sumaDeColumnas(mat, nColum);
		boolean mayorATodos = true;

		for (int i = 0; i < mat.length; i++) {
			mayorATodos = mayorATodos && sumaColumnasTotal < sumaFila(mat[i]);
		}
		return mayorATodos;
	}

	private int sumaDeColumnas(int[][] mat, int nColum) {
		int sumaTotal = 0;
		for (int j = 0; j < mat.length; j++) {
			sumaTotal += mat[j][nColum];
		}
		return sumaTotal;
	}

	private int sumaFila(int[] mat) {
		int sumaTotal = 0;
		for (int i = 0; i < mat.length; i++) {
			sumaTotal += mat[i];
		}
		return sumaTotal;
	}

	/**
	 * Dadas 2 matrices, se verifica si hay intersección entre las columnas de cada
	 * matriz, columna a columna.
	 * 
	 * Si las matrices tienen distinta cantidad de columnas o alguna matriz está
	 * vacía, devuelve falso.
	 * 
	 * @param mat1
	 * @param mat2
	 * @return
	 */
	public boolean hayInterseccionPorColumna(int[][] mat1, int[][] mat2) {
		if (mat1.length == 0 || mat2.length == 0 || mat1[0].length != mat2[0].length)
			return false;
		boolean columnasTodasConInterseccion = true;
		for (int i = 0; i < mat1[0].length; i++) {
			int[] arregloMat1 = arregloDeColumna(mat1, i);
			int[] arregloMat2 = arregloDeColumna(mat2, i);
			columnasTodasConInterseccion = columnasTodasConInterseccion
					&& buscarInterserccion(arregloMat1, arregloMat2);
		}

		return columnasTodasConInterseccion;
	}

	private boolean buscarInterserccion(int[] mat1, int[] mat2) {
		boolean columnaConInterseccion = false;
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat2.length; j++) {
				columnaConInterseccion = columnaConInterseccion || mat1[i] == mat2[j];
			}
		}
		return columnaConInterseccion;
	}

	private int[] arregloDeColumna(int[][] mat, int i) {
		int[] arregloColumna = new int[mat.length];
		for (int j = 0; j < mat.length; j++) {
			arregloColumna[j] = mat[j][i];
		}
		return arregloColumna;
	}
}