import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GoogleSearchExample {
    public static void main(String[] args) {
        // Specify the query you want to search
        String query = "Quality Education";

        // Perform a Google search
        performGoogleSearch(query);
    }

    private static void performGoogleSearch(String query) {
        try {
            // Google search URL
            String googleSearchUrl = "https://www.google.com/search?q=" + query;

            // Fetch the HTML of the Google search results page
            Document doc = Jsoup.connect(googleSearchUrl).get();

            // Extract search results
            Elements searchResults = doc.select("div.g");

            // Check if there are search results
            if (searchResults.isEmpty()) {
                System.out.println("No search results found.");
                return;
            }

            // Iterate over search results and display titles and URLs
            for (Element result : searchResults) {
                Element titleElement = result.select("h3").first();
                Element urlElement = result.select("a").first();

                if (titleElement != null && urlElement != null) {
                    String title = titleElement.text();
                    String url = urlElement.attr("href");

                    // Ensure the URL is not empty or a Google-specific link
                    if (!url.isEmpty() && !url.startsWith("/search")) {
                        System.out.println("Title: " + title);
                        System.out.println("URL: " + url);
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
