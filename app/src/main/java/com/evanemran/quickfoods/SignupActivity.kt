package com.evanemran.quickfoods

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.concurrent.TimeUnit

class SignupActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    var databaseReference: DatabaseReference? = null
    var phoneNumber = ""
    private var verificationId = ""
    private var authStateListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()

        authStateListener = AuthStateListener { firebaseAuth ->
            val firebaseUser = firebaseAuth.currentUser
            if (firebaseUser != null) {
                Toast.makeText(this@SignupActivity, "Welcome!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@SignupActivity, MainActivity::class.java)
                startActivity(intent)
                this@SignupActivity.finish()
            } else {
                Toast.makeText(this@SignupActivity, "Please Login", Toast.LENGTH_SHORT).show()
            }
        }

        button_signup.setOnClickListener(View.OnClickListener {
            phoneNumber = editTextPhone.getText().toString()
            if (phoneNumber.isEmpty()) {
                editTextPhone.setError("Enter phone number.")
                return@OnClickListener
            }
            val phone = "+88$phoneNumber"
            sendVerificationCode(phone)
        })

        button_verify.setOnClickListener {
            val code = editTextOtp.text.toString()
            verifyCode(code)
        }
    }

    private fun sendVerificationCode(number: String) {
        // this method is used for getting
        // OTP on user phone number.
        val options = PhoneAuthOptions.newBuilder(mAuth!!)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(mCallBack) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private val mCallBack: OnVerificationStateChangedCallbacks =
        object : OnVerificationStateChangedCallbacks() {
            // below method is used when
            // OTP is sent from Firebase
            override fun onCodeSent(s: String, forceResendingToken: ForceResendingToken) {
                super.onCodeSent(s, forceResendingToken)
                // when we receive the OTP it
                // contains a unique id which
                // we are storing in our string
                // which we have already created.
                verificationId = s
                otp_container.visibility = View.VISIBLE
            }

            // this method is called when user
            // receive OTP from Firebase.
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
                // below line is used for getting OTP code
                // which is sent in phone auth credentials.
                val code = phoneAuthCredential.smsCode

                // checking if the code
                // is null or not.
                if (code != null) {
                    // if the code is not null then
                    // we are setting that code to
                    // our OTP edittext field.
                    editTextOtp.setText(code)

                    // after setting this code
                    // to OTP edittext field we
                    // are calling our verifycode method.
                    verifyCode(code)
                }
            }

            // this method is called when firebase doesn't
            // sends our OTP code due to any error or issue.
            override fun onVerificationFailed(e: FirebaseException) {
                // displaying error message with firebase exception.
                Toast.makeText(this@SignupActivity, e.message, Toast.LENGTH_LONG).show()
            }
        }

    private fun verifyCode(code: String) {
        // below line is used for getting
        // credentials from our verification id and code.
        val credential = PhoneAuthProvider.getCredential(verificationId, code)

        // after getting credential we are
        // calling sign in method.
        signInWithCredential(credential)
    }

    private fun signInWithCredential(credential: PhoneAuthCredential) {
        // inside this method we are checking if
        // the code entered is correct or not.
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // if the code is correct and the task is successful
                    // we are sending our user to new activity.
                    val user = mAuth!!.currentUser
                    val profileUpdates = UserProfileChangeRequest.Builder()
                        .setDisplayName(editTextName.text.toString()).build()
                    user!!.updateProfile(profileUpdates).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(ContentValues.TAG, "User profile updated.")
                        }
                    }
                    val i = Intent(this@SignupActivity, MainActivity::class.java)
                    startActivity(i)
                    finish()
                } else {
                    // if the code is not correct then we are
                    // displaying an error message to the user.
                    Toast.makeText(this@SignupActivity, task.exception!!.message, Toast.LENGTH_LONG)
                        .show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener(authStateListener!!)
    }
}