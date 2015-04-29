package radtech.tempoapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by kevinyoung on 4/22/15.
 * This activity allows the user to log in to their Tempo account
 */
public class LoginActivity extends ActionBarActivity {
    //THE onCreateView METHOD SETS UP THE VIEW FOR THE FRAGMENT. EVERYTHING THAT IS DISPLAYED ON THE SCREEN PHYSICALLY IS DECLARED HERE
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        final Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            //WHEN THE LOG IN BUTTON IS CLICKED, onClick BRINGS THE USER BACK TO FRAGMENT B
            public void onClick(View v) {
                finish();
            }
        });
    }

}
