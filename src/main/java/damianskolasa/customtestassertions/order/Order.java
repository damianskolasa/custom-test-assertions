package damianskolasa.customtestassertions.order;

import damianskolasa.customtestassertions.item.Item;
import damianskolasa.customtestassertions.money.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private String orderId = "ORD"+UUID.randomUUID().toString();
    private List<Item> items = new ArrayList<>();
    private Money totalPrice = Money.ZERO;

    public void addItem(Item item) {
        this.items.add(item);
        this.totalPrice = this.totalPrice.add(item.getPrice());
    }

    public String getOrderId() {
        return orderId;
    }

    protected List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (items != null ? !items.equals(order.items) : order.items != null) return false;
        return totalPrice != null ? totalPrice.equals(order.totalPrice) : order.totalPrice == null;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
