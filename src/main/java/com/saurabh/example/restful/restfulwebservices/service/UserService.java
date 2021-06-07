package com.saurabh.example.restful.restfulwebservices.service;

import com.saurabh.example.restful.restfulwebservices.dto.User;
import com.saurabh.example.restful.restfulwebservices.exceptions.UserAlreadyExistsException;
import com.saurabh.example.restful.restfulwebservices.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    private static List<User> users=new ArrayList<>();
    private static Integer userCount=0;
    static {
        users.add(new User(1,"Saurabh",new Date()));
        users.add(new User(2,"Pankaj",new Date()));
        users.add(new User(3,"Varun",new Date()));
        users.add(new User(4,"Shilpa",new Date()));
        users.add(new User(5,"Bokya",new Date()));
        userCount=users.size();
    }

    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        if(users.stream().anyMatch(userX -> userX.equals(user)))
            try {
                throw new UserAlreadyExistsException("User already exists...."+user,user);
            } catch (UserAlreadyExistsException e) {
                e.printStackTrace();
            }
        if(user.getUserId()==null){
            user.setUserId(++userCount);
        }
        users.add(user);
        return user;
    }
    public User findOne(Integer userId){
      return   users.stream().filter(user->user.getUserId().equals(userId))
              .findFirst()
              .orElseThrow(
                      ()->new UserNotFoundException("User "+userId+" not found"));
    }

    public User delete(Integer userId){
        Iterator<User> userIterator=users.iterator();
        while (userIterator.hasNext()){
            User userTobeDeleted=userIterator.next();
            if(userTobeDeleted.getUserId().equals(userId)) {
                userIterator.remove();
                return userTobeDeleted;
            }
        }
        return null;
    }
}
