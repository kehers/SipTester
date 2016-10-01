package be.obem.siptester;

import android.app.Activity;
import android.net.sip.SipManager;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "";
        TextView tv = (TextView) findViewById(R.id.textview);
        if (SipManager.isVoipSupported(this) && SipManager.isApiSupported(this)) {
            tv.setText("Congrats! VOIP and SIP API supported.");
        }
        else if (!SipManager.isVoipSupported(this) && SipManager.isApiSupported(this)){
            tv.setText("SIP API supported but VOIP not supported :/");
        }
        else if (SipManager.isVoipSupported(this) && !SipManager.isApiSupported(this)){
            tv.setText("SIP API not supported but VOIP supported :/");
        }
        else {
            // Device not supported
            tv.setText("Both SIP API and VOIP not supported :/");
        }
    }
}
