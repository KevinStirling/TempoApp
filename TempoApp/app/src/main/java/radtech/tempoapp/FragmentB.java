package radtech.tempoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by kevinyoung on 2/22/15.
 */
public class FragmentB extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] values = new String[] { "Music Video 1", "Music Video 2", "Music Video 3",
                "Music Video 3", "Music Video 4", "Music Video 5", "Music Video 6", "Music Video 7",
                "Music Video 8", "Music Video 9" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_b,container,false);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // do something with the data
    }


    //private string smsBody = "I vote for " + voteChoice + "\n from voter ID number " + IDnumber;
    //The voteChoice comes from the video that is chosen.  The IDnumber comes from the login account number.
    //private int addressNumber = 3458;
    //There is a specific number the text message needs to be sent to.  That number may be based on the location that the message is sent from.
    
//    public void invokeSMSApp() {
//        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
//
//        smsIntent.putExtra("sms_body", "Hello World!");
//        smsIntent.putExtra("address", "0123456789");
//        smsIntent.setType("vnd.android-dir/mms-sms");
//
//        startActivity(smsIntent);
//   }
}