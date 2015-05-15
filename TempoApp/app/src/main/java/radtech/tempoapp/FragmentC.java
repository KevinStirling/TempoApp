package radtech.tempoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kevinyoung on 2/22/15.
 * This Fragment provides the Tempo Talk'r functionality. It displays a dialer.
 */
public class FragmentC extends Fragment implements View.OnClickListener {

    private Button[] numberButtons;
    TextView phoneAddressTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_c, container, false);
        phoneAddressTextView = (TextView) v.findViewById(R.id.phoneAddressTextView);
        numberButtons = new Button[10];
        numberButtons[1] = (Button) v.findViewById(R.id.button2);
        numberButtons[2] = (Button) v.findViewById(R.id.button3);
        numberButtons[3] = (Button) v.findViewById(R.id.button4);
        numberButtons[4] = (Button) v.findViewById(R.id.button5);
        numberButtons[5] = (Button) v.findViewById(R.id.button6);
        numberButtons[6] = (Button) v.findViewById(R.id.button7);
        numberButtons[7] = (Button) v.findViewById(R.id.button8);
        numberButtons[8] = (Button) v.findViewById(R.id.button9);
        numberButtons[9] = (Button) v.findViewById(R.id.button10);
        numberButtons[0] = (Button) v.findViewById(R.id.button12);

        for (Button b : numberButtons) {
            if (b != null) {
                b.setOnClickListener(this);
            } else {
                Log.v("ERROR", "b is null!!!!!!!!!");
            }

        }


        return inflater.inflate(R.layout.fragment_c,container,false);
    }

    public void onButtonClick(View v) {

    }

    @Override
    public void onClick(View v) {
        Log.v("inside onButtonClick", "double yay");
        String newValue = (String) phoneAddressTextView.getText() + ((Button) v).getText();
        phoneAddressTextView.setText(newValue);
        Log.v("finished onButtonClick", "double yay!!!!!");
    }
}
