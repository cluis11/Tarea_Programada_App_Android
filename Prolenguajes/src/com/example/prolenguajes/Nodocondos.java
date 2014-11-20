package com.example.prolenguajes;



//Clase de Nodo Lista Doble
public class Nodocondos
{
	//Acceso directo
	Object datos;
	Object datos1;
	
	Nodocondos siguiente;
	Nodocondos anterior;
	
//Constructor: Crea un Nodo tipo int
Nodocondos (Object elemInser,Object elemInser1)
{
	datos=elemInser;
	datos1=elemInser1;
	siguiente=null;
	anterior = null;
}
Nodocondos ()
{
	datos=0;
	datos1="";
	siguiente=null;
	anterior = null;
}

//Constructor: Crea un nodo del tipo int y al siguiente nodo de la lista
Nodocondos (Object valor,Object elemInser1, Nodocondos signodo)
{
	datos=valor;
	datos1=elemInser1;
	siguiente= signodo;
}

//Retorna el dato que se encuentra en el Nodo
Object getint()
{
	return datos;
	
}

//Retorna el siguiente nodo
Nodocondos getnext()
{
	return siguiente;
}
}
