package ma.ofppt.retrofitrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import ma.ofppt.retrofitrecyclerview.databinding.ActivityMainBinding
import ma.ofppt.retrofitrecyclerview.model.Repo

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var githubViewModel: RepoViewModel
    lateinit var adaper : RepoRecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        githubViewModel = ViewModelProvider(this).get(RepoViewModel::class.java)
        githubViewModel.getRepos()

        githubViewModel.repoList.observe(this,{list ->
            adaper = RepoRecyclerView(list)
            binding.recycler.adapter = adaper
            adaper.notifyDataSetChanged()
            list.forEach { Log.i("MyGitTAG",it.name) }
        })

    }
}