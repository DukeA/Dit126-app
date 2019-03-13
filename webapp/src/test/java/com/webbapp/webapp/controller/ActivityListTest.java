package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.ActivityFacade;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.argThat;

public class ActivityListTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @InjectMocks
    private ActivityList activityList;

    @Mock
    private ActivityFacade activityFacade;

    @Test
    public void testGetListEmpty() {
        List<ActivityEntity> res = activityFacade.findByTypes(new ArrayList<>());
        List<ActivityEntity> exp = new ArrayList<>();

        Assert.assertEquals(res, exp);
    }

    @Test
    public void testGetList() {
        activityList.setTypes("JOGGING");

        activityList.getList();

        verify(activityFacade).findByTypes(argThat(types -> types.equals(Stream.of("JOGGING").collect(Collectors.toList()))));
    }
}
