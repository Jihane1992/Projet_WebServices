package fr.ensiie.Hotelfiltering.controller;

import fr.ensiie.Hotelfiltering.entity.Hotel;
import fr.ensiie.Hotelfiltering.entity.User;
import fr.ensiie.Hotelfiltering.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private HotelService service;

    @PostMapping("/addUser")
    public User addHotel(@RequestBody User user){
        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return service.getUsers();
    }

    @PostMapping("/user")
    public String user(@RequestBody User user ){
        User oauthUser = service.loginget(user.getFirstname(),user.getPassword());
        System.out.println(oauthUser);
        if (Objects.nonNull(oauthUser)){
            return ("Welcome User "+oauthUser.getFirstname());
        }
        else {
            return ("User doesn't exist");
        }
    }

    @GetMapping("/userget")
    public int userget(@RequestParam("usrname") String username, @RequestParam("usrpassword") String userpassword){
        User user1 = service.loginget(username,userpassword);
        if (Objects.nonNull(user1)){
            return (1);
        }
        else {
            return (0);
        }
    }

}
