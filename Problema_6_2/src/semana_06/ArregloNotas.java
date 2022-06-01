package semana_06;

import javax.swing.JOptionPane;

public class ArregloNotas {
	// Atributo privado
	private int nota[];
	// Atributo privado indice
	private int indice;
	// Constructor sin par�metros que reserve 10 espacios en nota e inicialice con 0 al indice
	public ArregloNotas() {
		nota = new int[10];
		indice = 0;
	}
	// M�todo que retorne la cantidad de datos ingresados hasta ese momento
	public int tamanio() {
		return indice;
	}
	// M�todo que reciba una posici�n y retorne la nota registrada en dicha posici�n.
	public int obtener(int i) {
		return nota[i];
	} 
	// M�todo privado que extienda el arreglo en diez espacios m�s
	private void ampliarArreglo() {
		int aux[] = nota;
		nota = new int[indice + 10];
		
		for(int i = 0; i < tamanio(); i++) {
			nota[i] = aux[i];
		}
	}
	// m�todo que reciba una nota y la registre en la posici�n que corresponda. Verifique primero si el arreglo est� lleno para invocar al m�todo ampliarArreglo
	public void adicionar(int not) {
		if(indice == nota.length)	ampliarArreglo();
		nota[indice] = not;
		indice++;
	}
	// M�todo que elimina l�gicamente la �ltima nota del arreglo
	public void eliminarAlFinal() {
		indice--;
	}
	// M�todo que elimina l�gicamente todas las notas
	public void eliminarTodo() {
		indice = 0;
	}
	// M�todo que retorne la posici�n de la �ltima nota menor que 13. En caso no exista retorne -1.
	public int posUltimaNotaDesaprobatoria() {
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(nota[i] < 13)	return i;
		}
		return -1;
	}
	// m�todo que disminuya la �ltima nota menor que 13 en dos puntos. En caso que al disminuir resulte una nota negativa, fije la nota en cero
	public void decrementarUltimaNotaDesaprobatoria() {
		int posi = posUltimaNotaDesaprobatoria();
		try {
			if(posi != 1) nota[posi] -= 2;
			if(nota[posi] < 0)	nota[posi] = 0;			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No hay notas desaprobatorias a disminuir");
		}
	}
	// M�todo que cambie la �ltima nota desaprobatoria por la �ltima nota del arreglo.
	public void remplazarUltimaNotaDesaprobatoria() {
		try {			
			int posi = posUltimaNotaDesaprobatoria();
			if(posi!=-1) nota[posi] = nota[tamanio()-1];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No existe nota a remplazar");
		}
	}
}
