package learning.apitesting.restassured.pojo;

import static org.apache.commons.lang3.StringEscapeUtils.escapeJson;

public class JSONPlaceHolderPosts {
    private int userId;
    private int id;
    private String title;
    private String body;

    @Override
    public String toString() {
        return """
                {
                    "userId": "%d",
                    "id": "%d",
                    "title": "%s",
                    "body": "%s"
                }
                """.formatted(userId, id, title, body.replaceAll("\n", ""));
    }
}
