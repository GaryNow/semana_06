package semana_06;

import javax.swing.JOptionPane;

public class ArregloEdades {
	// atributo privado edad (int) de tipo arreglo linea
	private int edad[];
	
	// atributo privado indice (int)
	private int indice;
	
	// Constructor sin parámetros que reserve 10 espacios en edad e inicialice con 0 al indice
	public ArregloEdades() {
		edad = new int[10];
		indice = 0;
	}
	// Método que retorne la cantidad de datos ingresados hasta ese momento.
	public int tamanio() {
		return indice;
	}
	// Método que reciba una posición y retorne la edad registrada en dicha posición.
	public int obtener(int posi) {
		return edad[posi];
	}
	// Método privado que extienda el arreglo en diez espacios más
	private void ampliarArreglo() {
		int aux[] = edad;
		edad = new int[indice + 10];
		
		for(int i = 0; i < tamanio(); i++) {
			edad[i] = aux[i];
		}
		
	}
	// Método que reciba una edad y la registre en la posición que corresponda. Verifique primero si el arreglo está lleno para invocar al método ampliarArreglo.
	public void adicionar(int ed) {
		if(indice == edad.length)	ampliarArreglo();
		
		edad[indice] = ed;
		indice++;
	}
	// Método que elimina lógicamente la última edad del arreglo.
	public void eliminarAlFinal() {
		indice--;
	}
	// Método que elimina lógicamente todas las edades.
	public void eliminarTodo() {
		indice = 0;
	}
	// Método que retorne la mayor de todas las edades.
	public int edadMayor() {
		int edMayor = 0;
		for(int i = 0; i < tamanio(); i++) {
			if(edad[i] > edMayor)	edMayor = edad[i];
		}
		return edMayor;
	}
	// Método que retorne la posición de la primera edad encontrada en el rango de 20 a 59 años. En caso no exista retorne -1.
	public int posPrimeraEdadAdulta() {
		for(int i = 0; i < tamanio(); i++) {
			if(edad[i] >= 20 && edad[i] <= 59 ) return i;		
		}
		return -1;
	}
	// Método que aumente la primera edad adulta en 5 años.
	public void incrementarPrimeraEdadAdulta() {
		int posi=posPrimeraEdadAdulta();
		int a = 5;
		if(posi!=-1){
			edad[posi]+=a;
		} else {
			JOptionPane.showMessageDialog(null, "No existe edad adulta a incrementar");
		}
	}
	// Método que cambie la primera edad adulta por la edad mayor.
	public void remplazarPrimeraEdadAdulta() {
		int posi = posPrimeraEdadAdulta();
		int em = edadMayor();
		if(posi!=-1) {
			edad[posi] = em;
		} else {
			JOptionPane.showMessageDialog(null, "No existe edad adulta a remplazar");
		}
	}
}
