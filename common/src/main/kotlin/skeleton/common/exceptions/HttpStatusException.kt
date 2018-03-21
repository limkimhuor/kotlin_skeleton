package phoneappli.pacd3.common.exceptions

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus

open class HttpStatusException(
    val httpStatus: HttpStatus,
    message: String
) : RuntimeException(message) {

    fun toResponseJson(): String =
        responseObjectMapper.writeValueAsString(this)

    companion object {
        @JvmStatic
        val responseObjectMapper = ObjectMapper().apply {
            addMixIn(HttpStatusException::class.java, HttpStatusExceptionMixin::class.java)
        }
    }
}

@JsonAutoDetect(
    getterVisibility = JsonAutoDetect.Visibility.NONE,
    isGetterVisibility = JsonAutoDetect.Visibility.NONE,
    fieldVisibility = JsonAutoDetect.Visibility.NONE
)
interface HttpStatusExceptionMixin {
    @get:JsonProperty val httpStatus: HttpStatus
    @get:JsonProperty val message: String?
}

class UnauthorizedException(message: String) : HttpStatusException(HttpStatus.UNAUTHORIZED, message)

class NotFoundException(message: String) : HttpStatusException(HttpStatus.NOT_FOUND, message)

class InternalServerErrorException(message: String) : HttpStatusException(HttpStatus.INTERNAL_SERVER_ERROR, message)

class AccesssDeniedException(message: String) : HttpStatusException(HttpStatus.FORBIDDEN, message)