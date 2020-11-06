package pers.paopa.gson.simple;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class GsonTest {
    public static void main(String[] args) {
        String founderJson = "[[{'name': 'Christian','flowerCount': 1}, {'name': 'Marcus', 'flowerCount': 3}, {'name': 'Norman', 'flowerCount': 2}]]";

        Gson gson = new Gson();

        Type founderListType = new TypeToken<List<List<Founder>>>(){}.getType();

        List<List<Founder>> founderList = gson.fromJson(founderJson, founderListType);
        System.out.println(founderList);
    }
}

class Founder{
    private String value;
}
