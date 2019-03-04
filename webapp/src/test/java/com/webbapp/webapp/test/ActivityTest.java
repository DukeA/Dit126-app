package com.webbapp.webapp.test;

//import com.webbapp.webapp.model.Actvity;
import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.LocationEntity;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



/**
 * @Author: Adam Grandén
 * @Class: The class is an structure of the code is to  create the testcode.
 */
@RunWith(JUnit4.class)
public class ActivityTest {

    private static ActivityEntity actvity = null;
/*
    @BeforeClass
    public static void init() {

        String title =  "Runner";
        String type = "Jogging";
        String description = "The best runners location in goteborg";
        Double lat = 55.0;
        Double lng = 14.0;
        int value = 1;
        String valueid = String.valueOf(value);
        String City="Gothenburg";
        LocationEntity locationEntity = new LocationEntity(value,City,lat,lng);
        actvity = new ActivityEntity(valueid,title, type, description,locationEntity);
    }

    @Test
    @DisplayName("Testing the Constructor")
    public void testConstructor(){
        ActivityEntity act = actvity;
        Object[] value = new Object[]{"Runner", "Jogging", "The best runners location in goteborg", 55.0, 14.0};
        Object[] value2 = new Object[]{act.getTitle(),act.getActivity(),act.getDescription(), act.getLocationByLocationId().getLatitude()
                ,act.getLocationByLocationId().getLongitude()};
        Assert.assertArrayEquals("Check the Constructor", value, value2);
    }

    @Test
    @DisplayName("Testing the Setting values")
    public void SetValues() {
        ActivityTest activityTest = new ActivityTest();
        String  value = "Cycling tour";
        ActivityEntity actvity = this.actvity;
        actvity.setTitle(value);
        Assert.assertEquals("Check the set Title  method",
                "Cycling tour", actvity.getTitle()
                );
        String value2= "Cycling";
        actvity.setActivity(value2);
        Assert.assertEquals("Check the set Type method ",
                value2,actvity.getActivity());
        String value3 = "A nice cycling tour";
        actvity.setDescription(value3);
        Assert.assertEquals("Chcek the set description value",
                value3,actvity.getDescription());
        Double new_lat = 123.0;
        actvity.getLocationByLocationId().setLatitude(new_lat);
        Assert.assertEquals("Check the value for latitude",
               new_lat,(Double)actvity.getLocationByLocationId().getLatitude() );
        Double new_long= 60.0;
        actvity.getLocationByLocationId().setLongitude(new_long);
        Assert.assertEquals("Check the set longitude",
                new_long,(Double) actvity.getLocationByLocationId().getLongitude());
    }

*/

}
