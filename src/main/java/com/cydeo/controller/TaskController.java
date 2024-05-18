/*
package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.ProjectStatus;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import jdk.javadoc.doclet.DocletEnvironment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.StringBufferInputStream;
import javax.validation.Valid;

@Controller
@RequestMapping("/task")

public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;

    private final TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());


        return "/task/create";
    }
    @PostMapping("/create")
    public String insertTask(TaskDTO task){

        taskService.save(task);

        return "redirect:/task/create";
    }

    @GetMapping("/delete/{taskId}")
    private String deleteTask(@PathVariable("taskId") Long taskId){

        taskService.deleteById(taskId);

        return "redirect:/task/create";
    }

    @GetMapping("/update/{taskId}")
    private String editTask(@PathVariable("taskId") Long taskId, Model model){

        model.addAttribute("task", taskService.findById(taskId));
        model.addAttribute("projects", projectService.findAll());
        model.addAttribute("employees", userService.findEmployees());
        model.addAttribute("tasks", taskService.findAll());

        return "/task/update";
    }

    @PostMapping("/update/{id}")
    private String updateTask(TaskDTO task){

        taskService.update(task);

        return "redirect:/task/create";
    }

    @GetMapping("/employee/pending-tasks")
    public String employeePendingTasks(Model model){

        model.addAttribute("tasks", taskService.findAllPendingTasks(ProjectStatus.COMPLETE));




        return "/task/pending-tasks";
    }
    @GetMapping("/employee/archive")
    public String employeeArchivedTasks(Model model){

        model.addAttribute("tasks", taskService.findAllCompleteTasks(ProjectStatus.COMPLETE));

        return "/task/archive";
    }

    @GetMapping("/employee/edit/{id}")
    public String employeeEditTask(@PathVariable Long id, Model model){

      model.addAttribute("task", taskService.findById(id));

        model.addAttribute("statuses", ProjectStatus.values());
        model.addAttribute("tasks", taskService.findAllPendingTasks(ProjectStatus.COMPLETE));

        return "/task/status-update";
    }

    @PostMapping("/employee/update/{id}")
    public String employeeUpdateTask(@Valid @ModelAttribute("task") TaskDTO task, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("statuses", ProjectStatus.values());
            model.addAttribute("tasks", taskService.findAllPendingTasks(ProjectStatus.COMPLETE));

            return "/task/status-update";

        }

        taskService.updateTask(task);

        return "redirect:/task/employee/pending-tasks";

    }


}
*/
