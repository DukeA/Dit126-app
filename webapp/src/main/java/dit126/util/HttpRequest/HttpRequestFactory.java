package dit126.util.HttpRequest;

public class HttpRequestFactory {

    /**
     * Creates a concrete implementation of HttpRequest
     * */
    public static HttpRequest getHttpRequest(){
        return new UrlConnectionHttpRequest();
    }
}
