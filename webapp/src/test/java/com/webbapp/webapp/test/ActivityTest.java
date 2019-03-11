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

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;


/**
 * @Author: Adam Grandén
 * @Class: The class is an structure of the code is to  create the testcode.
 */
@RunWith(JUnit4.class)
public class ActivityTest {

    private static ActivityEntity actvity;

    @BeforeClass
    public static void init() {


        LocationEntity locationEntity = mock (LocationEntity.class);
        actvity = mock(ActivityEntity.class);
    }

    @Test
    @DisplayName("Testing the Activity Entity")
    public void testConstructor(){
        String title =  "Runner";
        String type = "Jogging";
        String description = "The best runners location in goteborg";
        Double lat = 55.0;
        Double lng = 14.0;
        int value = 1;
        String valueid = String.valueOf(value);
        String City="Gothenburg";
        ActivityEntity act = actvity;

        ArrayList<Object> valuelist = new ArrayList<Object>(Arrays.asList(title, type, description));
        when(act.getTitle()).thenReturn((String)valuelist.get(0));
        when(act.getType()).thenReturn((String)valuelist.get(1));
        when(act.getDescription()).thenReturn((String)valuelist.get(2));

       ArrayList<Object> value2 = new ArrayList<>(
               Arrays.asList(
                       act.getTitle(),
                       act.getType(),
                       act.getDescription()));
        verify(act,times(1)).getTitle();
        verify(act,times(1)).getType();
        verify(act,times(1)).getDescription();

        Assert.assertArrayEquals("Check the Constructor", valuelist.toArray(), value2.toArray());
    }
    @Test
    @DisplayName("Check the LocationEntity for the Location")
    public void CheckLocationEninty() {
        Double lat =55.0;
        Double lon =11.0;
        String City ="GOTHENBURG";

        LocationEntity locationEntity = mock(LocationEntity.class);

        when(locationEntity.getLongitude()).thenReturn(lon);
        when(locationEntity.getLatitude()).thenReturn(lat);
        when(locationEntity.getCity()).thenReturn(City);

        Assert.assertEquals(lon,(Double)locationEntity.getLongitude());
        verify(locationEntity,times(1)).getLongitude();

        Assert.assertEquals(lat,(Double)locationEntity.getLatitude());
        verify(locationEntity,times(1)).getLatitude();

        Assert.assertEquals(City,locationEntity.getCity());
        verify(locationEntity,times(1)).getCity();

    }
    @Test
    @DisplayName("Test the attribute together")
    public void TestBoth() {

    }


}
