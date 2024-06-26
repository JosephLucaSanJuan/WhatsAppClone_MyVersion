package com.alanturing.cpifp.whatsappclone.chat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.alanturing.cpifp.whatsappclone.R
import com.alanturing.cpifp.whatsappclone.chat.data.Contact
import com.alanturing.cpifp.whatsappclone.chat.data.ContactsRepository
import com.alanturing.cpifp.whatsappclone.chat.data.Message
import com.alanturing.cpifp.whatsappclone.chat.data.MessageRepository
import com.alanturing.cpifp.whatsappclone.databinding.FragmentChatBinding
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatFragment : Fragment() {
    /** TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
    private lateinit var binding: FragmentChatBinding
    private val args: ChatFragmentArgs by navArgs()
    @Inject
    lateinit var contactRepository: ContactsRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = args.id

        //val contactRepository = ContactsRepository()
        val contact: Contact? = contactRepository.contacts.find {
            it.id == id
        }
        contact?.let { binding.contactName.text = "${it.name}" }

        /*val listAdapter = MessageListAdapter(::toChat)
        binding.chat.layoutManager = LinearLayoutManager(context)
        val repo = MessageRepository()
        listAdapter.submitList(repo.getMessages())
        binding.chat.adapter = listAdapter
        val rv = binding.contactName
        rv.setOnClickListener {
            val action = ChatListFragmentDirections.actionChatListFragmentToChatFragment()
            findNavController().navigate(action)
        }*/
    }

    /*private fun toChat(view: View, message: Message) {
        val action = ChatFragmentDirections.actionChatFragmentToMessageRepository(message.texto)
        findNavController().navigate(action)
    }*/
}