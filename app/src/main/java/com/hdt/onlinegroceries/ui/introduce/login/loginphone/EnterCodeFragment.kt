package com.hdt.onlinegroceries.ui.introduce.login.loginphone

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.hdt.onlinegroceries.R
import com.hdt.onlinegroceries.base.ui.BaseFragment
import com.hdt.onlinegroceries.databinding.FragmentEnterCodeBinding
import com.hdt.onlinegroceries.extension.onClick
import com.hdt.onlinegroceries.extension.stringArgument
import com.hdt.onlinegroceries.ui.MainActivity
import java.util.concurrent.TimeUnit


class EnterCodeFragment  : BaseFragment<FragmentEnterCodeBinding, MainActivity>() {

    private val phone by stringArgument("phone")

    private var mAuth: FirebaseAuth? = null
    private var verificationId = ""

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEnterCodeBinding = FragmentEnterCodeBinding.inflate(inflater)

    override fun setupView() {
        sendVerificationCode(phone!!)

        binding.btnBack.onClick { popBackStack() }
        binding.btnNext.onClick { verifyCode(binding.edtCode.text.toString()) }
    }

    override fun setupData() {

    }

    private val mCallBack: OnVerificationStateChangedCallbacks =
        object : OnVerificationStateChangedCallbacks() {
            override fun onCodeSent(s: String, forceResendingToken: ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                verificationId = s
            }

            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                val code = phoneAuthCredential.smsCode

                if (code != null) {
                    binding.edtCode.setText(code)
                }
            }
            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(requireContext(), e.message, Toast.LENGTH_LONG).show()
            }
        }


    private fun sendVerificationCode(number: String) {
        mAuth = FirebaseAuth.getInstance()
        val options = PhoneAuthOptions.newBuilder(mAuth!!)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(activity as MainActivity) // Activity (for callback binding)
            .setCallbacks(mCallBack) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun verifyCode(code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithCredential(credential)
    }

    private fun signInWithCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    navigateTo(R.id.action_enterCodeFragment_to_shopFragment)

                } else {
                    // if the code is not correct then we are
                    // displaying an error message to the user.
                }
            }
    }

}