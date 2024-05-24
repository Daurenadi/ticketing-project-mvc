
package com.cydeo.controller;

import com.cydeo.dto.ProjectDTO;


import com.cydeo.service.ProjectService;

import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@Controller
@RequestMapping("/project")
public class ProjectController {

    private final UserService userService;
    private final ProjectService projectService;

    public ProjectController(UserService userService, ProjectService projectService) {
        this.userService = userService;
        this.projectService = projectService;
    }

    @GetMapping("/create")
    public String createProject(Model model){

        model.addAttribute("project", new ProjectDTO());
        model.addAttribute("managers", userService.ListAllByRole("manager"));
        model.addAttribute("projects", projectService.findAll());



        return "/project/create";
    }

    @PostMapping("/create")
    public String insertProject(@ModelAttribute("project") ProjectDTO project, BindingResult bindingResult, Model model){

      //  if (bindingResult.hasErrors()) {

            model.addAttribute("managers", userService.ListAllByRole("manager"));
            model.addAttribute("projects", projectService.findAll());



       // }

        projectService.save(project);


        return "redirect:/project/create";

    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){

        projectService.deleteById(projectCode);



        return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectCode}")
    private String completeProject(@PathVariable("projectCode") String projectCode){

        projectService.complete(projectCode);

        return "redirect:/project/create";
    }



    @GetMapping("/update/{projectCode}")
    public String editUser(@PathVariable("projectCode") String projectCode, Model model){
        model.addAttribute("project", projectService.findByProjectCode(projectCode));
        model.addAttribute("managers", userService.ListAllByRole("manager"));
        model.addAttribute("projects", projectService.findAll());

        return "/project/update";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("project") ProjectDTO project){




        projectService.update(project);


        return "redirect:/project/create";

    }
    /*

    @GetMapping("/manager/project-status")
    public String getProjectByManager(Model model) {

        UserDTO manager = userService.findById("john@cydeo.com");

        List<ProjectDTO> projects = projectService.getCountedListOfProjectDTO(manager);


        model.addAttribute("projects", projects);

        return "/manager/project-status";

    }

    @GetMapping("/manager/complete/{projectCode}")
    public String managerCompleteProject(@PathVariable("projectCode") String projectCode) {
        projectService.complete(projectService.findById(projectCode));
        return "redirect:/project/manager/project-status";
    }
    */

}

