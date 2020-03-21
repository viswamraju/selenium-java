import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExample {

    /*

    A stream represents a sequence of elements and supports different kinds of
    operations (filter, sort, map, and collect) from a collection.
    We can chain these operations together to form a pipeline to query the data

    */

    public void listStream(){
        List<String> languages = new ArrayList<>();

        languages.add("English");
        languages.add("German");
        languages.add("French");

        languages.forEach(System.out::println);
    }


    public void filterStream(){
        List<String> languages = new ArrayList<>();

        languages.add("English");
        languages.add("German");
        languages.add("French");

        languages.stream()
                .filter(lang -> lang.startsWith("E"))
                .forEach(System.out::println);

    }

    public void sortStream(){
        List<String> languages = new ArrayList<>();

        languages.add("English");
        languages.add("German");
        languages.add("French");

        languages.stream()
                .sorted()
                .forEach(System.out::println);

    }

    public void mapStream(){
        List<String> languages = new ArrayList<>();

        languages.add("English");
        languages.add("German");
        languages.add("French");

        languages.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println(languages);

    }

    public void collectStream(){
        List<String> languages = new ArrayList<>();

        languages.add("English");
        languages.add("German");
        languages.add("French");

        List<String> upperLang = languages.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperLang);

    }

    public void getMin(){

        List<Product> products = new ArrayList<>();
        products.add(new Product("MADISON OVEREAR HEADPHONES", 125.00));
        products.add(new Product("MADISON EARBUDS", 35.00));
        products.add(new Product("MP3 PLAYER WITH AUDIO", 185.00));

        Product product = products.stream().min(Comparator.comparing(Product::getPrice)).get();
        System.out.println(product.getName());
    }

    public void getMax(){

        List<Product> products = new ArrayList<>();
        products.add(new Product("MADISON OVEREAR HEADPHONES", 125.00));
        products.add(new Product("MADISON EARBUDS", 35.00));
        products.add(new Product("MP3 PLAYER WITH AUDIO", 185.00));

        Product product = products.stream().max(Comparator.comparing(Product::getPrice)).get();
        System.out.println(product.getName());
    }




    public static void main(String[] args) {
        // new StreamApiExample().listStream();
        // new StreamApiExample().filterStream();
        // new StreamApiExample().sortStream();
        // new StreamApiExample().mapStream();
        // new StreamApiExample().collectStream();
        // new StreamApiExample().getMin();
        new StreamApiExample().getMax();



    }
}


class Product {
    String name;
    Double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}