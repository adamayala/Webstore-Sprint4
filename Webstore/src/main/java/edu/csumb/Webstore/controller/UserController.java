//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.service.UserService;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController
{

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    UserService userService;

    // @ResponseBody
    // String getProducts("/"){
    //     return "hello products and stuff";
    // }

    //REQUESTMAPPING
    //We are setting a request mapping with request type GET. You can change these to POST or anything else you want!
    //The value is the location of the api. So this would be HEROKU/products/example

    //APIOPERATION
    //This is comments that will be displayed in swagger. Remember to do this or you will lose points!

    //EXAMPLE()
    //We are returning an Iterable, which means a List! Use Iterable<Datatype> when you want to return many.
    //For example Iterable<Product>
    // @RequestMapping(method = RequestMethod.GET, value = "/products/example")
    // @ApiOperation(value = "An example of a api function to get you started." )
    // public Iterable<String> example()
    // {
    //     //ALL LOGIC SHOULD BE IN THE SERVICE. EVEN IF IT'S JUST ONE LINE!
    //     //IF YOU HAVE ANY LOGIC IN THE CONTROLLER IT IS BAD!
    //     //So we are calling the service function we want.
    //     return productService.example();
    // }

    @RequestMapping(method = RequestMethod.GET, value = "/users/getAll")
    @ApiOperation(value = "Returns all users from database." )
    public Iterable<User> getAll()
    {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/get/{userName, password}")
    @ApiOperation(value = "Verifies that username and password exist and match." )
    public boolean verifyUser(@RequestParam String userName, String password)
    {
        return userService.verifyUser(userName, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/addUser")
    @ApiOperation(value = "Adds a user to the database." )
    public void addUser(@RequestBody User user)
    {
        userService.add(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/cart/addToCart")
    @ApiOperation(value = "Adds item to a users cart." )
    public void addToCart(String userName, String productId, int quantity)
    {
        userService.addToCart(userName, productId, quantity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/cart/checkout")
    @ApiOperation(value = "Empties users cart and reduces the available stock of the product." )
    public void checkout(String userName)
    {
        userService.checkout(userName);
    }

    //NETWORKING QUICK REFERENCE
    //IF @RequestMapping(method = RequestMethod.GET, value = "/example/{var}")
    //Then you should use @RequestParam to get the variable, like so
    // public returnType getVar(@RequestParam DataType var)

    //IF  @RequestMapping(method = RequestMethod.POST, value = "/example")
    //Then you should use @RequestBody to get the variable, like so.
    //public returnType foo(@RequestBody dataType var)

    //Put and Delete will use either. They can also be compiled.
    // So IF @RequestMapping(value = "/{pathVar}", method = RequestMethod.PUT)
    //public void foo(@RequestParam dataType pathVar, @RequestBody dataType postVar)


}