package damianskolasa.customtestassertions.basket;

import damianskolasa.customtestassertions.item.Item;
import damianskolasa.customtestassertions.order.Order;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public Order orderAllItems(){
        Order order = new Order();
        items.forEach(order::addItem);
        return order;
    }
}
