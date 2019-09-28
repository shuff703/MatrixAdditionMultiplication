import javax.swing.JOptionPane;

public class MatrixAdditionMultiplication {
	public static String output = "";
	public static int [][] createMatrix(int [][] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				a[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter the # for Row " + (i + 1) + " Col " + (j + 1)));
			}
		}
		return a;
	}
	public static int [][] addMatrix(int [][] a, int [][] b) {
		int [][] result = new int [a.length][b.length];
		for(int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
				output += result[i][j] + " ";
			}
			output += "\n";
		}
		return result;
	}
	public static int [][] multMatrix(int [][] a, int [][] b) {
		int [][] result = new int [a.length][b[0].length];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				for(int k = 0; k < a[0].length; k++) {
					//here you had the values in a/b vvvvvvvvvv being added rather than multiplied
					result[i][j] = result[i][j] + a[i][k]*b[k][j];
				}
				//need to print the result output after running the sum
				output += result[i][j] + " ";
			}
		}
		return result;
	}
	public static void main(String[] args) {
		while(true) {
			int row1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the # of Rows for Matrix 1: "));
			int col1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the # of Columns for Matrix 1: "));
			int row2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the # of Rows for Matrix 2: "));
			int col2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the # of Columns for Matrix 2: "));
			int [][] matrix1 = new int[row1][col1];
			int [][] matrix2 = new int[row2][col2];
			createMatrix(matrix1);
			createMatrix(matrix2);
			if(row1 == row2 && col1 == col2) {
				output += "The Sum of the Matrices is:\n";
				addMatrix(matrix1, matrix2);
			}
			else if(row1 != row2 && col1 != col2){
				output += "*Could not Compute Sum*\n";
			}
			else if(col1 == row2) {
				output += "\nThe Product of the two Matrices is: \n";
				multMatrix(matrix1, matrix2);
			}
			else {
				output += "\n*Could not Compute Product*";
			}
			JOptionPane.showMessageDialog(null, output);
		}
	}
}