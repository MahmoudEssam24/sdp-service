package sa.com.mcp.ai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elder")
public class ElderController {

    @GetMapping("maid")
    public String create() {
        return "House maid has been requested";
    }

    @GetMapping("checkup")
    public String getCheckup() {
        return "House Checkup has been requested";
    }
}
