package com.example.karenli.apptimizedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

//Add Apptimize import statements
import com.apptimize.Apptimize;
import com.apptimize.ApptimizeVar;

public class MainActivity extends AppCompatActivity {

    //Declare three dynamic variables for use on Apptimize
    private static ApptimizeVar<String> appText = ApptimizeVar.createString("Text", "Apptimize Me!");
    private static ApptimizeVar<String> appColor = ApptimizeVar.createString("Background Color | magenta, green or blue", "blue");
    private static ApptimizeVar<Boolean> appButtonToggle = ApptimizeVar.createBoolean("Button Visibility", true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize Apptimize and include your app key
        Apptimize.setup(this, "CVhHRhmUzvn6eh84Cnexxkf2NMeLXMg");
        Apptimize.track("App loaded");

        //Set the text to the String variable from Apptimize
        TextView mainText = (TextView) findViewById(R.id.mainText);
        mainText.setText(appText.value());

        //Set the color depending on keywords from Apptimize
        if(appColor.value().equals("magenta")){
            mainText.setBackgroundColor(Color.MAGENTA);
        }
        else if (appColor.value().equals("green")){
            mainText.setBackgroundColor(Color.GREEN);
        }
        else{
            mainText.setBackgroundColor(Color.BLUE);
        }

        //Toggle button visibility depending on boolean from Apptimize
        Button okButton = (Button) findViewById(R.id.okButton);
        if (!appButtonToggle.value()){
            okButton.setVisibility(View.GONE);
        }

    }
}
