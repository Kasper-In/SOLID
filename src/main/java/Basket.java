import java.util.Arrays;
import java.util.Objects;

public class Basket {               //разделение покупки и корзины по принципу единственной отвественности
    protected Purchase[] purchases; // = new Purchase[4]; магическое число, надо брать размер мапы ассортимента и
                                    // и передать через конструктор

    public Basket(int sizeBasket){
        purchases = new Purchase[sizeBasket];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].getTitle().equals(title)) {
                int newCount = purchases[i].getCount() + count;
                purchases[i].setCount(newCount);
                return;
            }
        }
    }

    public int sum(ProductAssortment products) {     //разделение метода sum (он только должен считать сумму)
        //int sum;

        return Arrays.stream(purchases)              //замена на стрим
                .filter(Objects::nonNull)
                .map(purchase -> purchase.getCount() * products.getPrice(purchase.getTitle()))
                .mapToInt(Integer::intValue).sum();

/*        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            sum += purchase.getCount() * products.getPrice(purchase.getTitle());
        }*/
        //return sum;
}

    public void printBasket(ProductAssortment products) { //отдельный метод вывода корзины на печать
        System.out.println("КОРЗИНА:");
        Arrays.stream(purchases)              //замена на стрим
                .filter(Objects::nonNull)
                .forEach(purchase ->  System.out.println("\t" + purchase.getTitle() + " "
                        + purchase.getCount() + " шт. в сумме "
                        + (purchase.getCount() * products.getPrice(purchase.getTitle())) + " руб."));

/*        for (Purchase purchase : purchases) {
            if (purchase == null) continue;
            System.out.println("\t" + purchase.getTitle() + " " + purchase.getCount() + " шт. в сумме "
                    + (purchase.getCount() * products.getPrice(purchase.getTitle())) + " руб.");
        }*/
        int summa = sum(products);
        System.out.println("ИТОГО: " + summa);
    }
}
