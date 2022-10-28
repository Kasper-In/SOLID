import java.util.HashMap;
import java.util.Map;

public class ProductAssortment {                              // логично сделать отдельрный класс ассортимента, чтобы
                                                              // в других классах не было прямого доступа к каталогу, только через методы
    private Map<String, Integer> products = new HashMap<>(); // Принцип инверсии зависимостей
                                                             // (вместо HashMap при объявление переменной просто Map)

    public ProductAssortment(){ }

    public ProductAssortment (Map<String, Integer> products){
        this.products = products;
    }

    public void addProduct(String title, int price){      // новый продукт добавляется с помощью метода
        products.put(title, price);
    }

    public int getPrice(String title){                     // узнать цену по названию
        return products.get(title);
    }

    public int getSize(){                                 // размер ассортимента
        return products.size();
    }

    public void printAssortment(){                        // отдельный метод, перенесенный из Main, печать ассортимента
        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ:");
        products.forEach((key, value) -> System.out.println(key + " за " + value + " руб./шт.")); //замена на стрим

/*        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }*/

    }
}
