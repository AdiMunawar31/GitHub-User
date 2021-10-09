package com.example.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserDetail extends AppCompatActivity {
    public static final String EXTRA_ITEM = "extra_item";

    ImageView imgAvatar;
    TextView tvName, tvUsername, tvCompany, tvLocation, tvRepository, tvFollower, tvFollowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        imgAvatar = findViewById(R.id.img_avatar);
        tvName = findViewById(R.id.tv_name);
        tvUsername = findViewById(R.id.tv_username);
        tvCompany = findViewById(R.id.tv_company);
        tvLocation = findViewById(R.id.tv_location);
        tvRepository = findViewById(R.id.tv_repository);
        tvFollower = findViewById(R.id.tv_follower);
        tvFollowing = findViewById(R.id.tv_following);

        User user = getIntent().getParcelableExtra(EXTRA_ITEM);

        if (user != null){
            imgAvatar.setImageResource(user.getPhoto());
            tvName.setText(user.getName());
            tvUsername.setText(user.getUsername());
            tvCompany.setText("Company : " + user.getCompany());
            tvLocation.setText("Location : " + user.getLocation());
            tvRepository.setText("Repository : " + user.getRepository());
            tvFollower.setText(user.getFollowers() + " Followers");
            tvFollowing.setText(user.getFollowing() + " Following");
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail User");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}