package com.example.pardi_anna_kopapirollo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AlertDialog;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonRock;
    private Button buttonPaper;
    private Button buttonScissors;
    private TextView textViewResult;
    private ImageView imagePlayerChoice;
    private ImageView imageRobotChoice;
    private int playerWins = 0;
    private int robotWins = 0;
    private int playerChoice = 0; //0 = rock, 1=paper, 2 = scissors
    private int robotChoice = 0;
    private Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        buttonRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = 0;
                Match();
            }
        });
        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = 1;
                Match();
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerChoice = 2;
                Match();
            }
        });

    }

    public void init(){
        buttonRock = findViewById(R.id.buttonRock);
        buttonPaper = findViewById(R.id.buttonPaper);
        buttonScissors = findViewById(R.id.buttonScissors);
        textViewResult = findViewById(R.id.textViewResult);
        imagePlayerChoice = findViewById(R.id.imagePlayerChoice);
        imageRobotChoice = findViewById(R.id.imageRobotChoice);
        random = new Random();
    }

    public void Match(){
        robotChoice = random.nextInt(3);
        if (playerChoice == robotChoice){
            //tie
        }else if(robotChoice == 0 && playerChoice == 2
              || robotChoice == 1 && playerChoice == 0
              || robotChoice == 2 && playerChoice == 1)
        {
            // robot won
            robotWins++;
        }else{
            playerWins++;
            //player won
        }
        updateVisuals();
        //most nem ellenőrzök hibát
    }

    public void updateVisuals(){
        switch (playerChoice){
            case 0: imagePlayerChoice.setImageResource(R.drawable.rock);
            break;
            case 1: imagePlayerChoice.setImageResource(R.drawable.paper);
            break;
            case 2: imagePlayerChoice.setImageResource(R.drawable.scissors);
            break;
        }
        switch (robotChoice){
            case 0: imageRobotChoice.setImageResource(R.drawable.rock);
                break;
            case 1: imageRobotChoice.setImageResource(R.drawable.paper);
                break;
            case 2: imageRobotChoice.setImageResource(R.drawable.scissors);
                break;
        }

        textViewResult.setText(String.format("Eredmény: Ember: %d Robot: %d",playerWins,robotWins));

    }



}