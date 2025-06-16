package nekit.corporation.yurtify.data.api

import nekit.corporation.data.dto.UserDto
import retrofit2.http.GET

interface ApiUser {
    @GET
    fun getProfile(): UserDto
}