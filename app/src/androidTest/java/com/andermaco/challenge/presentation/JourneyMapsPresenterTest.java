package com.andermaco.challenge.presentation;

import com.andermaco.challenge.data.network.GetEstimatesService;
import com.andermaco.challenge.view.activity.JourneyMaps;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.presenter.JourneyMapsPresenter;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by andermaco@gmail.com on 21/08/17.
 */

public class JourneyMapsPresenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    JourneyMaps view;

    @Mock
    Router router;
    @Mock
    ResourceManager resourceManager;
    @Mock
    GetEstimatesService mGetEstimatesService;

    JourneyMapsPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testJourneyMapsPresenterInitialization() {
        presenter = mock(JourneyMapsPresenter.class);
        assertThat(presenter, is(notNullValue()));
    }

}
