package com.takasima.wikinime


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.takasima.wikinime.DetailActivity.Companion.EXTRA_CHAR
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val characterAdapter = CharacterAdapter()
    private val listCharacter = ArrayList<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setTheme(R.style.splashScreen)
        setContentView(R.layout.activity_main)

        fromResourceToList()

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = characterAdapter

        sendDataToDetail()
    }

    @SuppressLint("Recycle")
    private fun fromResourceToList() {
        val resourceImage = resources.obtainTypedArray(R.array.photo)
        val resourceName = resources.getStringArray(R.array.name)
        val resourceGenre =  resources.getStringArray(R.array.detail)

        for (i in resourceName.indices) {
            val itemCharacter = Character(
                resourceImage.getResourceId(i, -1),
                resourceName[i],
                resourceGenre[i]
            )
            listCharacter.add(itemCharacter)
        }

        characterAdapter.setData(listCharacter)
    }

    private fun sendDataToDetail() {
        characterAdapter.setOnItemClickListener(object : CharacterAdapter.OnItemClickListener{
            override fun onItemClicked(character: Character) {
                val characterParcel = Character(
                    character.photo,
                    character.name,
                    character.detail
                )
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(EXTRA_CHAR, characterParcel)
                startActivity(intent)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentPindah : Intent
        when (item.itemId) {
            R.id.menu_profile -> {
                title = "WIKINIME"
                intentPindah = Intent(this, AboutActivity::class.java)
                startActivity(intentPindah)
            }
        }
        supportActionBar?.title = title
        return true
    }
}

