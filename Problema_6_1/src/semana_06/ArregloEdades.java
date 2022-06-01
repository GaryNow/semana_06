package semana_06;

import javax.swing.JOptionPane;

public class ArregloEdades {
	// atributo privado edad (int) de tipo arreglo linea
	private int edad[];
	
	// atributo privado indice (int)
	private int indice;
	
	// Constructor sin par�metros que reserve 10 espacios en edad e inicialice con 0 al indice
	public ArregloEdades() {
		edad = new int[10];
		indice = 0;
	}
	// M�todo que retorne la cantidad de datos ingresados hasta ese momento.
	public int tamanio() {
		return indice;
	}
	// M�todo que reciba una posici�n y retorne la edad registrada en dicha posici�n.
	public int obtener(int posi) {
		return edad[posi];
	}
	// M�todo privado que extienda el arreglo en diez espacios m�s
	private void ampliarArreglo() {
		int aux[] = edad;
		edad = new int[indice + 10];
		
		for(int i = 0; i < tamanio(); i++) {
			edad[i] = aux[i];
		}
		
	}
	// M�todo que reciba una edad y la registre en la posici�n que corresponda. Verifique primero si el arreglo est� lleno para invocar al m�todo ampliarArreglo.
	public void adicionar(int ed) {
		if(indice == edad.length)	ampliarArreglo();
		
		edad[indice] = ed;
		indice++;
	}
	// M�todo que elimina l�gicamente la �ltima edad del arreglo.
	public void eliminarAlFinal() {
		indice--;
	}
	// M�todo que elimina l�gicamente todas las edades.
	public void eliminarTodo() {
		indice = 0;
	}
	// M�todo que retorne la mayor de todas las edades.
	public int edadMayor() {
		int edMayor = 0;
		for(int i = 0; i < tamanio(); i++) {
			if(edad[i] > edMayor)	edMayor = edad[i];
		}
		return edMayor;
	}
	// M�todo que retorne la posici�n de la primera edad encontrada en el rango de 20 a 59 a�os. En caso no exista retorne -1.
	public int posPrimeraEdadAdulta() {
		for(int i = 0; i < tamanio(); i++) {
			if(edad[i] >= 20 && edad[i] <= 59 ) return i;		
		}
		return -1;
	}
	// M�todo que aumente la primera edad adulta en 5 a�os.
	public void incrementarPrimeraEdadAdulta() {
		int posi=posPrimeraEdadAdulta();
		int a = 5;
		if(posi!=-1){
			edad[posi]+=a;
		} else {
			JOptionPane.showMessageDialog(null, "No existe edad adulta a incrementar");
		}
	}
	// M�todo que cambie la primera edad adulta por la edad mayor.
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
