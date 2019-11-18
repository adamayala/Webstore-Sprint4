//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.mongodb.Mongo.Holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;
import edu.csumb.Webstore.repositories.UserRepository;;

//Remember to annotate what type of class this is!
@Service
public class UserService {
    // We need to autowire the database here. If you are stuck, look at
    // ProductController!

    // public Iterable<String> example()
    // {
    // List<String> sList = new ArrayList<>();
    // sList.add("Cameron is such a good TA, i'm going to give him 5 stars on every
    // review!");
    // return sList;
    // }

    @Autowired
    UserRepository userRepository;
    ProductRepository productRepository;

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public boolean verifyUser(String userName, String password) {
        List<User> list = userRepository.findAll();
        User findThisOne = new User(userName, password);
        for (int i = 0; i < list.size(); i++) {
            User currentUser = list.get(i);
            if (currentUser.getID().equals(userName) && currentUser.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void add(User user) {
        userRepository.insert(user);
    }

    public void addToCart(String userName, String productId, int quantity) {
        User holder = new User("string", "string");
        HashMap<String, Integer> holderCart = new HashMap<>();
        if (quantity != 0) {
            List<User> list = userRepository.findAll();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getID().equals(userName)) {
                    holder = list.get(i);
                }
            }
            holderCart = holder.getCart();
            if (holderCart.containsKey(productId)) {
                holderCart.put(productId, holderCart.get(productId) + quantity);
                if (holderCart.get(productId) == 0) {
                    holderCart.remove(productId);
                }
            } else {
                holderCart.put(productId, quantity);
            }
        }
        userRepository.findById(userName).get().setCart(holderCart);
    }

    public void checkout(String userName){
        HashMap<String, Integer> userCart = userRepository.findById(userName).get().getCart();
        userRepository.findById(userName).get().getCart().clear();
        for(String i: userCart.keySet()){
            int stock = productRepository.findById(i).get().getStock();
            productRepository.findById(i).get().setStock(stock - userCart.get(i));
        }
    }
}