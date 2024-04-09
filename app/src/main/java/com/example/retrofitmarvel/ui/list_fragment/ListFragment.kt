package com.example.retrofitmarvel.ui.list_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.data.domain.usecase.GetMarvelUseCase
import com.example.retrofitmarvel.databinding.FragmentListBinding
import com.example.retrofitmarvel.injection.InjectionSingleton
import com.example.retrofitmarvel.ui.list_fragment.adapter.HeroAdapter
import kotlinx.coroutines.launch


class ListFragment : Fragment(), HeroAdapter.CellClickListener {

    private lateinit var mBinding: FragmentListBinding
    private lateinit var mAdapter: HeroAdapter
    private val mViewModel: ListFragmentViewModel =
        ListFragmentViewModel(GetMarvelUseCase(InjectionSingleton.provideDataSource()))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentListBinding.inflate(inflater, container, false)

        setupAdapter()

        setupViewModel()

        //mViewModel.getHeroes()
        mViewModel.getPageOfHeroes()

        setupScrollListener()


        return mBinding.root
    }

    /*private fun setupViewModel() {
        lifecycleScope.launch {
            mViewModel.heroes.collect {
                mAdapter.refreshData(it)
            }
        }
    }*/

    private fun setupViewModel() {
        lifecycleScope.launch {
            mViewModel.uiState.collect{uiState ->
                when (uiState) {

                    is ListFragmentUiState.Error -> {
                        mBinding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(),
                            "Ha ocurrido un error: ${uiState.msg}",
                            Toast.LENGTH_SHORT).show()
                    }

                    ListFragmentUiState.Loading -> {
                        mBinding.progressBar.visibility = View.VISIBLE
                    }

                    is ListFragmentUiState.Success -> {
                        mBinding.progressBar.visibility = View.GONE
                        mAdapter.refreshData(uiState.heroList)
                    }
                }
            }
        }
    }

    private fun setupScrollListener() {
        mBinding.recyclerView.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                    val layoutManager = mBinding.recyclerView.layoutManager
                    val visibleItemCount = layoutManager?.childCount ?: 0
                    val totalItemCount = layoutManager?.itemCount ?: 0
                    val firstVisibleItemPosition =
                        (layoutManager as? LinearLayoutManager)?.findFirstVisibleItemPosition() ?: 0

                    if (firstVisibleItemPosition + visibleItemCount >= totalItemCount) {
                        setupViewModel()
                        mViewModel.getPageOfHeroes()
                    }
                }
            })
    }

    private fun setupAdapter() {
        mAdapter = HeroAdapter(requireContext(), arrayListOf(), this)
        val listLayout = LinearLayoutManager(requireContext())

        mBinding.recyclerView.setHasFixedSize(true)
        mBinding.recyclerView.layoutManager = listLayout
        mBinding.recyclerView.adapter = mAdapter
    }

    override fun onCellClick(heroModel: HeroModel) {
        findNavController().navigate(
            ListFragmentDirections
                .actionListFragmentToDetailFragment(
                    img = heroModel.largeThumbnailPath,
                    name = heroModel.name,
                    description = heroModel.description
                )
        )
    }
}