package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonSearchDataFetcher {

    private static final String JSON_FILE_PATH = "resources/searchData.json";

    public static Object[] fetchTestData() {
        Object[] testData = null;

        try{
            //Read the JSON File
            FileReader fileReader = new FileReader(JSON_FILE_PATH);
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(fileReader);

            //Initialize the test data array with the size of the JSONArray
            testData = new Object[jsonArray.size()];

            //Iterate through the JSON array and extract the test data
            for (int i = 0; i<jsonArray.size(); i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                String userid = (String) jsonObject.get("searchData");
                System.out.println("*************** userid ***************** " + userid);
                testData[i] = userid;
            }
        }catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return testData;
    }
}
