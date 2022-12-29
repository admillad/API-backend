package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;
@Service
public class CartService
{
    @Autowired
    CartRepository cr;

    public List<CartItem> getCartItems()
    {
        return cr.selectAllItems();
    }//gör en ifall den är null:

}
