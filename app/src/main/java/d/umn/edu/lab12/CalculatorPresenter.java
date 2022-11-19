package d.umn.edu.lab12;

import android.view.View;

public class CalculatorPresenter implements Contract.Presenter {
    private Contract.Model model;
    private Contract.ViewMVP view;

    CalculatorPresenter(Contract.ViewMVP view, Contract.Model model) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onCalculateClicked(View view) {
        int firstReading = this.view.getPrevReading();
        int lastReading = this.view.getCurrReading();
        int gallons = this.view.getFuelGallons();

        this.view.showCalculation(this.model.calculateMPG(firstReading, lastReading, gallons));
    }

    @Override
    public void onSaveClicked(View view) {
        this.model.saveMPG();
        this.view.showGreatestMPG(this.model.getGreatestMPG());
        this.view.showLeastMPG(this.model.getLeastMPG());
    }
}
