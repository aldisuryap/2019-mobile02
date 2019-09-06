package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText inputNumber;
	private Button guessButton, resetButton;
	private int randomNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		initRandomNumber();
		inputNumber = findViewById(R.id.number_input);
		guessButton = findViewById(R.id.guess_button);
		resetButton = findViewById(R.id.reset_button);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random number = new Random();
		randomNumber = number.nextInt(100-1) + 1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		if (inputNumber.getText().toString().isEmpty()) {
			Toast.makeText(this,"Harus mengisi tebakan", Toast.LENGTH_SHORT).show();
		} else {
			int convertTebak = Integer.parseInt(inputNumber.getText().toString());
			if (convertTebak == randomNumber) {
				Toast.makeText(this, "Tebakan anda benar", Toast.LENGTH_SHORT).show();
				guessButton.setEnabled(false);
			} else if (convertTebak < randomNumber) {
				Toast.makeText(this, "Tebakan anda terlalu kecil", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "Tebakan anda terlalu besar", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		initRandomNumber();
		inputNumber.setText("");
		guessButton.setEnabled(true);
	}
}
