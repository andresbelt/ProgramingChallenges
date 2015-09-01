/*
LCD Display
A friend of yours has just bought a new computer. Before this, the most powerful
machine he ever used was a pocket calculator. He is a little disappointed because he
liked the LCD display of his calculator more than the screen on his new computer! To
make him happy, write a program that prints numbers in LCD display style.
Input
The input file contains several lines, one for each number to be displayed. Each line
contains integers s and n, where n is the number to be displayed (0 ≤ n ≤ 99, 999, 999)
and s is the size in which it shall be displayed (1 ≤ s ≤ 10). The input will be terminated
by a line containing two zeros, which should not be processed.
Output
Print the numbers specified in the input file in an LCD display-style using s “-” signs
for the horizontal segments and s “|” signs for the vertical ones. Each digit occupies
exactly s + 2 columns and 2s + 3 rows. Be sure to fill all the white space occupied by
the digits with blanks, including the last digit. There must be exactly one column of
blanks between two digits.
Output a blank line after each number. You will find an example of each digit in the
sample output below.
Sample Input
2 12345
3 67890
0 0
Sample Output
      --   --        -- 
   |    |    | |  | |   
   |    |    | |  | |   
      --   --   --   -- 
   | |       |    |    |
   | |       |    |    |
      --   --        -- 
 ---   ---   ---   ---   --- 
|         | |   | |   | |   |
|         | |   | |   | |   |
|         | |   | |   | |   |
 ---         ---   ---       
|   |     | |   |     | |   |
|   |     | |   |     | |   |
|   |     | |   |     | |   |
 ---         ---   ---   --- 
*/

package co.edu;

import javax.swing.JOptionPane;

public class LCDDisplay {

	private static int nLineas;
	private static int nColumnas;
	private static char lcdNumber[][];
	private static char lcdNumbers[][][];
	private static char strNumber[] = new char[9];

	public static void setLcdSize(int size, int length) {//O(1)
		nLineas = 2 * size + 3;
		nColumnas = size + 2;
		lcdNumber = new char[nLineas][nColumnas];
		lcdNumbers = new char[length][nLineas][nColumnas];
	}

	static void limpiarLcdNumero() { //O(n)
		int i; //O(1)
		for (i = 0; i < nLineas; i++) {//O(n)
			int j;//O(1)
			for (j = 0; j < nColumnas; j++) {//O(n)
				lcdNumber[i][j] = ' ';	//O(1)
			}
		}
	}

	static void dibujarLine(int lineNumber) {// O(n)
		int j;//O(1)
		int c=nColumnas - 1;//O(1)
		
		for (j = 1; j < c; j++) {//O(n)
			lcdNumber[lineNumber][j] = '-';//O(1)
		}
	}

	static void drawFirstLine() {//O(n)
		dibujarLine(0);
	}

	static void drawMiddleLine() {//O(n)

		dibujarLine(nLineas / 2);
	}

	static void drawLastLine() {//O(n)
		dibujarLine(nLineas - 1);
	}

	static void drawFirstColumn(int columnNumber) {//O(n+2)
		int i;//O(1)
		for (i = 1; i < nLineas / 2; i++) {//O(n+2)
			lcdNumber[i][columnNumber] = '|';//O(1)
		}
	}

	static void drawLastColumn(int columnNumber) {//O(n/2-1)
		int i;//O(1)
		for (i = (nLineas / 2) + 1; i < nLineas - 1; i++) {//O(n/2-1)
			lcdNumber[i][columnNumber] = '|';//O(1)
		}
	}

	static void drawFirstLeftColumn() {//O(n+2)
		drawFirstColumn(0);
	}

	static void drawLastLeftColumn() {//O(n/2-1)
		drawLastColumn(0);
	}

	static void drawFirstRightColumn() {//O(n+2)
		drawFirstColumn(nColumnas - 1);
	}

	static void drawLastRightColumn() {//O(n/2-1)
		drawLastColumn(nColumnas - 1);
	}

	static void printLcd(int position) { //O(n)
		int i;//O(1)
		for (i = 0; i < nLineas; i++) {//O(n)
			int j;//O(1)
			for (j = 0; j < nColumnas; j++) {//O(n)
				lcdNumbers[position][i][j] = lcdNumber[i][j];//O(1)
			}
		}
	}

	static void printZero(int position) {
		limpiarLcdNumero();  	//O(n)
		drawFirstLine();		//O(n)
		drawFirstLeftColumn();	//O(n+2)
		drawFirstRightColumn();	//O(n+2)
		drawLastLeftColumn();	//O(n/2-1)
		drawLastRightColumn();	//O(n/2-1)
		drawLastLine();			//O(n)
		printLcd(position); 	//O(n)
	}

	static void printOne(int position) {
		limpiarLcdNumero();		//O(n)
		drawFirstRightColumn();	//O(n+2)
		drawLastRightColumn();	//O(n/2-1)
		printLcd(position);		//O(n)
	}

	static void printTwo(int position) {
		limpiarLcdNumero();
		drawFirstLine();
		drawFirstRightColumn();
		drawMiddleLine();
		drawLastLeftColumn();
		drawLastLine();
		printLcd(position);
	}

	static void printThree(int position) {
		limpiarLcdNumero();
		drawFirstLine();
		drawFirstRightColumn();
		drawMiddleLine();
		drawLastRightColumn();
		drawLastLine();
		printLcd(position);
	}

	static void printFour(int position) {
		limpiarLcdNumero();
		drawFirstLeftColumn();
		drawFirstRightColumn();
		drawMiddleLine();
		drawLastRightColumn();
		printLcd(position);
	}

	static void printFive(int position) {
		limpiarLcdNumero();
		drawFirstLine();
		drawFirstLeftColumn();
		drawMiddleLine();
		drawLastRightColumn();
		drawLastLine();
		printLcd(position);
	}

	static void printSix(int position) {
		limpiarLcdNumero();
		drawFirstLine();
		drawFirstLeftColumn();
		drawMiddleLine();
		drawLastLeftColumn();
		drawLastRightColumn();
		drawLastLine();
		printLcd(position);
	}

	static void printSeven(int position) {
		limpiarLcdNumero();
		drawFirstLine();
		drawFirstRightColumn();
		drawLastRightColumn();
		printLcd(position);
	}

	static void printEight(int position) {
		limpiarLcdNumero();
		drawFirstLine();
		drawFirstLeftColumn();
		drawFirstRightColumn();
		drawMiddleLine();
		drawLastLeftColumn();
		drawLastRightColumn();
		drawLastLine();
		printLcd(position);
	}

	static void printNine(int position) {
		limpiarLcdNumero();
		drawFirstLine();
		drawFirstLeftColumn();
		drawFirstRightColumn();
		drawMiddleLine();
		drawLastRightColumn();
		drawLastLine();
		printLcd(position);
	}

	static void printNumber(int n, int position) { //O(1)

		switch (n) {
		case 1:
			printOne(position);
			break;
		case 2:
			printTwo(position);
			break;

		case 3:
			printThree(position);
			break;

		case 4:
			printFour(position);
			break;

		case 5:
			printFive(position);
			break;

		case 6:
			printSix(position);
			break;
		case 7:
			printSeven(position);
			break;

		case 8:
			printEight(position);
			break;
		case 9:
			printNine(position);
			break;
		case 0:
			printZero(position);
			break;

		default:
			break;
		}

	}

	public static void Dibujar(String s, String number, Interfaz interfaz) {
		
		int size = Integer.parseInt(s); 				//O(1)
		strNumber = number.toCharArray();				//O(1)
		if(size != 0){
			setLcdSize(size, strNumber.length); 		//O(n)
			int length = strNumber.length; 				//O(1)
			int i; 										//O(1)
		
			for (i = 0; i < length; i++) { 				//O(n)
				int n = strNumber[i] - '0'; 			//O(1)
				printNumber(n, i);						//O(n)
			}
			String str = "";							//O(1)
			for (i = 0; i < nLineas; i++) {				//O(n^3)
				int n;									//O(1)
				for (n = 0; n < length; n++) {			//O(n^2)
					int j;								//O(1)
					for (j = 0; j < nColumnas; j++) {	//O(n)
						str += lcdNumbers[n][i][j];		//O(1)
				}
			}
			interfaz.Pintar(str + "\n"); 				//O(1)
			System.out.println(str);					//O(1)
			str = "";									//O(1)
			}
		}else{
			
			JOptionPane.showMessageDialog(null, "Ingrese un tamaño superior a 0");
			
		}
	}

}
