package org.institutoserpis.org;

public class Array {

	public static void main(String[] args) {
		
		int[] v = new int[]{5, 9, 7, 12, 21};
		//v[0] = 33;
		for (int index=0; index < 5; index++)
			System.out.println("Elemento con index=" + index +" vale " +v[index]);
		System.out.println("Suma del Array="+ suma(v));
		System.out.println("Valor menos="+ menor(v));
		System.out.println("indexOf="+ indexOf(v, 0));
	}
	
	public static int suma(int[] v){
		int suma = 0;
		//numero de elementos del vector: v.length
		for (int index=0; index <v.length; index++)
			suma=suma+v[index];
		return suma;
		
	}
	public static int menor(int[] w){
		
		int menos=w[0];
		
		for(int index =0; index < w.length; index++){
			if (w[index]<menos){
				menos=w[index];
			}
		}
		return menos;
		
	}
	public static int indexOf(int[] v,int item){
		int index= -1;
		
		for(int i =0; index < v.length; index++){
			if (v[index]<item){
				index=i;
			
			}
	}
		return index;
		}
}