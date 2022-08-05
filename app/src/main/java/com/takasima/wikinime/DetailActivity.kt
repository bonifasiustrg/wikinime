package com.takasima.wikinime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CHAR = "extra_char"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Info Detail"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val intent = intent.getParcelableExtra<Character>(EXTRA_CHAR)

        Glide.with(this).load(intent?.photo).into(detail_image)
        detail_name.text = intent?.name
        detail_character.text = intent?.detail
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
