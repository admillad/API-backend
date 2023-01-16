package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.CartItem;
import se.jensenyh.javacourse.saltmerch.backend.repository.CartRepository;

import java.util.List;
@Service
public class CartService
{
    @Autowired
    CartRepository cr;

    public List<CartItem> getCartItems(int id)
    {
        if (cr.selectAllItems()==null || cr.selectAllItems().isEmpty()){
            throw new IllegalStateException("no Items in your cart");
        }
        else
            return cr.selectAllItems();
    }
    public int addingCartItem(Integer id, CartItem item, String action){
        if (id == null){
            return -2;}
        if (item.quantity > 0){
            return -3;}
        else
            return cr.insertOrIncrementItem(item);
    }
    public int deleteCart (int id){return cr.deleteAllItems();}
    public int deleteArtist(int id)
    {
        return db.deleteArtist(id);
    }
    //public void clearCartAndUpdateIfBoolTrue(boolean restock){
       // if (){}
   // }




}
