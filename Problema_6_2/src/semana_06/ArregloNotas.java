package semana_06;

import javax.swing.JOptionPane;

public class ArregloNotas {
	// Atributo privado
	private int nota[];
	// Atributo privado indice
	private int indice;
	// Constructor sin parámetros que reserve 10 espacios en nota e inicialice con 0 al indice
	public ArregloNotas() {
		nota = new int[10];
		indice = 0;
	}
	// Método que retorne la cantidad de datos ingresados hasta ese momento
	public int tamanio() {
		return indice;
	}
	// Método que reciba una posición y retorne la nota registrada en dicha posición.
	public int obtener(int i) {
		return nota[i];
	} 
	// Método privado que extienda el arreglo en diez espacios más
	private void ampliarArreglo() {
		int aux[] = nota;
		nota = new int[indice + 10];
		
		for(int i = 0; i < tamanio(); i++) {
			nota[i] = aux[i];
		}
	}
	// método que reciba una nota y la registre en la posición que corresponda. Verifique primero si el arreglo está lleno para invocar al método ampliarArreglo
	public void adicionar(int not) {
		if(indice == nota.length)	ampliarArreglo();
		nota[indice] = not;
		indice++;
	}
	// Método que elimina lógicamente la última nota del arreglo
	public void eliminarAlFinal() {
		indice--;
	}
	// Método que elimina lógicamente todas las notas
	public void eliminarTodo() {
		indice = 0;
	}
	// Método que retorne la posición de la última nota menor que 13. En caso no exista retorne -1.
	public int posUltimaNotaDesaprobatoria() {
		for(int i = tamanio() - 1; i >= 0; i--) {
			if(nota[i] < 13)	return i;
		}
		return -1;
	}
	// método que disminuya la última nota menor que 13 en dos puntos. En caso que al disminuir resulte una nota negativa, fije la nota en cero
	public void decrementarUltimaNotaDesaprobatoria() {
		int posi = posUltimaNotaDesaprobatoria();
		try {
			if(posi != 1) nota[posi] -= 2;
			if(nota[posi] < 0)	nota[posi] = 0;			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No hay notas desaprobatorias a disminuir");
		}
	}
	// Método que cambie la última nota desaprobatoria por la última nota del arreglo.
	public void remplazarUltimaNotaDesaprobatoria() {
		try {			
			int posi = posUltimaNotaDesaprobatoria();
			if(posi!=-1) nota[posi] = nota[tamanio()-1];
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"No existe nota a remplazar");
		}
	}
}
