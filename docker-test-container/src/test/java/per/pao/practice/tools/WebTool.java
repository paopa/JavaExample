package per.pao.practice.tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.util.Objects.isNull;

public class WebTool
{
    public enum HttpMethod
    {
        GET, POST, DELETE, PUT;
    }

    public static String request(HttpMethod method, String address)
            throws Exception
    {
        URL url = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method.toString());
        StringBuilder builder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while (!isNull(line = in.readLine())) {
                builder.append(line);
            }
        }
        return builder.toString();
    }
}
