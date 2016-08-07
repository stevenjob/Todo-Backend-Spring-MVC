package com.sjob;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@CrossOrigin
@RequestMapping("/")
public class TodoController {

    private Map<Integer, Todo> todos;

    private int currentId;

    public TodoController() {
        todos = new HashMap<Integer, Todo>();
        currentId = 0;
    }

    @RequestMapping(method = GET)
    public @ResponseBody List<Todo> getAll() {
        return new ArrayList<Todo>(todos.values());
    }

    @RequestMapping(method = GET, value = "/{id}")
    public @ResponseBody Todo getTodoById(@PathVariable int id) {
        return todos.get(id);
    }

    @RequestMapping(method = POST)
    public @ResponseBody Todo createTodo(@RequestBody final Todo todo, HttpServletRequest request) {
        todo.setUrl(URI.create(request.getRequestURL() + "/" + currentId));
        todo.setId((long) currentId);
        todos.put(currentId++, todo);
        return todo;
    }

    @RequestMapping(method = PATCH, value = "/{id}")
    public @ResponseBody Todo update(@PathVariable int id, @RequestBody Todo todo) {
        return todos.get(id).patchWith(todo);
    }

    @RequestMapping(method = DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody void deleteAll() {
        todos.clear();
    }

    @RequestMapping(method = DELETE, value = "/{id}")
    public @ResponseBody void deleteTodo(@PathVariable int id) {
        todos.remove(id);
    }
}
