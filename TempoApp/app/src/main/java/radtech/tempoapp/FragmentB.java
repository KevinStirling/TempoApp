package radtech.tempoapp;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by kevinyoung on 2/22/15.
 */
public class FragmentB extends ListFragment {
    private boolean isLoggedIn = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_b,container, false);
        String[] values = new String[] { "Music Video 1", "Music Video 2", "Music Video 3",
                "Music Video 3", "Music Video 4", "Music Video 5", "Music Video 6", "Music Video 7",
                "Music Video 8", "Music Video 9" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);

        final Button loginbutton = (Button) root.findViewById(R.id.loginbutton);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                logIn(v);
                isLoggedIn = true;
            }
        });
        return root;

    }


    public void logIn(View view) {
        Intent LoginActivity = new Intent(FragmentB.this.getActivity(), LoginActivity.class);
        startActivity(LoginActivity);
    }


    public void onListItemClick(ListView l, View v, int position, long id) {
        // do something with the data
        if(isLoggedIn == false){
            //toast
            //Context context = getApplicationContext();
            Toast.makeText(getActivity(), "Please login first", Toast.LENGTH_SHORT).show();
        }else {
            String data=(String)l.getItemAtPosition(position);
            invokeSMSApp(data);
            //ADD SOMETHING TO BRING THE USER BACK TO THE APP
        }
    }


    //private string smsBody = "I vote for " + voteChoice + "\n from voter ID number " + IDnumber;
    //The voteChoice comes from the video that is chosen.  The IDnumber comes from the login account number.
    //private int addressNumber = 3458;
    //There is a specific number the text message needs to be sent to.  That number may be based on the location that the message is sent from.
    
    public void invokeSMSApp(String data) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:" + Uri.encode("9084619650")));
        smsIntent.putExtra("sms_body", "I vote for "+data);
        smsIntent.putExtra("exit_on_sent", true);
        

        startActivity(smsIntent);
   }
}
