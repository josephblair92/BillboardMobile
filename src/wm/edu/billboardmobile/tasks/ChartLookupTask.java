package wm.edu.billboardmobile.tasks;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;

import wm.edu.billboardmobile.ChartDisplayActivity;
import wm.edu.billboardmobile.SearchResultsActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Base64;
import android.view.View;

public class ChartLookupTask extends AsyncTask<String, Integer, String> {
	
	private Context appContext;
	private ChartDisplayActivity chartDisplayActivity;
	ProgressDialog pd;
	String msg;
	
	public ChartLookupTask(ChartDisplayActivity u, String loadingMsg) {
		chartDisplayActivity = u;
		this.msg = loadingMsg;
	}
	
	public ChartLookupTask() {
		appContext = null;
	}

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }
    
    @Override
    protected void onPreExecute () {
    	
    	if (chartDisplayActivity != null)  {
	    	pd = new ProgressDialog(chartDisplayActivity);
	    	pd.setMessage(msg);
	    	pd.show();
    	}
    	else
    		pd = null;
    	
    }

    protected void onPostExecute(String result) {
    	//Toast.makeText(getApplicationContext(), "command sent", Toast.LENGTH_LONG).show();
    	super.onPostExecute(result);
    	
    	if (pd != null)
    		pd.dismiss();
    	
    	if (result.equals(""))  {
    		//chartDisplayActivity.noResults();
    		return;
    	}

		chartDisplayActivity.displayChart(result);
    	
    }

	@Override
	protected String doInBackground(String... params) {
		
		String response="";
		
		DateFormat dfURL = new SimpleDateFormat("MMddyyyy");
		//HttpRequestTask reverseLookupTask = new HttpRequestTask(this, "Getting results...");
		response = httpRequest("http://billboard-jpblair.herokuapp.com/chart", "GET", "date", params[0], "type", params[1]);
	    System.out.println("Response: " + response);
	    return response;
		
	}
	
	public String httpRequest(String... params) {
		
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

            }
            
            // Get the response
            
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
