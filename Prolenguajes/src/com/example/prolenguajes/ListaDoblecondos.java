package com.example.prolenguajes;






public class ListaDoblecondos 
{
	private static final Boolean Interger = null;
	public Nodocondos PrimerNodo;
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
			Nodocondos Actual=PrimerNodo;
			Nodocondos Actual1=PrimerNodo;
			
			
			while (Actual != null)
			{
				System.out.print("("+Actual.datos+ ">");
				System.out.print(Actual1.datos1+ ") >");
				Actual=Actual.siguiente;
				Actual1=Actual1.siguiente;
			}
			System.out.println();
		}
		
		
	}
	
	
	public ListaDoblecondos(String s)
	{
		Nombre = s;
		PrimerNodo = null;
	}
	
	//Constructor: Construye una Lista Vacía con un nombre de List
	public ListaDoblecondos()
	{
		this ("Lista");
	}
	
	//Inserta un Elemento al Frente de la Lista
	public void InsertaInicio(Object ElemInser,Object Otro)
	{
		//Lista Vacía
		if (Vacialista())
		{
			PrimerNodo = new Nodocondos (ElemInser,Otro);
		}
		//Lista No Vacía
		else
		{
			PrimerNodo = PrimerNodo.anterior = new Nodocondos (ElemInser,Otro,PrimerNodo);
		}
	}
	
	//Inserta al Final de la Lista
	public void InsertaFinal(Object ElemInsert, Object Otro)
	{
		//Lista Vacía
		if (Vacialista())
		{
			PrimerNodo = new Nodocondos (ElemInsert,Otro);
		}
		//lista No Vacía
		else
		{
			Nodocondos aux= PrimerNodo;
			while (aux.siguiente != null)
				aux = aux.siguiente;
			aux.siguiente = new Nodocondos (ElemInsert,Otro);
			aux.siguiente.anterior = aux;
		}
	}
	
	// Inserta Posición Medio
	public void InsertaMedio(Object ElemInsert,Object Otro, int Posicion )
	{
		//Lista Vacía
		if (Vacialista())
		{
			PrimerNodo = new Nodocondos (ElemInsert,Otro);
		}
		//Lista No Vacía
		else
		{
			if (Posicion <=1)
			{
				InsertaInicio(ElemInsert,Otro);
			}
			else
			{
				Nodocondos Aux = PrimerNodo;
				int i = 2;
				while ((i != Posicion) & (Aux.siguiente != null))
				{
					i++;
					Aux = Aux.siguiente;
				}
				if (i==Posicion)
				{
					Nodocondos Nuevo = new Nodocondos (ElemInsert,Otro);
					Nuevo.siguiente = Aux.siguiente;
					Aux.siguiente = Nuevo;
					Nuevo.anterior = Aux;
					Nuevo.siguiente.anterior=Nuevo;
				}
				else
					InsertaFinal(ElemInsert,Otro);
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
				Nodocondos Actual = PrimerNodo;
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
			Nodocondos Actual = PrimerNodo;
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
		Nodocondos sig = PrimerNodo;
		Nodocondos anterior = null;
		while (! (Vacialista()))
		{
			sig =PrimerNodo.siguiente = anterior;
			anterior = PrimerNodo;
			PrimerNodo = sig;
		}
	}
	public boolean contains(Object cod) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean usuarioexiste(String h,String g){
		Nodocondos sig = PrimerNodo;
		while(sig!=null){
			if (h.equals(sig.datos.toString().toLowerCase())&& g.toString().equals(sig.datos1.toString().toLowerCase())){
				return true;
			}
			else{
				System.out.println("no entro con"+h+""+sig.datos+"&&"+g.toString()+" "+sig.datos1);
				sig=sig.siguiente;
			}
		}return false;
	}
	//Acomodar
	
	
}
	
	
	


				
		






















