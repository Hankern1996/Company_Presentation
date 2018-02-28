package com.example.hannahkern.company_presentation;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hannahkern.company_presentation.R;

/**
 * Created by hannahkern on 20.02.18.
 */

public class ContactFragment extends android.support.v4.app.Fragment{

    private ImageView mPhone;
    private ImageView mEmail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact, container, false);

        mPhone = (ImageView) v.findViewById(R.id.imageView2) ;
        mPhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String number = "+49 6284 929244";
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + number));                       //connect intent with phone number
                startActivity(i);
            }
        });

        mEmail = (ImageView) v.findViewById(R.id.imageView3);
        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.fromParts("mailto","info@wiesentalranch.de",null));
                startActivity(i);
            }
        });

        return  v;}
}
