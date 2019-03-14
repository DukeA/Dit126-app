package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.entity.ActivityEntity;
import com.webbapp.webapp.model.facade.ActivityFacade;
import com.webbapp.webapp.model.facade.ListActivityFacade;
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

public class ListActivityTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @InjectMocks
    private ListActivity listActivity;

    @Mock
    private ListActivityFacade activityFacade;

    @Test
    public void testGetListEmpty() {
        List<ActivityEntity> res = activityFacade.findByTypes(new ArrayList<>());
        List<ActivityEntity> exp = new ArrayList<>();

        Assert.assertEquals(res, exp);
    }

    @Test
    public void testGetList() {
        listActivity.setTypes("JOGGING");

        listActivity.getList();

        verify(activityFacade).findByTypes(argThat(types -> types.equals(Stream.of("JOGGING").collect(Collectors.toList()))));
    }
}
