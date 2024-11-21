package com.example.tpspring;

import com.example.tpspring.entities.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/roles")
public class RoleController {
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewRole (@RequestBody String name) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Role> getAllRoles() {
        // This returns a JSON or XML with the users
        return roleRepository.findAll();
    }
}
