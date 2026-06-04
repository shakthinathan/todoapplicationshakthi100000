package com.app.todoapp.controller;
//The Model object is used to transfer the data from the Controller to the UI page

import com.app.todoapp.Services.TaskService;
import com.app.todoapp.models.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model)
    {
        List<Task> tasks=taskService.getAllTasks();
        model.addAttribute("tasks",tasks);//addattribute adds data to the UI
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String title)
    {
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deletetask(@PathVariable Long id)
    {
        taskService.deletetask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggletask(@PathVariable Long id)
    {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
