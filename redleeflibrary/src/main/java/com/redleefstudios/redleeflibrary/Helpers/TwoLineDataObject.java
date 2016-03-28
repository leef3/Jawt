package com.redleefstudios.redleeflibrary.Helpers;

/**
 * Created by Fred on 3/28/2016.
 */
public class TwoLineDataObject {

    private String mLargeText;
    private String mSmallText;
    private int mImage;


    public TwoLineDataObject(String largeText, String smallText, int imageURL)
    {
        mLargeText = largeText;
        mSmallText = smallText;
        mImage = imageURL;
    }

    public String GetLargeText() { return mLargeText; }
    public String GetSmallText() { return mSmallText; }
    public int GetImageUrl() { return mImage; }

    public void SetLargeText(String toSet) { mLargeText = toSet; }
    public void SetSmallText(String toSet) { mSmallText = toSet; }
    public void SetImageUrl(int toSet) { mImage = toSet ; }
}
