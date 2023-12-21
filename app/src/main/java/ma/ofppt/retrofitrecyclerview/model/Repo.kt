package ma.ofppt.retrofitrecyclerview.model

import com.squareup.moshi.Json

data class Repo(
    @field:Json(name="id")
    val id : Long,
    @field:Json(name="name")
    val name : String,
    @field:Json(name="owner")
    val user : Owner
)

data class Owner(
    @field:Json(name="id")
      val id : Long,
      @field:Json(name="login")
    val name : String
        )