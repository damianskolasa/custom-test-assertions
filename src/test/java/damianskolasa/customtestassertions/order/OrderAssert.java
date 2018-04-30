package damianskolasa.customtestassertions.order;

import damianskolasa.customtestassertions.item.Item;
import org.assertj.core.api.Assertions;

public class OrderAssert {

    private Order order;

    private OrderAssert(Order order) {
        this.order = order;
    }

    public static OrderAssert of(Order order) {
        return new OrderAssert(order);
    }

    public void assertContainsItem(Item item) {
        Assertions.assertThat(order.getItems()).hasSize(1);
        Assertions.assertThat(order.getItems()).contains(item);
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(item.getPrice());
    }
}
