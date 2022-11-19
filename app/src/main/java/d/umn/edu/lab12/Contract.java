package d.umn.edu.lab12;

import android.view.View;

public interface Contract {
    interface ViewMVP {
        void showCalculation(int calculatedValue);

        void showGreatestMPG(int greatest);

        void showLeastMPG(int least);

        int getCurrReading();

        int getPrevReading();

        int getFuelGallons();
    }

    interface Model {
        int getGreatestMPG();

        int getLeastMPG();

        int calculateMPG(int firstReading, int lastReading, int gallons);

        void saveMPG();
    }

    interface Presenter {
        void onCalculateClicked(View view);

        void onSaveClicked(View view);
    }
}
