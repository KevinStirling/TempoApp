package radtech.tempoapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.text.Spanned;
import android.text.Html;
import android.text.method.LinkMovementMethod;

/**
 * Created by kevinyoung on 2/22/15.
 * This fragment is for the Tempo Kids functionality
 */
public class FragmentD extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_d, container, false);
        TextView link = (TextView) v.findViewById(R.id.textLink);
        final Spanned s = Html.fromHtml("<br/><br/><br/><p><a href='http://www.gottempo.com/home/shows/jjandfriends'>Tempo Kids</a></p><br/><br/><br/>"
        + "<p><a href='http://www.tempowater.com'>Tempo water</a></p><br/><br/><br/>"
        + "<p><a href='https://www.youtube.com/user/gottempo'>Watch Tempo videos</a></p>");
        link.setText(s);
        link.setMovementMethod(LinkMovementMethod.getInstance());
        return v;

    }
}
