package com.example.prolenguajes;



//Clase de Nodo Lista Doble
public class Nodoespecial
{
	//Acceso directo
	String datos;
	String datos1;
	String datos3;
	ListaDoblecondos datos4;
	
	Nodoespecial siguiente;
	Nodoespecial anterior;
	
//Constructor: Crea un Nodo tipo int
Nodoespecial (String elemInser,String elemInser1,String eme,ListaDoblecondos as)
{
	datos=elemInser;
	datos1=elemInser1;
	datos3=eme;
	datos4=as;
	siguiente=null;
	anterior = null;
}
Nodoespecial ()
{
	datos="0";
	datos1="";
	datos3="";
	
	siguiente=null;
	anterior = null;
}

//Constructor: Crea un nodo del tipo int y al siguiente nodo de la lista
Nodoespecial (String valor,String elemInser1,String eme,ListaDoblecondos as, Nodoespecial signodo)
{
	datos=valor;
	datos1=elemInser1;
	datos3=eme;
	datos4=as;
	siguiente= signodo;
}

//Retorna el dato que se encuentra en el Nodo
String getint()
{
	return datos;
	
}

//Retorna el siguiente nodo
Nodoespecial getnext()
{
	return siguiente;
}
}
