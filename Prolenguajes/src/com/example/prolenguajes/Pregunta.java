package com.example.prolenguajes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.prolenguajes.Realizarpregunta.HttpAsyncTask;

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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Pregunta extends Activity {
	ListView lista;
	ArrayAdapter<String> adaptador;
	ArrayList<String> datos;
	nacho g = new nacho();
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		new HttpAsyncTask().execute("https://murmuring-dawn-5532.herokuapp.com/respuestas/"+Globales.pregid);
		setContentView(R.layout.activity_pregunta);
		TextView etResponse = (TextView) findViewById(R.id.textView1);
		etResponse.setText(Globales.pregid+". "+Globales.preguser+" ¿"+Globales.prepre.replace("-", " ")+"? Etiquetas:"+ConcatenarTags());
		new HttpAsyncTask().execute("https://murmuring-dawn-5532.herokuapp.com/respuestas/"+Globales.pregid);
		datos= new ArrayList<String>();
		g.ConseguirPreguntas();
		lista=(ListView)findViewById(R.id.listView1);
		adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos);
		lista.setAdapter(adaptador);
		hola();
		
	}
	public void ultima(View V){
		EditText txtlo=(EditText)findViewById(R.id.editText1);
		new HttpAsyncTask().execute("https://murmuring-dawn-5532.herokuapp.com/get_respuesta/"+Globales.pregid.toString()+"+"+Globales.usuariodeverdad.toString()+"+"+txtlo.getText().toString().replace(" ", "-"));
		System.out.println("https://murmuring-dawn-5532.herokuapp.com/get_usuario/"+txtlo.getText().toString()+"_");
		Globales.usuariodeverdad=txtlo.getText().toString();
		Toast.makeText(getBaseContext(), "Su respuesta fue enviada con exito", Toast.LENGTH_LONG).show();	
		PasarActividad3(V);
		}
		
	public void PasarActividad3 (View w){
	    Intent intent = new Intent(this, Usuario.class);
	    Bundle b = new Bundle();
	    b.putString("resultado","hola");
	    intent.putExtras(b);
	    finish();
	    startActivity(intent);
	      	
	    }
	public void llenarlista(String h)
	{	
			datos.add(h.toString());
		
	}
	public void hola()
	{
		Nodocondos aux = Globales.pretag.PrimerNodo;
		while(aux != null)
		{
			llenarlista(aux.datos.toString() + " Posteado por: "+aux.datos1.toString());
			aux = aux.siguiente;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pregunta, menu);
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
	
	public String ConcatenarTags()
	{
		Nodocondos aux = Globales.pretag.PrimerNodo;
		String tags = "";
		while(aux != null)
		{
			tags += aux.datos;
			tags += ",";
			aux = aux.siguiente;
		}
		return tags;
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
        Globales.nueva=result;
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
      
    }
}
