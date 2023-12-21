package ma.ofppt.retrofitrecyclerview

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ma.ofppt.retrofitrecyclerview.model.Repo
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RepoViewModel(application: Application) : AndroidViewModel(application) {
    val repoList = MutableLiveData<List<Repo>>()
    val githubAPI by lazy {
        val reto= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        reto.create(GithubService::class.java)
    }


    fun getRepos(){
        GlobalScope.launch(Dispatchers.IO) {
            val list = githubAPI.getRepos("oughzal")
            repoList.postValue(list)
            Log.i("MyGitTAG",list.size.toString())
        }
    }
}