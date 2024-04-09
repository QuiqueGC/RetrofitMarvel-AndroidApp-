package com.example.retrofitmarvel.ui.detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofitmarvel.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()


    private lateinit var mBinding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        mBinding = FragmentDetailBinding.inflate(inflater, container, false)

        with(mBinding) {
            tvHeroName.text = args.name
            tvDescription.text = args.description
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }

        }

        Glide.with(requireContext())
            .load(args.img)
            .apply(RequestOptions().centerInside())
            .into(mBinding.imgHero)
        return mBinding.root
    }
}