package MuiltiThreading.completableFeature;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Dashboard {

    public static void main(String[] args) throws URISyntaxException {

        CompletableFuture<String> user =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("[Thread "+Thread.currentThread().getName()+"]");
                    sleep();
                    return "Ashok";
                });

        CompletableFuture<String> orders =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("[Thread "+Thread.currentThread().getName()+"]");
                    sleep();
                    return "10 Orders";
                });

        CompletableFuture<String> cart =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("[Thread "+Thread.currentThread().getName()+"]");
                    sleep();
                    return "3 Items";
                });

        CompletableFuture<String> recommendations =
                CompletableFuture.supplyAsync(() -> {
                    sleep();
                    return "Laptop";
                });

        CompletableFuture.allOf(user, orders, cart, recommendations)
                .join();
        HttpClient httpClient = HttpClient.newHttpClient();
   CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture = httpClient.sendAsync(HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/todos/1")).build(), HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> httpResponseCompletableFuture2 = httpClient.sendAsync(HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/todos/2")).build(), HttpResponse.BodyHandlers.ofString());
        CompletableFuture<HttpResponse<String>> httpResponseCompletableFutur3 = httpClient.sendAsync(HttpRequest.newBuilder(new URI("https://jsonplaceholder.typicode.com/todos/3")).build(), HttpResponse.BodyHandlers.ofString());

        CompletableFuture.allOf(httpResponseCompletableFuture,httpResponseCompletableFuture2,httpResponseCompletableFutur3);
        System.out.println(httpResponseCompletableFuture.join().body());
        System.out.println(httpResponseCompletableFuture2.join().body());
        System.out.println(httpResponseCompletableFutur3.join().body());
//        System.out.println(user.join());
//        System.out.println(orders.join());
//        System.out.println(cart.join());
//        System.out.println(recommendations.join());

    }

    static void sleep() {
        try {
            Thread.sleep(2000);
        } catch(Exception e) {}
    }
}