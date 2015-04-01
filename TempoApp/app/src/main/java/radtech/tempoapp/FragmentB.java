package radtech.tempoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kevinyoung on 2/22/15.
 */
public class FragmentB extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b,container,false);
    }
    
    
    public void invokeSMSApp() {
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.putExtra("sms_body", "Hello World!"); 
        smsIntent.putExtra("address", "0123456789");
        smsIntent.setType("vnd.android-dir/mms-sms");

        startActivity(smsIntent);
   }
}