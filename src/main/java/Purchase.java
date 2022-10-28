
public class Purchase { // разделение покупки и корзины по принципу единственной отвественности
                        // убраны методы в новый класс Basket и добавлены геттеры и сеттеры
    private String title;
    private int count;


    public Purchase(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
