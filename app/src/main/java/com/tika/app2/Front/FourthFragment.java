package com.tika.app2.Front;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tika.app2.R;

import java.net.URLEncoder;

public class FourthFragment extends Fragment {
    Button button1,button2;

    ImageView whatsapp,facebook,instagram;

    TextView swarkshaLink;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragmentfourth,container,false);


        swarkshaLink = (TextView) view.findViewById(R.id.swarksha_link);
        button1 = (Button) view.findViewById(R.id.fir_button);

        whatsapp = view.findViewById(R.id.whatsapp);
        facebook = view.findViewById(R.id.facebook);
        instagram = view.findViewById(R.id.insta);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://digitalpolice.gov.in/ncr/State_Selection.aspx"));
                startActivity(browserIntent);

            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PackageManager packageManager = getContext().getPackageManager();

                Intent i = new Intent(Intent.ACTION_VIEW);

                try {
                    String url = "https://api.whatsapp.com/send?phone="+ "+918755289525" +"&text=" + URLEncoder.encode("Your message: ", "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        getContext().startActivity(i);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PackageManager packageManager = getContext().getPackageManager();

                Intent i = new Intent(Intent.ACTION_VIEW);

                try {
                    String url = "https://instagram.com/maheshwari__apoorv?igshid=35jid2u2ui83";
                    i.setPackage("com.instagram");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        getContext().startActivity(i);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        swarkshaLink.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.swarksha.org"));
                startActivity(intent);
            }
        });


        return view;
    }




}
