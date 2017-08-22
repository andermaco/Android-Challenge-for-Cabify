package com.andermaco.challenge.presentation;

import android.content.Context;

import com.andermaco.challenge.view.activity.Loading;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.presenter.LoadingPresenter;
import com.google.android.gms.location.FusedLocationProviderClient;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Created by andermaco@gmail.com on 20/08/17.
 */

public class LoadingPresenterTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private Context mockContext;

    @Mock
    Loading view;
    @Mock
    Router router;
    @Mock
    ResourceManager resourceManager;

    @InjectMocks
    LoadingPresenter presenter;

    @Mock
    private FusedLocationProviderClient mFusedLocationClient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = mock(LoadingPresenter.class);
        presenter.getLastLocation();

    }

    @Test
    public  void testLoadingPresenterInitialization() {
        assertThat(presenter, is(notNullValue()));
    }

    @Test
    public void checkPersmissionsTest() {
        assertThat(presenter.checkPermissions(), instanceOf(Boolean.class));
    }

    @Test
    public void showLocationPermissionsRequiredTest() {
        presenter.showLocationPermissionRequired();
    }
}
