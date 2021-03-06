package dit126.util.HttpRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Gustav
 * Class that handles HTTP requests to the Google maps API
 * */
class UrlConnectionHttpRequest implements HttpRequest{

    @Override
    public String getCity(Double lat, Double lng) {
        try {
            if(ApiKey.MAPSKEY.equals("")){
                throw new Exception("No API-key supplied");
            }
            URL googleApi = new URL("https://maps.googleapis.com/maps/api/geocode/json?latlng="+ lat +"," + lng + "&sensor=false&key="+ApiKey.MAPSKEY);
            URLConnection connection = googleApi.openConnection();


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder s = new StringBuilder();

            while (true){
                String line = in.readLine();
                if(line == null){
                    break;
                }else{
                    s.append(line);
                }
            }
            in.close();


            JSONObject json = new JSONObject(s.toString());
            JSONArray arr = json.getJSONArray("results");

            //Loop every result in the array, start from the end
            for(int i = arr.length()-1;i>0;i--){
                JSONArray addressComponents = arr.getJSONObject(i).getJSONArray("address_components");
                //For every result loop the adress_component
                for(int j = 0;j<addressComponents.length();j++){
                    //Check if the type array in adress_component contains postal or locality
                    JSONObject addressComponent = addressComponents.getJSONObject(j);
                    if(isPostalOrLocality(addressComponent)){
                        //If so we have found the city name
                        return addressComponent.getString("long_name");
                    }
                }
            }

            return "";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    private boolean isPostalOrLocality(JSONObject jsonObject) {
        JSONArray types = jsonObject.getJSONArray("types");
        for(int i = 0;i<types.length();i++){
            String type = types.getString(i);
            if(type.equals("postal_town") || type.equals("locality")){
                return true;
            }
        }
        return false;
    }
}