package id.tisnahadiana.masakanpadangapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.tisnahadiana.masakanpadangapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val dataFood = intent.getParcelableExtra("key_food") as? Food

        if (dataFood != null) {
            binding.titleDetail.text = dataFood.name
            binding.descriptionDetail.text = dataFood.description
            binding.imageDetail.setImageResource(dataFood.photo)
        }

        binding.actionShare.setOnClickListener {
            val message = "Masakan Padang : ${dataFood?.name}"
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.putExtra(Intent.EXTRA_TEXT, message)
            shareIntent.type = "text/plain"

            val shareIntentChooser = Intent.createChooser(shareIntent, "Share via")
            startActivity(shareIntentChooser)
        }
    }
}