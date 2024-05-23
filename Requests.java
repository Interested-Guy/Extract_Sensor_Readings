import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


public class Requests {
	private static String readStream(InputStream is) {
	    try {
	      ByteArrayOutputStream bo = new ByteArrayOutputStream();
	      int i = is.read();
	      while(i != -1) {
	        bo.write(i);
	        i = is.read();
	      }
	      return bo.toString();
	    } catch (IOException e) {
	      return "";
	    }
	}
	/*private static void writeStream(OutputStream out) throws IOException{
	    String output = "Hello world";
	    //out.write(output.getBytes());
	    out.flush();
	}*/
	 public static void main(String[] args) throws Exception {
	        URL yahoo = new URL("http://roger123.pythonanywhere.com/dummy/");
	        HttpURLConnection urlConnection = (HttpURLConnection) yahoo.openConnection();
			   try {
			     urlConnection.setDoOutput(true);
			     //urlConnection.setChunkedStreamingMode(0);

			     //OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
			     //writeStream(out);
				 urlConnection.addRequestProperty("Content-Type", "application/"+"POST");
				 String query="42";
				 if(query!=null) {
					 urlConnection.setRequestProperty("Content-Length", Integer.toString(query.length()));
					 urlConnection.getOutputStream().write(query.getBytes());
				 }
			     InputStream in = new BufferedInputStream(urlConnection.getInputStream());
			     System.out.println(readStream(in));
			   } finally {
			     urlConnection.disconnect();
			   }
	        /*HttpURLConnection con = (HttpURLConnection) yahoo.openConnection();
	        con.setRequestMethod("GET");
	        Map<String, String> parameters = new HashMap<>();
	        parameters.put("param1", "val");

	        con.setDoOutput(true);
	        DataOutputStream out = new DataOutputStream(con.getOutputStream());
	        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
	        out.flush();
	        out.close();*/
	        /*URLConnection yc = yahoo.openConnection();
	        //yc.setRequestProperty("hello", "moto");
	        yc.setDoOutput(true);
	        OutputStreamWriter out = new OutputStreamWriter(
	                                         yc.getOutputStream());
	        out.write("string=" + "hello");
	        out.close();
	        /*PrintWriter writer = new PrintWriter(yc.getOutputStream());
	        writer.println("hello");
	        writer.close();
	        
	        BufferedReader in = new BufferedReader(
	                                new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;

	        while ((inputLine = in.readLine()) != null) 
	            System.out.println(inputLine);
	        in.close();*/
		 
	    }}
 