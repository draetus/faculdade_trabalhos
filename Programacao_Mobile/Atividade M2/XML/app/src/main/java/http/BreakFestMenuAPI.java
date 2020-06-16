package http;

import android.util.Xml;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.univali.entities.BreakFestMenu;
import com.univali.entities.Food;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Documented;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class BreakFestMenuAPI {

    private final String resourceURI = "https://www.w3schools.com/xml/simple.xml";

    public List<Food> getAllPosts() {
        try {
            Document document = null;
            String httpParameters = "";//?id=0
            String formattedURL = resourceURI + httpParameters;
            URL url = new URL(formattedURL);
            InputStream is = url.openStream();
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            try {
                dBuilder = dbFactory.newDocumentBuilder();
                document = dBuilder.parse(is);
            } catch (ParserConfigurationException | IOException | SAXException e) {
                e.printStackTrace();
            }
            return parseFoods(document);
        } catch (IOException ex) {
            return null;
        }

    }

    private List<Food> parseFoods(Document document) {
        List<Food> foods = new ArrayList<Food>();
        NodeList foodElements = document.getElementsByTagName("food");
        for (int i=0; i<foodElements.getLength(); i++) {
            Food food = new Food(
                    Long.valueOf(i),
                    foodElements.item(i).getChildNodes().item(1).getTextContent(),
                    foodElements.item(i).getChildNodes().item(3).getTextContent(),
                    foodElements.item(i).getChildNodes().item(5).getTextContent(),
                    Integer.parseInt(foodElements.item(i).getChildNodes().item(7).getTextContent()));
            foods.add(food);
        }
        return foods;
    }
}
