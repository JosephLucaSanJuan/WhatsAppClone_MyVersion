package com.alanturing.cpifp.whatsappclone.chat.ui.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.alanturing.cpifp.whatsappclone.R
import com.alanturing.cpifp.whatsappclone.databinding.FragmentMessageListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MessageListFragment : Fragment() {

    companion object {
        fun newInstance() = MessageListFragment()
    }

    private lateinit var binding: FragmentMessageListBinding
    private val viewModel: MessageListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflater.inflate(R.layout.fragment_message_list, container, false)
        binding = FragmentMessageListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.messageList.collect {
                    Log.d("", "")
                    binding.listaMensajes.text = it.toString()
                }
            }
        }
    }

    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MessageListViewModel::class.java)
        // TODO: Use the ViewModel
    }*/

}