package krassdraufstudios.wikipeter;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONException;

public class ProductOverviewActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private static String product;

    private static String product_id;
    private static String product_name;
    private static String product_category;
    private static String product_price;
    private static String product_spezifications;
    private static String product_producer_page;
    private static String product_producer_trailer;

    JSONObject jsonObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_overview);

        /*Bundle qrCodeData = getIntent().getExtras();
        if (qrCodeData != null) {
            product = qrCodeData.getString("ProductInformation");

            try {
                jsonObject = new JSONObject(product);
            } catch (JSONException e){
                Toast.makeText(this,"QR-Code konnte nicht ausgelesen werden.", Toast.LENGTH_SHORT).show();

                // After retrieving Error-Message, switch back to ScanActivity
                Intent intent = new Intent(getApplicationContext(), ScanActivity.class);

                // start ScanActivity
                startActivity(intent);
            }

            try {
                product_id = jsonObject.getString("id");
                product_name = jsonObject.getString("name");
                product_category = jsonObject.getString("category");
                product_price = jsonObject.getString("price");
                product_spezifications = jsonObject.getString("spezifications");
                product_producer_page = jsonObject.getString("producer_product_page");
                product_producer_trailer = jsonObject.getString("producer_product_trailer");

            } catch (JSONException e) {
                Toast.makeText(this,"QR-Code konnte nicht verarbeitet werden.", Toast.LENGTH_SHORT).show();
            }


        }*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product_overview, menu);
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
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // Returning the current tabs
            switch (position) {
                case 0:
                    TabOneProductDetails tab1 = new TabOneProductDetails();
                    return tab1;

                case 1:
                    TabTwoProductReviews tab2 = new TabTwoProductReviews();
                    return tab2;

                case 2:
                    TabThreeProducerVideos tab3 = new TabThreeProducerVideos();
                    return tab3;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "PRODUKT DETAILS";
                case 1:
                    return "TESTBERICHTE";
                case 2:
                    return "HERSTELLER VIDEOS";
            }
            return null;
        }
    }
}
