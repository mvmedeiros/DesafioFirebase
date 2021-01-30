package com.example.desafiofirebase.login.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.desafiofirebase.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_signup.*

class SignupFragment : Fragment() {

    private lateinit var _view: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        _view.findViewById<Button>(R.id.btnCreateAccountRegister).setOnClickListener {
            val name = _view.findViewById<TextInputEditText>(R.id.txtNameRegister)
            val email = _view.findViewById<TextInputEditText>(R.id.txtEmailRegister)
            val password = _view.findViewById<TextInputEditText>(R.id.txtPasswordRegister)
            val repeatPassword = _view.findViewById<TextInputEditText>(R.id.txtRepeatPasswordRegister)

            createAccount(name, email, password, repeatPassword)

        }

    }

    private fun createAccount(
        name: TextInputEditText,
        email: TextInputEditText,
        password: TextInputEditText,
        repeatPassword: TextInputEditText
    ) {

        val nameRegister = name.text.toString()
        val emailRegister: String = email.text.toString()
        val passwordRegister = password.text.toString()
        val repeatPassRegister = repeatPassword.text.toString()

        if (nameRegister.isEmpty()) {
            view?.findViewById<TextInputEditText>(R.id.txtNameRegister)!!.error = "O campo não pode ser vazio!"
        } else if (emailRegister.isEmpty()) {
            view?.findViewById<TextInputEditText>(R.id.txtEmailRegister)!!.error = "O campo não pode ser vazio!"
        } else if (passwordRegister.isEmpty()) {
            view?.findViewById<TextInputEditText>(R.id.txtPasswordRegister)!!.error = "O campo não pode ser vazio!"
        } else if (repeatPassRegister.isEmpty()) {
            view?.findViewById<TextInputEditText>(R.id.txtRepeatPasswordRegister)!!.error =
                "O campo não pode ser vazio!"
        } else if (passwordRegister != repeatPassRegister) {
            view?.findViewById<TextInputEditText>(R.id.txtRepeatPasswordRegister)!!.error =
                "As senhas precisam ser iguais!."
        } else {

            _view.findNavController()
                .navigate(R.id.action_signupFragment_to_loginFragment)
        }
    }

}