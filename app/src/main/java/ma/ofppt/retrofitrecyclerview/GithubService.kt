package ma.ofppt.retrofitrecyclerview
import ma.ofppt.retrofitrecyclerview.model.Repo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GithubService {
    @GET("{user}/repos")
    suspend fun getRepos(@Path("user") user : String) :List<Repo>




}