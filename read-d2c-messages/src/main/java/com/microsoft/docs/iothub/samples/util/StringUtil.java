package com.microsoft.docs.iothub.samples.util;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;






public class StringUtil {
	
	public HashMap<String,String> getMessageMap(String msg)
	{
		HashMap<String,String> hm = new HashMap();
		msg = msg.substring(1, msg.length()-1);
		System.out.println(msg);
		String arr[] = msg.split(",");
		for(String s:arr)
		{
			if(s.contains("="))
			{
			String sa[] = s.split("=");
			hm.put(sa[0], sa[1]);
			}
		}
		return hm;
	}
	
public String[] compareMessages(String telemetric,String model)
{
	  JsonArray jsonArr = new JsonArray();
	  String arr[] = new String[2];
	  arr[0]="";
	  arr[1] = "yes";
try {
	 ObjectMapper objectMapper = new ObjectMapper(); 
	  List<HashMap> listModel = objectMapper.readValue(model, List.class);
	  HashSet<String> hs = getAllModelsName(listModel);
	  HashMap<String,String> hm = objectMapper.readValue(telemetric, HashMap.class);
	  
		Set<String> keySet = hm.keySet();
		for(String name:keySet )
		{
			 JsonObject obj = new JsonObject();
			if(hs.contains(name))
			{
			  obj.addProperty("Model", name);	
			  obj.addProperty("Telemetry", name);
			  obj.addProperty("Value", hm.get(name));
			  obj.addProperty("Match", "T");
			}
			else
			{
				  obj.addProperty("Model", "");	
				  obj.addProperty("Telemetry", name);
				  obj.addProperty("Value", hm.get(name));
				  obj.addProperty("Match", "F");
				  arr[1] = "no";
			}
			jsonArr.add(obj);
		} 
	  	
	
} catch (Exception e) {
	// TODO: handle exception
	System.out.println(e.toString());
	arr[1]="no";
	return arr;
}	

arr[0] = jsonArr.toString();

return arr;
}


public HashSet<String> getAllModelsName(List<HashMap> listModel )
{
	HashSet hs = new HashSet();
	for(HashMap hm : listModel)
	{
		hs.add(hm.get("name"));
	}
return hs;


}



	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
String msg = "{correlation-id=69cc9f0e-860c-4ed2-b0ed-1ffa545d49fd, iothub-connection-auth-method={\"scope\":\"device\",\"type\":\"sas\",\"issuer\":\"iothub\",\"acceptingIpFilterRule\":null}, iothub-enqueuedtime=Thu Jan 21 06:53:43 PST 2021, absolute-expiry-time=0, iothub-connection-device-id=TestMyDevice, iothub-connection-auth-generation-id=637466689139457130, group-sequence=0, iothub-message-source=Telemetry, creation-time=0, message-id=ef3377df-0266-4f44-98dd-db0e43f5b813, content-type=UTF-8}";
ObjectMapper mapper = new ObjectMapper();
StringUtil su = new StringUtil();

String tele = "{\"Temperature\":\"10° C\"}";
String model = "[{\"id\":\"123\",\"name\":\"Temperature\",\"value\":\"10 deg\",\"unit\":\"Centigrade\"}]";
System.out.println(su.compareMessages(tele, model));





	}

}
