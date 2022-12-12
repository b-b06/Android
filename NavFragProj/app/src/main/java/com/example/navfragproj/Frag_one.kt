package com.example.navfragproj

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Frag_one.newInstance] factory method to
 * create an instance of this fragment.
 */
class Frag_one : Fragment() {
    // TODO: Rename and change types of parameters
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
        var view= inflater.inflate(R.layout.fragment_frag_one,container,false)

        var submitButton=view.findViewById<Button>(R.id.button)
        var txt=view.findViewById<TextView>(R.id.frag_one_textView)
        submitButton.setOnClickListener{
            var usernameEditText=view.findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
            var passwordEditText=view.findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            var bundle=Bundle()
            bundle.putString("key1",usernameEditText)
            bundle.putString("key2",passwordEditText)
            var fragTwo=Frag_two()
            fragTwo.arguments=bundle
            Navigation.findNavController(view).navigate(R.id.action_frag_one_to_frag_two,bundle)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Frag_one.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Frag_one().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}