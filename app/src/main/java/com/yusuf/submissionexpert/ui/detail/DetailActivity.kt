package com.yusuf.submissionexpert.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.yusuf.core.domain.Club
import com.yusuf.submissionexpert.R
import com.yusuf.submissionexpert.databinding.ActivityDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailClub = intent.getParcelableExtra<Club>(EXTRA_DATA)
        showDetailTourism(detailClub)
    }

    private fun showDetailTourism(detailClub: Club?) {
        detailClub?.let {
            binding.apply {
                supportActionBar?.title = detailClub.name
                tvDetailName.text = detailClub.name
                tvStadium.text = detailClub.stadium
                tvDetailDescription.text = detailClub.description
                Glide.with(this@DetailActivity)
                    .load(detailClub.stadiumImage)
                    .into(binding.stadiumImage)

                var statusFavorite = detailClub.isFavorite
                setStatusFavorite(statusFavorite)
                fabFavorite.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailViewModel.setFavoriteClub(detailClub, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24))
        } else {
            binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24))
        }
    }
}