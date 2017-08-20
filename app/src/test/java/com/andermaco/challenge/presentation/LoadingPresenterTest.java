package com.andermaco.challenge.presentation;

import com.andermaco.challenge.view.activity.Loading;
import com.andermaco.challenge.view.common.utils.ResourceManager;
import com.andermaco.challenge.view.common.utils.Router;
import com.andermaco.challenge.view.presenter.LoadingPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by andermaco@gmail.com on 20/08/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoadingPresenterTest  {

    @Mock Loading view;
    @Mock Router router;
    @Mock ResourceManager resourceManager;

    LoadingPresenter presenter;

    @Before
    public void setUp() {
        presenter = new LoadingPresenter(view, router, resourceManager);
    }

    @Test
    public void testLoadingPresenterInitialization() {
        assertThat(presenter, is(notNullValue()));
    }
}
