package munoz.sonia.dam.isi.frsf.utn.edu.ar.lab01c2016;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements OnSeekBarChangeListener{


    SeekBar seekbar1;
    int value;
    TextView result;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbar1=(SeekBar)findViewById(R.id.seekBardias);
        seekbar1.setOnSeekBarChangeListener(this);
        result=(TextView)findViewById(R.id.tvdias);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    public void onclickboton(View view) {
      try{
        int M =Integer.parseInt(((TextView)findViewById(R.id.editText2)).getText().toString());
        int dias=seekbar1.getProgress();
          int i=360;
        double interes;
          if(((TextView)findViewById(R.id.editText)).getText().toString().trim().equals("")){
              ((TextView)findViewById(R.id.textView6)).setText("El CUIT no puede ser vacio");
              int colorMsjError = R.color.colorMsjError;
              ((TextView)findViewById(R.id.textView6)).setTextColor(getResources().getColor(colorMsjError));
              return;
          }
          if((((TextView)findViewById(R.id.editTextEmail)).getText().toString().trim().equals(""))){
              ((TextView)findViewById(R.id.textView6)).setText("El mail no puede ser vacio");
              int colorMsjError = R.color.colorMsjError;
              ((TextView)findViewById(R.id.textView6)).setTextColor(getResources().getColor(colorMsjError));
              return;
          }

          float f5menos=Float.parseFloat(getResources().getString(R.string.t0A5000Menos30dias));
          float f5mas=Float.parseFloat(getResources().getString(R.string.t0A5000Mas30dias));
          float f59menos=Float.parseFloat(getResources().getString(R.string.t5000A99999Menos30dias));
          float f59mas=Float.parseFloat(getResources().getString(R.string.t5000A99999Mas30dias));
          float f9menos=Float.parseFloat(getResources().getString(R.string.t99999Menos30dias));
          float f9mas=Float.parseFloat(getResources().getString(R.string.t99999Mas30dias));
        if(M<5000) {
            if(dias<30) {

               interes=M*(Math.pow((1.0+ f5menos),(i/360)));
            }
            else{
                interes=M*(Math.pow((1.0+f5mas),(i/360))-1);
            }
        }
        else if(M<99999){
            if(dias<30){
                interes=M*(Math.pow(1.0+f59menos,(i/360))-1);
            }
            else{
                interes=M*(Math.pow(1.0+f59mas,(i/360))-1);
            }
        }
        else {
            if(dias<30){
                interes=M*(Math.pow(1.0+f9menos,(i/360))-1);
            }
            else{
                interes=M*(Math.pow(1.0+f9mas,(i/360))-1);
            }
        }
        ((TextView)findViewById(R.id.textView5)).setText("$"+interes);
          ((TextView)findViewById(R.id.textView6)).setText("Plazo fijo realizado.Recibira $"+interes+" al vencimiento");
          ((TextView)findViewById(R.id.textView6)).setTextColor(getResources().getColor(R.color.colorMsjCorrecto));
      }catch (Exception e){
          ((TextView)findViewById(R.id.textView6)).setText("ERROR");
          int colorMsjError = R.color.colorMsjError;
          ((TextView)findViewById(R.id.textView6)).setTextColor(getResources().getColor(colorMsjError));

      }

    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://munoz.sonia.dam.isi.frsf.utn.edu.ar.lab01c2016/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://munoz.sonia.dam.isi.frsf.utn.edu.ar.lab01c2016/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        value = progress;
        result.setText ("Dias:"+value);
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }
}
