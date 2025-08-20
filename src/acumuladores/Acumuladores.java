package acumuladores;

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
			System.out.println(
					"sumaColumnasTotal = " + sumaColumnasTotal + " sumaFila(mat[" + i + "])" + sumaFila(mat[i]));
			mayorATodos = mayorATodos && sumaColumnasTotal < sumaFila(mat[i]);
			System.out.println(mayorATodos);
		}
		return mayorATodos;
	}

	private int sumaDeColumnas(int[][] mat, int nColum) {
		int sumaTotal = 0;
		System.out.println(mat.length + " " + mat[0].length + " " + mat[0][0] + " " + nColum);
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
		throw new RuntimeException("Metodo no implementado aun!!!");
	}
}
