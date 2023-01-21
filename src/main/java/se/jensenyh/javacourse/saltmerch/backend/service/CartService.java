package se.jensenyh.javacourse.saltmerch.backend.service;//klar

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cr;

    public List<CartItem> getCartItems(CartItem item) {
        return cr.selectAllItems();
    }

    public int updateCart(CartItem item, String actionToExecute) {
        if (actionToExecute.equalsIgnoreCase("add")) {
            return cr.insertOrIncrementItem(item);
        } else if (actionToExecute.equalsIgnoreCase("remove")) {
            return cr.deleteOrDecrementItem(item);
        } else return -3;
    }

    public int deleteCart(boolean buyout) {
        if (buyout) {
            cr.deleteAllItems(true);
            return 1;
        } else
            cr.deleteAllItems(false);
        return 2;
    }
}




