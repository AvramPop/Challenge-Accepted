package shopping.cart.fineas;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Fineas on 19/03/2017.
 */
public class ShoppingCart {
    private final String name;
    private final Map<StockItem, Integer> list;

    public ShoppingCart(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToCart(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inCart = list.getOrDefault(item, 0);
            list.put(item, inCart + quantity);
            return inCart;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping cart " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}
