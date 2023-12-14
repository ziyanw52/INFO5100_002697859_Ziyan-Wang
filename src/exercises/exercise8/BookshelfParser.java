package exercises.exercise8;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

public class BookshelfParser {

    public static void main(String[] args) {
        // Sample XML
        String xmlData = "<BookShelf>" +
                "<Book>" +
                "<title>Book 1</title>" +
                "<publishedYear>2022</publishedYear>" +
                "<numberOfPages>200</numberOfPages>" +
                "<authors>" +
                "<author>Author 1</author>" +
                "</authors>" +
                "</Book>" +
                "<Book>" +
                "<title>Book 2</title>" +
                "<publishedYear>2020</publishedYear>" +
                "<numberOfPages>150</numberOfPages>" +
                "<authors>" +
                "<author>Author 2</author>" +
                "</authors>" +
                "</Book>" +
                "<Book>" +
                "<title>Book 3</title>" +
                "<publishedYear>2021</publishedYear>" +
                "<numberOfPages>180</numberOfPages>" +
                "<authors>" +
                "<author>Author 3</author>" +
                "</authors>" +
                "</Book>" +
                "</BookShelf>";

        // Parse and print XML
        System.out.println("Parsing and printing XML:");
        parseAndPrintXML(xmlData);

        // Sample JSON
        String jsonData = "{" +
                "\"BookShelf\": {" +
                "\"Book\": [" +
                "{" +
                "\"title\": \"Book 1\"," +
                "\"publishedYear\": 2022," +
                "\"numberOfPages\": 200," +
                "\"authors\": {" +
                "\"author\": [\"Author 1\"]" +
                "}" +
                "}," +
                "{" +
                "\"title\": \"Book 2\"," +
                "\"publishedYear\": 2020," +
                "\"numberOfPages\": 150," +
                "\"authors\": {" +
                "\"author\": [\"Author 2\"]" +
                "}" +
                "}," +
                "{" +
                "\"title\": \"Book 3\"," +
                "\"publishedYear\": 2021," +
                "\"numberOfPages\": 180," +
                "\"authors\": {" +
                "\"author\": [\"Author 3\"]" +
                "}" +
                "}" +
                "]" +
                "}" +
                "}";

        // Parse and print JSON
        System.out.println("\nParsing and printing JSON:");
        parseAndPrintJSON(jsonData);

        // Add a new book programmatically
        JSONObject newBook = new JSONObject();
        newBook.put("title", "Book 4");
        newBook.put("publishedYear", 2023);
        newBook.put("numberOfPages", 220);

        JSONArray newAuthors = new JSONArray();
        newAuthors.put("Author 4");
        newAuthors.put("Author 5");

        JSONObject newAuthorsObject = new JSONObject();
        newAuthorsObject.put("author", newAuthors);

        newBook.put("authors", newAuthorsObject);

        // Add the new book to JSON data
        JSONObject jsonBookshelf = new JSONObject(jsonData);
        jsonBookshelf.getJSONObject("BookShelf").getJSONArray("Book").put(newBook);

        // Convert the updated JSON data to XML and print
        System.out.println("\nPrinting XML after adding a new book:");
        String updatedXmlData = XML.toString(jsonBookshelf);
        System.out.println(updatedXmlData);
    }

    private static void parseAndPrintXML(String xmlData) {
        JSONObject jsonObject = XML.toJSONObject(xmlData);
        System.out.println(jsonObject.toString(4));
    }

    private static void parseAndPrintJSON(String jsonData) {
        JSONObject jsonObject = new JSONObject(jsonData);
        System.out.println(jsonObject.toString(4));
    }
}

