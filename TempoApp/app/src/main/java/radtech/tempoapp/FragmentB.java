package radtech.tempoapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
 * This Fragment is responsible for the CCC (Cross Caribbean Countdown).
 * This fragment provides the options for logging in, viewing the voting results, and casting a vote.
 */

public class FragmentB extends ListFragment {
    private boolean isLoggedIn = false;

    //THE onCreateView METHOD SETS UP THE VIEW FOR THE FRAGMENT. EVERYTHING THAT IS DISPLAYED ON THE SCREEN PHYSICALLY IS DECLARED HERE
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_b,container, false);

        //THIS STRING ARRAY STORES THE NAME OF EACH MUSIC VIDEO THAT IS AVAILABLE FOR VOTING. THE ArrayAdapter THEN PREPARES THE ARRAY TO BE DISPLAYED IN THE LISTVIEW
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

    //logIn METHOD HANDLES A CLICK ON THE LOG IN BUTTON. UPON CLICKING, THE USER WILL BE BROUGHT TO THE LOGIN ACTIVITY
    public void logIn(View view) {
        Intent LoginActivity = new Intent(FragmentB.this.getActivity(), LoginActivity.class);
        startActivity(LoginActivity);
    }

    //onListItemClick CHECKS TO SEE IF USER IS LOGGED IN WHEN A VOTING OPTION IS CLICKED.
    public void onListItemClick(ListView l, View v, int position, long id) {
        //IF THE USER IS NOT LOGGED IN, ASK THEM TO LOG IN. IF THEY ARE LOGGED IN, BEGIN VOTING PROCESS
        if(isLoggedIn == false){
            Toast.makeText(getActivity(), "Please login first", Toast.LENGTH_SHORT).show();
        }else {
            String data=(String)l.getItemAtPosition(position);
            invokeSMSApp(data);
        }
    }


    //invokeSMSApp OPENS SMS APPLICATION WITH THE VOTING OPTION THE USER SELECTED IN THE MESSAGE BODY, ADDRESSED TO THE TEXT MESSAGE SERVICE FOR VOTING
    public void invokeSMSApp(String data) {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
        smsIntent.setData(Uri.parse("smsto:" + Uri.encode("9084619650")));
        smsIntent.putExtra("sms_body", "I vote for "+data);
        smsIntent.putExtra("exit_on_sent", true);
        startActivity(smsIntent);
   }
}
