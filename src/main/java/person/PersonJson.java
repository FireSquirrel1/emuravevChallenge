package person;

import com.google.gson.Gson;
import db.GetPersonFromDataBase;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonJson {
    public static void ConvertPersonToJson()  {
        ArrayList<String> personJsonData = new ArrayList<>();
        Gson gson = new Gson();
        Person person1 = new GetPersonFromDataBase("SELECT * FROM challange.emuravev WHERE id = 1;").getPersonData();
        Person person2 = new GetPersonFromDataBase("SELECT * FROM challange.emuravev WHERE id = 2;").getPersonData();


        personJsonData.add(gson.toJson(person1));
        personJsonData.add(gson.toJson(person2));

        try {
            FileWriter fw = new FileWriter("personDataJson");
            fw.write(String.valueOf(personJsonData));
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
