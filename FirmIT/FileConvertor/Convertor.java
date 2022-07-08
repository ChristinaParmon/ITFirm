package FirmIT.FileConvertor;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Convertor {

    public static void exportToTXTFile(String fileName, Object obj) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.write(obj.toString());
        //bw.write(str);
        //bw.flush();
        bw.close();
        System.out.println("Export to TXT File completed");
    }

    public static void writeJsonSimpleDemo(String filename) throws Exception {
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", "Christina");
        sampleObject.put("age", 23);

        JSONArray messages = new JSONArray();
        messages.add("Finish task 2.3!");
        messages.add("Talk to a manager");

        sampleObject.put("messages", messages);
        Files.write(Paths.get(filename), sampleObject.toString().getBytes());
        System.out.println("JSON file has been made");
    }

    public static Object readJsonSimpleDemo(String filename) throws Exception {
        FileReader reader = new FileReader(filename);
        JSONParser jsonParser = new JSONParser();
        return jsonParser.parse(reader);
    }
}
