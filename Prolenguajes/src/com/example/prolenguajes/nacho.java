package com.example.prolenguajes;
import java.util.StringTokenizer;


public class nacho {
	public static String x;
	
	public static void separar()
	{
		String linea = Globales.preguntas;
		Globales.listapreguntas = new ListaEspecial();
		String datos2 = null;String datos1 = null;String datos = null;
		StringTokenizer token_info = new StringTokenizer(linea);
		while(token_info.hasMoreTokens())
		{
			StringTokenizer token_getinfo = new StringTokenizer(token_info.nextToken());
			int contador = 1;
			while(token_getinfo.hasMoreTokens())
			{
				String info_obtenida = token_getinfo.nextToken("[");
				String [] obt = info_obtenida.split("]");
				if(contador == 1)
				{
					datos = obt[0];
					
				}
				if(contador == 2)
				{
					datos1 = obt[0];
				}
				if (contador == 3)
				{
					datos2 = obt[0];
				}
				contador += 1;
				x = obt[0];
			}
			
			StringTokenizer token_getinfo1 = new StringTokenizer(x);
			ListaDoblecondos n = new ListaDoblecondos();
			while(token_getinfo1.hasMoreTokens())
			{
				String tag = token_getinfo1.nextToken(",");
				n.InsertaFinal(tag,"");
			}
			Globales.listapreguntas.InsertaFinal(datos,datos1,datos2,n);
			Globales.listapreguntas.Imprimir();
		}
		
		
	}
	public void ConseguirPreguntas()
	{
		String linea = Globales.nueva;
		Globales.pretag= new ListaDoblecondos();
		String datos2 = null;String datos1 = null;String datos = null;
		StringTokenizer token_info = new StringTokenizer(linea);
		while(token_info.hasMoreTokens())
		{
			StringTokenizer token_getinfo = new StringTokenizer(token_info.nextToken());
			int contador = 1;
			while(token_getinfo.hasMoreTokens())
			{
				String info_obtenida = token_getinfo.nextToken("[");
				String [] obt = info_obtenida.split("]");
				if(contador == 1)
				{
					datos = obt[0];
					
				}
				if(contador == 2)
				{
					datos1 = obt[0];
				}
				if (contador == 3)
				{
					datos2 = obt[0];
				}
				contador += 1;
			}
			
			Globales.pretag.InsertaFinal(datos1,datos2);
			
			Globales.pretag.Imprimir();
		}
		
	}
	
	


}
