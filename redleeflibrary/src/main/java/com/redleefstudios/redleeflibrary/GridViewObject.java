package com.redleefstudios.redleeflibrary;

/**
 * Created by Fred on 3/23/2016.
 */
public class GridViewObject {

    private String Title;
    private String Content;
    private int Image;

    public GridViewObject() {}

    public GridViewObject(String Title, String Content, int Image)
    {
        this.Title = Title;
        this.Content = Content;
        this.Image = Image;
    }

    public String getName()
    {
        return this.Title;
    }
    public String getContent()
    {
        return this.Content;
    }
    public int getPhoto()
    {
        return this.Image;
    }
}
