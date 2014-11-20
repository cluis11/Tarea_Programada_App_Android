package com.example.prolenguajes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//new HttpAsyncTask().execute("https://fast-peak-8768.herokuapp.com/usuarios");
	System.out.println(Globales.usuarios.toString());
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
        Globales.usuarios=result;
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
        	
       }
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
	
	public void login(View V){
	EditText txtlo=(EditText)findViewById(R.id.etuser);
	EditText txt2=(EditText)findViewById(R.id.pass);

	new HttpAsyncTask().execute("https://murmuring-dawn-5532.herokuapp.com/usuarios");
	strinalista();
	System.out.println(Globales.usuarios);
	//txt3.setText(Globales.usuarios);
	Globales.lista.Imprimir();
	int x=0;
	Nodocondos no= new Nodocondos();
	no=Globales.lista.PrimerNodo;
	while(no!=null){
		if (txtlo.getText().toString().equals(no.datos.toString())&& no.datos1.toString().equals(txt2.getText().toString())){
			PasarActividad3(V);
			Globales.usuariodeverdad=no.datos.toString();
			no=no.siguiente;
			x=1;
			break;}
			
		else{
			no=no.siguiente;
		}
		}
	}
	public void strinalista(){
		String linea=Globales.usuarios;
		String auxs="";
		StringTokenizer tokens = new StringTokenizer(linea,"#");
		while(tokens.hasMoreTokens()){
		linea=tokens.nextToken();
		int j = 0;
		String [] campos = linea.split(",");
		while(j<campos.length){
			if (j%2!=0){
				Globales.lista.InsertaFinal( auxs.toString(),campos[j].toString());
				System.out.println(auxs+"user");
				System.out.println(campos[j]+"contra");
				Globales.lista.Imprimir();
			}else{
				auxs=campos[j];
			}
		
		j++;

		}
		}
	}
	public void PasarActividad3 (View w){
	    Intent intent = new Intent(this, Usuario.class);
	    Bundle b = new Bundle();
	    b.putString("resultado","hola");
	    intent.putExtras(b);
	    finish();
	    startActivity(intent);
	      	
	    }
	public void Pasar2(View w){
	    Intent intent = new Intent(this, Creausauario.class);
	    finish();
	    startActivity(intent);
	      	
	    }
}
