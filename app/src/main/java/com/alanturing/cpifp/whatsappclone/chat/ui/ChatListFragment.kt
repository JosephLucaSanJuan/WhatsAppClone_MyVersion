package com.alanturing.cpifp.whatsappclone.chat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alanturing.cpifp.whatsappclone.R
import com.alanturing.cpifp.whatsappclone.databinding.FragmentChatListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatListFragment : Fragment() {
    private lateinit var binding: FragmentChatListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val createChatButton = binding.createChatButton
        createChatButton.setOnClickListener {
            val action = ChatListFragmentDirections.actionChatListFragmentToSelectContactFragment()
            findNavController().navigate(action)
        }
    }
}