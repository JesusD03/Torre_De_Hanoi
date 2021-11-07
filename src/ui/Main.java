package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


//Basado en el algoritmo de la pagina: http://puntocomnoesunlenguaje.blogspot.com/2012/04/torres-de-hanoi.html
public class Main {
	
	private BufferedReader br;	
	private BufferedWriter bw;
	
	//utilice arreglos debido a que por alguna razon si uso int se me daña el codigo :/
	private int[] a;
	private int[] b;
	private int[] c;
	
	public Main() {
		try {
			br = new BufferedReader(new FileReader("data/casos_de_prueba.txt"));
			bw = new BufferedWriter(new FileWriter("data/resultados.txt"));
			a = new int[1];
			b = new int[1];
			c = new int[1];
		} catch (FileNotFoundException e) {
		
		} catch (IOException e) {
			
		}
	}
	
	public static void main(String[] args) {
		
		
		try {
			Main main = new Main();
			int line = Integer.parseInt(main.br.readLine());
			main.pila(line);
			main.br.close();
			main.bw.close();
			System.out.println("se calcularon los resultados exitosamente");
		} catch (NumberFormatException e) {
			
		} catch (IOException e) {
			
		} catch (NullPointerException e) {
			
		}
		
	}
	
	public void pila(int line) throws NumberFormatException, IOException {
		if(line == 0) {
			//no se hace nada porque es el caso base para que continue con el siguiente ejercicio
		}else {
			int numDisc = Integer.parseInt(br.readLine());
			a[0] = numDisc;
			bw.write(a[0] + " " + b[0] + " " + c[0] + "\n");
			hanoi(numDisc, a, b, c);
			bw.write("\n");
			a[0]=0;
			b[0]=0;
			c[0]=0;
			line--;
			pila(line);
			
		}
	}
	
	public void hanoi(int num, int origen[], int auxiliar[], int destino[]) throws IOException {
		if(num==1) {
			origen[0]--;
			destino[0]++;
			bw.write(a[0] + " " + b[0] + " " + c[0] + "\n");
		}else {
			hanoi(num-1, origen, destino, auxiliar);
			origen[0]--;
			destino[0]++;
			bw.write(a[0] + " " + b[0] + " " + c[0] + "\n");
			hanoi(num-1, auxiliar, origen, destino);
		}
	}
	
}
