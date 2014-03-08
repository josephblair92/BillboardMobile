package wm.edu.billboardmobile.tasks;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.json.JSONObject;

//import edu.wm.werewolfmobile.exceptions.HttpErrorException;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Base64;
import android.widget.Toast;

public class HttpRequestTask extends AsyncTask<String, Integer, String> {
	
	private Context appContext;
	ProgressDialog pd;
	String msg;
	
	public HttpRequestTask(Context c, String loadingMsg) {
		appContext = c;
		this.msg = loadingMsg;
	}
	
	public HttpRequestTask() {
		appContext = null;
	}

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }
    
    @Override
    protected void onPreExecute () {
    	
    	if (appContext != null)  {
	    	pd = new ProgressDialog(appContext);
	    	pd.setMessage(msg);
	    	pd.show();
    	}
    	else
    		pd = null;
    	
    }

    protected void onPostExecute(String result) {
    	//Toast.makeText(getApplicationContext(), "command sent", Toast.LENGTH_LONG).show();
    	super.onPostExecute(result);
    	//pd.setMessage("");
    	if (pd != null)
    		pd.dismiss();
    }

	@Override
	protected String doInBackground(String... params) {
		
		if (pd != null)
			pd.setMessage(msg);
		
    	String output = "";
    	
    	try	{
    		
    		String s = params[0] + "?";
        	for (int i = 2; i < params.length - 1; i=i+2) {
        		
        		if (i != 2)
        			s = s + "&";

        		s = s + params[i] + "=" + params[i+1];
        	}
        	
        	s = s.replace(" ", "%20");
        	
        	System.out.println(s);
 	       
        	URL url = new URL(s); 
        	String method = params[1];
        	String authBase64 = "";
        	
        	for (int i = 3; i < params.length; i++)  {
        		
        	}
        	
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Connection", "close");
            //String encoded = Base64.encode(username+":"+password); 
            
            if (params[1].equals("GET"))
            	conn.setRequestMethod("GET");
            else if (params[1].equals("POST")) {
            	conn.setDoOutput(true);
            	conn.setDoInput(true);
            	conn.setRequestMethod("POST");
            	DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            	for (int i = 2; i < params.length - 1; i=i+2) {
            		
            		if (i != 2)
            			os.writeBytes("&");

            		os.writeBytes(params[i] + "=" + params[i+1]);
            	}
        		os.flush();
        		os.close();
            	/*
            	conn.setRequestProperty("Content-Type","application/json");
            	JSONObject payload = new JSONObject();
            	for (int i = 4; i < params.length - 1; i++)
            		payload.put(params[i], params[i+1]);
            	DataOutputStream os = new DataOutputStream(conn.getOutputStream ());
                os.writeUTF(URLEncoder.encode(payload.toString(),"UTF-8"));
                os.flush();
                os.close();
				*/
            	
            	
            	
            }
            
            // Get the response
            
            /*
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
            	throw new HttpErrorException();
            */
            
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            output = "";
            while ((line = rd.readLine()) != null) {
        		output += line;
            }
            
    	}
    	catch (Exception e)	{
    		e.printStackTrace();
    	}
    	
    	return output;
	}
}
