package com.example.daydayseoul.mypage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.daydayseoul.R;
import com.example.daydayseoul.sign.SignInActivity;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class MyPageActivity extends AppCompatActivity {

    private TextView nameTextView;
    private TextView emailTextView;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        auth = FirebaseAuth.getInstance();
        Button logout = (Button)findViewById(R.id.login_out_button);

        nameTextView = (TextView)findViewById(R.id.user_name_textView);
        emailTextView = (TextView)findViewById(R.id.user_email_textView);

        nameTextView.setText(auth.getCurrentUser().getDisplayName());
        emailTextView.setText(auth.getCurrentUser().getEmail());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                LoginManager.getInstance().logOut();
                finish();
                //
                Intent intent = new Intent(MyPageActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}
