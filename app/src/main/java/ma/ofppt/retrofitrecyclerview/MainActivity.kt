package ma.ofppt.retrofitrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var githubViewModel: RepoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        githubViewModel = ViewModelProvider(this).get(RepoViewModel::class.java)
        githubViewModel.getRepos()

        githubViewModel.repoList.observe(this,{list ->
            //TODO : modifier l'adapter
        })

    }
}