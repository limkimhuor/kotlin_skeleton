package skeleton.web.controllers.front

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Suppress("unused")
@RequestMapping("/")
@Controller
class TopController {
    @GetMapping
    fun get() = "top"
}