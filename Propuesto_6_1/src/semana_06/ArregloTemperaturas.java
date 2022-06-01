package semana_06;

public class ArregloTemperaturas {
	// Atributo privado
	private double temperatura[];
	private int indice;
	// Constructor sin par�metros que reserve 10 espacios en temperatura e inicialice con 0 al indice.
	public ArregloTemperaturas() {
		temperatura = new double[10];
		indice = 0;
	}
	// M�todo que retorne la cantidad de datos ingresados hasta ese momento
	public int tamanio() {
		return indice;
	}
	// M�todo que reciba una posici�n y retorne la temperatura registrada en dicha posici�n.
	public double obtener(int i) {
		return temperatura[i];
	}
	// M�todo privado que extienda el arreglo en diez espacios m�s.
	private void ampliarArreglo() {
		double aux[] = temperatura;
		temperatura = new double[indice + 10];
		for(int i = 0; i < tamanio(); i++) {
			temperatura[i] = aux[i];
		}
	}
	// M�todo que reciba una temperatura y la registre en la posici�n que corresponda. Verifique primero si el arreglo est� lleno para invocar al m�todo ampliarArreglo.
	public void adicionar(double temp) {
		if(indice == temperatura.length)	ampliarArreglo();
		
		temperatura[indice] = temp;
		indice++;
	}
	// M�todo que elimina l�gicamente la �ltima temperatura del arreglo.
	public void eliminarAlFinal() {
		indice--;
	}
	// M�todo que elimina l�gicamente todas las temperaturas
	public void eliminarTodo() {
		indice = 0;
	}
	// M�todo que tetorne la emperatura m�s baja
	public double temperaturaMenor() {
		double baja = temperatura[0];
		for(int i = 0; i < tamanio(); i++) {
			if(baja > temperatura[i])	baja = temperatura[i];
		}
		return baja;
	}
	// M�todo que retorne la posici�n de la primera temperatura encontrada en el rango de 36.1�C a 37.2�C.
	public int posPrimeraTemperaturaNormal() {
		for(int i = 0; i < tamanio(); i++) {
			if(temperatura[i] >= 36.1 && temperatura[i] <= 37.2)	return i;
		}
		return -1;
	}
	// M�todo que cambie la primera temperatura normal por la menor temperatura del arreglo. Para el efecto, invoque a los m�todos posPrimeraTemperaturaNormal y temperaturaMenor
	public void remplazarPrimeraTemperaturaNormal() {
		temperatura[posPrimeraTemperaturaNormal()] = temperaturaMenor();
	}
	// M�todo que aumente todas las temperaturas en 0.2�C.
	public void incrementarTemperaturas() {
		for(int i = 0; i < tamanio(); i++) 	{			
			temperatura[i] += 0.2;
		}
	}
}
