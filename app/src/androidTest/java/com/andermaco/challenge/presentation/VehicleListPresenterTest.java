package com.andermaco.challenge.presentation;

import com.andermaco.challenge.view.activity.VehicleList;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.presenter.VehicleListPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by andermaco@gmail.com on 22/08/17.
 */

public class VehicleListPresenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    VehicleList view;

    @Mock
    Router router;
    @Mock
    ResourceManager resourceManager;

    VehicleListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testJourneyMapsPresenterInitialization() {
        presenter = mock(VehicleListPresenter.class);
        assertThat(presenter, is(notNullValue()));
    }
}
