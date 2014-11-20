package com.example.prolenguajes;







public class ListaEspecial 
{
	private static final Boolean Interger = null;
	public Nodoespecial PrimerNodo;
	String Nombre;

	//Constructor: construye una lista vacía con un nombre
	
	//Retorna True cuando la lista esta vacía
	public boolean Vacialista()
	{
		return PrimerNodo==null;
	}
	//imprime el Contenido de la lista
	public void Imprimir()
	{
		if (Vacialista())
		{
			System.out.println("Vacia"+Nombre);
		}
		else
		{
			System.out.println("La "+ Nombre + " es: ");
			Nodoespecial Actual=PrimerNodo;
			Nodoespecial Actual1=PrimerNodo;
			
			
			while (Actual != null)
			{
				
				System.out.print("("+Actual1.datos+ ">");
				System.out.print(Actual1.datos1+ ">");
				System.out.print(Actual1.datos3+ ">");
				Actual1.datos4.Imprimir();
				System.out.print(")");
				Actual=Actual.siguiente;
				Actual1=Actual1.siguiente;
			}
			System.out.println();
		}
		
		
	}
	
	
	public ListaEspecial(String s)
	{
		Nombre = s;
		PrimerNodo = null;
	}
	
	//Constructor: Construye una Lista Vacía con un nombre de List
	public ListaEspecial()
	{
		this ("Lista");
	}
	
	//Inserta un Elemento al Frente de la Lista
	public void InsertaInicio(String ElemInser,String Otro,String aa,ListaDoblecondos dd)
	{
		//Lista Vacía
		if (Vacialista())
		{
			PrimerNodo = new Nodoespecial (ElemInser,Otro,aa,dd);
		}
		//Lista No Vacía
		else
		{
			PrimerNodo = PrimerNodo.anterior = new Nodoespecial (ElemInser,Otro,aa,dd,PrimerNodo);
		}
	}
	
	//Inserta al Final de la Lista
	public void InsertaFinal(String ElemInsert, String Otro,String Otr,ListaDoblecondos a)
	{
		//Lista Vacía
		if (Vacialista())
		{
			PrimerNodo = new Nodoespecial (ElemInsert,Otro,Otr,a);
		}
		//lista No Vacía
		else
		{
			Nodoespecial aux= PrimerNodo;
			while (aux.siguiente != null)
				aux = aux.siguiente;
			aux.siguiente = new Nodoespecial (ElemInsert,Otro,Otr,a);
			aux.siguiente.anterior = aux;
		}
	}
	
	// Inserta Posición Medio
	public void InsertaMedio(String ElemInsert,String Otro,String eme,ListaDoblecondos as, int Posicion )
	{
		//Lista Vacía
		if (Vacialista())
		{
			PrimerNodo = new Nodoespecial (ElemInsert,Otro,eme,as);
		}
		//Lista No Vacía
		else
		{
			if (Posicion <=1)
			{
				InsertaInicio(ElemInsert,Otro,eme,as);
			}
			else
			{
				Nodoespecial Aux = PrimerNodo;
				int i = 2;
				while ((i != Posicion) & (Aux.siguiente != null))
				{
					i++;
					Aux = Aux.siguiente;
				}
				if (i==Posicion)
				{
					Nodoespecial Nuevo = new Nodoespecial (ElemInsert,Otro,eme,as);
					Nuevo.siguiente = Aux.siguiente;
					Aux.siguiente = Nuevo;
					Nuevo.anterior = Aux;
					Nuevo.siguiente.anterior=Nuevo;
				}
				else
					InsertaFinal(ElemInsert,Otro,eme,as);
			}
		}
	}
	// Elimina Inicio
	public void EliminaIncio()
	{
		if (Vacialista()){
			System.out.println("No hay Elementos");}
		else
		{
			if(PrimerNodo.siguiente == null){
				PrimerNodo = null;}
			else{
				PrimerNodo = PrimerNodo.siguiente;
				PrimerNodo.anterior = null;}
		}
	}
	// Ellimina Final
	public void EliminaFinal()
	{
		if (Vacialista())
			System.out.println( "No hay Elementos");
		else
		{
			if (PrimerNodo.siguiente == null)
				PrimerNodo = null;
			else
			{
				Nodoespecial Actual = PrimerNodo;
				while (Actual.siguiente.siguiente != null)
					Actual = Actual.siguiente;
				Actual.siguiente = null;
			}
		}
	}
	
	// Elimina Elemento en Posicion
	public void EliminaMedio (int Posicion)
	{
		if (Vacialista())
			System.out.println("Nada");
		else
		{
			Nodoespecial Actual = PrimerNodo;
			int i = 1;
			while ((i != Posicion) & (Actual.siguiente != null))
			{
				i++;
				Actual = Actual.siguiente;
			}
			if (Posicion == 1)
				EliminaIncio();
			else
			{
				if (i == Posicion)
				{
					Actual.anterior.siguiente = Actual.siguiente;
					Actual.siguiente.anterior = Actual.anterior;
				}
			}
		}
	}
	
	//Invertir
	public void Invertir()
	{
		Nodoespecial sig = PrimerNodo;
		Nodoespecial anterior = null;
		while (! (Vacialista()))
		{
			sig =PrimerNodo.siguiente = anterior;
			anterior = PrimerNodo;
			PrimerNodo = sig;
		}
	}
	public boolean contains(String cod) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
	
	
	


				
		






















