package semana_06;

public class ArregloTemperaturas {
	// Atributo privado
	private double temperatura[];
	private int indice;
	// Constructor sin parámetros que reserve 10 espacios en temperatura e inicialice con 0 al indice.
	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}
	// Método que retorne la cantidad de datos ingresados hasta ese momento
	public int tamanio() {
		return indice;
	}
	// Método que reciba una posición y retorne la temperatura registrada en dicha posición.
	public double obtener(int i) {
		return temperatura[i];
	}
	// Método privado que extienda el arreglo en diez espacios más.
	private void ampliarArreglo() {
		double aux[] = temperatura;
		temperatura = new double[indice + 10];
		for(int i = 0; i < tamanio(); i++) {
			temperatura[i] = aux[i];
		}
	}
	// Método que reciba una temperatura y la registre en la posición que corresponda. Verifique primero si el arreglo está lleno para invocar al método ampliarArreglo.
	public void adicionar(double temp) {
		if(indice == temperatura.length)	ampliarArreglo();
		
		temperatura[indice] = temp;
		indice++;
	}
	// Método que elimina lógicamente la última temperatura del arreglo.
	public void eliminarAlFinal() {
		indice--;
	}
	// Método que elimina lógicamente todas las temperaturas
	public void eliminarTodo() {
		indice = 0;
	}
	// Método que tetorne la emperatura más baja
	public double temperaturaMenor() {
		double baja = temperatura[0];
		for(int i = 0; i < tamanio(); i++) {
			if(baja > temperatura[i])	baja = temperatura[i];
		}
		return baja;
	}
	// Método que retorne la posición de la primera temperatura encontrada en el rango de 36.1°C a 37.2°C.
	public int posPrimeraTemperaturaNormal() {
		for(int i = 0; i < tamanio(); i++) {
			if(temperatura[i] >= 36.1 && temperatura[i] <= 37.2)	return i;
		}
		return -1;
	}
	// Método que cambie la primera temperatura normal por la menor temperatura del arreglo. Para el efecto, invoque a los métodos posPrimeraTemperaturaNormal y temperaturaMenor
	public void remplazarPrimeraTemperaturaNormal() {
		temperatura[posPrimeraTemperaturaNormal()] = temperaturaMenor();
	}
	// Método que aumente todas las temperaturas en 0.2°C.
	public void incrementarTemperaturas() {
		for(int i = 0; i < tamanio(); i++) 	{			
			temperatura[i] += 0.2;
		}
	}
}
