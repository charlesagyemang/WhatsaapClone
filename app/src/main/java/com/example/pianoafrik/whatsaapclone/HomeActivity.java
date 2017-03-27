package com.example.pianoafrik.whatsaapclone;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.pianoafrik.whatsaapclone.apiadapter.CallAdapter;
import com.example.pianoafrik.whatsaapclone.apimodel.Call;
import com.example.pianoafrik.whatsaapclone.fakeadapter.ChatAdapter;
import com.example.pianoafrik.whatsaapclone.fakeadapter.StatusAdapter;
import com.example.pianoafrik.whatsaapclone.fakemodel.Chat;
import com.example.pianoafrik.whatsaapclone.fakemodel.Status;
import com.example.pianoafrik.whatsaapclone.greendao.CallBackUp;
import com.example.pianoafrik.whatsaapclone.greendao.DaoSession;
import com.squareup.picasso.Downloader;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends FunctionActivity {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    TabLayout tabLayout;
    public static DaoSession getDao;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;



    public static final String CHAT_KEY = "chatKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.z
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        getDao = getAppDaoSession();

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setUpTabIcons();


    }

    private void setUpTabIcons () {
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_comment_white_24dp2);
//        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_launcher);
//        tabLayout.getTabAt(2).setIcon(R.mipmap.ic_launcher);
//        tabLayout.getTabAt(3).setIcon(R.mipmap.ic_launcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class ChatFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public ChatFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ChatFragment newInstance(int sectionNumber) {
            ChatFragment fragment = new ChatFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.chat_page, container, false);

            ListView listView = (ListView)rootView.findViewById(R.id.chat_list_item);
            final List<Chat> chatList = new ArrayList<>(Arrays.asList(
                    new Chat (R.drawable.pic_two, "Babe", "Love u ):", "1:00PM", 2),
                    new Chat (R.drawable.pic_three, "ExBae", "You good?", "Yesterday", 1),
                    new Chat (R.drawable.pic_four, "Next Bae", "I didnt get you", "3:00PM", 7),
                    new Chat (R.drawable.image_five, "Yorn", "Charlie xup?", "4:00PM", 9),
                    new Chat (R.drawable.image_seven, "Devless", "Charlie xup?", "5:00PM", 8),
                    new Chat (R.drawable.image_ten, "Ashwin", "Charlie xup?", "6:00PM", 1),
                    new Chat (R.drawable.pic_two, "Side Chic", "Charlie xup?", "12/03/2016", 2),
                    new Chat (R.drawable.pic_two, "Kelly", "Charlie xup?", "8:00PM", 4),
                    new Chat (R.drawable.pic_two, "Counsellor", "Charlie xup?", "9:00PM", 7),
                    new Chat (R.drawable.pic_two, "Maria", "Charlie xup?", "10:00PM", 3)


            ));



            ChatAdapter adapter  = new ChatAdapter(this.getContext(), 0,  chatList );
            listView.setFooterDividersEnabled(false);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Chat chat = chatList.get(position);

                    Intent intent = new Intent(view.getContext(), ChatActivity.class);
                    intent.putExtra(CHAT_KEY, (Serializable)chat);
                    startActivity(intent);

                }
            });
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class StatusFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public StatusFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static StatusFragment newInstance(int sectionNumber) {
            StatusFragment fragment = new StatusFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {



            View rootView = inflater.inflate(R.layout.status_page, container, false);

            ListView recentList = (ListView)rootView.findViewById(R.id.recent_updates_list);

            List<Status> statusList = new ArrayList<>(Arrays.asList(
                    new Status (R.drawable.pic_one, "William", "Charlie xup?"),
                    new Status (R.drawable.pic_two, "Micheal", "Charlie xup?")
            ));

            StatusAdapter adapter = new StatusAdapter(this.getContext(), 0, statusList);

            recentList.setAdapter(adapter);

            ListView viewedUpdates = (ListView)rootView.findViewById(R.id.viewed_updates_list);

            List<Status> viewedStatusList = new ArrayList<>(Arrays.asList(
                    new Status (R.drawable.pic_three, "Kwame", "Charlie xup?"),
                    new Status (R.drawable.pic_four, "Babe", "Charlie xup?")
            ));

            StatusAdapter viewedAdapter = new StatusAdapter(this.getContext(), 0, viewedStatusList);

            viewedUpdates.setAdapter(viewedAdapter);

            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            return rootView;
        }
    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class CallsFragment extends Fragment {

        ListView callsList;

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public CallsFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static CallsFragment newInstance(int sectionNumber) {
            CallsFragment fragment = new CallsFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            
            
            final TextView  json_object;
            
            final List<Call> calls = new ArrayList<Call>();


            final View rootView = inflater.inflate(R.layout.calls_page, container, false);

            callsList = (ListView) rootView.findViewById(R.id.call_list);

            json_object = (TextView)rootView.findViewById(R.id.json_string);



            //ApiCall
            //Make  StirngRequest
            //First
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(rootView.getContext());
            String url = "https://whatsaapcloneapi.herokuapp.com/calls";

            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            json_object.setText(response);



                            CallAdapter adapter = new CallAdapter(rootView.getContext(), R.layout.calls_page_item, calls);
                            callsList.setFooterDividersEnabled(false);
                            callsList.setAdapter(adapter);

                            List <Call> calls = new ArrayList<>();




                            //Empty Db
                            getDao.getCallBackUpDao().deleteAll();


                            try {
                               JSONArray jsonArray = new JSONArray(json_object.getText().toString());

                                int count  = 0;
                                String  callerName, callerPicture, date, timeOfCall;
                                boolean callTypeIcon;
                                int     numberOfCalls;

                                while (count < jsonArray.length()){

                                    JSONObject JO  = jsonArray.getJSONObject(count);
                                    callerName     = JO.getString("caller_name");
                                    callerPicture  = JO.getString("caller_picture");
                                    callTypeIcon   = JO.getBoolean("call_type_icon");
                                    date           = JO.getString("date");
                                    numberOfCalls =  JO.getInt("number_of_calls");
                                    timeOfCall     = JO.getString("time_of_call");

                                    Call call  =  new Call(callerName, callerPicture, callTypeIcon,
                                                            date, numberOfCalls, timeOfCall);
                                    adapter.add(call);

                                    CallBackUp backDataUp = new CallBackUp(null,callerName, callerPicture, callTypeIcon,
                                                                           date, numberOfCalls, timeOfCall );

                                    //Populate Db
                                    //Todo: save the api calls array in greenDao
                                    getDao.getCallBackUpDao().insert(backDataUp);

                                    count++;

                                }

                                Toast.makeText(rootView.getContext(), String.valueOf( getDao.getCallBackUpDao().loadAll().size()), Toast.LENGTH_LONG).show();

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //json_object.setText("That didn't work!" + error);

                    //TODO: create a greenDao db and load the saved json here

                    List <CallBackUp> callBackUp = getDao.getCallBackUpDao().loadAll();
                    List <Call> backUp = new ArrayList<Call>();

                    for(int i = 0; i < callBackUp.size(); i++){

                        CallBackUp callBackUpEach = callBackUp.get(i);

                        Call call  = new Call (callBackUpEach.getCallerName(),
                                                callBackUpEach.getCallerPicture(),
                                                callBackUpEach.getCallTypeIcon(),
                                                callBackUpEach.getDate(),
                                                callBackUpEach.getNumberOfCalls(),
                                                callBackUpEach.getTimeOfCall());

                        backUp.add(call);
                    }


                    CallAdapter adapter = new CallAdapter(rootView.getContext(), R.layout.calls_page_item, backUp);
                    callsList.setFooterDividersEnabled(false);
                    callsList.setAdapter(adapter);



                }
            });

            queue.add(stringRequest);





            return rootView;
        }





    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class CameraFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public CameraFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static CameraFragment newInstance(int sectionNumber) {
            CameraFragment fragment = new CameraFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {



            View rootView = inflater.inflate(R.layout.camera_page, container, false);

            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            ImageView imageView = (ImageView)rootView.findViewById(R.id.imgRondo);


            Picasso.with(this.getContext())
                    .load("https://s26.postimg.org/cdr12l761/Doo_Fmajor_inv0.png")
                    .placeholder(R.drawable.image_seven)   // optional
                    .error(R.drawable.image_seven)      // optional
                    .resize(60, 60)                        // optional
                    .rotate(180)                             // optional
                    .into(imageView);
            return rootView;
        }
    }





    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);

            switch (position){

                case 0:
                    CameraFragment cameraFragment = new CameraFragment();
                    return cameraFragment.newInstance(1);
                case 1:
                    ChatFragment chatFragment = new ChatFragment();
                    return chatFragment.newInstance(2);
                case 2:
                    StatusFragment statusFragment = new StatusFragment();
                    return statusFragment.newInstance(3);
                case 3:
                    CallsFragment callsFragment = new CallsFragment();
                    return callsFragment.newInstance(4);
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position) {
                case 0:
                    return "";
                case 1:
                    return "CHATS";
                case 2:
                    return "STATUS";
                case 3:
                    return "CALLS";

            }
            return null;
        }

    }


    //        Toast.makeText(this, json_string, Toast.LENGTH_LONG).show();
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


 //   String url = "https://whatsaapcloneapi.herokuapp.com/calls";
  //      new GetJson().execute();

}
