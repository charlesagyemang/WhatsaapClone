package com.example.pianoafrik.whatsaapclone;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.pianoafrik.whatsaapclone.fakemodel.Chat;

public class ChatActivity extends FunctionActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#045f50")));


        imageView = (ImageView)findViewById(R.id.imager) ;
        Chat chat  = (Chat)getIntent().getSerializableExtra(HomeActivity.CHAT_KEY);
        imageView.setImageResource(chat.getProfilePicture());
        myToolbar.setLogo(chat.getProfilePicture());

    }
}
