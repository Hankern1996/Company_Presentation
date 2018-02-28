package com.example.hannahkern.company_presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.internal.ShareInternalUtility;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by hannahkern on 20.02.18.
 */

public class FacebookFragment extends Fragment {

    private CallbackManager callbackManager;
    private LoginButton loginButton;

    private static String url =
            "https://graph.facebook.com/v2.12/wiesentalranch/feed?access_token=EAAaOVLY3rZCsBABjzLOCVWZCZCZCSs7ABtlQDAic66lYAtMAULGmZC2cwwJhGvkhLgZCJZCYgUZApwDgmdlGD7DHDEJoFKavEXBGursIqNqxcXm5LSHRmhnJI0pZCysZCritNU3UF4w4ZBQlkW4j4vYWFHPzVZC525kTsGSEJ9PvVGaRy5pJdrHuabZAekKJgBVQV15HiMCRVRH6A0QZDZD";

    private static final String TAG_STORY = "user";
    private static final String TAG_ID = "id";
    private static final String TAG_MESSAGE = "message";
    Button Btngetdata;

    JSONArray user = null;


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        callbackManager = CallbackManager.Factory.create();

        boolean loggedIn = AccessToken.getCurrentAccessToken() == null;

        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });







        /*GraphRequest request = GraphRequest.newGraphPathRequest(
                accessToken,
                "/wiesentalranch/feed",
                new GraphRequest.Callback() {
                    @Override
                    public void onCompleted(GraphResponse response) {
                        // Insert your code here
                    }
                });

        request.executeAsync();*/

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_facebook, container, false);

        loginButton = (LoginButton) v.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email","user_posts");
        // If using in a fragment
        loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/151142424964972/feed",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
            /* handle the result*/
                String responseJson = response.getRawResponse();
                Log.i("last Few Lines: ", responseJson.substring(responseJson.length()/5));
/*
                JSONParser parser = new JSONParser();
                JSONObject object = null;
                try {
                    object = (JSONObject) parser.parse(responseJson);
                }catch(Exception e){
                    e.printStackTrace();
                }

                JSONArray array   = null;
                try {
                       array = (JSONArray) object.get("data");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i("hannahananawm", array.toString());
/**/




                        }

                        // Log.i("jetzt kommt der array", jsonArray.toString());
//nachdem der array erfolgreich da ist mit den dagen, kann man die daten aus dem array in eier liste anzeigen

                      /* List<String> list = new ArrayList<String>();
                        for(int i = 0; i < arr.length(); i++){
                            String info = null;
                            try {
                                info = arr.getJSONObject(i).getString("area") + arr.getJSONObject(i).getString("city");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            list.add(info);
                        }*/


                }
        ).executeAsync();

        return v;
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


}
