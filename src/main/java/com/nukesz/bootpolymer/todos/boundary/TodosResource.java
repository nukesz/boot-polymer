package com.nukesz.bootpolymer.todos.boundary;

import com.nukesz.bootpolymer.todos.entity.Todo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class TodosResource {

    @RequestMapping(path= "todos", method = RequestMethod.GET)
    public List<Todo> all() {
        return Arrays.asList(new Todo("todo1"), new Todo("todo2"));
    }
}
