package ie.seankehoe.simpleromannumeralconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText editnumber;
    public Button convertBtn;
    public TextView result;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editnumber = (EditText) findViewById(R.id.editNumber);
        convertBtn = (Button) findViewById(R.id.convertBtn);
        result = (TextView) findViewById(R.id.result);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int resultNum = getNumeral();
                result.setText(String.valueOf(resultNum));
                total = 0;
            }
        });
    }


    public int getNumeral() {


        String str = editnumber.getText().toString();

        for (int i = 0; i < str.length(); i++) {
            Character deductivechar = null;
            String deductive = null;
            Character singlecharchar = str.charAt(i);
            String singlechar = singlecharchar.toString();


            if (i != str.length() - 1) {
                deductivechar = str.charAt(i + 1);
                deductive = deductivechar.toString();
            }

            if (singlechar.equalsIgnoreCase("I"))
            {
                if (deductive != null) {


                    if (deductive.equalsIgnoreCase("V")) {
                        total = total + 4;
                        i++;
                    }
                    if (deductive.equalsIgnoreCase("X")) {
                        total = total + 9;
                        i++;
                    }
                    if(!deductive.equalsIgnoreCase("X") && !deductive.equalsIgnoreCase("V")){
                        total = total + 1;
                    }
                }
                else{
                    total = total +1;
                }
            }

                if (singlechar.equalsIgnoreCase("V"))
                {
                    total += 5;
                }

                if (singlechar.equalsIgnoreCase("X"))
                {
                    if (deductive != null) {
                        if (deductive.equalsIgnoreCase("L")) {
                            total += 40;
                            i++;
                        }
                        if (deductive.equalsIgnoreCase("C")) {
                            total += 90;
                            i++;
                        }
                        if(!deductive.equalsIgnoreCase("L") && !deductive.equalsIgnoreCase("C")){
                            total = total + 10;
                        }
                    }
                    else {
                        total += 10;
                    }
                }
                if (singlechar.equalsIgnoreCase("L"))
                {
                    total += 50;
                }
                if (singlechar.equalsIgnoreCase("C"))
                {
                    if (deductive != null) {
                        if (deductive.equalsIgnoreCase("D")) {
                            total += 400;
                            i++;
                        }
                        if (deductive.equalsIgnoreCase("M")) {
                            total += 900;
                            i++;
                        }
                        if(!deductive.equalsIgnoreCase("D") && !deductive.equalsIgnoreCase("M")){
                            total = total + 100;
                        }
                    }
                    else {
                        total += 100;
                    }
                }
                if (singlechar.equalsIgnoreCase("D"))
                {
                    total += 500;
                }
                if (singlechar.equalsIgnoreCase("M"))
                {
                    total += 1000;
                }
            }
            return total;
        }

}


