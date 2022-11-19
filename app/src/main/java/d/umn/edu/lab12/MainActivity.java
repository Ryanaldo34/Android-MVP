package d.umn.edu.lab12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Contract.ViewMVP {

    private Contract.Presenter presenter;
    private Button calcBtn;
    private Button saveBtn;
    private TextView leastMpgLabel;
    private TextView greatestMpgLabel;
    private TextView calculatedMpgLabel;
    // EditText elements in the form
    private EditText prevReading;
    private EditText currReading;
    private EditText fuelGallons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.presenter = new CalculatorPresenter(this, new Calculator());
        this.calcBtn = (Button) findViewById(R.id.calcButton);
        this.saveBtn = (Button) findViewById(R.id.saveButton);
        this.prevReading = (EditText) findViewById(R.id.prevReading);
        this.currReading = (EditText) findViewById(R.id.currReading);
        this.fuelGallons = (EditText) findViewById(R.id.fuelGallons);

        calcBtn.setOnClickListener(v -> this.presenter.onCalculateClicked(v));
        saveBtn.setOnClickListener(v -> this.presenter.onSaveClicked(v));
    }

    @Override
    public int getPrevReading() {
        return Integer.parseInt(prevReading.getText().toString());
    }

    @Override
    public int getCurrReading() {
        return Integer.parseInt(this.currReading.getText().toString());
    }

    @Override
    public int getFuelGallons() {
        return Integer.parseInt(this.fuelGallons.getText().toString());
    }

    @Override
    public void showCalculation(int calculatedValue) {
        this.calculatedMpgLabel.setText(Integer.toString(calculatedValue));
    }

    @Override
    public void showGreatestMPG(int greatest) {
        this.greatestMpgLabel.setText(Integer.toString(greatest));
    }

    @Override
    public void showLeastMPG(int least) {
        this.leastMpgLabel.setText(Integer.toString(least));
    }
}