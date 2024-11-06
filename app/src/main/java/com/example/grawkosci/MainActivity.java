package com.example.grawkosci;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView dice1, dice2, dice3, dice4, dice5;
    private TextView textRollResult, textGameResult, textRollCount;
    private int gameScore = 0, rollCount = 0;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicjalizacja widoków
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        dice3 = findViewById(R.id.dice3);
        dice4 = findViewById(R.id.dice4);
        dice5 = findViewById(R.id.dice5);
        textRollResult = findViewById(R.id.textRollResult);
        textGameResult = findViewById(R.id.textGameResult);
        textRollCount = findViewById(R.id.textRollCount);
        Button buttonRollDice = findViewById(R.id.buttonRollDice);
        Button buttonReset = findViewById(R.id.buttonReset);

        random = new Random();

        // Obsługa przycisku "RZUĆ KOŚĆMI"
        buttonRollDice.setOnClickListener(v -> rollDice());

        // Obsługa przycisku "RESETUJ WYNIK"
        buttonReset.setOnClickListener(v -> resetGame());
    }

    private void rollDice() {
        int[] diceValues = new int[5];
        int rollScore = 0;

        for (int i = 0; i < 5; i++) {
            diceValues[i] = random.nextInt(6) + 1;
            rollScore += diceValues[i];
        }

        // Aktualizacja wyników na ekranie
        dice1.setText(String.valueOf(diceValues[0]));
        dice2.setText(String.valueOf(diceValues[1]));
        dice3.setText(String.valueOf(diceValues[2]));
        dice4.setText(String.valueOf(diceValues[3]));
        dice5.setText(String.valueOf(diceValues[4]));

        textRollResult.setText("Wynik tego losowania: " + rollScore);
        gameScore += rollScore;
        textGameResult.setText("Wynik gry: " + gameScore);
        rollCount++;
        textRollCount.setText("Liczba rzutów: " + rollCount);
    }

    private void resetGame() {
        // Resetowanie wartości
        dice1.setText("?");
        dice2.setText("?");
        dice3.setText("?");
        dice4.setText("?");
        dice5.setText("?");

        textRollResult.setText("Wynik tego losowania: 0");
        textGameResult.setText("Wynik gry: 0");
        textRollCount.setText("Liczba rzutów: 0");

        gameScore = 0;
        rollCount = 0;
    }
}
