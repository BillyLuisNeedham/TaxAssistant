package com.billyluisneedham.taxassistant.expenses.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.billyluisneedham.taxassistant.databinding.FragmentRecyclerviewFabBinding
import com.billyluisneedham.taxassistant.expenses.ExpenseAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class AllExpensesFragment: DaggerFragment() {

    private lateinit var adapter: ExpenseAdapter
    private lateinit var binding: FragmentRecyclerviewFabBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AllExpensesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        FragmentRecyclerviewFabBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            binding = this
        }

        binding.tvTEST.text = viewModel.someString

        return binding.root
    }
}