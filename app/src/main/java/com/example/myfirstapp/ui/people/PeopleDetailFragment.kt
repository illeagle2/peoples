package com.example.myfirstapp.ui.people


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myfirstapp.data.model.people.PeopleItemModel
import com.example.myfirstapp.data.model.people.PeopleModel
import com.example.myfirstapp.databinding.FragmentPeopleBinding
import com.example.myfirstapp.databinding.FragmentPeopleDetailBinding
import com.example.myfirstapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PeopleDetailFragment(val person: PeopleItemModel) : Fragment() {

    private var _binding: FragmentPeopleDetailBinding? = null
    private val binding get() = _binding!!

    val bundle = arguments
    val args = PeopleDetailFragmentArgs.fromBundle(bundle!!)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPeopleDetailBinding.inflate(inflater, container, false)
        binding.textView.text = person.firstName
        
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}