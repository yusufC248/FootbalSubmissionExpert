package com.yusuf.submissionexpert.ui.clubs

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.yusuf.core.data.Resource
import com.yusuf.core.ui.ClubAdapter
import com.yusuf.submissionexpert.R
import com.yusuf.submissionexpert.databinding.FragmentClubsBinding
import com.yusuf.submissionexpert.ui.detail.DetailActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ClubsFragment : Fragment() {

    private val clubsViewModel: ClubsViewModel by viewModel()
    private var _binding: FragmentClubsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentClubsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val clubAdapter = ClubAdapter()
            clubAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }

            clubsViewModel.club.observe(viewLifecycleOwner, { club ->
                if (club != null) {
                    when (club) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            clubAdapter.setData(club.data)
                            binding.progressBar.visibility = View.GONE
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.errorNotification.root.visibility = View.VISIBLE
                            binding.errorNotification.tvError.text = club.message ?: getString(R.string.error_notif)
                        }
                    }
                }
            })
            with(binding.rvClubs) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = clubAdapter
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}