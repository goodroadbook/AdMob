package com.njh.admobtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity
{
    private final String AD_UNIT_ID = "ca-app-pub-4007514873014137/8901946609";
    private InterstitialAd interstitialAd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(AD_UNIT_ID);
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdLoaded()
            {
                if (interstitialAd.isLoaded())
                {
                    interstitialAd.show();
                }
            }

            @Override
            public void onAdOpened()
            {
                ;
            }

            @Override
            public void onAdFailedToLoad(int errorCode)
            {
                ;
            }
        });

    }
}
