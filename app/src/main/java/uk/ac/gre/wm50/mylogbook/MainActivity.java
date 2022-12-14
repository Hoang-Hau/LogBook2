package uk.ac.gre.wm50.mylogbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    EditText addLink_txt;
    Button backward_button, forward_button, add_link_button, clear_link_button;
    ArrayList<String> arrayList;
    int index;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
        backward_button = findViewById(R.id.backward_button);
        forward_button = findViewById(R.id.forward_button);
        add_link_button = findViewById(R.id.add_link_button);
        addLink_txt = findViewById(R.id.addLink_txt);

        add_link_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayList.add(addLink_txt.getText().toString().trim());
                Glide.with(getApplicationContext())
                        .load(loadLastImg())
                        .placeholder(R.drawable.ic_baseline_image_24)
                        .into(imageView);



                Toast.makeText(MainActivity.this, "Add Successfully!!!", Toast.LENGTH_SHORT).show();

            }
        });

        clear_link_button = findViewById(R.id.clear_link_button);

        clear_link_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addLink_txt.setText("");

            }
        });

        arrayList = new ArrayList<>();

        arrayList.add(0,"https://img.thuthuatphanmem.vn/uploads/2018/09/28/anh-rong-cuc-dep-2_024751600.jpg");
        arrayList.add(1,"https://img.thuthuatphanmem.vn/uploads/2018/09/28/anh-rong-cuc-dep_024751615.jpg");
        arrayList.add(2,"https://img.thuthuatphanmem.vn/uploads/2018/09/28/dragon-image_024751694.jpg");

        Glide.with(getApplicationContext())
                .load(loadLastImg())
                .placeholder(R.drawable.ic_baseline_image_24).into(imageView);


        backward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext())
                        .load(backward_button())
                        .placeholder(R.drawable.ic_baseline_image_24).into(imageView);
            }
        });

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(getApplicationContext())
                        .load(forward_button())
                        .placeholder(R.drawable.ic_baseline_image_24).into(imageView);
            }
        });
    }

    String loadLastImg(){
        url = arrayList.get(arrayList.size() - 1 );
        return url;
    }

    String forward_button(){
        index = arrayList.indexOf(url);
        if(index == (arrayList.size()-1)){
            url = arrayList.get(0);
        } else {
            index++;
            url = arrayList.get(index);
        }
        return url;
    }

    String backward_button(){
        index = arrayList.indexOf(url);
        if(index == 0){
            url = arrayList.get(arrayList.size()-1);
        } else {
            index--;
            url = arrayList.get(index);
        }
        return url;
    }
}