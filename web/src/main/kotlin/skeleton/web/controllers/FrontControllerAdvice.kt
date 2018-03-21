package skeleton.web.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import phoneappli.pacd3.common.exceptions.HttpStatusException
import javax.servlet.http.HttpServletResponse

@Suppress("unused")
@ControllerAdvice("skeleton.web.controllers.front")
class FrontControllerAdvice {

    @ExceptionHandler(HttpStatusException::class)
    fun handleHttpStatusException(e: HttpStatusException, response: HttpServletResponse): String {
        response.status = e.httpStatus.value()
        return when (e.httpStatus) {
            HttpStatus.UNAUTHORIZED,
            HttpStatus.FORBIDDEN,
            HttpStatus.NOT_FOUND,
            HttpStatus.INTERNAL_SERVER_ERROR -> "error/${e.httpStatus.value()}"
            else -> "error/500"
        }
    }
}
