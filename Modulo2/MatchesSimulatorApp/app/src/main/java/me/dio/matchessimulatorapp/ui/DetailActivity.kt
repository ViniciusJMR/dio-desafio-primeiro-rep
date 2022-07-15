package me.dio.matchessimulatorapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.FieldClassification
import com.bumptech.glide.Glide
import me.dio.matchessimulatorapp.databinding.ActivityDetailBinding
import me.dio.matchessimulatorapp.domain.Match

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding

    object Extras {
        const val MATCH:String = "EXTRA_MATCH"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadMatchFromExtra()
    }

    private fun loadMatchFromExtra(){
        intent?.extras?.getParcelable<Match>(Extras.MATCH).let {
            Glide.with(this).load(it?.place?.image).into(binding.ivPlace)
            supportActionBar?.title = it?.place?.name
        }
    }

}