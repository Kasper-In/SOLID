import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

/*      HashMap<String, Integer> products = new HashMap<>();  // замена на объект нового класса Assortment
        products.put("Хлеб", 56);
        products.put("Масло", 153);
        products.put("Колбаса", 211);
        products.put("Пирожок", 45);*/

        ProductAssortment products = new ProductAssortment();
        products.addProduct("Хлеб", 56);           // добавление через новый класс
        products.addProduct("Масло", 153);
        products.addProduct("Колбаса", 211);
        products.addProduct("Пирожок", 45);


/*        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");        // печать ассортмента через метод нового класса
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }
        */
        products.printAssortment();                        // печать ассортимента

        System.out.println("Введите два слова: название товара и количество. Или end");
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket(products.getSize());
        //Purchase purchase = new Purchase(); //Корзина формируется в Basket
        while (true) {
            String line = scanner.nextLine();
            if ("end".equals(line)) break;
            String[] parts = line.split(" ");
            String product = parts[0];
            int count = Integer.parseInt(parts[1]);
            //purchase.addPurchase(product, count); //покупка добавляется в корзину basket
            basket.addPurchase(product, count);
        }

/*        long sum = purchase.sum(products);        // печать корзины и итоговая сумма через новый метод корзины basket
        System.out.println("ИТОГО: " + sum);*/

        basket.printBasket(products);
    }
}
