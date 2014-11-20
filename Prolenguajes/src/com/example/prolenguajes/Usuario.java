package com.example.prolenguajes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.prolenguajes.MainActivity.HttpAsyncTask;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Usuario extends Activity {
	
	ListView lista;
	ArrayAdapter<String> adaptador;
	ArrayList<String> datos;
	nacho g = new nacho();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new HttpAsyncTask().execute("https://murmuring-dawn-5532.herokuapp.com/preguntas");
		System.out.println(Globales.preguntas);
		setContentView(R.layout.activity_usuario);
		datos= new ArrayList<String>();
		separar(g);
		hola();
		lista=(ListView)findViewById(R.id.listaSimple);
		adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
		lista.setAdapter(adaptador);
		if (Globales.cont==0){
			Globales.cont+=1;
		PasarActiv(lista);}
		else{
			Globales.cont+=1;
		}
		lista.setOnItemClickListener(new AdapterView.OnItemClickListener() 
		{
			
			@Override
			public void onItemClick(AdapterView<?> parent, View vista,
					int posicion, long arg3) 
			{
				Nodoespecial no = Globales.listapreguntas.PrimerNodo;
				while(no!=null)
				{
					if (((TextView)vista).getText().toString().replace(" ", "-").equals(no.datos3.toString()))
					{	Globales.pregid=no.datos.toString();
						Globales.preguser=no.datos1.toString();
						Globales.prepre=no.datos3.toString();
						Globales.pretag = no.datos4;
						PasarActividad9(vista);
						//Toast.makeText(getBaseContext(),no.datos.toString()+" "+no.datos1.toString()+" "+no.datos3.toString(), Toast.LENGTH_LONG).show();
						
					}
					no=no.siguiente;
					//Toast.makeText(getBaseContext(),Globales.listapreguntas.PrimerNodo.datos1.toString(), Toast.LENGTH_LONG).show();
		        	//Toast.makeText(getBaseContext(),(String)((TextView)vista).getText(), Toast.LENGTH_LONG).show();
				}
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void llenarlista(String h)
	{	
			datos.add(h.toString().replace("-", " "));
		
	}
	public void hola(){
		Nodoespecial aux = Globales.listapreguntas.PrimerNodo;
		while(aux != null)
		{
			llenarlista(aux.datos3.toString());
			aux = aux.siguiente;
		}
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.usuario, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void PasarActiv (View w){
		
	    Intent intent = new Intent(this, Usuario.class);
	    Bundle b = new Bundle();
	    b.putString("resultado","hola");
	    intent.putExtras(b);
	    finish();
	    startActivity(intent);}
	      	
	 
	public void PasarActividad9(View w){
		
	    Intent intent = new Intent(this, Pregunta.class);
	    Bundle b = new Bundle();
	    b.putString("resultado","hola");
	    intent.putExtras(b);
	    finish();
	    startActivity(intent);
	      	
	    }
public void pasarqq(View w){
		
	    Intent intent = new Intent(this, Realizarpregunta.class);
	    finish();
	    startActivity(intent);
	      	
	    }
	
	
	public void PasarActividad3 (View w){
		Globales.usuariodeverdad="";
	    Intent intent = new Intent(this, MainActivity.class);
	    Bundle b = new Bundle();
	    b.putString("resultado","hola");
	    intent.putExtras(b);
	    finish();
	    startActivity(intent);
	      	
	    }
	public static String GET(String url){
		InputStream inputStream = null;
		String result = "";
		try {
			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
			// receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();
			// convert inputstream to string
			if(inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}
		
		return result;
	}
	
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
        
        inputStream.close();
        Globales.preguntas=result;
        return result;
        
    }
	
    public boolean isConnected(){
    	ConnectivityManager connMgr = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
    	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    	    if (networkInfo != null && networkInfo.isConnected()) 
    	    	return true;
    	    else
    	    	return false;	
    }
    
    public class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
        	Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
        
       }
    }
    
    //////////////////////////////////////////////////////////////
    public static void separar(nacho g)
    {
    	g.separar();
    }
}

