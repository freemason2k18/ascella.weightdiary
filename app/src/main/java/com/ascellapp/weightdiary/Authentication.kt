package com.ascellapp.weightdiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ActionMode
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import kotlinx.android.synthetic.main.activity_authentication.*
import java.util.*

class Authentication : AppCompatActivity() {


    lateinit var providers : List <AuthUI.IdpConfig>
    val MY_REQUEST_CODE: Int = 7117 // Any numbers you want

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        //Init
        providers = Arrays.asList<AuthUI.IdpConfig> (
            AuthUI.IdpConfig.EmailBuilder().build(), // Email login
            AuthUI.IdpConfig.GoogleBuilder().build(), // Google login
            AuthUI.IdpConfig.FacebookBuilder().build(), // Facebook login
            AuthUI.IdpConfig.PhoneBuilder().build() // Phone login
        )

        showSingInOptions()

        //Event
        btn_sing_out.setOnClickListener{
            //SingOut
            AuthUI.getInstance().signOut(this@Authentication)
                .addOnCompleteListener {
                    btn_sing_out.isEnabled=false
                    showSingInOptions()
                }
                .addOnFailureListener {
                    e->Toast.makeText(this@Authentication, e.message,Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == MY_REQUEST_CODE)
        {
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode == Activity.RESULT_OK)
            {
              val user = FireBaseAuth.getInstance().currentUser // Get current user
              Toast.makeText(this,""+user!!.email,Toast.LENGTH_SHORT).show()

                btn_sing_out.isEnabled = true
            }
            else
                (
                    Toast.makeText(this,""+response!!.error!!.message,Toast.LENGTH_SHORT).show()
                        )
        }
    }


    private fun showSingInOptions() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTheme(R.style.AppTheme)
            .build(), MY_REQUEST_CODE)
    }
}
