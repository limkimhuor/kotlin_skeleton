package skeleton.web.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Suppress("unused")
@RequestMapping("/error")
@Controller
class ErrorController {
    @RequestMapping("/401")
    fun unauthorized() = "error/401"

    @RequestMapping("/403")
    fun forbidden() = "error/403"

    @RequestMapping("/404")
    fun notFound() = "error/404"

    @RequestMapping("/500")
    fun internalServerError() = "error/500"
}
